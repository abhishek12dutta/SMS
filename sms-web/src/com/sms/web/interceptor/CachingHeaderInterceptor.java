package com.sms.web.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CachingHeaderInterceptor extends AbstractInterceptor {
	private Logger LOGGER = Logger.getLogger(CachingHeaderInterceptor.class);
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		long startTime = System.currentTimeMillis();
		LOGGER.debug("<<<<<<<<<<<<<<<<<<<<<<<--ENTER METHOD>>>>>>>>>>>>>>>>> CachingHeaderInterceptor intercept() method +"
				+ "\n");
		final ActionContext actionContext = invocation.getInvocationContext();
		Map<String, Object> sessionMap = actionContext.getSession();
		HttpServletResponse response = (HttpServletResponse) actionContext
				.get(StrutsStatics.HTTP_RESPONSE);
		if (response != null) {
			response.setHeader("Cache-control", "no-cache, no-store");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Expires", "-1");

		}
		LOGGER.debug("<<<<<<<<<<<<<<<<<<<<<<EXIT CachingHeaderInterceptor intercept() method>>>>>>>>>>>>>TOTAL EXECUTION TIME<<<<<<<<<["
				+ (System.currentTimeMillis() - startTime) + " ]>>>>> MILI SEC");
		return invocation.invoke();
	}

}
