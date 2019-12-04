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
<link rel="stylesheet" type="text/css" href="StudentQueue.css" />
<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<script>
var xhttp = new XMLHttpRequest();
xhttp.open("GET", 'CheckQueueServlet?', false);
xhttp.send();

if(xhttp.responseText.trim().length > 0){
	document.getElementById("queueInfo").innerHTML =xhttp.responseText.trim();
}



function updateQueue(){
	var xhttp = new XMLHttpRequest();
	xhttp.open("GET", 'DisplayQueueServlet?', false);
	xhttp.send();
	if(xhttp.responseText.trim().length > 0){
		document.getElementById("queueInfo").innerHTML =xhttp.responseText.trim();
	}
	else{
		return;
	}
}
</script>


<title>Student Office Hour Queue</title>
</head>
<body>
<h1>Student <%= courseName %> Course Office Hour Queue</h1>

<div id="queueInfo"> </div>

<p id="signout">
<a href="SignOutServlet" style="color: #990000; text-decoration: none;" > Sign Out</a>
</p>

<!-- ADD/REMOVE FROM QUEUE -->
<%
//if the user is already in the queue show Remove From Queue
if(request.getSession().getAttribute("InQueue")==null || !(boolean)request.getSession().getAttribute("InQueue")){
	%>
	<div id = "join">
		<form action="JoinQueueServlet">
			<input type="text" name="comment" value="Add Comment Here" id="commentbox" style="margin-left : 800px; font-size: 15px; color: #990000; width : 300px; height : 40px; text-decoration: none;"><br>
			<input type="submit" value="JOIN QUEUE" style="margin-left : 880px; margin-top : 25px; background-color: #FFCC00; border: 0.5px; border-radius: 3px; width : 150px; height : 40px; color: #990000; text-decoration: none; font-weight: bold; font-size: 20px;">
		</form>
	</div> 
	
	
	<%
}
else 
 { %>
	<div id = "leave">
		<form action="LeaveQueueServlet">
			<input type="submit" value="LEAVE QUEUE" style="color: #990000; text-decoration: none;">
		</form>
	</div> 
<%}

%>
<div id = "update">
		<button class="button" onclick='updateQueue()' style="background-color: #FFCC00; border: 0.5px; border-radius: 3px; width : 150px; height : 40px; color: #990000; text-decoration: none; font-weight: bold; font-size: 20px;">Update Page</button>
</div> 

</body>
</html>
