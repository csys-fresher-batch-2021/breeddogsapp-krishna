<!DOCTYPE>
<%@page import="in.raja.dao.ProductDAO"%>
<html lang="en" xml:lang="en">
<%@page import="java.util.List"%>
<%@page import="in.raja.model.DogDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.raja.service.DogManager"%>
<head>
<title>MyApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Dog Details</h3>
		<table class="table table-bordered">
		<caption>Dog Details</caption>
		<thead>
		<tr>
			<th scope="col">Dog No</th>
				<th scope="col">Dog Name</th>
				<th scope="col">Dog Age</th>
				<th scope="col">Dog Gender</th>
				<th scope="col">Dog Place</th>
				<th scope="col">Dog Price</th>
				<th scope="col">Dog Insurance</th>
		</tr>
		</thead>
	    <tbody>
	    <%
	    List<DogDetails> taskList =ProductDAO.findAll();

	    	    /*   int i=0; */
	    	      for(DogDetails detail:taskList)
	    	      {
	    	      
	     %>
	    
	    
	     
	    
	    
	   
	    
	    
	     <tr>
			    
			    <td><%=detail.getDogNo() %></td>
			    <td><%=detail.getDogName() %></td>
			    <td><%=detail.getDogAge()%></td>
			    <td><%=detail.getDogGender() %></td>
			    <td><%=detail.getDogPlace() %></td>
			    <td><%=detail.getDogPrice() %></td>
			    <td><%=detail.getDogInsurance() %></td>
			    
			    </tr> 
	     <%}%> 
	   </tbody>
	   
		
		</table>
		<a href="UserDogServlet.java"></a>
</main>
</body>
</html>
