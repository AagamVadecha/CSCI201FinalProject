
<%
    session.setAttribute("nextPage", "/GuestCalendar.jsp");

    ArrayList<String> course_list = CourseManager.getAllCourses();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList"
	import="servlets.GuestServlet" import="classes.CourseManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="Guest.css" />
<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
<title>Guest</title>
</head>
<body>
	<p id="Guest" class="solid">Guest</p>
	<h1>Select a course</h1>
	<form id="dropdown" method="GET" action="SetCourseIDGuest">
		<select id="drop" name="course_list">
			<option value="choose">Select Course</option>

			<%
			    for (int i = 0; i < course_list.size(); i++) {
			        String course = course_list.get(i);
			%>
			<option value="<%=course%>"> <%=course%></option>
			<%
			    }
			%>
		</select> <br>
		<br> <input id="submit_button" type="submit">
	</form>
</body>
</html>
