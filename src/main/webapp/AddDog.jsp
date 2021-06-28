
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
			<label for="dogName"> Dog Name :  </label> <input type="text"
				name="dogName" id="dogName" placeholder="Enter Dog Name" required
				autofocus /> <br /> <label for="age"> Dog Age (Days) :</label> <input
				type="number" name="age" id="age" placeholder="Enter Dog Age"
				min="1" max="400" required autofocus />(Between 1 to 400 Days) <br />
			<label for="gender">Dog Gender :</label> <input type="radio"
				name="gender" id="gender" value="male" required autofocus>
			Male <input type="radio" name="gender" id="gender" value="female"
				required autofocus> Female<br /> <label for="place">Location
				:</label> <input type="text" name="place" id="place"
				placeholder="Enter Dog Place" required autofocus /> <br /> <label
				for="price">Price :</label> <input type="number" name="price"
				id="price" min="1" max="1000000000000" placeholder="Enter Dog Price"
				required autofocus /> <br /> <label for="insurance">Insurance
				:</label> <input type="text" name="insurance" id="insurance"
				placeholder="Enter Dog insurance" required autofocus /> <br />
			<button type="submit">Submit</button>
		</form>

	</main>
</body>
</html>






