
<%
ArrayList <String> course_list = GuestServlet.getCourses();  
/*ASSUME THAT INSTRUCTOR NAME ("grujic:)") IS SAVED IN SESSION VARIABLE AFTER INSTRUCTOR LOGIN/ REGISTER*/
ArrayList <String> instructor_course_list = GuestServlet.getInstructorCourses("grujic:)");   
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="servlets.GuestServlet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="Instructor.css" />
<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
<title>Instructor</title>
</head>
<body>
<p id = "Instructor" class="solid">Instructor</p>
<p id = "CoursesLabel" class="solid">Your Courses</p>
Courses listed here
<% for (int i = 0; i <instructor_course_list.size(); i++)
 {	 String instructor_course = instructor_course_list.get(i); %>
  		<button><a href="InstructorCalendar.jsp" style="color: #990000; text-decoration: none;"><%=instructor_course%></a></button>
 <%
 }%>
 
<div id = "newcourse">
		<form action="InstructorAddCourse">
			<input type="text" name="new" value="Add New Course" id="commentbox"><br>
			<input type="submit" id="submit_button" value="ADD NEW COURSE">
		</form>
	</div> 
<button class="button"> 
<a href="InstructorFullSchedule.jsp" style="color: #990000; text-decoration: none;">Your Schedule</a>
</button>
<p id="signout">
<a href="servlet" style="color: #990000; text-decoration: none;"> Sign Out</a>
</p>
<h1>Select a course</h1>
<form id="dropdown" method="GET" action="InstructorCalendar.jsp">  
    <select id="drop" name="course_list">
    <option value="choose">Select Course</option>
    
 <% for (int i = 0; i < course_list.size(); i++)
 {
	 String course = course_list.get(i);
%>
 <option  value="<%= course %>"> <%= course %></option>
<% 
 }%>
  </select>
  <br><br>
  <input id = "submit_button" type="submit">
  </form>
</body>
</html>
