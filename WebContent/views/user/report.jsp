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
<title>Report</title>

</head>
<body>
	<h1>Cost Item report</h1>
	
	<form action="http://localhost:8888/FinalProject/router/user/report" method="get">
		startDate: <input type="date" name="start" placeholder="Enter the start date you  want for the report" />

		endDate: <input type="date" name="end" placeholder="Enter the end date you  want for the report" />

		<input type="submit" value="Get report"/>
	</form>
	
		<%
	
		    // initialization the sum
		    double sum = 0;
		   //getting the attribute of the specific list of the user from the DB (also with the chosen dates)
			List<CostItem> costItems = (List<CostItem>) request.getAttribute("listUser");
		   //checking the attribute sum is not null
			if(request.getAttribute("sum") != null){
		      //getting the attribute of the sum spending at the chosen dates
		     sum = (double) request.getAttribute("sum");
			}%>
	
	
 		 
	<table border='1' class = center>

			<% if(costItems != null) { %>
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
			
			}%>
			
			<h4> your total spend is : <%= sum %> </h4><br> 
			
		<% } %>
		

	</table>
	
	   
		<a href="http://localhost:8888/FinalProject/views/user/home.jsp">Go to Home</a>
	
</body>
</html>