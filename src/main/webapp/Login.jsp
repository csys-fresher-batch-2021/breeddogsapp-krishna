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
            <label for="username">UserName:</label>
            <input type = "text" name="username" id="username" min=3 max=9999999999 placeholder="Enter Your Name" required autofocus /> 



            <br><br>
            <label for="password">Password:</label>
            <input type="password" name="password"  id="password" placeholder="Enter Your PassWord" required autofocus />
            <br>
            <br><br>           
            <button type="submit">Login</button>         

        </form>


 Forgot <a href="forgotPassword.jsp"> password? </a>
    </div>
</main>

</body>
</html>



