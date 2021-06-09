<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>



<%
String loggedInUsername = (String) session.getAttribute("LOGGED_IN_USER");
 String role = (String) session.getAttribute("ROLE");
 String adminrole = (String) session.getAttribute("ADMINROLE");

 
%>
<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="#">MyApp</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavId">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      
       
      
      <li class="nav-item">
        <a class="nav-link" href="ListDogsByPrice.jsp">DogList</a>
      </li>
      <%
      if("user".equalsIgnoreCase(role)) {
      %>
       <li class="nav-item">
        <a class="nav-link" href="placeOrder.jsp">PlaceOrder</a>
      </li>
    <%
    }%>
       
       
        <%
      if("admin".equalsIgnoreCase(adminrole)) {
      %>
       <li class="nav-item">
        <a class="nav-link" href="adddog.jsp">AdminAddDetails</a>
      </li>
      
      
      
      
       <li class="nav-item">
        <a class="nav-link" href="orderDetail.jsp">AdminVeiwOrderDetails</a>
      </li>
      
      
      
      
       <li class="nav-item">
        <a class="nav-link" href="dogdetails.jsp">AdminveiwListDetails</a>
      </li>
    <%
    }%>
       
</ul>    
     
 
  </div> 
   
    
 
 
 
 
 <%
		if (loggedInUsername == null) {
		%>
		<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="dropdownId"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">SignIn</a>
				<div class="dropdown-menu" aria-labelledby="dropdownId">
					<a class="dropdown-item" href="Login.jsp">User Login</a> <a
						class="dropdown-item" href="Admin.jsp">Admin Login</a>
				</div></li>

			<li class="nav-item active"><a class="nav-link"
				href="Register.jsp">Register</a></li>
		</ul>

		<%
		} else {
		%>



		<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
			<li class="nav-item"><a class="nav-link" href="#">Welcome<%=" " + loggedInUsername%></a>
			</li>
			<li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a>
			</li>
		</ul>

		<%
		}
		%>

 
 
 
 
  
</nav>
</header>