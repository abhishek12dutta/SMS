package com.sms.web.repository.login;

import com.sms.web.exception.SMSWebException;
import com.sms.web.form.userdetails.UserDetails;

public interface LoginRepository {

	public void createUser(UserDetails userDetails) throws SMSWebException;

	public UserDetails getUserDetails(String userid) throws SMSWebException;

}
