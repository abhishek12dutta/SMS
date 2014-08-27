
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 
<s:if test="hasActionMessages()">
   <div class="success">
      <s:actionmessage/>
   </div>
</s:if> -->
<s:if test="hasActionErrors()">
   <div class="error">
      <s:actionerror/>
   </div>
</s:if>
<div class="green-full-width Sign In">

            
                    <h1>Sign In</h1>

                    
                    
                    <div class="content-body">
                        <form action="userlogin" method="post" class="login">
                            <p class="form-row form-row-wide">
                                <label for="username">Username:</label>
                                <input type="text" tabindex="1" id="username" name="userDetails.userid" class="input-text">
                            </p>
                            <p class="form-row form-row-wide">
                                <label class="sign_pw" for="password">Password:</label>
                                <a tabindex="3"  href="#" class="lost_password"> Lost Password?</a>
                                <input type="password" tabindex="2" id="password" name="userDetails.password" class="input-text">
                            </p>
                            <div class="clear"></div>

                            <p class="form-row login_form">
                                 <input type="submit" value="Sign In" name="" class="button">
								<a href="<c:url value="launchUsersignup.action"/>" class="button register_button">Sign Up</a>
                            </p>
                        </form>
                    </div>

                            </div>
