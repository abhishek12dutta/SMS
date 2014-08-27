/**
 * Maven, Struts2 Annotations and Tiles Integration Example via Convention / Codebhind / Zero Config plugin using Eclipse IDE
 * http://codeoftheday.blogspot.com/2013/07/maven-struts2-annotations-and-tiles.html
 */
package com.sms.web.action.welcome;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class WelcomeWebSiteAction extends ActionSupport implements SessionAware{
	
	private String serverTime;
	private static int totalVisits;
	
	private Map<String, Object> userSession;

	public void setSession(Map<String, Object> session) {
		userSession = session;

	}

	public Map<String, Object> getSession() {
		return userSession;
	}

	@Action(value="/launchSite", results={@Result(name="success", location="launchSite.tiles", type="tiles")})
	public String launchSite()
	{
		boolean loogedInStatus =false;
		serverTime = SimpleDateFormat.getDateTimeInstance().format(new Date(System.currentTimeMillis()));
		System.out.println("serverTime = " + serverTime);
		System.out.println("totalVisits = " + ++totalVisits);
		if(userSession.containsKey("LOOGEDIN_STATUS")){
			loogedInStatus = (Boolean)userSession.get("LOOGEDIN_STATUS");
		}
		if (loogedInStatus) {
			//do nothing
		}else{
			userSession.put("LOOGEDIN_STATUS", loogedInStatus);
		}
		return "success";
	}

	public String getServerTime() {
		return serverTime;
	}
	
	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}
	
	public int getTotalVisits() {
		return totalVisits;
	}
	
	public void setTotalVisits(int totalVisits) {
		WelcomeWebSiteAction.totalVisits = totalVisits;
	}

}
