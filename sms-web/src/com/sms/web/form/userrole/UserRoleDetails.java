package com.sms.web.form.userrole;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserRoleDetails {
	private String adminRole;
	private String financeRole;
	private String eventRole;
	private String studentRole;
	@Id
	private String userid;



	public String getUserid() {
		return userid;
	}

	public String getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}

	public String getFinanceRole() {
		return financeRole;
	}

	public void setFinanceRole(String financeRole) {
		this.financeRole = financeRole;
	}

	public String getEventRole() {
		return eventRole;
	}

	public void setEventRole(String eventRole) {
		this.eventRole = eventRole;
	}

	public String getStudentRole() {
		return studentRole;
	}

	public void setStudentRole(String studentRole) {
		this.studentRole = studentRole;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	

}
