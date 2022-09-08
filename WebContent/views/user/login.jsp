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
<title>Login</title>
    
</head>
<body>
	<h1>Login Page</h1>
    <form action="http://localhost:8888/FinalProject/router/user/login" method="get" >
        User Name: <input type="text" name=username />
        <br />
        Password: <input type="password" name=password />
        <br />
        <input type="submit" value="Login" />
        <br />
    </form>
            
    <%
     
     RequestDispatcher dispatcher = null;
    //getting the attribute of the user that want to use the app
 	Users success = (Users) session.getAttribute("match");
    //getting the attribute if not found the user that want use the app
 	Users fail = (Users) session.getAttribute("fail");  
    //check if there is a match
    
 	 if(success != null){
 	 	// send the user that login to the app to the home page 
 		dispatcher = request.getRequestDispatcher("/views/user/home.jsp");
		dispatcher.forward(request, response);
 	
	}
     //checking the attribute of the notfound user is not null if its not null the login didnt success	
 	if(fail != null){ %>
 	<h4>Wrong username or password, please try again</h4><br>
 	
 	<% }%> 
 	
		
 
 <a href="http://localhost:8888/FinalProject/router/user/register">Go to Register</a>
	

</body>
</html>
