<!-- Meital Elmakaies 207058322
Yuval Rozilyo 313930703
 --> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="il.ac.hit.model.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Product</title>
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<style>
form, h1 {
	margin-left: 30px;
}

h1 {
	text-align: center;
	color:#ffaaa7;
}
</style>
</head>
<body>
	<h1>Find Product</h1>
	<form
		action="http://localhost:8888/FinalProject/router/user/getproduct"
		method="get">

		ID: <input type="text" name="ID" placeholder="Enter ID" /><br> <br>
		<input type="submit" value="Find Product" />
	</form>


	<%
	//check if this is the first time that the jsp load
	if(request.getParameter("ID") != null){
		
		//getting the attribute of the cost item that the user want to get from the DB
		CostItem item = (CostItem) request.getAttribute("idproduct");
		//checking if the attribute of the item that returned is not null, if it not null show to the user the item he want to get 
		if (item != null) {
			out.println("<h4 align='center'>" + item + "</h4>");
		}else {
			out.println("<h4 style='color:red' align='center'>" + "Product Not Found !" + "</h4>");
		}
	
	}
	
	%>
	<a href="http://localhost:8888/FinalProject/views/user/home.jsp">Go to Home</a>

</body>
</html>