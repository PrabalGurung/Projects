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
					<form action="${pageContext.request.contextPath}/displayProductServlet" method="post">
						<button type="submit" style="border: none; background: none; cursor: pointer;">			
								<i class="fas fa-box"></i> Products
						</button>
					</form>
				</li>
					<form action="${pageContext.request.contextPath}/displayOrderServlet" method="post">
						<button type="submit" style="border: none; background: none; cursor: pointer;">			
								<i class="fas fa-box"></i> Orders
						</button>
					</form>
				<li class="nav-item">
				
				</li>
				<li class="nav-item">
					<form action="${pageContext.request.contextPath}/LogOutServlet" method="post">
						<button type="submit" style="border: none; background: none; cursor: pointer;">			
								<i class="fas fa-sign-out-alt"></i> Logout
						</button>
					</form>
				</li>
			</ul>
		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
