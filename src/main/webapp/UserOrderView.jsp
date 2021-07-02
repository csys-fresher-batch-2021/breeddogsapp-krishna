
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="in.raja.dao.OrderDAO"%>

<%@page import="java.util.List"%>
<%@page import="in.raja.model.AdminOrderList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.raja.service.DogManager"%>
<!DOCTYPE>
<html lang="en">
<head>
<title>My Order</title>

<script src="assets/js/axios.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>My Order</h3>
		<table class="table table-bordered">
			<caption>Dog Details</caption>
			<thead>
				<tr>
					<th scope="col">SI No</th>
					<th scope="col">Order Dog No</th>
					<th scope="col">Contact NO</th>
					<th scope="col">Delivery Address</th>
					<th scope="col">Status</th>
					<th scope="col">Order Date</th>
					<th scope="col">Delivery Date</th>
				</tr>
			</thead>
			<tbody>
				<%
				HttpSession sess = request.getSession();
				String userName = (String) sess.getAttribute("LOGGED_IN_USER");

				List<AdminOrderList> orderList = OrderDAO.orderList(userName);
			    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				int i = 1;
				for (AdminOrderList detail : orderList) {	
					
					String orderDate = detail.getOrderDate().format(formatters);
					String deliveryDate = detail.getDeliveryDate().format(formatters);

				%>
				<tr>
					<td><%=i%></td>

					<td><%=detail.getDogNo()%></td>
					<td><input id="phoneNo<%=i%>" type="text" name="input_field"
						data-orderId="<%=detail.getOrderId()%>"
						data-mobileNumber="<%=detail.getPhoneNo()%>"
						value="<%=detail.getPhoneNo()%>" readOnly /></td>
					<td><input id="address<%=i%>" type="text" name="input_field"
						data-address="<%=detail.getAddress()%>"
						value="<%=detail.getAddress()%>" readOnly /></td>
					<td><%=detail.getStatus()%></td>
					<td><%=orderDate %></td>
					<td><%=deliveryDate %></td>


					<td><a
						href="DeleteOrderServlet?orderId=<%=detail.getOrderId()%>"
						class="btn btn-danger">Delete</a>
					<td><div id="editBtn<%=i%>" style="display: block">
							<a onclick="callFunction(<%=i%>,1)" class="btn btn-success">Edit</a>
						</div>
						<div id="okBtn<%=i%>" style="display: none">
							<a onclick="callFunction(<%=i%>,2)" class="btn btn-success">ok</a>
							<a onclick="callFunction(<%=i%>,3)" class="btn btn-danger">Cancel</a>
						</div>
				</tr>
				<%
				i++;
				%>
				<%
				}
				%>
			</tbody>


		</table>
	</main>
	<script src="js/edit-details.js"></script>
</body>
</html>
