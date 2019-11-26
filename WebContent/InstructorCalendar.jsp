<%
String courseName = (String)session.getAttribute("courseName");
int courseID = (int) session.getAttribute("courseID");
System.out.println("course name: " + courseName);
ArrayList<String> courseOH = CourseManager.getOfficeHoursCourse(courseID);
//session.setAttribute("nextPage", "InstructorCalendar.jsp");

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
<h1>Instructor <%= courseName %> Calendar</h1>
<div id="start">
<button onclick="window.location.href = 'StartQueueServlet';" style="color: #990000; text-decoration: none;">Start Office Hour Now</button></div>

<div id = "hours">
        <form action="AddOfficeHours">
            Day <input type="text" name="day"></br>
            Start Time (between 0 and 24): <input type="number" name="hourStart" min="0" max="24"></br>
            End Time (between 0 and 24): <input type="number" name="hourEnd" min="0" max="24"></br> 
          <input type="submit">
        </form>     
</div>
<p id="signout">
<a href="SignOutServlet" style="color: #990000; text-decoration: none; text-align: center;" >Sign Out</a>
</p>
</body>
</html>
