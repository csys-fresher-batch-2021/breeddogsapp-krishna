<%-- <%@page import="in.raja.service.DogManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dogs</title>
</head>
<body>
<%
Integer dogno=Integer.parseInt(request.getParameter("dogno"));
String dogname=request.getParameter("dogname");
String age=request.getParameter("age");
String gender=request.getParameter("gender");
String place=request.getParameter("place");
Integer price=Integer.parseInt(request.getParameter("price"));

String insurance=request.getParameter("insurance");

DogManager.addDog(dogno, dogname, age, gender, place, price, insurance);
response.sendRedirect("dogdetails.jsp");
%>

</body>
</html>


 --%>