<%@page import="com.nexusnimbus.model.ProductModel"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nexusnimbus.controller.DatabaseController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/css/ProductDetails.css">
<script src="../pages/javascript/productdetail.js" defer></script>

</head>
<body>
<jsp:include page="header.jsp" />

	<%
String productName = request.getParameter("productName");
DatabaseController dbController = new DatabaseController();

Connection conn = dbController.getConnection();
ArrayList <ProductModel> products = dbController.specificProduct(productName);

%>


	<main class="container">
			<%
				 for (ProductModel sp: products){
			 %>

		<!-- Left Column / Headphones Image -->
		<div class="left-column">
				<img data-image="blue" src="${pageContext.request.contextPath}/pages/images/productimg/<%= sp.getPicture() %>"
				alt=""> <img data-image="red" class="active"
				src="${pageContext.request.contextPath}/pages/images/productimg/<%= sp.getPicture() %>">
		</div>


		<!-- Right Column -->
		<div class="right-column">

			<!-- Product Description -->
			<div class="product-description">
				<span><%= sp.getProductName()%></span>
				<h1><%= sp.getProductName()%></h1>
				<p>The preferred choice of a vast range of acclaimed DJs.
					Punchy, bass-focused sound and high isolation. Sturdy headband and
					on-ear cushions suitable for live performance</p>
			</div>

			<div class="product-processor">
				<span><%= sp.getProductProcessor()%></span> 
			</div>

			<div class="product-gpu">
				<span><%= sp.getProductGPU()%></span>

			<div class="product-brand">
				<span><%= sp.getProductBrand()%></span>

			<div class="product-display">
				<span><%= sp.getProductDisplay()%></span> 
			</div>

			<div class="product-memory">
				<span><%= sp.getProductMemory()%></span> 
			</div>
			<!-- Product Pricing -->
			<div class="product-storage">
				<span><%= sp.getProductStorage()%></span> 
			</div>

			<div class="product-price">
				<span><%= sp.getProductPrice()%></span> 
			</div>
		</div>
		<% } %>
	</main>

</body>
</html>