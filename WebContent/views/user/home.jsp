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
a {
	margin-left: 30px;
}

h1,h4 {
color: #ffaaa7;
}
</style>
<title>home</title>
    
</head>
<body>
	<h1>Home Page</h1>
            
     <%
 	//getting the attribute of the user that using the app
 	Users users = (Users) session.getAttribute("match"); 
    //checking if the attribute of the user not null and using the app 
 	if(users != null){ %>
 		<h4>Hello <%= users.getUsername() %> !</h4><br><br> 	
	       	
 <%}%>
 <!--Router to other pages through the router with links-->
 <a href="http://localhost:8888/FinalProject/router/user/addproduct">Go to add product</a><br>
 <a href="http://localhost:8888/FinalProject/router/user/getproduct">Go to get product</a><br>
 <a href="http://localhost:8888/FinalProject/router/user/products">Go to products</a><br>
 <a href="http://localhost:8888/FinalProject/router/user/deleteproduct">Go to delete product</a><br>
 <a href="http://localhost:8888/FinalProject/router/user/report">Go to report</a><br>
 <a href="http://localhost:8888/FinalProject/router/user/signout">sign out</a>
  <br>
 
	

</body>
</html>