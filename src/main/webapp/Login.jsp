<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
<div style="text-align: center">
        <h1> UserLogin</h1>
        <form action="LoginServlet" method="post">
            <label for="PhoneNumber">PhoneNumber:</label>
            <input name="number" size="10" />
            <br><br>
            <label for="password">Password:</label>
            <input type="password" name="password" size="8" />
            <br>${message}
            <br><br>           
            <button type="submit">Login</button>
        </form>
    </div>
</main>
</body>
</html>



