<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="in.raja.dao.DogsDetailsDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.raja.model.AdminOrderList"%>
<%@page import="in.raja.dao.OrderDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.raja.service.AdminOrderListService"%><!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>PlacedOrder</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Dog Details</h3>
		<table class="table table-bordered">
			<caption>Placed User</caption>
			<thead>
				<tr>
					<th scope="col">S.NO</th>
					<th scope="col">ID.NO</th>
					<th scope="col">Dog No</th>
					<th scope="col">Phone No</th>
					<th scope="col">User Address</th>
					<th scope="col">Status</th>
					<th scope="col">Order Date</th>
					<th scope="col">Delivery Date</th>
					<th scope="col">Reject Order</th>
					<th scope="col">Accept Order</th>
					<th scope="col">Remove Order</th>

				</tr>

			</thead>
			<tbody>
				<%
				List<AdminOrderList> order = OrderDAO.findAll();
				int i = 0;

				DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				for (AdminOrderList orderDetail : order) {

					String orderDate = orderDetail.getOrderDate().format(formatters);
					String deliveryDate = orderDetail.getDeliveryDate().format(formatters);
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=orderDetail.getUserId()%></td>
					<td><%=orderDetail.getDogNo()%></td>
					<td><%=orderDetail.getPhoneNo()%></td>
					<td><%=orderDetail.getAddress()%></td>
					<td><%=orderDetail.getStatus()%></td>
					<td><%=orderDate%></td>
					<td><%=deliveryDate%></td>

					<td><a
						href="RejectOrderServlet?orderId=<%=orderDetail.getOrderId()%>&DogNo=<%=orderDetail.getDogNo()%>"
						class="btn btn-danger">Reject</a></td>
					<td><a
						href="AcceptOrderServlet?orderId=<%=orderDetail.getOrderId()%>&DogNo=<%=orderDetail.getDogNo()%>"
						class="btn btn-success">Accept</a></td>

					<td><a
						href="DeleteOrderServlet?orderId=<%=orderDetail.getOrderId()%>"
						class="btn btn-danger">Delete</a></td>

				</tr>
				<%
				}
				%>

			</tbody>
		</table>
	</main>
</body>
</html>











