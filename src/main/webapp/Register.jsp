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
<form action="RegisterServlet"  method="post">  
  
UserName:<input type="text" name="userName" id="userName" placeholder="Enter Your Name" required/><br/><br/>  
PhoneNumber:<input type="number" name="phoneNumber"  id="phoneNumber" placeholder="Enter Your PhNo"/><br/><br/>  
Email Id:<input type="email" name="userM ail"  id="userMail" placeholder="Enter Your Mail"/><br/><br/>  
Password:<input type="password" name="password1"  id="password1" placeholder="EnterYourPassword"/><br/><br/> 
ReEnterPassword:<input type="password" name="password2"  id="password2" placeholder="ReEnterPassword"/><br/><br/>  
 
 
 
City:  
<select name="userCountry">  
<option>Madurai</option>  
<option>Chennai</option>  
<option>Coimbatore</option>  
<option>Theni</option>  
<option>Sivakasi</option>  
<option>Viruthunagar</option>  
<option>Thoothukudi</option>  
<option>Trichy</option>  

</select>  
  
<br/><br/>  
<input type="submit" value="register"/>  
  
</form> 
</main> 
</body>
</html>






