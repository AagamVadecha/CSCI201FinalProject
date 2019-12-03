<%
String courseName= (String)session.getAttribute("courseName");
System.out.println("course name: " + courseName);

int queueNumber = GuestServlet.getQueue();
GuestServlet.DisplayCalendar(courseName);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="servlets.GuestServlet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="GuestCalendar2.css" />
<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
<title>Guest Calendar</title>
</head>
<body>
<h1>Guest  <%= courseName %> Calendar</h1>
<p id = "QueueNumber" class="solid">Number of People in Queue #  <%= queueNumber %></p>
<button class="button" style="margin-left: 20px;"> 
	<a href="SignOutServlet" style="color: #990000; text-decoration: none; font-weight: bold; font-size: 20px;" >Home Page</a>
</button>
<div style="width: 900px; margin-left: 140px; margin-top: 30px;">
 <div style="float: left; width: 150px;">
	 <table border="1" style="border-color: #990000; border-style: hidden; font-size: 20px; color: #990000; background-color: #FFCC00;">
		<tr>
		<td>Monday</td>
		</tr>
		<!-- PRINT OFFICE HOUR TABLE: Get table for each day and sort by hourstart (repeat function below
	for each day + can make into for loop looping through all days (mon-fri) to not repeat code)
	
	can either 1) call SQL function here (as shown below) OR
	2) print html from servlet/java class and append to calendar div in this jsp
	-->
	<%
	/*
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost/test";
	String username="root";
	String password="root";
	
	String query="SELECT * FROM officeHour WHERE courseID = ? AND day = ? ORDER BY hourStart ASC;";
	Connection conn=DriverManager.getConnection(url,username,password);
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(query);
	while(rs.next())
	{
	*/
	%>
	    <tr><td><%/*=rs.getInt("hourStart"); */%>:00 - <%/*=rs.getInt("hourEnd"); */%>:00</td></tr>
	<%
	/*}*/
	%>
	    </table>
	    <%
	    /*rs.close();
	    stmt.close();
	    conn.close();
	    }*/
	/*
	catch(Exception e)
	{
	    e.printStackTrace();
	    }*/
	%>
	</table>
</div>
 <div style="float: left; width: 150px;">
	 <table border="2 " style="border-color: #990000; border-style: hidden; font-size: 20px; color: #990000; background-color: #FFCC00;">
		<tr>
		<td>Tuesday</td>
		</tr>
	</table>
</div>
 <div style="float: left; width: 180px;">
  	<table border="2" style="border-color: #990000; border-style: hidden; font-size: 20px; color: #990000; background-color: #FFCC00;">
		<tr>
		<td>Wednesday</td>
		</tr>
	</table>
 </div>
  <div style="float: left; width: 160px;">
  	<table border="2" style="border-color: #990000; border-style: hidden; font-size: 20px; color: #990000; background-color: #FFCC00;">
		<tr>
		<td>Thursday</td>
		</tr>
	</table>
 </div>
  <div style="float: left; width: 130px;">
  	<table border="2" style="border-color: #990000; border-style: hidden; font-size: 20px; color: #990000; background-color: #FFCC00;">
		<tr>
		<td>Friday</td>
		</tr>
	</table>
 </div>
  </div>
  <div style="float: left; width: 150px;">
  	<table border="2" style="border-color: #990000; border-style: hidden; font-size: 20px; color: #990000; background-color: #FFCC00;">
		<tr>
		<td>Satuday</td>
		</tr>
	</table>
 </div>
  </div>
  <div style="float: left; width: 150px;">
  	<table id="sunday" border="2" style="border-color: #990000; border-style: hidden; font-size: 20px; color: #990000; background-color: #FFCC00;">
		<tr>
		<td>Sunday</td>
		</tr>
	</table>
 </div>
 <br style="clear: left;" />
</div>
</body>
</html>
