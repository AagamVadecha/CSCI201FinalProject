<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="servlets.GuestServlet" import ="classes.CourseManager"%>
<!DOCTYPE html>
<html>

<%
//session.setAttribute("nextPage", "/StudentCalendar.jsp");
ArrayList <String> course_list = CourseManager.getAllCourses();   
%>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="Student.css" />
	<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
	<title>Student</title>
</head>
<body>
	<p id = "Student" class="solid">Student</p>
	<p id="signout">
	<a href="servlet" style="color: #990000; text-decoration: none;" > Sign Out</a>
	</p>
	<h1>Select a course</h1>
	<form id="dropdown" action="SetCourseIDStudent">  
	  <select id="drop" name="course_list">
	    
		 <% for (int i = 0; i < course_list.size(); i++) {
		     String course = course_list.get(i);
		 %>
		     <option  value="<%=course%>"> <%=course%></option>
		<% } %>
	  </select>
	  <br><br>
	  <input id = "submit_button" type="submit">
	</form>
</body>
</html>
