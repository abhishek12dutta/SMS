package com.sms.web.action.login;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.sms.web.encryption.DecryptionService;
import com.sms.web.exception.SMSWebException;
import com.sms.web.form.userdetails.UserDetails;
import com.sms.web.repository.login.LoginRepository;
public class UserLoginAction extends ActionSupport implements SessionAware {

	@Autowired
	private LoginRepository loginRepository;

	private UserDetails userDetails;

	private Map<String, Object> userSession;

	public void setSession(Map<String, Object> session) {

		userSession = session;

	}

	public Map<String, Object> getSession() {
		return userSession;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Action(value = "/launchLogin", results = {
			@Result(name = "success", location = "loginerror.tiles", type = "tiles"),
			@Result(name = "error", location = "loginerror.tiles", type = "tiles") })
	public String launchLoginAction() {
		return SUCCESS;
	}
	
	@Action(interceptorRefs={
		      @InterceptorRef("defaultSecurityStack")},value = "/userlogin", results = {
			@Result(name = "success", location = "launchSite.tiles", type = "tiles"),
			@Result(name = "error", location = "loginerror.tiles", type = "tiles") })
	public String userlogin() {

		String result = "ERROR";
		UserDetails userDetailsFromDB = null;
		try {
			userDetailsFromDB = loginRepository.getUserDetails(userDetails
					.getUserid());
			if (null != userDetailsFromDB) {
				if (StringUtils.isNotBlank(userDetailsFromDB.getEncryptedpassword())) {
					if (StringUtils.equals(userDetails.getPassword(),
							DecryptionService.decrypt(userDetailsFromDB.getEncryptedpassword()))) {
						result = SUCCESS;
						if (null != userDetailsFromDB) {
							userSession.put("LOGGEDIN_USER_PROFILE",
									userDetailsFromDB);
							userSession.put("LOOGEDIN_STATUS", true);
						}
					} else {
						addActionError("Password not matched");
						result = ERROR;
					}
				}
			} else {
				addActionError("User Not exixts");
				result = ERROR;
			}
		} catch (SMSWebException e) {
			addActionError(e.getMessage());
		}

		return result;
	}

	@Action(value = "/userLogout", results = {
			@Result(name = "success", location = "launchSite.tiles", type = "tiles"),
			@Result(name = "error", location = "launchSite.tiles", type = "tiles") })
	public String logout() {
		userSession.remove("LOGGEDIN_USER_PROFILE");
		userSession.remove("LOOGEDIN_STATUS");
		return ActionSupport.SUCCESS;
	}
}