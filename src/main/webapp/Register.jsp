<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1"   name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
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
#city{
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

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="RegisterServlet" method="post">			

  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
			
			
			<hr>
			UserName:<input type="text" name="userName" id="userName"
				placeholder="Enter Your UserName" required autofocus /><br /> <br />
			PhoneNumber:<input type="number" name="phoneNumber" id="phoneNumber"
				min=1000000000 max=9999999999 placeholder="Enter Your PhNo" required
				autofocus /><br /> <br />
		    Email Id:<input type="email"
				name="userMail" id="userMail" placeholder="Enter Your Mail" required
				autofocus /><br /> <br />
		    Password:<input type="password"
				name="password" id="password" min=5 max=8
				placeholder="EnterYourPassword" required autofocus /><br /> <br />
			ReEnterPassword:<input type="password" name="confirmPassword"
				id="confirmPassword" min=5 max=8 placeholder="ReEnterPassword"
				required autofocus /><br /> <br />
		    City: <select name="city"
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
			<hr>
</div>
		</form>
	</main>
</body>
</html>

 --%>







<!-- 
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
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

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
</head>
<body>

<form action="/action_page.php">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" id="psw" required>

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" required>
    <hr>
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <button type="submit" class="registerbtn">Register</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>
</form>

</body>
</html>

 -->
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
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
 



