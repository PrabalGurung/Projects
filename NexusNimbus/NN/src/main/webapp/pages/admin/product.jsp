	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin - View Products</title>
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
					<h1>Your Products!</h1>
				</div>

				<!-- Buttons -->
				<div class="d-grid gap-2 d-md-flex justify-content-md-start mt-4">
					<a href="<%=request.getContextPath()%>/pages/admin/addProduct.jsp" class="btn btn-primary me-md-2"
						role="button">Add Product</a>
				</div>

				<!-- Table -->
				<div class="mt-4">
					<h3 class="mb-3">Products</h3>
					<form action="<%=request.getContextPath()%>/displayProductServlet"
						method="post">
						<button type="submit" class="btn btn-primary">Show List</button>
					</form>
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>	
									<th>Product ID</th>
									<th>Name</th>
									<th>Processor</th>
									<th>GPU</th>
									<th>Brand</th>
									<th>Display</th>
									<th>Memory</th>
									<th>Storage</th>
									<th>Price</th>
									<th>Picture</th>
									<th>Actions</th>
								</tr>
							</thead>
								<tbody>
								    <%@ page import="java.util.List" %>
								    <%@ page import="com.nexusnimbus.model.ProductModel" %>
								    <%
								        List<ProductModel> products = (List<ProductModel>) request.getAttribute("products");
								        if (products != null) {
								            for (ProductModel product : products) {
								    %>
								        <tr>
								            <td><%= product.getProductId() %></td>
								            <td><%= product.getProductName() %></td>
								            <td><%= product.getProductProcessor() %></td>
								            <td><%= product.getProductGPU() %></td>
								            <td><%= product.getProductBrand() %></td>
								            <td><%= product.getProductDisplay() %></td>
								            <td><%= product.getProductMemory() %></td>
								            <td><%= product.getProductStorage() %></td>
								            <td><%= product.getProductPrice() %></td>
											<td style="width: 100px;"><img src="<%=request.getContextPath()%>/pages/images/productimg/<%= product.getPicture() %>" style="width: 100px;"></td>
								            <td>
								            <form action="<%=request.getContextPath()%>/editProductPageServlet" method="post">
								            	<input type="hidden" name="productId" value="<%= product.getProductId() %>" />
								                <button class="btn btn-primary btn-sm">Edit</button>
								            </form>
								            <form action="<%=request.getContextPath()%>/deleteProduct" method="post">
								            	<input type="hidden" name="productId" value="<%= product.getProductId() %>" />
								                <button class="btn btn-danger btn-sm">Delete</button>
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
</body>
</html>
