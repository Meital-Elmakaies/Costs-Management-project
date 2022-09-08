<<!-- Meital Elmakaies 207058322
Yuval Rozilyo 313930703
 --> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="il.ac.hit.model.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Product</title>
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<style>
form,h1{
	margin-left: 30px;
}

h1{
	color:#ffaaa7;
}
</style>
</head>
<body>
	<h1>Delete Product</h1>

	<form action="http://localhost:8888/FinalProject/router/user/deleteproduct"
		method="get">
		ID: <input type="text" name="ID" placeholder="Enter product ID to delete" /> 
		<input type="submit" value="Delete Product"/>
	</form>

	<%
	//getting the attribute of the cost item that delete from the DB
	CostItem item = (CostItem) request.getAttribute("delete");
	//checking if the attribute of the item not null if not null show to the user that the item as been deleted
	if(item != null){
		out.println("<p align='center'>"+ "Cost Item" + " " + item.getName() + " Deleted Successfully" + "</p>");
	}
	
	%>
	<a href="http://localhost:8888/FinalProject/views/user/home.jsp">Go to Home</a>

</body>
</html>