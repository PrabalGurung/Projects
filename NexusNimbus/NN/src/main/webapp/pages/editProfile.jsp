<%@page import="com.nexusnimbus.utils.StringUtils"%>
<%@page import="com.nexusnimbus.model.UserModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.nexusnimbus.controller.DatabaseController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Profile Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/pages/css/editProfile1.css">
</head>
<body>
	<jsp:include page ="header.jsp" />
	<%
	if (session.getAttribute("email") == null) {
		response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);
		return;
	}
	%>

	<div class="container">
		<div class="main-body">
			<div class="row">
				<div class="col-lg-4"></div>
			</div>
		
			<%
			String email = request.getParameter("email");

			DatabaseController dbController = new DatabaseController();
			Connection conn = dbController.getConnection();
			ArrayList<UserModel> user = dbController.editUserProfile(email);
			for (UserModel um : user) {
			%>
			<form
				action="${pageContext.request.contextPath}/UpdateProfileServlet"
				method="post">
				<h2>Edit Your Profile</h2>
				<div class="card">
					<div class="card-body">

						<div class="row mb-3">
							<div class="col-sm-3">
								<h6 class="mb-0">First Name</h6>
							</div>
							<div class="col-sm-9 text-secondary">
								<input type="text" class="form-control" name="firstname"
									value="<%=um.getFirstName()%>">
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-sm-3">
								<h6 class="mb-0">Last Name</h6>
							</div>
							<div class="col-sm-9 text-secondary">
								<input type="text" class="form-control" name="lastname"
									value="<%=um.getLastName()%>">
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-sm-3">
								<h6 class="mb-0">Phone</h6>
							</div>
							<div class="col-sm-9 text-secondary">
								<input type="text" class="form-control" name="phonenumber"
									value="<%=um.getPhoneNumber()%>">
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-sm-3">
								<h6 class="mb-0">Address</h6>
							</div>
							<div class="col-sm-9 text-secondary">
								<input type="text" class="form-control" name="address"
									value="<%=um.getAddress()%>">
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-sm-3">
								<h6 class="mb-0">Password</h6>
							</div>
							<div class="col-sm-9 text-secondary">
								<input type="text" class="form-control" name="updatedpassword" value = "*******">
							</div>
						</div>

						<div class="row">
							<div class="col-sm-3"></div>
							<div class="col-sm-9 text-secondary">
								<input type="submit" class="btn btn-primary px-4"
									value="Save Changes">
							</div>
						</div>
					</div>
				</div>
			</form>

			<%
			}
			%>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
		
	</script>
	<jsp:include page="footer.jsp"/>
</body>
</html>