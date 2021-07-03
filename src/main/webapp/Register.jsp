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

.registerbtn {
	background-color: #04AA6D;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

#city {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text], input[type=password] {
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

input[type=number], input[type=number] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=number]:focus, input[type=number]:focus {
	background-color: #ddd;
	outline: none;
}

input[type=email], input[type=email] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=email]:focus, input[type=email]:focus {
	background-color: #ddd;
	outline: none;
}
</style>
<title>Register Page</title>
</head>
<body>
	<jsp:include page="Message.jsp"></jsp:include>

	<main class="container-fluid">
		<form action="RegisterServlet" method="post">

			<div class="container">
				<h1>Register</h1>
				<p>Please fill in this form to create an account.</p>


				<hr>
				UserName:<input type="text" name="userName" id="userName"
					placeholder="Enter Your UserName" required autofocus /><br /> <br />
				PhoneNumber:<input type="number" name="phoneNumber" id="phoneNumber"
					min=1000000000 max=9999999999 placeholder="Enter Your PhNo"
					required autofocus /><br /> <br /> Email Id:<input type="email"
					name="userMail" id="userMail" placeholder="Enter Your Mail"
					required autofocus /><br /> <br /> Password:<input
					type="password" name="password" id="password" min=5 max=8
					placeholder="EnterYourPassword" required autofocus /><br /> <br />
				ReEnterPassword:<input type="password" name="confirmPassword"
					id="confirmPassword" min=5 max=8 placeholder="ReEnterPassword"
					required autofocus /><br /> <br /> City: <select name="city"
					id="city" required autofocus>
					<option>Select</option>
					<option>Madurai</option>
					<option>Chennai</option>
					<option>Coimbatore</option>
					<option>Theni</option>
					<option>Sivakasi</option>
					<option>Viruthunagar</option>
					<option>Thoothukudi</option>
					<option>Trichy</option>

				</select> <br /> <br />
				<button type="submit" class="registerbtn" value="register">Register</button>

				<hr>
			</div>
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







