<%@page import="in.raja.service.DogDetails"%>
<%@page import="java.util.List"%>
<%@page import="in.raja.service.Dogs"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>

<html>
<head>
<title>BreedDogs</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Display BreedDogs Types</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>dogNo</th>
					<th>DogName</th>
					<th>Age</th>
					<th>Gender</th>
					<th>Color</th>
					<th>Place</th>
					<th>Price</th>
					<th>Insurance</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<DogDetails> dogLists = Dogs.getDogs();
				for (DogDetails dog : dogLists) {
				%>
				<tr>
					<td><%= dog.dogno%></td>
					<td><%= dog.dogname%></td>
					<td><%= dog.age%></td>
					<td><%= dog.gender%></td>
					<td><%= dog.color%></td>
					<td><%= dog.place%></td>
					<td><%= dog.price%></td>
					<td><%= dog.insurance%></td>

					</tr>
				<%} %>
			</tbody>

		</table>

	</main>
</body>
</html>





