<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/css/orderBootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/css/finalorder.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="content" class="col-sm-9">
		<h2 class="title">Order History</h2>
		<div class="table-responsive">
		<form action="<%=request.getContextPath()%>/displayUserOrderServlet" method="post">
			<button type="submit" class="btn btn-primary btn-sm">Change Status</button>
		</form>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<td class="text-center">Order ID</td>
						<td class="text-center">Status</td>
						<td class="text-center">Date Added</td>
						<td class="text-right">Total</td>
					</tr>
				</thead>
				<tbody>
					<%@ page import="java.util.List"%>
					<%@ page import="com.nexusnimbus.model.OrderModel"%>
					<%
					List<OrderModel> orders = (List<OrderModel>) request.getAttribute("orders");
					if (orders != null) {
						for (OrderModel order : orders) {
					%>
					<tr>
						<td><%=order.getId() %></td>
						<td><%=order.getDate()%></td>
						<td><%=order.getStatus()%></td>
						<td><%=order.getTotalAmt()%></td>
					</tr>
					<%
						}
						}
					%>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>
