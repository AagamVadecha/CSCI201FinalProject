<%
	int queueNumber = GuestServlet.getQueue();
	
	//String courseName = (String)session.getAttribute("courseName");
	// int courseID = (int) session.getAttribute("courseID"); 
	String courseName = "CSCI 201";
	int courseID = 1; 
	System.out.println("course name: " + courseName);
	ArrayList<String> courseOH = CourseManager.getOfficeHoursCourse(courseID);
	System.out.println("number of office hours: " + courseOH.size());
	// TODO - PARSE courseOH AND DISPLAY COURSES
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="servlets.GuestServlet" import="classes.CourseManager"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="StudentCalendar.css" />
	<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
	<title>Student Calendar</title>
</head>
<body>
	<h1>Student <%= courseName %> Calendar</h1>
	<p id = "QueueNumber" class="solid">Number of People in Queue #  <%= queueNumber %></p>
	<p id="signout">
	   <a href="servlet" style="color: #990000; text-decoration: none;" > Sign Out</a>
	</p>
	<p id="checkQueue">
	   <a href="CheckQueueServlet" style="color: #990000; text-decoration: none;" > Check Queue Detail</a>
	</p>


</body>
</html>
