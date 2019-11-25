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
<link rel="stylesheet" type="text/css" href="InstructorCalendar.css" />
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

function nextStudent(){
	var xhttp = new XMLHttpRequest();
	xhttp.open("GET", 'FinishQuestionServlet?', false);
	xhttp.send();
	update()

}
function noShow(){
	var xhttp = new XMLHttpRequest();
	xhttp.open("GET", 'NoShowServlet?', false);
	xhttp.send();
	update()

}
function update(){
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

<div id="queueInfo"> </div>

<div id = "finishStudnet">
	<button type='button' onclick='nextStudent()'>Next Student</button>
</div> 


<div id = "noShow">
		<button type='button' onclick='noShow()'>Student Not Showing Up</button>
</div> 


<div id = "update">
		<button type='button' onclick='update()'>Update Page</button>
</div> 

<div id = "end">
		<form action="EndQueueServlet">
			<input type="submit" id="submit_button" value="End Office Hour">
		</form>
</div> 

<p id="signout">
<a href="SignOutServlet" style="color: #990000; text-decoration: none; text-align: center;" >Sign Out</a>
</p>
</body>
</html>
