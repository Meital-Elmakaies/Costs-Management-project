<!-- Meital Elmakaies 207058322
Yuval Rozilyo 313930703
 --> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="il.ac.hit.model.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<style>
form,h1{
	margin-left: 30px;
}

h1 {
	text-align: center;
	color: #ffaaa7;
}
</style>
</head>
<body>
	<h1>Add New Product</h1>

	<form action="http://localhost:8888/FinalProject/router/user/addproduct"
		method="get">
		Name: <input type="text" name="name" placeholder="Enter Name" />

		Price: <input type="text" name="price" placeholder="Enter price" />

		Description: <input type="text" name="description" placeholder="Write Description"/>
		
		Category: <input type="text" name="category" placeholder="Category"/>
		
		Date:  <input type="date" name="date" placeholder="choose date"/>
		
		ID: <input type="text" name="ID" placeholder="Enter product ID" /> 
		<input type="submit" value="Add Product"/>
	</form>

	<%
	//getting the attribute of the cost item that added to the DB
	CostItem item = (CostItem) request.getAttribute("product");
	//checking if the attribute of the item that returned is not null, if it not null show to the user that the item as been added 
	if(item != null){
		out.println("Cost Item" + " " + item.getName() + " Added Successfully");
	}
	
	%>
	<a href="http://localhost:8888/FinalProject/views/user/home.jsp">Go to Home</a>

</body>
</html>