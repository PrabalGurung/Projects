<%@page import="com.nexusnimbus.utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Product</title>
<link rel="stylesheet" href="assets/css/addProduct_Bootstrap.css">
<link rel="stylesheet" href="assets/css/addProduct.css">
<body>
	<div class="container-fluid">
		<div class="row">
			<!-- Sidebar -->
			<div class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<jsp:include page="navBar.jsp" />
			</div>

			<div class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div class="container-fluid bg-light p-3">
					<h1>Add Products</h1>
				</div>
				<script>
					// JavaScript validation function to ensure Price is a valid number
					function validatePrice() {
						var priceInput = document.getElementById("Price");
						var priceValue = priceInput.value.trim();
						if (!priceValue.match(/^\d+(\.\d+)?$/)) {
							alert("Price must be a valid number.");
							priceInput.value = ""; // Clear the input field
							return false; // Prevent form submission
						}
						return true; // Allow form submission
					}
				</script>


				<form action="<%=request.getContextPath()%>/productServlet"
					method="post" enctype="multipart/form-data" onsubmit="return validatePrice();">

					<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
						<div class="row">
							<div class="col-12">
								<h2 class="tm-block-title d-inline-block">Add Product</h2>
							</div>
						</div>
						<div class="row tm-edit-product-row">
							<div class="col-xl-6 col-lg-6 col-md-12">
									<div class="form-group mb-3">
										<label for="Product_Id">Product Id </label> <input
											id="Product_Id" name="Product_Id" type="text"
											class="form-control validate" required />
									</div>
									<div class="form-group mb-3">
										<label for="Product_Name">Product Name </label> <input
											id="Product_Name" name="Product_Name" type="text"
											class="form-control validate" required />
									</div>
									<div class="form-group mb-3">
										<label for="Brand">Brand </label> <input id="Brand"
											name="Brand" type="text" class="form-control validate"
											required />
									</div>
									<div class="form-group mb-3">
										<label for="name">price </label> <input id="Price"
											name="Price" type="text" class="form-control validate"
											required />
									</div>
									<div class="row">
										<div class="form-group mb-3 col-xs-12 col-sm-6">
											<label for="Memory">Processor</label> <input id="Processor"
												name="Processor" type="text" class="form-control validate"
												data-large-mode="true" />
										</div>
										<div class="form-group mb-3 col-xs-12 col-sm-6">
											<label for="Storage">GPU</label> <input id="gpu" name="gpu"
												type="text" class="form-control validate" required />
										</div>
									</div>
									<div class="form-group mb-3">
										<label for="Path">Display </label> <input id="Display"
											name="Display" type="text" class="form-control validate"
											required />
									</div>
									<div class="row">
										<div class="form-group mb-3 col-xs-12 col-sm-6">
											<label for="Memory">Memory</label> <input id="Memory"
												name="Memory" type="text" class="form-control validate"
												data-large-mode="true" />
										</div>
										<div class="form-group mb-3 col-xs-12 col-sm-6">
											<label for="Storage">Storage</label> <input id="Storage"
												name="Storage" type="text" class="form-control validate"
												required />
										</div>
									</div>
									<label for="Path">Path </label> <input id="Path" name="Path"
										type="file" class="form-control validate" required />
							</div>
						</div>
						
						<div class="col-12">
							<button type="submit" class="btn-primary1">Add Product</button>
						</div>
				</form>
			</div>
		</div>

		<script src="assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>
