package com.sms.web.interceptor;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.sms.web.action.login.UserLoginAction;

public class SessionCheckInterceptor implements Interceptor {

	/**
	 * This class is responsible for check session, if session expire it will
	 * redirect to "sessionexpired" page.
	 */
	private static final long serialVersionUID = 1L;
	private Logger LOGGER = Logger.getLogger(SessionCheckInterceptor.class);

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
		LOGGER.debug(" retrived session..." + sessionMap);
		LOGGER.debug("=======================RETRIVED SESSION FROM CONTEXT==============================");
		boolean loggedInStatus = (Boolean) sessionMap
				.get("LOOGEDIN_STATUS");

		// sb: if the user is already signed-in, then let the request through.
		if (loggedInStatus) {
			return actionInvocation.invoke();
		}

		Object action = actionInvocation.getAction();

		// sb: if the action doesn't require sign-in, then let it through.

		// sb: if this request does require login and the current action is
		// not the login action, then redirect the user
		if ((action instanceof UserLoginAction)) {
			return actionInvocation.invoke();
		}
		if (sessionMap == null || sessionMap.isEmpty()
				|| sessionMap.get("LOOGEDIN_STATUS") == null) {
			LOGGER.debug("=======================SESSION EXPIRED==============================");
			return "sessionexpired";
		}
		String actionResult = actionInvocation.invoke();
		LOGGER.debug("<<<<<<<<<<<<<<<<<<<<<<EXIT LOG>>>>>>>>>>>>>TOTAL EXECUTION TIME<<<<<<<<<["
				+ (System.currentTimeMillis() - startTime) + " ]>>>>> MILI SEC");
		return actionResult;
	}
}
