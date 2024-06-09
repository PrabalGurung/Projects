<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Product</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<style>
.sidebar {
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
}
</style>
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
					<h1>Edit Products</h1>
				</div>
				<form action="<%=request.getContextPath()%>/editProductServlet" method="post">
					<%
					String errorMessage = (String) request.getAttribute("errorMessage");
					if (errorMessage != null && !errorMessage.isEmpty()) {
					%>
					<p class="error-message"><%=errorMessage%></p>
					<%
					}
					%>
					
					<%@ page import="java.util.List"%>
					<%@ page import="com.nexusnimbus.model.ProductModel"%>
					
					<%
					List<ProductModel> products = (List<ProductModel>) request.getAttribute("products");
					if (products != null) {
						for (ProductModel p : products) {
					%>
					
					<div class="form-group">
						<label for="name">Name</label> <input type="text"
							class="form-control" name="Name" 
							value="<%= p.getProductName()%>">
					</div>
					<div class="form-group">
						<label for="processor">Processor</label> <input type="text"
							class="form-control" name="Processor"
							value="<%= p.getProductProcessor()%>">
					</div>
					<div class="form-group">
						<label for="gpu">GPU</label> <input type="text"
							class="form-control" name="gpu" 
							value="<%= p.getProductGPU() %>">
					</div>
					<div class="form-group">
						<label for="brand">Brand</label> <input type="text"
							class="form-control" name="Brand" 
							value="<%= p.getProductBrand() %>">
					</div>
					<div class="form-group">
						<label for="display">Display</label> <input type="text"
							class="form-control" name="Display"
							value="<%= p.getProductDisplay() %>">
					</div>
					<div class="form-group">
						<label for="memory">Memory</label> <input type="text"
							class="form-control" name="Memory"
							value="<%= p.getProductMemory() %>">
					</div>
					<div class="form-group">
						<label for="storage">Storage</label> <input type="text"
							class="form-control" name="Storage"
							value="<%= p.getProductStorage() %>">
					</div>
					<div class="form-group">
						<label for="price">Price</label> <input type="text"
							class="form-control" name="Price"
							value="<%= p.getProductPrice() %>">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
				<%}} %>
				<div class="container my-3"></div>
			</div>
		</div>
	</div>

	<script src="assets/js/bootstrap.bundle.min.js"></script>

</body>
</html>
