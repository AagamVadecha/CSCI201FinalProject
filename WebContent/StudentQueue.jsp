<%
String courseName= (String)session.getAttribute("courseName");
System.out.println("couse name: " + courseName);
int queueNumber = GuestServlet.getQueue();
GuestServlet.DisplayCalendar(courseName);
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

<!-- ADD/REMOVE FROM QUEUE -->
<%
//if the user is already in the queue show Remove From Queue
String check  = (String)request.getSession().getAttribute("queueStatus");
if(request.getSession().getAttribute("queueStatus") == "InQueue")
 { %>
	<div id = "remove" >
	<a href="servlet" style="color: #990000; text-decoration: none;">Remove from queue</a>
	</div>
<%}
else { 
%>
	<div id = "join">
		<form action="GuestServlet">
			<input type="text" name="comment" value="Add Comment Here" id="commentbox"><br>
			<input type="submit" id="submit_button" value="JOIN QUEUE">
		</form>
	</div> 
	<!-- <div id = "join">
	<a href="servlet" style="color: #990000; text-decoration: none;">Join the queue</a>
	</div> -->
<%
}
%>
</body>
</html>
