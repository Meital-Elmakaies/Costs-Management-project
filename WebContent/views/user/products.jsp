<!-- Meital Elmakaies 207058322
Yuval Rozilyo 313930703
 --> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="il.ac.hit.model.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cost Items Table</title>
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<style>
table, td, th {
	width: 40%;
	border: 1px solid #ddd;
}

th, td {
	padding: 10px;
}

th {
	background-color: #ffc2b4;
	color: black;
}
h1{
	text-align: center;
	color: #ffaaa7;
}

table.center {
	margin-left: auto;
	margin-right: auto;
}

</style>
</head>
<body>
	<h1>Cost Item Table</h1>
	<table border='1' class = center>

		<%
		   //getting the attribute of the specific list of the user from the DB
			List<CostItem> costItems = (List<CostItem>) request.getAttribute("data");
	    //check if the attribute of the list not null 
			if(costItems != null){%>
				<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Date</th>
				<th>Category</th>
				<th>Price</th>
			</tr>

			<%
			 // do the table of the products
			for (CostItem p : costItems) {
			%>
			<tr>
				<td><%=p.getId()%></td>
				<td><%=p.getName()%></td>
				<td><%=p.getDescription()%></td>
			    <td><%=p.getDate()%></td>
				<td><%=p.getCategory()%></td>
				<td><%=p.getPrice()%></td>
			</tr>
			<%
			
			}
}
		%>

	</table>
	
	<a href="http://localhost:8888/FinalProject/views/user/home.jsp">Go to Home</a>
	
</body>
</html>