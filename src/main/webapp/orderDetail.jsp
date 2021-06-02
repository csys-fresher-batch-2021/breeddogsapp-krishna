<%@page import="in.raja.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.raja.model.AdminOrderList"%>
<%@page import="in.raja.dao.AdminOrder"%>

<%@page import="java.util.ArrayList"%>
<%@page import="in.raja.service.AdminOrderListService"%><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PlacedOrder</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Dog Details</h3>
		<table class="table table-bordered">
		<caption>Placed User</caption>
		<thead>
		<tr>
		        <th scope="col">S.NO</th>
			    <th scope="col">Dog No</th>
			    <th scope="col">Phone No</th>
			    
				<th scope="col">User Address</th>
				</tr>
				
		</thead>
		
		
		
		
		  <tbody>
		  
		   
	    
	    <% 
	    
	    List<AdminOrderList> order = ProductDAO.getOrderDetails();
		int i = 0;
		for (AdminOrderList orderDetail : order) {
			i++;
	    %>
	    
	    
	            <tr>
	            <td><%=i %></td>
	            <td><%=orderDetail.getDogno()%></td>
			    <td><%=orderDetail.getphoneno()%></td>
	            
			    <td><%=orderDetail.getAddress()%></td>
			    <td><a href="DeleteOrderServlet?dogno=<%=orderDetail.getDogno()%>" class="btn btn-danger">Delete</a>
			    
			    </tr>
			    <%
			    }
			    %>
	    
	    </tbody>
	    
	    
</body>
</html>










			    
			    