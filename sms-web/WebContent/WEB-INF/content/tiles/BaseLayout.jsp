<!--
	Maven, Struts2 Annotations and Tiles Integration Example via Convention / Codebhind / Zero Config plugin using Eclipse IDE
	http://codeoftheday.blogspot.com/2013/07/maven-struts2-annotations-and-tiles.html 
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>

<title><tiles:insertAttribute name="title" /></title>
<head>
  <tiles:insertAttribute name="fixedheader" />
  <tiles:insertAttribute name="customheader" />
</head>
	<body>
		<tiles:insertAttribute name="menu" />
		<div id="site_content">
		<tiles:insertAttribute name="body" />
		</div>
		<tiles:insertAttribute name="footer" />
	</body>
</html>
