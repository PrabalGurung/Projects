<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/pages/css/home2.css">

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="carousel">
		<!-- list item -->
		<div class="list">
			<div class="item">
				<img
					src="${pageContext.request.contextPath}/pages/images/sliderimg/banner2.png">
				<div class="content">
					<div class="author">Nexus Nimbus</div>
					<div class="title">Best Laptops</div>
					<div class="topic">Laptops</div>
					<div class="des">"Welcome to the forefront of innovation,
						where our tech company pioneers the future. With a relentless
						commitment to excellence, we seamlessly blend cutting-edge
						technology with unparalleled creativity, redefining possibilities
						every step of the way."</div>
				</div>
			</div>
			<div class="item">
				<img
					src="${pageContext.request.contextPath}/pages/images/sliderimg/banner3.png">
				<div class="content">
					<div class="author">Nexus Nimbus</div>
					<div class="title">Best Laptops</div>
					<div class="topic">Laptops</div>
					<div class="des">"Welcome to the forefront of innovation,
						where our tech company pioneers the future. With a relentless
						commitment to excellence, we seamlessly blend cutting-edge
						technology with unparalleled creativity, redefining possibilities
						every step of the way."</div>
				</div>
			</div>
			<div class="item">
				<img
					src="${pageContext.request.contextPath}/pages/images/sliderimg/banner4.png">
				<div class="content">
					<div class="author">Nexus Nimbus</div>
					<div class="title">Best Laptops</div>
					<div class="topic">Laptops</div>
					<div class="des">"Welcome to the forefront of innovation,
						where our tech company pioneers the future. With a relentless
						commitment to excellence, we seamlessly blend cutting-edge
						technology with unparalleled creativity, redefining possibilities
						every step of the way. "</div>
				</div>
			</div>
			<div class="item">
				<img
					src="${pageContext.request.contextPath}/pages/images/sliderimg/banner5.png">
				<div class="content">
					<div class="author">Nexus Nimbus</div>
					<div class="title">Best Laptops</div>
					<div class="topic">Laptops</div>
					<div class="des">"Welcome to the forefront of innovation,
						where our tech company pioneers the future. With a relentless
						commitment to excellence, we seamlessly blend cutting-edge
						technology with unparalleled creativity, redefining possibilities
						every step of the way."</div>
				</div>
			</div>
		</div>
		<!-- list thumnail -->
		<div class="thumbnail">
			<div class="item">
				<img
					src="${pageContext.request.contextPath}/pages/images/sliderimg/banner2.png">
				<div class="content">
					<div class="title">Flagship</div>
				</div>
			</div>
			<div class="item">
				<img
					src="${pageContext.request.contextPath}/pages/images/sliderimg/banner3.png">
				<div class="content">
					<div class="title">Best Deals</div>
				</div>
			</div>
			<div class="item">
				<img
					src="${pageContext.request.contextPath}/pages/images/sliderimg/banner4.png">
				<div class="content">
					<div class="title">Budget friendly</div>
				</div>
			</div>
			<div class="item">
				<img
					src="${pageContext.request.contextPath}/pages/images/sliderimg/banner5.png">
				<div class="content">
					<div class="title">High performance</div>
				</div>
			</div>
		</div>
		<!-- next prev -->

		<div class="arrows">
			<button id="prev"><</button>
			<button id="next">></button>
		</div>
		<!-- time running -->
		<div class="time"></div>
	</div>


	<script
		src="${pageContext.request.contextPath}/pages/javascript/Slider.js"></script>



	<section id="option" class="section-p1">

		<a
			href="${pageContext.request.contextPath}/pages/prodd.jsp?brand=Asus">
			<div class="fe-box">
				<img
					src="${pageContext.request.contextPath}/pages/images/brandimg/Asus.png"
					alt="" name="Asus">
				<h6>Asus</h6>
			</div>
		</a> <a
			href="${pageContext.request.contextPath}/pages/prodd.jsp?brand=Apple">
			<div class="fe-box">
				<img
					src="${pageContext.request.contextPath}/pages/images/brandimg/Apple_logo_grey.png"
					alt="" name="Apple">
				<h6>Apple</h6>
			</div>
		</a> <a
			href="${pageContext.request.contextPath}/pages/prodd.jsp?brand=Dell">
			<div class="fe-box">
				<img
					src="${pageContext.request.contextPath}/pages/images/brandimg/dell.png"
					alt="" name="Dell">
				<h6>Dell</h6>
			</div>
		</a> <a href="${pageContext.request.contextPath}/pages/prodd.jsp?brand=Hp">
			<div class="fe-box">
				<img
					src="${pageContext.request.contextPath}/pages/images/brandimg/hp.png"
					alt="" name="Hp">
				<h6>Hp</h6>
			</div>
		</a> <a
			href="${pageContext.request.contextPath}/pages/prodd.jsp?brand=Lenovo">
			<div class="fe-box">
				<img
					src="${pageContext.request.contextPath}/pages/images/brandimg/lenovo.jpg"
					alt="" name="Lenovo">
				<h6>Lenovo</h6>
			</div>
		</a> <a href="${pageContext.request.contextPath}/pages/prodd.jsp?brand=MSI">
			<div class="fe-box">
				<img
					src="${pageContext.request.contextPath}/pages/images/brandimg/msi.png"
					alt="" name="MSI">
				<h6>MSI</h6>
			</div>
		</a>

	</section>
	<div class="box">
		<img src="${pageContext.request.contextPath}/pages/images/Deals/4.png"
			alt="slides" id="slide">
		<!-- JavaScript for slider  -->
		<script>
			function second() {
				document.getElementById("slide").src = "${pageContext.request.contextPath}/pages/images/Deals/1.png";
			}
			function third() {
				document.getElementById("slide").src = "${pageContext.request.contextPath}/pages/images/Deals/2.png";
			}
			function first() {
				document.getElementById("slide").src = "${pageContext.request.contextPath}/pages/images/Deals/3.png";
			}
			setInterval(first, 2000);
			setInterval(second, 4000);
			setInterval(third, 6000);
		</script>
	</div>
	<section id="product2">
		<div class="pro-box"
			onclick="window,location.href='${pageContext.request.contextPath}/pages/prodd.jsp?brand=all'">
			<img
				src="${pageContext.request.contextPath}/pages/images/Deals/highlight3.png"
				alt="">
			<h3>Best For Gaming</h3>
		</div>
		<div class="pro-box"
			onclick="window,location.href='${pageContext.request.contextPath}/pages/prodd.jsp?brand=all'">
			<img
				src="${pageContext.request.contextPath}/pages/images/Deals/highlight2.png"
				alt="">
			<h3>Best For Learning</h3>

		</div>
	</section>

	<section id="banner">
		<div class="pro-box"
			onclick="window,location.href='${pageContext.request.contextPath}/pages/prodd.jsp?brand=all'">
			<img
				src="${pageContext.request.contextPath}/pages/images/Deals/highlight1.png"
				alt="">
			<h3>Best For Office</h3>
		</div>
	</section>

	<!-- footer for home page -->
	<jsp:include page="footer.jsp" />
</body>
</html>