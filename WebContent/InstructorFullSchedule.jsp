<%
/* IF U WANT MAKE A NEW FUNCTION TO DISPLAY ALL OF COURSE'S OFFICE HOURS
OR USE DisplayCalendar IN A LOOP FOR ALL OF THIS COURSE'S OFFICE HOURS */
String courseName= (String)session.getAttribute("courseName");
System.out.println("couse name: " + courseName);
GuestServlet.DisplayCalendar(courseName);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="servlets.GuestServlet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="InstructorFullSchedule.css" />
<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
<title>Instructor Full Schedule</title>
</head>
<body>
<h1>My Schedule</h1>
<p id="signout">
<a href="SignOutServlet" style="color: #990000; text-decoration: none;"> Sign Out</a>
</p>
</body>
</html>
