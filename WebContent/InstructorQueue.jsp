<%
String courseName= (String)session.getAttribute("courseName");
System.out.println("couse name: " + courseName);
GuestServlet.DisplayCalendar(courseName);

session.setAttribute("nextPage", "InstructorCalendar.jsp");
session.setAttribute("checkType", "instructor");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="servlets.GuestServlet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="InstructorQueue.css" />
<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
var xhttp = new XMLHttpRequest();
xhttp.open("GET", 'DisplayQueueServlet?', false);
xhttp.send();

if(xhttp.responseText.trim().length > 0){
	document.getElementById("queueInfo").innerHTML =xhttp.responseText.trim();
}


function nextStudent(){
	var xhttp = new XMLHttpRequest();
	xhttp.open("GET", 'FinishQuestionServlet?', false);
	xhttp.send();
	updateQueue();

}
function noShow(){
	var xhttp = new XMLHttpRequest();
	xhttp.open("GET", 'NoShowServlet?', false);
	xhttp.send();
	updateQueue();

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
<title>Instructor Office Hour Queue</title>
</head>
<body>
<h1>Instructor <%= courseName %> Office Hour Queue</h1>
<%//queue entries are in divs with style class "queueEntry" %>
<div id="queueInfo"> </div>

<div class="queueButton">
<div id = "finishStudent" >
	<button type='button' onclick='nextStudent()'  style="color: #990000; text-decoration: none;" >Next Student</button>
</div> 


<div id = "noShow">
		<button type='button' onclick='noShow()'  style="color: #990000; text-decoration: none;" >Student Not Showing Up</button>
</div> 


<div id = "update">
		<button type='button' onclick='updateQueue()'  style="color: #990000; text-decoration: none;" >Update Page</button>
</div> 

<div id = "end">
		<form action="EndQueueServlet">
			<input type="submit" id="submit_button" value="End Office Hour"  style="color: #990000; text-decoration: none;" >
		</form>
</div> 
</div>


<p id="signout">
<a href="SignOutServlet" style="color: #990000; text-decoration: none; text-align: center;" >Sign Out</a>
</p>
</body>
</html>
