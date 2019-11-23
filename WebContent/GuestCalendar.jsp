<%
String courseName= (String)session.getAttribute("courseName");
System.out.println("couse name: " + courseName);

int queueNumber = GuestServlet.getQueue();
GuestServlet.DisplayCalendar(courseName);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="servlets.GuestServlet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="GuestCalendar.css" />
<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
<title>Guest Calendar</title>
</head>
<body>
<h1>Guest  <%= courseName %> Calendar</h1>
<p id = "QueueNumber" class="solid">Number of People in Queue #  <%= queueNumber %></p>
<button class="button"> 
	<a href="SignOutServlet" style="color: #990000; text-decoration: none; font-weight: bold; font-size: 20px;" >Home Page</a>
</button>
</body>
</html>
