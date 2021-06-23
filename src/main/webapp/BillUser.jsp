<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>YOUR ORDER IS PLACED</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<link rel="stylesheet" href="BillUser.css">


<style>
body {
	background-color: rgb(167, 81, 167);
}

#main-content {
	background-color: rgb(206, 198, 206);
	width: 400px;
	height: 530px;
}
</style>
</head>

<body>
	<div class="container d-flex justify-content-center">
		<div id="main-content" class="rounded p-3 mt-5">
			<h1 class="display-4 text-center">PLACED ORDER DETAILS</h1>


			<p>
				Dog No : <span id="dogno"> <% out.println(request.getParameter("dogNo")); %>
				</span>
			</p>
			<p>
				PHONE NUMBER : <span id="phoneno"> <% out.println(request.getParameter("phoneNo")); %>
				</span>
			</p>
			<p>
				ORDERED DETAILS : <span id="oredrdetails"> <% out.println(request.getParameter("address")); %>
				</span>
			</p>



			<p class="text-center">HAPPY CUSTOMER !!!</p>
			<button onclick="saveDetails()" href="DogDetails.jsp">OK</button>
		</div>
	</div>

</body>
<script>
</script>
</html>
