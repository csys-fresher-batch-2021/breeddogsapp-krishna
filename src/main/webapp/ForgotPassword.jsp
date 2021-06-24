<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Change the password :</title>
</head>
<body>
   <jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="ForgotPasswordServlet" method="post">
			<table>
				<caption>Change Password</caption>
				<tr>
					<th scope="col">PHONE NUMBER</th>
					<td><input type="number" name="phoneNumber"
						onchange="phonenumber()" id="phoneNumber" min=1000000000
						max=9999999999 placeholder="Enter Your PhNo" required autofocus /><br />
						<br /></td>
				</tr>
				<tr>
					<th scope="col">NEW PASSWORD</th>
					<td><input type="password" id="password" name="password"
						placeholder="Enter Password" required></td>
				</tr>
				<tr>
					<th scope="col">RE-ENTER NEW PASSWORD</th>
					<td><input type="password" id="confirmPassword"
						name="confirmPassword" placeholder="Re-Enter Password" required></td>
				</tr>
			</table>
			<button type="submit" onclick="checkall()">SUBMIT</button>
		</form>
		<script>
			function phonenumber() {
				let mobileNumber = document.querySelector("#phoneNumber").value;
				if (mobileNumber.trim().length == 10) {
				} else {
					alert("Incorrect Mobile Number");
					event.preventDefault();
				}
			}
			function checkall() {
				let password1 = document.querySelector('#password').value;
				let password2 = document.querySelector('#confirmPassword').value;
				let phonenumber = document.querySelector('#phoneNumber').value;
				if (password1.length == 0 || password2.length == 0
						|| phonenumber.length == 0) {
					alert("Display All Details");
				} else {
					if (password1.length >= 4 && password2.length >= 4
							&& password1 == password2) {
					} else {
						alert("Invalid Password");
						event.preventDefault();
					}
				}
			}
		</script>
		<%
		String message = (String) session.getAttribute("Message");
		if (message != null && message.equalsIgnoreCase("its not registered")) {
		%>
		<p class="text-danger"><%=message%></p>
		<%
		}
		%>
	</main>
</body>
</html>




