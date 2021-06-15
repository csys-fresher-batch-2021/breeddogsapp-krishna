<!DOCTYPE>
<%@page import="in.raja.dao.OrderDAO"%>
<html lang="en" xml:lang="en">
<%@page import="java.util.List"%>
<%@page import="in.raja.model.AdminOrderList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.raja.service.DogManager"%>
<head>
<title>My Order</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>My Order</h3>
		<table class="table table-bordered">
		<caption>Dog Details</caption>
		<thead>
		<tr>
					
		
			    <th scope="col"> Order Dog No</th>
				<th scope="col">Contact NO </th>
				<th scope="col">Delivery Address</th>
				<th scope="col">Status</th>
			
		</tr>
		</thead>
	    <tbody>
	    <%
		
		HttpSession sess = request.getSession();
		String userName = (String) sess.getAttribute("LOGGED_IN_USER");


		int id = OrderDAO.getId(userName);

	    List<AdminOrderList> taskList =OrderDAO.orderList(id);

	    	    /*   int i=0; */
	    	      for(AdminOrderList detail:taskList)
	    	      {
	    	      
	     %>
	    
	    
	     
	    
	    
	   
	    
	    
	     <tr>
			    			
			    
			    <td><%=detail.getDogno() %></td>
			    <td><%=detail.getPhoneno() %></td>
			    <td><%=detail.getAddress()%></td>
			    <td><%=detail.getStatus() %></td>
			  
			    
			    </tr> 
	     <%}%> 
	   </tbody>
	   
		
		</table>
		</main>
</body>
</html>
