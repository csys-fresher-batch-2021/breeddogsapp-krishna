<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
	<link rel="stylesheet" href="Login.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="Message.jsp"></jsp:include>
	<main class="container-fluid">
	
	
<div style="text-align: center" class="header"  >
        <h1> UserLogin</h1>


        <form action="LoginServlet" method="post">
            <label for="username">UserName:</label>
            <input type = "text" name="username" id="username" min=3 max=9999999999 placeholder="Enter Your Name" required autofocus /> 



            <br><br>
            <label for="password">Password:</label>
            <input type="password" name="password"  id="password" placeholder="Enter Your PassWord" required autofocus />
            <br>
            <br><br>           
            <button type="submit" id = "button" class="btn btn-primary">Login</button>         

        </form>


 Forgot <a href="forgotPassword.jsp" id ="forgot"> password? </a>
    </div>






		<%
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



