<%-- 
    Document   : index
    Created on : Oct 8, 2019, 8:30:46 PM
    Author     : Thinkpad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Divisima | eCommerce Template</title>
	<meta charset="UTF-8">
	<meta name="description" content=" Divisima | eCommerce Template">
	<meta name="keywords" content="divisima, eCommerce, creative, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Favicon -->
	<link href="img/favicon.ico" rel="shortcut icon"/>

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i" rel="stylesheet">


	<!-- Stylesheets -->
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" href="css/flaticon.css"/>
	<link rel="stylesheet" href="css/slicknav.min.css"/>
	<link rel="stylesheet" href="css/jquery-ui.min.css"/>
	<link rel="stylesheet" href="css/owl.carousel.min.css"/>
	<link rel="stylesheet" href="css/animate.css"/>
	<link rel="stylesheet" href="css/style.css"/>


	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
        
    </head>
    <body>
        <jsp:include page="page-preloder.jsp"></jsp:include>
        
        <jsp:include page="header.jsp"></jsp:include>
        <br><br>
        
        <!-- Product filter section -->
	<section class="product-filter-section">
		<div class="container">
			<div class="row">
			<c:forEach var="product" items="${search }">
				<div class="col-lg-3 col-sm-6">
					<div class="product-item">
						<div class="pi-pic">
							<a href="<%=request.getContextPath() %>/product?maSP=${product.getMaSP() }"><img src="img/product/${product.getHinhanh() }" alt=""></a>
							<div class="pi-links">
								<%
								if(session.getAttribute("user") == null){
								%>
								<a href="#" class="add-card"><i class="flaticon-bag"></i><span>PLEASE LOGIN</span></a>
								<a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
								<%} %>
								<%if(session.getAttribute("user") != null){ %>
								<a href="<%=request.getContextPath() %>/CartServlet?command=addCart&maSP=${product.getMaSP() }%>" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
								<a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
								<%} %>
								</div>					
							</div>
						<div class="pi-text">
							<h6>${product.getPrice()}$</h6>
							<p>${product.getTenSP()}</p>
						</div>
					</div>
					</div>
					</c:forEach>
				</div>
			
				</div>
			</div>
			
			<div class="text-center pt-5">
				<button class="site-btn sb-line sb-dark">LOAD MORE</button>
			</div>
		</div>
	</section>
	<!-- Product filter section end -->
        
        
        <jsp:include page="banner.jsp"></jsp:include>
        
        <jsp:include page="footer.jsp"></jsp:include>
        
        <!--====== Javascripts & Jquery ======-->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.slicknav.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.nicescroll.min.js"></script>
	<script src="js/jquery.zoom.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/main.js"></script>
    </body>
</html>
