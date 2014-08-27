package com.sms.web.action.login;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.sms.web.exception.SMSWebException;
import com.sms.web.form.userdetails.UserDetails;
import com.sms.web.repository.login.LoginRepository;

public class UserSignupAction extends ActionSupport {

	@Autowired
	private LoginRepository loginRepository;

	private UserDetails userDetails;
	
	private String confirmPass;
	

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Action(value = "/launchUsersignup", results = {
			@Result(name = "success", location = "launchUsersignup.tiles", type = "tiles"),
			@Result(name = "error", location = "launchUsersignup.tiles", type = "tiles") })
	public String launchUserlogin() {
		return SUCCESS;
	}

	@Action(value = "/usersignup", results = {
			@Result(name = "success", location = "usersignupresult.tiles", type = "tiles"),
			@Result(name = "error", location = "usersignupresult.tiles", type = "tiles") })
	public String userlogin() {

		String result = SUCCESS;
		try {
			ValidatorFactory validatorFactory = Validation
					.buildDefaultValidatorFactory();
			Validator validator = validatorFactory.getValidator();
			Set<ConstraintViolation<UserDetails>> violations = validator
					.validate(userDetails);
			if(null !=confirmPass && null !=userDetails.getPassword()){
				if(confirmPass.equals(userDetails.getPassword())){
					addActionError("password not matched");
				}
			}
			if (violations.size() > 0) {
				for (ConstraintViolation<UserDetails> violation : violations) {
					String propertyPath = violation.getPropertyPath()
							.toString();
					String message = violation.getMessage();
					System.out.println("invalid value for: '" + propertyPath
							+ "': " + message);
					addActionError(message);
					result = ERROR;
				}
			}else if(getActionErrors().size()>0){
				result = ERROR;
			}else {
				userDetails.setCreationtime(new Date());
				loginRepository.createUser(userDetails);
				addActionMessage("User Successfully created");
			}

		} catch (SMSWebException smsWebException) {
			addActionError(smsWebException.getMessage());
			result = ERROR;
		}
		return result;

	}
}