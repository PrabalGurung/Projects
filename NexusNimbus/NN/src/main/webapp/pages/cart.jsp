<%@page import="com.nexusnimbus.utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Shopping Cart UI</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/pages/css/cart1.css">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,900"
	rel="stylesheet">
</head>
<jsp:include page="header.jsp" />
<body>

						<%
						String prodDelMsg = (String) request.getAttribute(StringUtils.ERROR_MESSAGE);
						if (prodDelMsg != null && !prodDelMsg.isEmpty()) {
						%>
						<p class="error-message"><%=prodDelMsg%></p>
						<%
						}
						%>
	<%
	if (session.getAttribute("email") == null) {
		response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
		return;
	}
	%>

	<%@ page import="java.util.List"%>
	<%@ page import="com.nexusnimbus.model.ProductModel"%>
	<section class="cart-section">
		<div class="CartContainer">
			<div class="Header">
				<h3 class="Heading">Shopping Cart</h3>
			</div>
			<%
			int productCount = 0;
			double totalPrice = 0.0;
			List<ProductModel> products = (List<ProductModel>) request.getAttribute("products");
			if (products != null) {
				for (ProductModel p : products) {
					productCount++;
					totalPrice += p.getProductPrice();
			%>
			<div class="Cart-Items">
				<div class="image-box">
					<img src="${pageContext.request.contextPath}/pages/images/productimg/<%= p.getPicture() %>" style=""
						height="120px"/>
				</div>
				<div class="about">
					<h1 class="title"><%=p.getProductName()%></h1>
					<h3 class="subtitle"><%=p.getProductBrand()%></h3>
				</div>
				<div class="prices">
					<div class="amount"><%=p.getProductPrice()%></div>
					<form action="${pageContext.request.contextPath}/removeCartServlet"
						method="post">
						<input type="hidden" name="productId"
							value="<%=p.getProductId()%>"> <input type="submit"
							class="remove" value="Remove">
					</form>
				</div>
			</div>
			<hr>
			<%
			}
			}
			%>
			<div class="checkout">
				<div class="total">
					<div>
						<div class="Subtotal">Sub-Total</div>
						<div class="items"><%=productCount%>
							items
						</div>
					</div>
					<div class="total-amount">
						$<%=totalPrice%></div>
				</div>

				<form action="${pageContext.request.contextPath}/AddToOrderServlet"
					method="post">
					<input type="hidden" name="amount" value="<%=totalPrice%>">
					<input type="submit" class="button" value="CheckOut">
				</form>
			</div>
		</div>
	</section>

</body>
</html>