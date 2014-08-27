package com.sms.web.repository.login;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.sms.web.exception.SMSWebException;
import com.sms.web.form.userdetails.UserDetails;
import com.sms.web.form.userrole.RoleType;
import com.sms.web.form.userrole.UserRoleDetails;

public class LoginRepositoryImpl implements LoginRepository {

	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void createUser(UserDetails userDetails) throws SMSWebException {
		try {
			userDetails.setUserRoleDetails(populateDefaultUserRole(userDetails));
			UserDetails existingUserDetails = mongoTemplate.findById(userDetails.getUserid(), UserDetails.class);
			if(null == existingUserDetails){
					mongoTemplate.insert(userDetails);
			}else{
				throw new SMSWebException("UserId already exists");
			}

		} catch (Exception e) {
			throw new SMSWebException(e.getMessage());
		}
		
	}

	private static UserRoleDetails populateDefaultUserRole(
			UserDetails userDetails) {
		UserRoleDetails userRoleDetails = new UserRoleDetails();
		userRoleDetails.setAdminRole(RoleType.ADMINROLE.getRoleType());
		userRoleDetails.setEventRole(RoleType.NOACCESS.getRoleType());
		userRoleDetails.setFinanceRole(RoleType.NOACCESS.getRoleType());
		userRoleDetails.setStudentRole(RoleType.NOACCESS.getRoleType());
		userRoleDetails.setUserid(userDetails.getUserid());
		return userRoleDetails;
	}

	public UserDetails getUserDetails(String userid) {
		return mongoTemplate.findOne(
				new Query(Criteria.where("userid").is(userid)),
				UserDetails.class);
	}

}
