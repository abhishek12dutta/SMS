<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="main">
	<div id="header">
	<div id="logo">
		<div id="logo_text">
			<!-- class="logo_colour", allows you to change the colour of the text -->
			<h1>
				<a href="index.html">CSS3<span class="logo_colour">_one</span> </a>
			</h1>
			<h2>Simple. Contemporary. Website Template.</h2>
		</div>
		<div id="showTime">
			<script type="text/javascript">
				function display_c() {
					var refresh = 1000; // Refresh rate in milli seconds
					mytime = setTimeout('display_ct()', refresh)
				}

				function display_ct() {
					var strcount
					var date = new Date().toString();
					var gmtIndex = date.indexOf("GMT");
					//alert(int);
					date = date.substring(0, gmtIndex);
					document.getElementById('ct').innerHTML = date;
					tt = display_c();
				}
			</script>
			<body onload=display_ct();>
				<span id='ct'></span>
		</div>
	</div>
	<c:set var="userLoggedInStatus" value="${sessionScope.LOOGEDIN_STATUS}" />
	<c:set var="userRoles" value="${sessionScope.LOGGEDIN_USER_PROFILE.userRoleDetails}" />
	<div id="upper-menu-container" style="margin-top: 100px;">
		<div id="page-menu-wrapper">
			<ul class="main left no-js">
				<li><a href="<c:url value="launchSite.action"/>" class="home"><span
						aria-hidden="true" class="icn_logo"></span> </a></li>
						<c:if test="${(userRoles.financeRole == 'RW') || (userRoles.financeRole == 'RO')}">
				<li class="submenu-item mobile-class"><a href="#"
					class="top-menu"> Finance </a>
					<div class="dropdown-menu categories">
						<div class="menu-header">
							<ul id="menu-nav-menu-1" class="menu">
								<li class="menu-item"><a
									href="">Menu 1</a></li>
								<li
									class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-18118"><a
									href="">Menu 2</a></li>
								<li
									class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-18124"><a
									href="">Menu 3</a></li>
							</ul>
						</div>
					</div></li>
					</c:if>
					<c:if test="${(userRoles.studentRole == 'RW') || (userRoles.studentRole == 'RO')}">
					<li class="submenu-item mobile-class"><a href="#"
					class="top-menu"> Student </a>
					<div class="dropdown-menu categories">
						<div class="menu-header">
							<ul id="menu-nav-menu-1" class="menu">
								<li class="menu-item"><a
									href="http://designmodo.com/design/">View Student</a></li>
								<li
									class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-18118"><a
									href="">Add Student</a></li>
							</ul>
						</div>
					</div></li>
					</c:if>
					<c:if test="${(userRoles.eventRole == 'RW') || (userRoles.eventRole == 'RO')}">
					<li class="submenu-item mobile-class"><a href="#"
					class="top-menu"> Events </a>
					<div class="dropdown-menu categories">
						<div class="menu-header">
							<ul id="menu-nav-menu-1" class="menu">
								<li class="menu-item"><a
									href="">Manage NoticeBoard</a></li>
								<li
									class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-18118"><a
									href="">Manage Events</a></li>
							</ul>
						</div>
					</div></li>
					</c:if>
					<c:if test="${(userRoles.adminRole == 'YES')}">
					<li class="submenu-item mobile-class"><a href="#"
					class="top-menu"> Admin </a>
					<div class="dropdown-menu categories">
						<div class="menu-header">
							<ul id="menu-nav-menu-1" class="menu">
								<li class="menu-item"><a
									href="">Manage User Roles</a></li>
							</ul>
						</div>
					</div></li>
					</c:if>
			</ul>
			<ul class="main right no-js"
				style="float: right; right: -1px; position: relative;">
				<c:if test="${(userLoggedInStatus == true)}">
				<li class="submenu-item mobile-class"><a class="top-menu"
					href="#">Welcome&nbsp;<c:out
									value="${sessionScope.LOGGEDIN_USER_PROFILE.firstname}" />&nbsp;<c:out
									value="${sessionScope.LOGGEDIN_USER_PROFILE.lastname}" /></a>

					<div class="dropdown-menu follow">
						<ul class="social">
							<li><a target="_blank" rel="nofollow" class="changepassword" title=""
								href=""><span>&nbsp;</span>Change Password</a>
							</li>
							<li><a target="_blank" rel="nofollow" class="userprofile"
								title="" href=""><span>&nbsp;</span>Update Profile</a>
							</li>
							<li><a target="_blank" rel="nofollow" class="logout"
								title="" href="<c:url value="userLogout.action"/>"><span>&nbsp;</span>LogOut</a>
							</li>
							<%-- <li><a target="_blank" rel="nofollow" class="googleplus"
								title="" href=""><span
									class="icn_googleplus" aria-hidden="true"></span>Google+</a>
							</li>
							<li><a target="_blank" rel="nofollow" class="dribbble"
								title="" href=""><span
									class="icn_dribbble" aria-hidden="true"></span>Dribbble</a>
							</li> --%>
						</ul>
						<div class="counter">359710 Subscribers &amp; Followers</div>
					</div>
				</li>
				</c:if>
				<c:if test="${(userLoggedInStatus == false)}">
					<li class="submenu-item mobile-class"><a
						href="<c:url value="launchLogin.action"/>"
						class="top-menu profile"><label>Sign In</label> </a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
	</div>