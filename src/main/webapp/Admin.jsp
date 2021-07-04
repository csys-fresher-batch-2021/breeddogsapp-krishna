<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1" name="viewport"
	content="width=device-width, initial-scale=1">

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: black;
}

hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 15px;
}

input[type=text], input[type=text] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=text]:focus {
	background-color: #ddd;
	outline: none;
}

input[type=password], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=password]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

img {
	display: block;
	margin-left: auto;
	margin-right: auto;
}
</style>
<title>Admin</title>
</head>
<body>
	<jsp:include page="Message.jsp"></jsp:include>
	<main class="container-fluid">
		<%
		String msg = request.getParameter("message");
		if (msg != null)
			out.println("<font color='red'>" + msg + "</font>");
		%>
		<h3>Admin Login</h3>
		<form action="AdminLoginServlet" method="post">
			<table>
				<caption>Admin</caption>
				<tr>
					<th scope="col">USER NAME :</th>
					<td><input type="text" name="userName" id="userName"
						placeholder="Enter userName" required></td>
				</tr>
				<tr>
					<th scope="col">PASSWORD :</th>
					<td><input type="password" name="password" id="password"
						placeholder="Enter password" required></td>
				</tr>
			</table>
			<button type="submit">SUBMIT</button>
		</form>
		<div>UserName : sivaram</div>
		<div>Password : sivaram</div>
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

		
		<section id="home">

			<img class="img-fluid"
				src="https://crueltyfreelife.org/wp-content/uploads/2020/02/blog-12.jpg"
				alt="dogs" style="width: 50%">

		</section>
	</main>
</body>
</html>





