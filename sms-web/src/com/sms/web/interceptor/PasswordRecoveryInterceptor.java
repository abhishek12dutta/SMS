package com.sms.web.interceptor;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PasswordRecoveryInterceptor implements Interceptor {

	/**
	 * This class is responsible for check session, if session expire it will
	 * redirect to "sessionexpired" page.
	 */
	private static final long serialVersionUID = 1L;
	private Logger LOGGER = Logger.getLogger(PasswordRecoveryInterceptor.class);

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		long startTime = System.currentTimeMillis();
		LOGGER.debug("<<<<<<<<<<<<<<<<<<<<<<<--ENTER METHOD>>>>>>>>>>>>>>>>> SessionCheckInterceptor intercept(ActionInvocation actionInvocation)+"
				+ "\n");
		ActionContext context = actionInvocation.getInvocationContext();
		Map<String, Object> sessionMap = context.getSession();
		
		Object action = actionInvocation.getAction();
	/*	action.getClass().get
		if ((action instanceof LoginAction)) {
			action.
			return actionInvocation.invoke();
		}*/
		
		LOGGER.debug(" retrived session..." + sessionMap);
		LOGGER.debug("=======================RETRIVED SESSION FROM CONTEXT==============================");
		String userId = (String) sessionMap.get("recoveryId");

		// sb: if the user is already signed-in, then let the request through.
		if (userId != null) {
			return actionInvocation.invoke();
		}

	

		// sb: if the action doesn't require sign-in, then let it through.

		// sb: if this request does require login and the current action is
		// not the login action, then redirect the user
		if (sessionMap == null || sessionMap.isEmpty()) {
			LOGGER.debug("=======================SESSION EXPIRED==============================");
			return "sessionexpired";
		}
		String actionResult = actionInvocation.invoke();
		LOGGER.debug("<<<<<<<<<<<<<<<<<<<<<<EXIT LOG>>>>>>>>>>>>>TOTAL EXECUTION TIME<<<<<<<<<["
				+ (System.currentTimeMillis() - startTime) + " ]>>>>> MILI SEC");
		return actionResult;
	}
}
