<%
	String courseName = (String)session.getAttribute("courseName");
	int courseID = (int) session.getAttribute("courseID");
	System.out.println("course name: " + courseName);
	ArrayList<String> courseOH = CourseManager.getOfficeHoursCourse(courseID);
	// FIX PARSING THE courseOH ARRAY LIST 
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="servlets.GuestServlet" import="classes.CourseManager"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="InstructorCalendar.css" />
	<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
	<title>Instructor Calendar</title>
</head>
<body>
    <div id = "header">
		<h1 class="allTitles">Instructor <%=courseName %> Calendar</h1>
	</div>
	
	<div id="buttons">
		<div id="start">
		   <button class="allButtons" onclick="window.location.href = 'StartQueueServlet';" >Start Office Hour Now</button>
		</div>
			
		<div id="signout">
		   <a href="SignOutServlet" class="allButtons">Sign Out</a>
		</div>
		 
	</div>
	
	
	<div id ="content">
	
		<div id = "hours">
		    <p class="allTitles">Add More Office Hours</p>
	        <form id="hoursForm" action="AddOfficeHours">
	            Day <input type="text" name="day"></br>
	            Start Time (between 0 and 24): <input type="number" name="hourStart" min="0" max="24"></br>
	            End Time (between 0 and 24): <input type="number" name="hourEnd" min="0" max="24"></br> 
	          <input class="allButtons" id="submitButton" type="submit">
	        </form>     
		</div>
	
		<div id="officeHoursList">
		       <p class="allTitles"> Office Hours for <%=courseName%> </p>
		       <table id ="OHTable"> 
		           <% for(int i = 0; i < courseOH.size(); ++i){ %>
                       <tr>
                           <%=courseOH.get(i)%>
                       </tr>
                   <% } %>
		       </table>
		</div>
		
	</div>
	
	
</body>
</html>
