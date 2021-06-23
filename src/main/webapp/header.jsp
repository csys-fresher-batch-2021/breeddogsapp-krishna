<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="header.css">
<script src="assets/js/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width , initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>


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
		<a class="navbar-brand text-center" href="#"><img
			src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBw8QEhAQEhAVEhIQFRUREBEWEg8VFxIXFRIWFxURFRgYHiogGBomHRUXITEjJykrLjAuFx8zODMtNzQtLisBCgoKBgcGDgcHGisZExkrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrK//AABEIALEBHAMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAAAAAAAQcEBQYDAgj/xAA3EAACAQIEBAQEBAYCAwAAAAAAAQIDEQQSITEFBkFhBxMiUTJxgZEUQrHhUmKhwdHwM3IVgsL/xAAUAQEAAAAAAAAAAAAAAAAAAAAA/8QAFBEBAAAAAAAAAAAAAAAAAAAAAP/aAAwDAQACEQMRAD8Ao0AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAJcWBAAAAk98JQztdO4Hnlsr/AND5zP3em3YzKOFdSo4bSbtFWv7/AOD1rYfyW49U/VK2yAw6dSP54Zl7p5X9+v1Pen+FdrqqvfWD/sfFdvo2/wA17NWs9/uY0pX16sD1xcIKTyNuPRytffseBJAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPqEbv8AU+T0oq7sB65lHZamw4Tjp5knZwbyu6Vlm0bbt+pqqzvKXz0O35H5QxPEctPDUoRg044rFVM0vL1V0l72aslvbVoDwx/BYTv5ODqzdGbhiZU43S/6pat7MyqXhrXrpSw8m0/yzhJNdmy9OXuAU8FTjgaEpSaWerVnrJt7zl07Jdjo1hoUadlfvJvWXzYH564H4P4mVVLE1IU6cUpTSk83dKy/v7bGf4l8pYKjQX4al5flJJTV3m0X/I95Xtuyx+KY6zcVJrXfXrpe9zURhGd1OF47SWrv0aa9gKL5SoSniaTTs1Lr10ehk8Xm41q8KkXmaySbsrXd1JXd2bfnXl//AMXi4TpNww9e86LvfI1vC/ZtWv09z543gMDGjTcJXk5SnOq5NzlJpWzN6vr21uBquJcFhGmlGo5VKau4O3w5c8mn/wC17a7s5xm+q8avGd4RlOpFpVE/VFvR3Xfc0LAXIAAAAAAAAAAAAAAAAAAAAAAAAAAAACUQAAMilTaaex4RZt+BYinGtGVSMJQXxZ8zSUfU7JfmeXKt/i6OzQevBOEPEVoUo6Sm7Xd9O7P1fy3wehgMPSwtFemCvJ2V5yfxVJd2ylPDxU8LhZY+thFiKuNnUo4VebCMacIRl505NtKKun0zPLp0L04bwyFCEacXNpJK85znJ+7cpNtvuwMTmDiVPh+FxWNlHMqUHNq+sraRgn83/Uq3hvi1HHShGqvw8NfMk5UlTjp6Us3qqSeuitay3Nx4w8x0HhKuETvGUsk7NXbhlkktb7rXfoUDwnFQpzdVwhKUP+OlUjmpyvdNNPS6unrpuBfXFOL4eUFOnUjUivVo03lTtdWdmtf6mRKtGUISh6lOzUrrr1/YoiVGvKXmYalONOFlKSd4uT3ejyv2sr6IsHlbjNZwVKpCUfK0vFZo20dr/J7dgOr43wynjsNLD1V6G81OSSzUpxXxx+9muqfcpeHCo0p1MPXhlqRvlkr+r2aftp+pctHHRSk75d3d2d/da+2n+6Fdc7U3UiqmW0qbbXul27aAcVjMI6TT6N6PuYZsq8nKkm5XbfwtNWe9+5rgIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPWhe+n1PmjSlJqMU5Sk1GMUm3Jt2SSW7L68O/Cehh6ccZxOKc9Jxw0mslNdHW/jl/Lsut+gajwe5QxlSvQ4jXShhKMZKn5l71E4NJ0o/ljdp5tL20vudd4geJdGlGrhcLO9W7hKotFHfNkfv3+3ucX4ic+43F+bRwzhRwcZKmoqUY1Ksd1UlrpB2skvdb9KxlUcU7tXW1mv7AdPVj57o4eTu/N0vZ2un+t3odbheRMLTyylFPrsmrrW2pXvCuILNCTesNnZd/8AP9C5OBYueLoxa1lHVrsnZrT7/RAeksApRjRpxUcto2SVo63v7pdvobbA8Cp04Xyrqtmrxdt+2hmUOHSVntL37f3Nq3GUWtNNL+9v2A52vw+MYvLHfX6e/wAyvuaMC7SUr3v2Vr6Jd9C2J4HPktOUMkk7xtrbeL02a0Od5u4ZG17Le99PbfUCkuN8JjSpKrfK7pqN73v26e5y7LT5xwMVg5Sbl6Xs7e3T9irAIAAAAAAAAAAAAAAAAAAAAAAAAAAAAkCCUQSgLz8NuGcO4PglxXF1qbxFek6tCKalOnTlZKNOLetRvfTS7W1yseducsXxOrKVaq3SjJujSSUYwWy06u3V+7M3l/hcsbw7iNR1Mr4dClOCak/MUpzco3v6bJW21vD2OUjRi7JNuUrWSWn3/YDM4Xj6sI1KcWsso+rRaar9djCrQktej662O65O4FTy1ZVIt/D6rO+reitfS6T1XQ1HNHCqdOcnTTjF6pTcVl0s9tHqlZ9b7Ac1SnY7Hk7m2rhZLLa97t/7tfb7HJ4bJe046P8ANeSt9r/ozMnw+LTnSmmlq03dL5ySTXzlGK7gX/w/mpVKcZO15Wjv1tpu+ptuG4h1LP3u/nqULyvzA6NSFOtdxTtbS3R++qdl2LL4HzBiMXVqeVQdKlC0KeZTg5e8t7dVsBYsqmVOTei76moxEFiZNWSgtZSvL7dFc8qOEm7Z5N31yrb9WZ+MqQo0m52UIp3+mtu4FQeK8qsYKEqkVC94x/M/ZLsVUdP4g8fljsU5aqFNZKcbWsuunucwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACUCALE8DeJQw/Ek5zyQqU3Tkv43OpThCP3kn8k+yLb585OwEnGtFrDVasknkhpUldK80ltZ2b+R+ZaFeUHGUXllFqUZaXTi7pp9NS4uA+Mk4zk8SlVpuMJuL1cJeiEoU1l01lKT3VoaWuBq+FVa2EbtWpV6TV/TUptNqN00t4t5l0PLF8MjiUmnCNRXtaFNpqL9S+LXTW3fsdFj+a+DV418TLhdCVGhGi5WUFUnOtJJKL9PwpNv5LvbHrcP4LbC16OH8iOKtKhP8a1ffPCUIzbTjZp36uwFb4nhcVP4syd5Wipbaq+1nr7fsa6NKNKV5tq3RNp32t2Z+iuJ+F8K9GcKeJ8ucreXUVO+XTa2bVPXr1K4qeCuPWJ8p1qboJpyxF2nltraD1vo+ttgMPkDgccTOnXlTc4Rcms0UryT0ba3/25bVCk0mstvayRu+GcrUMLRpUKMbRpRyr3l7yl/M3qes8M4uzWgGs4Vhra3ben2OY8V+Z4YbDOMY3q1PTC+0feR3FakoRk1fbol/k/N/iVxmOKxbyt2pLy2r3V03dprTd2+gHJzk2227t6v6nyAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASQSAIPunJJ3avvpdrpoz4AGZT4lVioxzJxi3KMZRhKN3GMXJxatJ5Ypap6HusbKrNOfmV6tSE6dm1L1SWWnGCab0bukratWtbXWHTeHvBZYzGUoJ2UGqkpfwqLT+/sB+jOScRKnRp4OrWU8RhacKWI0dlUyp5U9nZNLT2N9ja8YrNJ6J/Ek209NLLXqVrisdGnUxUXGTg1mUpSbvZW3evRGr5Yq1XNrzZShfNGGdtLvr9ALqpW2X0+R5cRqRhCUpbJHM4mtXyKpGpaajlTe32K74nzZxCUvJqzS16R3s7dXr7genN3ibUo/iqEadOThN06byyaklZSzerS2qKVxuI8ycp5VHM75UrJdkuiOq55r0pStBWtZN5m7vf2svpc44AAAJuQS0QAAAAAAAAAAAAAAAAAAAAAAAABIuQAJBAAAAAX54P8OoQwycreZJu8mrOzs8uu6KEitUX1gMRSoYDDRUsmaN3NZdV9dAOz4thaFanKFNK60coxu79mv0K+4BWlhMRWhUaV5PI2orMs1va/wBDb4bmiOFw8qkFOrUcWqcZ6Of8tNJK0VvfLFfPdcpieYliYU6mJllrpudS0ZStByUKbhJaOMWrST1s8ycloBa/4hZY3drrsVR4g1VHM1HNq1daX21fbc3UOKShelLWUEpTd72UvhWnV7nDc98acmoJ73vtqr7fdAcbiqt2l0X6mOSyABJAAlMgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEkAD2wsLzirXu1p79izY0qyw8G5SjGHpilJSsrXtmV/8AJVpbPJeMw9Wg6Mbu0U1mv6Xs+uvQDS8WxdWVqFL1Va8Mm93GN1duT1Xz77GO5QwLi6FR+ZTk3Kpf1OXluPptskpu3/Y6TieBp021Rg5VJtOc3fM9t3+WN9bHG8xWoxjTi7znepUnazs2rL3Sem3sBtZcQXkxzuriMVXvWlDPTjChCNSWX1W9EWmrwtbZ3WxzXM+GcKtnVpVWvTN0nJxjKKWaN2rPW9rN3SvoZvLOMdJYitJ/DS8uCtvKTT/+U38kc5KyVra3vftYDzAAAAlAQCWyABJBIEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB3XhnxWhh3U85emTSUrXs2jhT2hVyxsnu79QLS5h41hYSflylPrKL0j9U9Tg+NcShVd1GV3vdrXX9OxqvxU/c8pzb3AzfxKjTyKV23dq2i+vUwW7kAAASBJDIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB//9k="
			alt="dogImage2"></a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
				<%
				if (loggedInUsername == null) {
				%>
				<li class="nav-item"><a class="nav-link"
					href="ListDogsByPrice.jsp">DogList</a></li>
				<%
				}
				%>

				<%
				if ("user".equalsIgnoreCase(role)) {
				%>
				<li class="nav-item"><a class="nav-link" href="PlaceOrder.jsp">PlaceOrder</a>
				</li>


				<li class="nav-item"><a class="nav-link"
					href="ListDogByPriceUser.jsp">DogList</a></li>

				<li class="nav-item"><a class="nav-link"
					href="UserOrderView.jsp">ViewUserOrder</a></li>
				<%
				}
				%>


				<%
				if ("admin".equalsIgnoreCase(adminrole)) {
				%>
				<li class="nav-item"><a class="nav-link" href="AddDog.jsp">AdminAddDetails</a>
				</li>




				<li class="nav-item"><a class="nav-link" href="OrderDetail.jsp">AdminViewOrderDetails</a>
				</li>




				<li class="nav-item"><a class="nav-link" href="DogDetails.jsp">AdminviewListDetails</a>
				</li>
				<%
				}
				%>

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