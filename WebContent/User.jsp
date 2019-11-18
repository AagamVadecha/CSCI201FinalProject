<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="User.css" />
<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
<title>User</title>
</head>
<body>
<div class="header">
	<h1>Are You A</h1>
</div>
	<div>
		<button class="button guest-button"> 
			<a href="Guest.jsp" style="color: #990000; text-decoration: none; font-weight: bold; font-size: 20px;" >Guest</a>
		</button>
		<button class="button instructor-button"> 
			<a href="InstructorSignIn.jsp" style="color: #990000; text-decoration: none; font-weight: bold; font-size: 20px;" >Instructor</a>
		</button>
		<button class="button student-button"> 
			<a href="StudentSignIn.jsp" style="color: #990000; text-decoration: none; font-weight: bold; font-size: 20px;" >Student</a>
		</button>
	</div>
</body>
</html>