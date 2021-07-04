<!DOCTYPE>
<%@page import="in.raja.dao.DogsDetailsDAO"%>
<%@page import="in.raja.dao.DogsDetailsDAO"%>
<html lang="en">
<%@page import="java.util.List"%>
<%@page import="in.raja.model.DogDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.raja.service.DogManager"%>
<%@page import="java.io.OutputStream"%>

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
					<th scope="col">Dog Image</th>
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
				List<DogDetail> taskList = DogsDetailsDAO.findAll();
							
				if (taskList != null)
					for (DogDetail detail : taskList) {
						
				%>
				<tr>
					<td><img
						src="GetDogImageServlet?imageName=<%=detail.getDogNo()%>"
						width="50%" height="50%" alt="<%=detail.getDogNo()%>"></td>
					<td><%=detail.getDogNo()%></td>
					<td><%=detail.getDogName()%></td>
					<td><%=detail.getAge()%></td>
					<td><%=detail.getGender()%></td>
					<td><%=detail.getPlace()%></td>
					<td><%=detail.getPrice()%></td>
					<td><%=detail.getInsurance()%></td>
					<td><a href="DeleteServlet?dogNo=<%=detail.getDogNo()%>"
						class="btn btn-danger">Delete</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<a href="AddDog.jsp">Add Dog</a>
	</main>
</body>
</html>
