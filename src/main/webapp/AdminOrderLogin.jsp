<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Order Login</title>
</head>
<body>
<h3>Admin Order Login</h3>
		<form action="AdminOrderLoginServlet" method="post">
			<table>
				<caption>Admin Order Login</caption>
				<tr>
					<th scope="col">MOBILE NUMBER : </th>
					<td><input type="number" name="userId" id="userId"
						placeholder="Enter your phone number" required></td>
				</tr>
				<tr>
					<th scope="col">PASSWORD : </th>
					<td><input type="password" name="password" id="password"
						placeholder="Enter password" required></td>
				</tr>
			</table>
			<button type="submit">SUBMIT</button>
		</form>
</body>
</html>

