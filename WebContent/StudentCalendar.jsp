<%
	int queueNumber = GuestServlet.getQueue();
	
	String courseName = (String)session.getAttribute("courseName");
    int courseID = (int) session.getAttribute("courseID");
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
	<div id = "header">
        <h1 class="allTitles"><%=courseName %> Calendar</h1>
    </div>
    
    <div id="signout">
           <a id="signOutButton" href="SignOutServlet" >Sign Out</a>
    </div>
    
    <div id="queueButtons">
        <p class="allTitles">Queue Information</p>
		<div id = "queueNumber" >
		  Number of People in Queue #  <%=queueNumber%> <!-- TODO? -->
		</div>
		
		<div id="checkQueue">
		   <a href="CheckQueueServlet" class="allButtons" >Check Queue Details</a>
		</div>
    </div>

	<div id="officeHoursList">
		<p class="allTitles">
			Office Hours for
			<%=courseName%>
		</p>
		<table id="OHTable">
			<% for(int i = 0; i < courseOH.size(); ++i){ %>
			<tr>
				<%=courseOH.get(i)%>
			</tr>
			<% } %>
		</table>
	</div>
</body>
</html>
