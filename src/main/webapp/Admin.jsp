<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>



<h3>Admin Login</h3>
		<form action="AdminServlet" method="post">
			<table>
				<tr>

					<caption><th scope="col">MOBILE NUMBER : </th></caption>
					<td><input type="number" name="userId" id="userId"
						placeholder="Enter your phone number" required></td>
				</tr>
				<tr>
					<caption><th scope="col">PASSWORD : </th></caption>
					<td><input type="password" name="password" id="password"
						placeholder="Enter password" required></td>
				</tr>
				
			</table>
			<button type="submit">SUBMIT</button>
		</form>
</body>
</html>





