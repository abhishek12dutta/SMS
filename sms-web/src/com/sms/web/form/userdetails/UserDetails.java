package com.sms.web.form.userdetails;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sms.web.form.userrole.UserRoleDetails;

@Document
public class UserDetails {
	private Date creationtime;

	@Pattern(regexp = "^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((19|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$",message="please enter dob in dd/mm/yyyy format")
	private String dob;

	@NotEmpty
	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "email is not valid format")
	private String email;
	@NotNull(message = "Firstname cannot be null")
	private String firstname;
	@NotNull(message = "Lastname cannot be null")
	private String lastname;	
	@NotNull
	@Size(min = 2, max = 14, message = "password should be between 8 to 14 character")
	private String password;
	@Id
	@NotNull
	@Length(min=6, max=6, message = "Userid Should be lenght of 6")
	private String userid;
	
	private String encryptedpassword;
	
	public String getEncryptedpassword() {
		return encryptedpassword;
	}

	public void setEncryptedpassword(String encryptedpassword) {
		this.encryptedpassword = encryptedpassword;
	}

	private UserRoleDetails userRoleDetails;

	public Date getCreationtime() {
		return creationtime;
	}

	public String getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getPassword() {
		return password;
	}

	public String getUserid() {
		return userid;
	}

	public UserRoleDetails getUserRoleDetails() {
		return userRoleDetails;
	}

	public void setCreationtime(Date creationtime) {
		this.creationtime = creationtime;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setUserRoleDetails(UserRoleDetails userRoleDetails) {
		this.userRoleDetails = userRoleDetails;
	}

}