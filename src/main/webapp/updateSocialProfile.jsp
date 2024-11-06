<%@page import="com.jsp.springmvc_student_socialprofile.entity.SocialProfile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		SocialProfile socialProfie= (SocialProfile) request.getAttribute("Socialprofile"); 
		int sid = (int) request.getAttribute("studentId");
	%>
	<form action="updateSocialProfile" method="post">
		<input name="studentId" value="<%=sid%>" type="text" hidden="true"> 
		<input type="text" name="socialProfileId" placeholder="Enter Social profile ID" value="<%= socialProfie.getSocialProfileId() %>" >
		<input type="text" name="socialProfileName" placeholder="Enter Social profile Name" value="<%= socialProfie.getSocialProfileName() %> ">
		<input type="text" name="url" placeholder="Enter Social profile Url" value="<%= socialProfie.getUrl() %>">
		<input type="submit" value="UPDATE"> 
	</form>

</body>
</html>