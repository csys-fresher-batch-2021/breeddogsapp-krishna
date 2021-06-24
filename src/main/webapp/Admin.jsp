<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<% 
	String msg=request.getParameter("message");
if(msg !=null)
	out.println("<font color='red'>"+msg+"</font>");
%>
    	<h3>Admin Login</h3>
		<form action="AdminServlet" method="post">
			<table>
				<caption>Admin</caption>
				<tr>
					<th scope="col">MOBILE NUMBER :</th>
					<td><input type="number" name="userId" id="userId"
						min=1000000000 max=9999999999
						placeholder="Enter your phone number" required></td>
				</tr>
				<tr>
					<th scope="col">PASSWORD :</th>
					<td><input type="password" name="password" id="password"
						placeholder="Enter password" required></td>
				</tr>
			</table>
			<button type="submit">SUBMIT</button>
		</form>
		<br /> Note: Admin credentials are hard coded <br /> * User
		Name:9626848802<br /> * Password: k1234
	</main>
</body>
</html>





