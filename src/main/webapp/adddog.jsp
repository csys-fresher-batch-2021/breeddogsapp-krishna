<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>AddDogs</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>Add Dogs</h3>
	<form action="AddDogServlet">
	

	<label for="dogno"></label>
	<input type="number" name="dogno" placeholder="Enter Dog Number" required autofocus/>
	<br/>
	<label for="dogname"></label>
	<input type="text" name="dogname" placeholder="Enter Dog Name" required autofocus/> 
	<br/>
	<label for="age"></label>
	<input type="text" name="age" placeholder="Enter Dog Age" required autofocus/>
	<br/>
	<label for="gender"></label>
	<input type="text" name="gender" placeholder="Enter Dog Gender" required autofocus/>
	<br/>
	<label for="place"></label>
	<input type="text" name="place" placeholder="Enter Dog Place" required autofocus/>
	<br/>
	
	<label for="price"></label>
	<input type="number" name="price" placeholder="Enter Dog Price" required autofocus/>
	<br/>
	<label for="insurance"></label>
	<input type="text" name="insurance" placeholder="Enter Dog insurance" required autofocus/>
	<br/>
	<button  type="submit">Submit</button>
	</form>
		
</main>
</body>
</html>




			   