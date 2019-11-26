<%
String courseName= (String)session.getAttribute("courseName");
System.out.println("course name: " + courseName);
int queueNumber = GuestServlet.getQueue();
GuestServlet.DisplayCalendar(courseName);
session.setAttribute("checkType", "student");





//to be deleted later
session.setAttribute("userID", 0);
session.setAttribute("courseID",0);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="servlets.GuestServlet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="StudentCalendar.css" />
<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
<title>Student Calendar</title>
</head>
<body>
<h1>Student<%= courseName %> Course Name Calendar</h1>
<p id = "QueueNumber" class="solid">Number of People in Queue #  <%= queueNumber %></p>
<p id="signout">
<a href="servlet" style="color: #990000; text-decoration: none;" > Sign Out</a>
</p>
<p id="checkQueue">
<a href="CheckQueueServlet" style="color: #990000; text-decoration: none;" > Check Queue Detail</a>
</p>


</body>
</html>
