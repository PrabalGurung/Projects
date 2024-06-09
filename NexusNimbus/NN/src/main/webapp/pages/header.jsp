<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>header</title>
<%--link to the header css using context absolute path--%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/pages/css/header2.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<script src="${pageContext.request.contextPath}/pages/javascript/navDropdown.js"></script>
</head>
<body>
	<header>
		<input type="checkbox" name="" id="chk1"> <img
			src="${pageContext.request.contextPath}/pages/images/otherimg/logo.png"
			alt="logo">

		<div class="search-box">
			<form action="prodd.jsp">
				<input type="search" name="brand" id="srch" placeholder="Search">
				<button type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form>
		</div>

		<ul>
			<li><a href="${pageContext.request.contextPath}/pages/home.jsp">Home</a></li>
			<li><a
				href="${pageContext.request.contextPath}/pages/prodd.jsp?brand=all">Product</a></li>
			<li><a
				href="${pageContext.request.contextPath}/pages/Contact.jsp">Contact</a></li>

			<%--Getting the email attribute after login from session. --%>
			<%
			String email = (String) session.getAttribute("email");
			%>

			<%--If else condition to check if the user has logged in or not --%>
			<%
			if (session.getAttribute("email") == null) {
			%>
			<a href="${pageContext.request.contextPath}/pages/login.jsp">
				<button class="favorite styled" type="button">Login</button>
			</a>
			<%
			} else {
			%>
			
			<div class="dropdown">
				<button onclick="myFunction()" class="dropbtn">Profile</button>
				<div id="myDropdown" class="dropdown-content">
						<a href="${pageContext.request.contextPath}/pages/editProfile.jsp?email=<%=email%>">
							Edit Profile
						</a>
						<a href="${pageContext.request.contextPath}/pages/orderHistory.jsp?email=<%=email%>">
							History
						</a>

					<form action="${pageContext.request.contextPath}/LogOutServlet"
							method="post">
							<button type="submit" class="dropbtn">
								Log Out
							</button>
					</form>
				</div>
			</div>
			<%
			}
			%>

			<li>
				<form action="${pageContext.request.contextPath}/showCartServlet"
					method="post">
					<button type="submit"
						style="border: none; background: none; cursor: pointer;">
						<i class="fa fa-shopping-cart" aria-hidden="true"></i>
					</button>
				</form>
			</li>
		</ul>
		<div class="menu">
			<label for="chk1"> <i class="fa fa-bars"></i>
			</label>
		</div>
	</header>


</body>
</html>