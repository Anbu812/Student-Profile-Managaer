<%@page
	import="com.jsp.springmvc_student_socialprofile.entity.SocialProfile"%>
<%@page import="java.util.List"%>
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
	int sid = (int) request.getAttribute("studentId");
	List<SocialProfile> profiles = (List<SocialProfile>) request.getAttribute("listOfProfiles");
	%>
	<table>
		<tr>
			<th>Social Profile Id</th>
			<th>Profile Name</th>
			<th>Profile URL</th>
		</tr>
		<%
		for (SocialProfile sp : profiles) {
		%>
		<tr>
			<td><%=sp.getSocialProfileId()%></td>
			<td><%=sp.getSocialProfileName()%></td>
			<td><%=sp.getUrl()%></td>
			<td><a href="showSocialProfile?socialProfileId=<%=sp.getSocialProfileId()%>&studentId=<%=sid%>">UPDATE</a></td>
			<td><a href="deleteSocialProfile?socialProfileId=<%=sp.getSocialProfileId()%>&studentId=<%=sid%>">DELETE</a></td>		
		</tr>
		<% } %>
	</table>
	<a href="addSocialProfile.jsp?studentId=<%=sid%>">Add Social Profile</a>
	<a href="displayAllStudentDetails">Back</a>
</body>
</html>