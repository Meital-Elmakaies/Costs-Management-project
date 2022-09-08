<!-- Meital Elmakaies 207058322
Yuval Rozilyo 313930703
 --> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="il.ac.hit.model.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<style>
form, h1,h4 {
	margin-left: 30px;
}

h1,h4 {
color: #ffaaa7;
}
</style>
<title>Register</title>
    
</head>
<body>
	<h1>Register Page</h1>
    <form action="http://localhost:8888/FinalProject/router/user/register" method="get" >
        User Name: <input type="text" name=username />
        <br />
        Password: <input type="password" name=password />
        <br />
        <input type="submit" value="register" />
        <br />
    </form>
            
     <%
  	//getting the attribute of the user that want to use the app
 	Users users = (Users) request.getAttribute("add");
     //checking if the attribute of the user not null and show that he sign un succssfully
 	if(users != null){ %>
 		
 		<h4>You Have Successfully sign up to the Cost Manager App</h4><br><br>		
 <%}		
 %>
 <a href="http://localhost:8888/FinalProject/router/user/login">Go to Login</a>
</body>
</html>
