<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>placeOrder</title>
</head>
<body>


<h3>PlaceOrder</h3>
 <form action="PlaceOrderServlet" method="post">

<label for="dogno">DogNo : </label>
	<input type="number" name="dogno" placeholder="Enter Dog Number   " required autofocus/>
<br/>
<label for="dogno">PhoneNo : </label>
	<input type="number" name="phoneno" min="1000000000" max="9999999999" placeholder="Enter Phone Number   " required autofocus/>
<br/>

<label for="address">Delivery Address</label>
	<input type="text" name="address" placeholder="Enter Delivery Address" required autofocus/>
	<br/>
  <button  type="submit">Confirm</button>
    </form>
</body>
</html>




	