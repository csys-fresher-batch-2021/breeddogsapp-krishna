<!DOCTYPE>
<%@page import="in.raja.dao.DogsDetailsDAO"%>
<html lang="en">
<%@page import="java.util.List"%>
<%@page import="in.raja.model.DogDetail"%>
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

			<option value="2">Between 5000-10000</option>

			<option value="3">Above 10000</option>
			<option value="4">All</option>
		</select>
		<table id="sortedDogs" class="table table-bordered">
			<caption>List All Dogs</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">Dog Image</th>
					<th scope="col">Dog No</th>
					<th scope="col">Dog Name</th>
					<th scope="col">Dog Age(Days)</th>
					<th scope="col">Dog Gender</th>
					<th scope="col">Place</th>
					<th scope="col">Price</th>
					<th scope="col">Insurance</th>
				</tr>
			</thead>
			<tbody id="dogList">
			</tbody>
		</table>
		<a href="UserDogServlet.java"></a>
	</main>
	<script>
function select(){
	
var cost = document.getElementById("sortDog").value;
let url = "SearchByCostServlet?cost="+cost;
fetch(url).then(res=>res.json()).then(res=>{

	 var tableData = '' ;

		var tableData = '<thead class="thead-dark"><th>Dog No</th><th>Dog Name</th><th>Dog Age</th><th>Dog Gender</th><th>Place</th><th>Price</th><th>Insurance</th><th>Purchase</th></thead>'
			tableData+= '<tbody>'
	    for(i = 0;i < res.length; i++){
	    	tableData += '<tr>';
	    	tableData+=	'<td><img '+
	    		'src="GetDogImageServlet?imageName='+ res[i].dogNo + '"' +
			'width="50%" height="50%" alt="' + res[i] + '"></td>';
	    	tableData+= '<td>' + res[i].dogNo + '</td>';
	    	tableData+= '<td>' + res[i].dogName + '</td>';
	    	tableData+= '<td>' + res[i].age + '</td>';
	    	tableData+= '<td>' + res[i].gender + '</td>';
	    	tableData+= '<td>' + res[i].place + '</td>';
	    	tableData+= '<td>' + res[i].price + '</td>';
	    	tableData+= '<td>' + res[i].insurance + '</td>';
			tableData+='</tr>';
			tableData+= '</tbody>'


	    }
	     document.getElementById("dogList").innerHTML = tableData; 
	
});
}
</script>
</body>
</html>