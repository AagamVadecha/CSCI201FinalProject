<%
String courseName= (String)session.getAttribute("courseName");
System.out.println("couse name: " + courseName);
int queueNumber = GuestServlet.getQueue();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="servlets.GuestServlet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="StudentCalendar.css" />
<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<script>
var xhttp = new XMLHttpRequest();
xhttp.open("GET", 'CheckQueueServlet?', false);
xhttp.send();

if(xhttp.responseText.trim().length > 0){
	document.getElementById("queueInfo").innerHTML =xhttp.responseText.trim();
}
else{
	return;
}
</script>


<title>Student Office Hour Queue</title>
</head>
<body>
<h1>Student <%= courseName %> Course Office Hour Queue</h1>


<p id = "QueueNumber" class="solid">Number of People in Queue #  <%= queueNumber %></p>

<div id="queueInfo"> </div>

<p id="signout">
<a href="servlet" style="color: #990000; text-decoration: none;" > Sign Out</a>
</p>

<!-- ADD/REMOVE FROM QUEUE -->
<%
//if the user is already in the queue show Remove From Queue
String check  = (String)request.getSession().getAttribute("queueStatus");
if(request.getSession().getAttribute("queueStatus") == "InQueue")
 { %>
	<div id = "leave">
		<form action="LeaveQueueServlet">
			<input type="submit" id="submit_button" value="LEAVE QUEUE">
		</form>
	</div> 
<%}
else { 
%>
	<div id = "join">
		<form action="JoinQueueServlet">
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
