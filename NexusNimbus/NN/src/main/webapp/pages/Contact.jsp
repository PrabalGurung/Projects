<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/pages/css/Contact_bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/pages/css/Contact.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<jsp:include page="header.jsp"/>
	<div class="content">
		<div class="container">
			<div class="row align-items-stretch no-gutters contact-wrap">
				<div class="col-md-8">
					<div class="form h-100">
						<h3>Send us a message</h3>
						<form class="mb-5" action="${pageContext.request.contextPath}/contactServlet" method="post" id="contactForm" 
							name="contactForm">
							<div class="row">
								<div class="col-md-6 form-group mb-5">
									<label for="" class="col-form-label">Name *</label> <input
										type="text" class="form-control" name="name" id="name"
										placeholder="Your name">
								</div>
								<div class="col-md-6 form-group mb-5">
									<label for="" class="col-form-label">Email *</label> <input
										type="text" class="form-control" name="email" id="email"
										placeholder="Your email">
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 form-group mb-5">
									<label for="message" class="col-form-label">Message *</label>
									<textarea class="form-control" name="message" id="message"
										cols="30" rows="4" placeholder="Write your message"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 form-group">
									<input type="submit" value="Send Message"
										class="btn btn-primary rounded-0 py-2 px-4"><span
										class="submitting"></span>
								</div>
							</div>
						</form>

						<div id="form-message-warning mt-4"></div>
						<div id="form-message-success">Your message was sent, thank
							you!</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="contact-info h-100">
						<h3>Contact Information</h3>
						<p class="mb-5">"Empower Your World: Unleash Your Potential
							with Every Click!"</p>
						<ul class="list-unstyled">
							<li class="d-flex"><i class="fa fa-map-marker"
								aria-hidden="true"></i> <span class="text">Pokhara, Nepal</span>
							</li>
							<li class="d-flex"><i class="fa fa-mobile"
								aria-hidden="true"></i><span class="text">+9779800000000</span></li>
							<li class="d-flex"><i class="fa fa-envelope"
								aria-hidden="true"></i><span class="text">NexusNimbus@gmail.com</span>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>