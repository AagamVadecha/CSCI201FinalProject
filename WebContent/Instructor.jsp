<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<p id = "CoursesLabel" class="solid">Your Courses
</p>
Courses Listed here
<button class="button"> 
<a href="servlet" style="color: #990000; text-decoration: none;">Your Schedule</a>
</button>
<p id="signout">
<a href="servlet" style="color: #990000; text-decoration: none;"> Sign Out</a>
</p>
<h1>Select a course</h1>
<form id="dropdown" method="GET" action="servlet">  
  <select id="drop" name="course_list">
    <option value="courses">Select Course</option>
    <option value="course1">course 1</option>
    <option value="course2">course 2</option>
    <option value="course3">course 3</option>
    <option value="course4">course 4</option>
  </select>
  <br><br>
  <input id = "submit_button" type="submit">
  </form>
</body>
</html>