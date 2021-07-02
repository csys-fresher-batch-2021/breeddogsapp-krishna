<!DOCTYPE>
<%@page import="in.raja.dao.DogsDetailsDAO"%>
<html lang="en">
<%@page import="java.util.List"%>
<%@page import="in.raja.model.DogDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.raja.service.DogManager"%>
<head>
<title>MyApp</title>
<link rel="stylesheet" href="ListDogByPrice.css">

</head>
<body>


	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Dog Details</h3>

		<select onchange="select()" id="sortDog">

			<option value="1">Below 5000</option>

			<option value="2">Between 5000-10000</option>

			<option value="3">Above 10000</option>
			<option value="4">All</option>


		</select>

		<table id="sortedDogs" class="table table-bordered">

			<caption>Search Details</caption>
        <thead class="thead-dark">
        <tr>
        <th scope= "col"> Dog No</th>
        <th scope= "col"> Dog Name</th>
        <th scope= "col"> Dog Age(Days)</th>
        <th scope= "col"> Dog Gender</th>
        <th scope= "col"> Place</th>
        <th scope= "col"> Price</th>
        <th scope= "col">Insurance</th>
        <th scope= "col">Purchase</th>
        </tr>
        </thead>
        <tbody id = "searchDog">
        </tbody>
        </table>
        <a href=""></a>
	</main>
	<script>
function select(){
	
var cost = document.getElementById("sortDog").value;
let url = "SearchByCostServlet?cost="+cost;
fetch(url).then(res=>res.json()).then(res=>{
	var tableData = '';
	    for(i = 0;i < res.length; i++){
	    	tableData+= '<tr>'+	    	
	    	'<td>' + res[i].dogNo + '</td>'+
	    	'<td>' + res[i].dogName + '</td>'+
	    	'<td>' + res[i].age + '</td>'+
	    	'<td>' + res[i].gender + '</td>'+
	    	'<td>' + res[i].place + '</td>'+
	    	'<td>' + res[i].price + '</td>'+
	    	'<td>' + res[i].insurance + '</td>'+
	    	'<td><a href="PlaceOrder.jsp?DogNo='+ res[i].dogNo +'" class="btn  btn-success">Buy</a></td></tr>';
	    }

	     document.getElementById("sortedDogs").innerHTML = tableData; 

	
});

}





</script>
</body>
</html>
