<%
	ArrayList <String> course_list = CourseManager.getAllCourses();  
	String username = (String)session.getAttribute("username");
    ArrayList <String> instructor_course_list = CourseManager.getInstructorCourses(username);   
    System.out.println("course_list size: " + instructor_course_list.size());
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="classes.CourseManager" %>
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
 
<div id = "newcourse">
        <form action="CreateCourse">
            <input type="text" name="new" value="Add New Course" id="commentbox"><br>
            <input type="submit" id="submit_newcourse" value="Add New Course">
        </form>
</div> 

<p id="signout">
<a href="SignOutServlet" style="color: #990000; text-decoration: none;"> Sign Out</a>
</p>

<h1>Select a course</h1>
<form id="dropdown" action="SetCourseID">  
    <select id="drop" name="course_list">    
	 <% for (int i = 0; i < course_list.size(); i++)
	 {
	     String course = course_list.get(i);
	     System.out.println("current course: " + course);
	%>
	 <option value="<%=course%>"><%=course%></option>
	<% 
	 }%>
	  </select>
	  <br><br>
	  <input id = "submit_button" type="submit">
</form>
</body>
</html>
