<%
String courseName= (String)session.getAttribute("courseName");
System.out.println("couse name: " + courseName);
GuestServlet.DisplayCalendar(courseName);

session.setAttribute("nextPage", "InstructorCalendar.jsp");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="servlets.GuestServlet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="InstructorCalendar.css" />
<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
<title>Instructor Calendar</title>
</head>
<body>
<h1>Instructor <%= courseName %> Calendar</h1>
<div id="start">
<button><a href = "StartOfficeHoursServlet" style="color: #990000; text-decoration: none;">Start</a></button></div>

<div id = "hours">
		<form action="AddOfficeHours">
			Day <input type="text" name="day"></br>
		  	Start Time (between 0 and 24): <input type="number" name="hourStart" min="0" max="24"></br>
		  	End Time (between 0 and 24): <input type="number" name="hourEnd" min="0" max="24"></br> 
		  <input type="submit">
		</form>		
</div>
<p id="signout">
<a href="SignOutServlet" style="color: #990000; text-decoration: none; text-align: center;" >Sign Out</a>
</p>
</body>
</html>
