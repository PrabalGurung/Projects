<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Dashboard</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<!-- Sidebar -->
			<div class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<jsp:include page="navBar.jsp" />
			</div>

			<div class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div class="container-fluid bg-light p-3">
					<h1>Welcome back Admin!</h1>
				</div>

				<div class="container my-3">
					<div class="row row-cols-1 row-cols-md-3 g-4">
						<div class="col">
							<div class="card text-center h-100">
								<div class="card-body">
									<h5 class="card-title" id="orders-count">0</h5>
									<p class="card-text">Orders</p>
								</div>
							</div>
						</div>
						<div class="col">
							<div class="card text-center h-100">
								<div class="card-body">
									<h5 class="card-title" id="users-count">0</h5>
									<p class="card-text">Users</p>
								</div>
							</div>
						</div>
						<div class="col">
							<div class="card text-center h-100">
								<div class="card-body">
									<h5 class="card-title" id="sales-count">0</h5>
									<p class="card-text">Total Sales</p>
								</div>
							</div>
						</div>
					</div>

					<!-- Buttons -->
					<div class="d-grid gap-2 d-md-flex justify-content-md-start mt-4">
						<a href="<%=request.getContextPath()%>/admin/addProduct.jsp" class="btn btn-primary me-md-2"
							role="button">Add Product</a>
					</div>

					<!-- Table -->
					<div class="mt-4">
						<h3 class="mb-3">
							Recent Orders <a href="#" class="text-decoration-none">View
								all</a>
						</h3>
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>Order ID</th>
										<th>Username</th>
										<th>Product name</th>
										<th>Qty</th>
										<th>Order Date</th>
										<th>Order Status</th>
										<th>Total Amount</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>Samir</td>
										<td>Beats Studio Pro</td>
										<td>1</td>
										<td>17 Dec, 2022</td>
										<td><span class="badge bg-success">Delivered</span></td>
										<td>$128.90</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>

				<script src="assets/js/bootstrap.bundle.min.js"></script>
				<script>
                    function animateValue(id, start, end, duration) {
                        let range = end - start;
                        let current = start;
                        let increment = end > start? 1 : -1;
                        let stepTime = Math.abs(Math.floor(duration / range));
                        let obj = document.getElementById(id);
                        let timer = setInterval(function() {
                            current += increment;
                            obj.innerHTML = current;
                            if (current == end) {
                                clearInterval(timer);
                            }
                        }, stepTime);
                    }

                    window.onload = function() {
                        animateValue("orders-count", 0, 50, 50);
                        animateValue("users-count", 0, 500, 50);
                        animateValue("sales-count", 0, 777, 50);
                    };
                </script>
			</div>
		</div>
	</div>
</body>
</html>
