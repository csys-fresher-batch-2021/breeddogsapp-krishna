<!DOCTYPE>
<%@page import="in.raja.dao.ProductDAO"%>
<html lang="en" xml:lang="en">
<%@page import="java.util.List"%>
<%@page import="in.raja.model.DogDetails"%>
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
	
	<option value="2"> Between 5000-10000</option>
	
	<option value="3">Above 10000</option>
		<option value="4">All </option>
	
	
 </select> 
 
 
		 <table id="sortedDogs" class="table table-bordered">
		
	   
		
		</table> 
  		<a href="UserDogServlet.java"></a>  
</main>
<script>
function select(){
	
var cost = document.getElementById("sortDog").value;
console.log(cost);
let url = "SearchByCostServlet?cost="+cost;
fetch(url).then(res=>res.json()).then(res=>{
	console.log(res);
	var tableData = '<thead class="thead-dark"><th>Dog No</th><th>Dog Name</th><th>Dog Age</th><th>Dog Gender</th><th>Place</th><th>Price</th><th>Insurance</th><th>Purchase</th></thead>'
		tableData+= '<tbody>'
	    for(i = 0;i < res.length; i++){
	    	tableData+= '<tr>'+	    	
	    	'<td>' + res[i].dogno + '</td>'+
	    	'<td>' + res[i].dogname + '</td>'+
	    	'<td>' + res[i].age + '</td>'+
	    	'<td>' + res[i].gender + '</td>'+
	    	'<td>' + res[i].place + '</td>'+
	    	'<td>' + res[i].price + '</td>'+
	    	'<td>' + res[i].insurance + '</td>'+
	    	'<td><a href="placeOrder.jsp?Dogno='+ res[i].dogno +'" class="btn  btn-success">Buy</a></td></tr>';
	    }

		tableData+='</tbody>';
	     document.getElementById("sortedDogs").innerHTML = tableData; 

	
});

}





</script>
</body>
</html>
