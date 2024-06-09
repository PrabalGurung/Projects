<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	rel="stylesheet">
<title>Navbar Design</title>
</head>
<body>

	<div class="d-flex">
		<!-- Sidebar -->
		<div class="bg-dark text-white"
			style="width: 250px; min-height: 100vh;">
			<div class="px-3 py-4">
				<a href="#" class="h3 text-white text-decoration-none">NexusNimbus</a>
			</div>
			<ul class="nav flex-column">
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/admin/dashBoard.jsp"
					class="nav-link active text-white"><i
						class="fas fa-tachometer-alt"></i> Dashboard</a></li>
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/admin/product.jsp"
					class="nav-link text-white"><i class="fas fa-box"></i> Products</a>
				</li>
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/admin/order.jsp"
					class="nav-link text-white"><i class="fas fa-shopping-cart"></i>Orders</a></li>
				<li class="nav-item"><a href="#" class="nav-link text-white"><i
						class="fas fa-sign-out-alt"></i> Logout</a></li>
			</ul>
		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
