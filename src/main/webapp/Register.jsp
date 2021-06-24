<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">

<title>Register Page</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="RegisterServlet" method="post">
			<h3>UserRegistration</h3>
			UserName:<input type="text" name="userName" id="userName"
				placeholder="Enter Your UserName" required autofocus /><br /> <br />
			PhoneNumber:<input type="number" name="phoneNumber" id="phoneNumber"
				min=1000000000 max=9999999999 placeholder="Enter Your PhNo" required
				autofocus /><br /> <br /> Email Id:<input type="email"
				name="userMail" id="userMail" placeholder="Enter Your Mail" required
				autofocus /><br /> <br /> Password:<input type="password"
				name="password" id="password" min=5 max=8
				placeholder="EnterYourPassword" required autofocus /><br /> <br />
			ReEnterPassword:<input type="password" name="confirmPassword"
				id="confirmPassword" min=5 max=8 placeholder="ReEnterPassword"
				required autofocus /><br /> <br /> City: <select name="city"
				id="city" required autofocus>
				<option>Null</option>
				<option>Madurai</option>
				<option>Chennai</option>
				<option>Coimbatore</option>
				<option>Theni</option>
				<option>Sivakasi</option>
				<option>Viruthunagar</option>
				<option>Thoothukudi</option>
				<option>Trichy</option>

			</select> <br /> <br /> <input type="submit" value="register" />

		</form>
	</main>
</body>
</html>






