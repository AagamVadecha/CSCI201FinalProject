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
	<button id='button' type='button' onclick='nextStudent()' style="margin-left : 880px; margin-top : 25px; background-color: #FFCC00; border: 0.5px; border-radius: 3px; width : 150px; height : 40px; color: #990000; text-decoration: none; font-weight: bold; font-size: 20px;" >Next Student</button>
</div> 


<div id = "noShow">
		<button id='button' type='button' onclick='noShow()'  style="margin-left : 880px; margin-top : 25px; background-color: #FFCC00; border: 0.5px; border-radius: 3px; width : 150px; height : 60px; color: #990000; text-decoration: none; font-weight: bold; font-size: 20px;" >Student Not Showing Up</button>
</div> 


<div id = "update">
		<button id='button' type='button' onclick='updateQueue()'  style="margin-left : 880px; margin-top : 25px; background-color: #FFCC00; border: 0.5px; border-radius: 3px; width : 150px; height : 40px; color: #990000; text-decoration: none; font-weight: bold; font-size: 20px;" >Update Page</button>
</div> 

<div id = "end">
		<form action="EndQueueServlet">
			<input type="submit" value="End Office Hour"  style="margin-left : 880px; margin-top : 25px; background-color: #FFCC00; border: 0.5px; border-radius: 3px; width : 170px; height : 40px; color: #990000; text-decoration: none; font-weight: bold; font-size: 20px;">
		</form>
</div> 
</div>

<p id="signout">
<a href="SignOutServlet" style="color: #990000; text-decoration: none;" > Sign Out</a>
</p>
</body>
</html>
