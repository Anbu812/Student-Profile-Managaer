<%@page import="com.jsp.springmvc_student_socialprofile.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Student student = (Student) request.getAttribute("Student"); %>
	<form action="Update" method="post">
		<input type="text" name="studentId" placeholder="Enter student ID" value="<%= student.getStudentId() %>" readonly="readonly">
		<input type="text" name="studentName" placeholder="Enter student Name" value="<%= student.getStudentName() %>">
		<input type="text" name="studentEmail" placeholder="Enter student Email" value="<%= student.getStudentEmail() %>">
		<input type="text" name="studentMarks" placeholder="Enter student Marks" value="<%= student.getStudentMarks() %>">
		<input type="submit" value="UPDATE"> 
	</form>

</body>
</html>