
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="hasActionMessages()">
	<div class="success">
		<s:actionmessage />
	</div>
</s:if>
<s:if test="hasActionErrors()">
	<div class="error">
		<s:actionerror />
	</div>
</s:if>

<div class="green-full-width Registration">


	<h1>Registration</h1>

	<div class="content-body">
		<form autocomplete="off" action="usersignup" class="register" method="post" id="userSignUpForm">
			<p class="form-row form-row-wide">
				<label for="reg_username">Username:</label> <input type="text"
					value="" id="reg_username" name="userDetails.userid"
					class="input-text">
			</p>
			<p class="form-row form-row-wide">
				<label for="reg_firstname">First name</label> <input type="text"
					value="" id="reg_firstname" name="userDetails.firstname"
					class="input-text">
			</p>

			<p class="form-row form-row-wide">
				<label for="reg_lastname">Last name</label> <input type="text"
					value="" id="reg_lastname" name="userDetails.lastname"
					class="input-text">
			</p>

			<p class="form-row form-row-wide">
				<label for="reg_email">Email: </label> <input type="email" value=""
					id="reg_email" name="userDetails.email" class="input-text">
			</p>
			<p class="form-row form-row-wide">
				<label for="datepicker_result">DOB: </label> <input type="text"
					value="" name="userDetails.dob" class="input-text"
					id="datepicker_result" placeholder="DOB in dd/mm/yyyy format">
			</p>
			<div class="clear"></div>

			<p class="form-row form-row-first">
				<label for="reg_password">Password: </label> <input type="password"
					value="" id="reg_password" name="userDetails.password"
					class="input-text">
			</p>
			<p class="form-row form-row-last">
				<label for="reg_password2">Confirm password:</label> <input
					type="password" value="" id="reg_password2"
					name="confirmPass" class="input-text">
			</p>
			<div class="clear"></div>

			<p class="form-row">
				<input type="submit" value="Register" name="" class="button">
			</p>

		</form>
	</div>
</div>