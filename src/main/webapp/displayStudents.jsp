<%@page import="com.jsp.springmvc_student_socialprofile.entity.Student"%>
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
	
	<% List<Student> students=(List<Student>)request.getAttribute("list"); %>
	<table>
	<tr>
		<th>StudentId</th>
		<th>StudentName</th>
		<th>StudentEmail</th>
		<th>StudentMarks</th>
		<th>Social Profile</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	
	<% for(Student s:students) {%>
		<tr>
			<td><%= s.getStudentId() %></td>
			<td><%= s.getStudentName() %></td>
			<td><%= s.getStudentEmail() %></td>
			<td><%= s.getStudentMarks() %></td>
			<td><a href="DisplayAllSocialProfile?studentId=<%= s.getStudentId()%>">VIEW</a></td>
			<td><a href="findAndLoadStudent?studentId=<%= s.getStudentId()%>">UPDATE</a></td>
			<td><a href="deleteStudent?studentId=<%= s.getStudentId()%>">DELETE</a></td>
		</tr>
	<% } %>
	</table>
</body>
</html>