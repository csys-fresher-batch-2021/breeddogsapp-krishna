<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Veiw List</title>
</head>
<body>
<h3>Admin Veiw List</h3>
		<form action="AdminVeiwListServlet" method="post">
			<table>
				
				<tr>
					<th scope="col">MOBILE NUMBER : </th>
					<td><input type="number" name="userId" id="userId"
						placeholder="Enter your phone number" required autofocus></td>
				</tr>
				<tr>
					<th scope="col">PASSWORD : </th>
					<td><input type="password" name="password" id="password"
						placeholder="Enter password" required autofocus></td>
				</tr>
			</table>
			<button type="submit">SUBMIT</button>
					<br /> Note: Admin credentials are hard coded <br /> * User
			Name:9626848802<br /> * Password: k1234
			
		</form>
</body>
</html>

