<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="User.css">
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<%
    String username = (String) request.getAttribute("username");
    String password = (String) request.getAttribute("password");
  	%>
</head>
<body>
    <div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Login Form -->
    <form method="POST" action="InstructorLoginServlet">
      <label for="login" style="color: #FFCC00">Username</label>
      <input type="text" id="login" class="fadeIn second" name="username">
      <label for="password" style="color: #FFCC00">Password</label>
      <input type="password" id="password" class="fadeIn third" name="password" >
      <input type="submit" class="fadeIn fourth" value="Log In">
    </form>
  </div>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
</script>
