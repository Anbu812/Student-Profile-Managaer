<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% int sid=Integer.parseInt(request.getParameter("studentId")); %>
	<form action="AddSocialProfile" >
		<input name="studentId" value="<%=sid%>" type="text" hidden="true"> 
		<input type="number" name="socialProfileId" placeholder="Enter Profile Id">
		<input type="text" name="socialProfileName" placeholder="Enter Profile Name">
		<input type="text" name="url" placeholder="Enter Profile URL">
		<input type="submit" value="ADD" >
	</form>

</body>
</html>