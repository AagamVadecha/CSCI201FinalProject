<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="Guest.css" />
<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
<title>Guest</title>
</head>
<body>
<p id = "Guest" class="solid">Guest</p>
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