<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.usc_logo
{
	display: block;
	margin-top: 150px;
  	margin-left: auto;
 	margin-right: auto;
}
#formContent
{
	margin-top: 50px;
	margin-left: 500px; 
	
}
</style>

<!-- 	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
	<link rel="stylesheet" href="User.css">
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<%
    String username = (String) request.getAttribute("username");
    String password = (String) request.getAttribute("password");
    String errorMsg = "";
	if ((String)request.getAttribute("error") != null)
	{
		errorMsg = (String)request.getAttribute("error");
		System.out.println("error is " + errorMsg);
	}
  	%>
</head>
<body>
    <div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Login Form -->
    <form method="POST" action="InstructorLoginServlet">
      <label for="login" style="color: #FFCC00">Username</label>
      <input type="text" id="login" class="fadeIn second" name="username" id="box">
      <label for="password" style="color: #FFCC00">Password</label>
      <input type="password" id="password" class="fadeIn third" name="password"  id="box">
      <input type="submit" class="fadeIn fourth" value="Log In">
    </form>
    <p style="color: #FFCC00 "> <%= errorMsg %> </p>
  </div>
</div>
<div>
	<img src="usc.png" alt="usc" class="usc_logo">
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
</script>
