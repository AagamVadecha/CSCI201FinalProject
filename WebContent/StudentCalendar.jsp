
<%
    int queueNumber = GuestServlet.getQueue();

    String courseName = (String) session.getAttribute("courseName");
    int courseID = (int) session.getAttribute("courseID");
    System.out.println("course name: " + courseName);
    ArrayList<String> courseOH = CourseManager.getOfficeHoursCourse(courseID);

    System.out.println("number of office hours: " + courseOH.size());
    // TODO - PARSE courseOH AND DISPLAY COURSES
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList"
	import="servlets.GuestServlet" import="classes.CourseManager" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="StudentCalendar.css" />
<link rel="icon" href="cheesecake.png" type="image/png" sizes="16x16">
<title>Student Calendar</title>
</head>
<body>
	<div id="header">
		<h1 class="allTitles"><%=courseName%>
			Calendar
		</h1>
	</div>

	<div id="signout">
		<a id="signOutButton" href="SignOutServlet">Sign Out</a>
	</div>

	<div id="queueButtons">
		<p class="allTitles">Queue Information</p>
		<div id="queueNumber">
			Number of People in Queue #
			<%=queueNumber%>
			<!-- TODO? -->
		</div>

		<div id="checkQueue">
			<a href="CheckQueueServlet" class="allButtons">Check Queue
				Details</a>
		</div>
	</div>

	<div id="officeHoursList">
		<p class="allTitles">
			Office Hours for
			<%=courseName%>
		</p>
		<div style="margin-left: 140px; margin-top: 30px;">
			<!-- Monday table -->
			<div style="float: left; width: 150px;">
				<table border="1"
					style="border-color: #990000; border-style: hidden; font-size: 20px; color: #990000; background-color: #FFCC00;">
					<tr>
						<td>Monday</td>
					</tr>
					<%
					    try {
					        PreparedStatement ps = null;
					        Connection conn = null;
					        ResultSet rs = null;
					        Class.forName("com.mysql.jdbc.Driver");

					        String sql =
					            "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";
					        conn = DriverManager.getConnection(sql);

					        String query =
					            "SELECT * FROM officeHour WHERE courseID = ? AND day = ? ORDER BY hourStart ASC";
					        String d = "monday";
					        //   String query = "select * from officeHour where courseID=1 and day = \ order by hourStart asc"
					        ps = conn.prepareStatement(query);
					        ps.setInt(1, courseID);
					        ps.setString(2, d);
					        boolean success = ps.execute();

					        rs = ps.getResultSet();
					        while (rs.next()) {
					%>
					<tr>
						<td><%=rs.getInt("hourStart")%>:00 - <%=rs.getInt("hourEnd")%>:00
						</td>
					</tr>
					<%
					    }
					%>
					<%
					    rs.close();
					        ps.close();
					        conn.close();
					    } catch (Exception e) {
					        e.printStackTrace();
					    }
					%>
				</table>
			</div>
			<!-- End Monday table -->
			<!-- Tuesday table -->
			<div style="float: left; width: 150px;">
				<table border="2 "
					style="border-color: #990000; border-style: hidden; font-size: 20px; color: #990000; background-color: #FFCC00;">
					<tr>
						<td>Tuesday</td>
					</tr>
					<%
					    try {
					        PreparedStatement ps = null;
					        Connection conn = null;
					        ResultSet rs = null;
					        Class.forName("com.mysql.jdbc.Driver");

					        String sql =
					            "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";
					        conn = DriverManager.getConnection(sql);

					        String query =
					            "SELECT * FROM officeHour WHERE courseID = ? AND day = ? ORDER BY hourStart ASC";
					        String d = "tuesday";
					        //   String query = "select * from officeHour where courseID=1 and day = \ order by hourStart asc"
					        ps = conn.prepareStatement(query);
					        ps.setInt(1, courseID);
					        ps.setString(2, d);
					        boolean success = ps.execute();

					        rs = ps.getResultSet();
					        while (rs.next()) {
					%>
					<tr>
						<td><%=rs.getInt("hourStart")%>:00 - <%=rs.getInt("hourEnd")%>:00
						</td>
					</tr>
					<%
					    }
					%>
					<%
					    rs.close();
					        ps.close();
					        conn.close();
					    } catch (Exception e) {
					        e.printStackTrace();
					    }
					%>
				</table>
			</div>
			<!-- End Tuesday table -->

			<!-- Wednesday table -->
			<div style="float: left; width: 180px;">
				<table border="2"
					style="border-color: #990000; border-style: hidden; font-size: 20px; color: #990000; background-color: #FFCC00;">
					<tr>
						<td>Wednesday</td>
					</tr>
					<%
					    try {
					        PreparedStatement ps = null;
					        Connection conn = null;
					        ResultSet rs = null;
					        Class.forName("com.mysql.jdbc.Driver");

					        String sql =
					            "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";
					        conn = DriverManager.getConnection(sql);

					        String query =
					            "SELECT * FROM officeHour WHERE courseID = ? AND day = ? ORDER BY hourStart ASC";
					        String d = "wednesday";
					        //   String query = "select * from officeHour where courseID=1 and day = \ order by hourStart asc"
					        ps = conn.prepareStatement(query);
					        ps.setInt(1, courseID);
					        ps.setString(2, d);
					        boolean success = ps.execute();

					        rs = ps.getResultSet();
					        while (rs.next()) {
					%>
					<tr>
						<td><%=rs.getInt("hourStart")%>:00 - <%=rs.getInt("hourEnd")%>:00
						</td>
					</tr>
					<%
					    }
					%>
					<%
					    rs.close();
					        ps.close();
					        conn.close();
					    } catch (Exception e) {
					        e.printStackTrace();
					    }
					%>
				</table>
			</div>
			<div style="float: left; width: 160px;">
				<table border="2"
					style="border-color: #990000; border-style: hidden; font-size: 20px; color: #990000; background-color: #FFCC00;">
					<tr>
						<td>Thursday</td>
					</tr>
					<%
					    try {
					        PreparedStatement ps = null;
					        Connection conn = null;
					        ResultSet rs = null;
					        Class.forName("com.mysql.jdbc.Driver");

					        String sql =
					            "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";
					        conn = DriverManager.getConnection(sql);

					        String query =
					            "SELECT * FROM officeHour WHERE courseID = ? AND day = ? ORDER BY hourStart ASC";
					        String d = "thursday";
					        //   String query = "select * from officeHour where courseID=1 and day = \ order by hourStart asc"
					        ps = conn.prepareStatement(query);
					        ps.setInt(1, courseID);
					        ps.setString(2, d);
					        boolean success = ps.execute();

					        rs = ps.getResultSet();
					        while (rs.next()) {
					%>
					<tr>
						<td><%=rs.getInt("hourStart")%>:00 - <%=rs.getInt("hourEnd")%>:00
						</td>
					</tr>
					<%
					    }
					%>
					<%
					    rs.close();
					        ps.close();
					        conn.close();
					    } catch (Exception e) {
					        e.printStackTrace();
					    }
					%>
				</table>
			</div>
			<div style="float: left; width: 130px;">
				<table border="2"
					style="border-color: #990000; border-style: hidden; font-size: 20px; color: #990000; background-color: #FFCC00;">
					<tr>
						<td>Friday</td>
					</tr>
					<%
					    try {
					        PreparedStatement ps = null;
					        Connection conn = null;
					        ResultSet rs = null;
					        Class.forName("com.mysql.jdbc.Driver");

					        String sql =
					            "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";
					        conn = DriverManager.getConnection(sql);

					        String query =
					            "SELECT * FROM officeHour WHERE courseID = ? AND day = ? ORDER BY hourStart ASC";
					        String d = "friday";
					        //   String query = "select * from officeHour where courseID=1 and day = \ order by hourStart asc"
					        ps = conn.prepareStatement(query);
					        ps.setInt(1, courseID);
					        ps.setString(2, d);
					        boolean success = ps.execute();

					        rs = ps.getResultSet();
					        while (rs.next()) {
					%>
					<tr>
						<td><%=rs.getInt("hourStart")%>:00 - <%=rs.getInt("hourEnd")%>:00
						</td>
					</tr>
					<%
					    }
					%>
					<%
					    rs.close();
					        ps.close();
					        conn.close();
					    } catch (Exception e) {
					        e.printStackTrace();
					    }
					%>
				</table>
			</div>

			<div style="float: left; width: 150px;">
				<table border="2"
					style="border-color: #990000; border-style: hidden; font-size: 20px; color: #990000; background-color: #FFCC00;">
					<tr>
						<td>Satuday</td>
					</tr>
					<%
					    try {
					        PreparedStatement ps = null;
					        Connection conn = null;
					        ResultSet rs = null;
					        Class.forName("com.mysql.jdbc.Driver");

					        String sql =
					            "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";
					        conn = DriverManager.getConnection(sql);

					        String query =
					            "SELECT * FROM officeHour WHERE courseID = ? AND day = ? ORDER BY hourStart ASC";
					        String d = "saturday";
					        //   String query = "select * from officeHour where courseID=1 and day = \ order by hourStart asc"
					        ps = conn.prepareStatement(query);
					        ps.setInt(1, courseID);
					        ps.setString(2, d);
					        boolean success = ps.execute();

					        rs = ps.getResultSet();
					        while (rs.next()) {
					%>
					<tr>
						<td><%=rs.getInt("hourStart")%>:00 - <%=rs.getInt("hourEnd")%>:00
						</td>
					</tr>
					<%
					    }
					%>
					<%
					    rs.close();
					        ps.close();
					        conn.close();
					    } catch (Exception e) {
					        e.printStackTrace();
					    }
					%>
				</table>
			</div>

			<div style="float: left; width: 150px;">
				<table id="sunday" border="2"
					style="border-color: #990000; border-style: hidden; font-size: 20px; color: #990000; background-color: #FFCC00;">
					<tr>
						<td>Sunday</td>
					</tr>
					<%
					    try {
					        PreparedStatement ps = null;
					        Connection conn = null;
					        ResultSet rs = null;
					        Class.forName("com.mysql.jdbc.Driver");

					        String sql =
					            "jdbc:mysql://google/Hmwk4Database?cloudSqlInstance=cs201-lab:us-central1:sql-db-2&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=root&password=111";
					        conn = DriverManager.getConnection(sql);

					        String query =
					            "SELECT * FROM officeHour WHERE courseID = ? AND day = ? ORDER BY hourStart ASC";
					        String d = "sunday";
					        //   String query = "select * from officeHour where courseID=1 and day = \ order by hourStart asc"
					        ps = conn.prepareStatement(query);
					        ps.setInt(1, courseID);
					        ps.setString(2, d);
					        boolean success = ps.execute();

					        rs = ps.getResultSet();
					        while (rs.next()) {
					%>
					<tr>
						<td><%=rs.getInt("hourStart")%>:00 - <%=rs.getInt("hourEnd")%>:00
						</td>
					</tr>
					<%
					    }
					%>
					<%
					    rs.close();
					        ps.close();
					        conn.close();
					    } catch (Exception e) {
					        e.printStackTrace();
					    }
					%>
				</table>
			</div>

			<br style="clear: left;" />
		</div>
	</div>
</body>
</html>
