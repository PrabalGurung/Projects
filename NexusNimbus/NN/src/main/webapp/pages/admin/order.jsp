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
					<h1>Orders</h1>
				</div>

				<div class="container my-3">

					<!-- Table -->
					<div class="mt-4">
						<h3 class="mb-3">Recent Orders</h3>
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>Order ID</th>
										<th>Email</th>
										<th>Date</th>
										<th>Order Status</th>
										<th>Total Amount</th>
									</tr>
								</thead>
								<tbody>
									<%@ page import="java.util.List"%>
									<%@ page import="com.nexusnimbus.model.OrderModel"%>
									<%
									int Count = 0;
									List<OrderModel> orders = (List<OrderModel>) request.getAttribute("orders");
									if (orders != null) {
										for (OrderModel order : orders) {
											Count++; 
									%>
									<tr>
										<td><%= Count %></td>
										<td><%=order.getUserName()%></td>
										<td><%=order.getDate()%></td>
										<td><%=order.getStatus()%></td>
										<td><%=order.getTotalAmt()%></td>
										<td>
											<form
												action="<%=request.getContextPath()%>/changeOrderStatusServlet"
												method="post">
												<input type="hidden" name="orderId"
													value="<%=order.getId()%>" /> 
													<select name="orderStatus" class="form-control">
														<option value="Delivered"
															<%=order.getStatus().equals("Delivered") ? "selected" : ""%>>Delivered</option>
														<option value="Pending"
															<%=order.getStatus().equals("Pending") ? "selected" : ""%>>Pending</option>
													</select>
												<button type="submit" class="btn btn-primary btn-sm">Change
													Status</button>
											</form>
										</td>
									</tr>
									<%
									}
									}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<script src="assets/js/bootstrap.bundle.min.js"></script>
			</div>
		</div>
	</div>
</body>
</html>
