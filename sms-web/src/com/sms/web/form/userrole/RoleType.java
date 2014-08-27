package com.sms.web.form.userrole;

public enum RoleType {
	
		READWRITE("RW"), READONLY("RO"), NOACCESS("NO"),ADMINROLE("YES");
	 
		private String roleType;
	 
		public String getRoleType() {
			return roleType;
		}

		private RoleType(String roleType) {
			this.roleType = roleType;
		}
	 

}
