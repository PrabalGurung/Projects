<%@page import="com.nexusnimbus.utils.StringUtils"%>
<%@page import="com.nexusnimbus.model.SaveProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.nexusnimbus.controller.DatabaseController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Products</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/pages/css/finalproduct.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="hero-image">
	<img src= "${pageContext.request.contextPath}/pages/images/sliderimg/banner.jpg"></div>
	<!-- Your product section -->
	<% 
                String brand = request.getParameter("brand");
                DatabaseController dbController = new DatabaseController();
                Connection conn = dbController.getConnection();

                ArrayList<SaveProduct> products = dbController.getBrandProduct(brand);
    %>
	<section id="product" class="section-p1">
		<div class="pro">

			<!-- Product cards generation -->
			<div class="pro-container">
				<% 
				if(products == null || products.isEmpty()){
					
				%>
				<h3> No products found.</h3>
				<% 
				}else{
	             	for (SaveProduct ss : products) {
	            %>
				<div class="product-card">
					<img
						src="${pageContext.request.contextPath}/pages/images/productimg/<%= ss.getPicture() %>"
						alt="">
					<h4><a href="${pageContext.request.contextPath}/pages/productdetail.jsp?productName=<%=ss.getProductName()%>">
						<%= ss.getProductName() %>
						</a>
					</h4>
					<div>
						<span>$<%= ss.getProductPrice() %></span>
						<form action="${pageContext.request.contextPath}/addToCartServlet"
							method="post">
							<input type="hidden" name="productName"
								value="<%= ss.getProductName() %>">
							<button type="submit"
								style="border: none; background: none; cursor: pointer;">
								<i class="fa fa-shopping-cart" aria-hidden="true"></i>
							</button>
						</form>
					</div>
				</div>
				<%  }   	}%>
			</div>
		</div>
	</section>
	<section id="pagination" class="section-p1">
		<a href="#">1</a> <a href="#">2</a> <a href="#"><i
			class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
	</section>
	<jsp:include page="footer.jsp" />
</body>
</html>
