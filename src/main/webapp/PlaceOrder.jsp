<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>placeOrder</title>
</head>
<body>
	<jsp:include page="Message.jsp"></jsp:include>
	<main class="container-fluid">
		<%
String dogNo = request.getParameter("DogNo");
%>
		<h3>PlaceOrder</h3>
		 
		<form action="PlaceOrderServlet" method="post" onsubmit="send()">

			<label for="dogno">DogNo : </label> <input type="number" name="dogNo"
				id="dogNo" value="<%=dogNo%>" readOnly /> <br /> <label
				for="dogno">PhoneNo : </label> <input type="number" name="phoneNo"
				id="phoneNo" min="1000000000" max="9999999999"
				placeholder="Enter Phone Number   " required autofocus /> <br /> <label
				for="address">Delivery Address</label> <input type="text"
				name="address" id="address" placeholder="Enter Delivery Address"
				required autofocus /> <br />
			<button type="submit">Confirm</button>
		</form>
			<%
		String email = (String) session.getAttribute("LOGGED_IN_USEREMAIL");
		String role = (String) session.getAttribute("ROLE");
		String adminrole = (String) session.getAttribute("ADMINROLE");
		String message = request.getParameter("message");
		if (message == null) {
			out.print("");
		} else {
			out.print("<font color='red'><center>" + message + "</font>");
		}
		%>
	</main>
</body>
</html>

