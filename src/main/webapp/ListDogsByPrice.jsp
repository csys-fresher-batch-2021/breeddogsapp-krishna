<!DOCTYPE>
<%@page import="in.raja.dao.ProductDAO"%>
<html lang="en" xml:lang="en">
<%@page import="java.util.List"%>
<%@page import="in.raja.model.DogDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.raja.service.DogManager"%>
<head>
<title>MyApp</title>
</head>
<body>
 

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Dog Details</h3>
		
<select onchange="select()" id="sortDog">

	<option value="1">Below 5000</option>
	
	<option value="2"> Between 5000-10000</option>
	
	<option value="3">Above 10000</option>
	
</select> 
		 <table id="sortedDogs" class="table table-bordered">
		</table> 
</main>
<script>
function select(){
	
var cost = document.getElementById("sortDog").value;
console.log(cost);
let url = "SearchByCostServlet?cost="+cost;
fetch(url).then(res=>res.json()).then(res=>{
	console.log(res);
	var tableData = '<thead class="thead-dark"><th>Dog No</th><th>Dog Name</th><th>Dog Age</th><th>Dog Gender</th><th>Place</th><th>Price</th><th>Insurance</th></thead>'
		tableData+= '<tbody>'
	    for(i = 0;i < res.length; i++){
	    	tableData+= '<tr>';
	    	tableData+= '<td>' + res[i].dogno + '</td>';
	    	tableData+= '<td>' + res[i].dogname + '</td>';
	    	tableData+= '<td>' + res[i].age + '</td>';
	    	tableData+= '<td>' + res[i].gender + '</td>';
	    	tableData+= '<td>' + res[i].place + '</td>';
	    	tableData+= '<td>' + res[i].price + '</td>';
	    	tableData+= '<td>' + res[i].insurance + '</td>';


	    	
	    	
	    	
	    }
		tableData+='</tbody>';
	     document.getElementById("sortedDogs").innerHTML = tableData; 

	
});

}
</script>
</body>
</html>
