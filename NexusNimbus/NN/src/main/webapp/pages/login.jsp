<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="ISO-8859-1">
<title>Login and Registration Form</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/pages/css/reg_login.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<div class="container">
		<div class="container">
			<input type="checkbox" id="flip">
			<div class="cover">
				<div class="front">
					<img
						src="${pageContext.request.contextPath}/pages/images/otherimg/login-img.jpg"
						alt="">
					<div class="text">
						<span class="text-1">Every new friend is a <br> new
							adventure
						</span> <span class="text-2">Let's get connected</span>
					</div>
				</div>
				<div class="back">
					<!--<img class="backImg" src="images/backImg.jpg" alt="">-->
					<div class="text">
						<span class="text-1">Complete miles of journey <br>
							with one step
						</span> <span class="text-2">Let's get started</span>
					</div>
				</div>
			</div>

			<div class="forms">
				<div class="form-content">
					<div class="login-form">
						<section>

							<div class="title">
								Login <a
									href="${pageContext.request.contextPath}/pages/home.jsp">
									<button class="favorite styled" type="button">Close</button>
								</a>
							</div>
						</section>

						<%
						String logErrorMessage = (String) request.getAttribute(StringUtils.ERROR_MESSAGE);
						if (logErrorMessage != null && !logErrorMessage.isEmpty()) {
						%>
						<p class="error-message"><%=logErrorMessage%></p>
						<%
						}
						%>

						<form action="${pageContext.request.contextPath}/LoginServlet"
							method="post">
							<div class="input-boxes">
								<div class="input-box">
									<i class="fas fa-envelope"></i> <input type="text" name="Email"
										placeholder="Enter your email" required>
								</div>
								<div class="input-box">
									<i class="fas fa-lock"></i> <input type="password"
										name="Password" placeholder="Enter your password" required>
								</div>
								<div class="text">
									<a href="#">Forgot password?</a>
								</div>
								<div class="button input-box">
									<input type="submit" value="Submit">
								</div>
								<div class="text sign-up-text">
									Don't have an account? <label for="flip">Signup now</label>
								</div>
							</div>
						</form>
					</div>
					<div class="signup-form">
						<section>
							<div class="title">
								Signup <a
									href="${pageContext.request.contextPath}/pages/home.jsp">
									<button class="favorite styled" type="button">Close</button>
								</a>
							</div>
						</section>
						<%-- Display error message if it exists --%>

						<%@ page import="com.nexusnimbus.utils.StringUtils"%>
						<%
						String errorMessage = (String) request.getAttribute(StringUtils.REG_ERROR_MESSAGE);
						if (errorMessage != null && !errorMessage.isEmpty()) {
						%>
						<p class="errormessage"><%=errorMessage%></p>
						<%
						}
						%>
						<script>
							function validateForm() {
								var firstname = document.forms["registrationForm"]["firstname"].value;
								var lastname = document.forms["registrationForm"]["lastname"].value;
								var phonenumber = document.forms["registrationForm"]["phonenumber"].value;
								var email = document.forms["registrationForm"]["email"].value;
								var password = document.forms["registrationForm"]["password"].value;
								var confirmpassword = document.forms["registrationForm"]["confirmpassword"].value;

								var nameRegex = /^[a-zA-Z]+$/;
								var phoneRegex = /^\d{10}$/;
								var emailRegex = /\S+@\S+\.\S+/;

								if (!nameRegex.test(firstname)
										|| !nameRegex.test(lastname)) {
									alert("First name and last name should not contain special characters.");
									return false;
								}

								if (!phoneRegex.test(phonenumber)) {
									alert("Phone number should be exactly 10 numbers.");
									return false;
								}

								if (!emailRegex.test(email)) {
									alert("Please enter a valid email address.");
									return false;
								}

								if (password !== confirmpassword) {
									alert("Passwords do not match");
									return false;
								}

								return true;
							}
						</script>
						<form action="${pageContext.request.contextPath}/RegisterServlet"
							method="post" name = "registrationForm" onsubmit="return validateForm()">
							<div class="input-boxes">
								<div class="input-box1">
									<i class="fas fa-user"></i> <input type="text" name="firstname"
										placeholder="First name" required> <input type="text"
										name="lastname" placeholder="Last name" required>
								</div>
								<div class="input-box">
									<i class="fas fa-mobile"></i> <input type="text"
										name="phonenumber" placeholder="Enter your Phone Number"
										required>
								</div>
								<div class="input-box">
									<i class="fas fa-home"></i> <input type="text" name="address"
										placeholder="Enter your Address" required>
								</div>
								<div class="input-box">
									<i class="fas fa-envelope"></i> <input type="text" name="email"
										placeholder="Enter your email" required>
								</div>
								<div class="input-box">
									<i class="fas fa-lock"></i> <input type="password"
										name="password" placeholder="Enter your password" required>
								</div>
								<div class="input-box">
									<i class="fas fa-key"></i> <input type="password"
										name="confirmpassword" placeholder="Confirm password" required>
								</div>
								<div class="button input-box">
									<input type="submit" value="Submit">
								</div>
								<div class="text sign-up-text">
									Already have an account? <label for="flip">Login now</label>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>
