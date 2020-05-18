<%-- 
    Document   : product-section
    Created on : Oct 8, 2019, 9:43:19 PM
    Author     : Thinkpad
--%>

<%@page import="java.util.List"%>
<%@page import="DAO.ProductDAOImpl"%>
<%@page import="model.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
    </head>
    <body>
        <!-- product section -->
	<section class="product-section">
		<div class="container">
		
		<c:set scope="request" var="product" value="${Product}" />
			<div class="back-link">
				<a href="<%=request.getContextPath() %>/productList?maTL=${product.getMaTL()}"> &lt;&lt; Back to Category</a>
			</div>
			<div class="row">
				<div class="col-lg-6">
					<div class="product-pic-zoom">
						<img class="product-big-img" src="img/product/${product.getHinhanh() }" alt="">
					</div>
					<div class="product-thumbs" tabindex="1" style="overflow: hidden; outline: none;">
						<div class="product-thumbs-track">
							<div class="pt active" data-imgbigurl="img/single-product/1/${product.getHinhanh() }"><img src="img/single-product/thumb1/${product.getHinhanh() }" alt=""></div>
							<div class="pt" data-imgbigurl="img/single-product/2/${product.getHinhanh() }"><img src="img/single-product/thumb2/${product.getHinhanh() }" alt=""></div>
							<div class="pt" data-imgbigurl="img/single-product/3/${product.getHinhanh() }"><img src="img/single-product/thumb3/${product.getHinhanh() }" alt=""></div>
							<div class="pt" data-imgbigurl="img/single-product/4/${product.getHinhanh() }"><img src="img/single-product/thumb4/${product.getHinhanh() }" alt=""></div>
						</div>
					</div>
				</div>
				<div class="col-lg-6 product-details">
					<h2 class="p-title">${product.getTenSP() }</h2>
					<h3 class="p-price">${product.getPrice() }$</h3>
					<h4 class="p-stock">Available: <span>In Stock</span></h4>
					<div class="p-rating">
						<i class="fa fa-star-o"></i>
						<i class="fa fa-star-o"></i>
						<i class="fa fa-star-o"></i>
						<i class="fa fa-star-o"></i>
						<i class="fa fa-star-o fa-fade"></i>
					</div>
					<div class="p-review">
						<a href="">3 reviews</a>|<a href="">Add your review</a>
					</div>
					<div class="fw-size-choose">
						<p>Size</p>
						<div class="sc-item">
							<input type="radio" name="sc" id="xs-size">
							<label for="xs-size">0</label>
						</div>
						<div class="sc-item">
							<input type="radio" name="sc" id="s-size">
							<label for="s-size">1</label>
						</div>
						<div class="sc-item">
							<input type="radio" name="sc" id="m-size" checked="">
							<label for="m-size">2</label>
						</div>
						<div class="sc-item">
							<input type="radio" name="sc" id="l-size">
							<label for="l-size">3</label>
						</div>
						<div class="sc-item disable">
							<input type="radio" name="sc" id="xl-size" disabled>
							<label for="xl-size">4</label>
						</div>
						<div class="sc-item">
							<input type="radio" name="sc" id="xxl-size">
							<label for="xxl-size">5</label>
						</div>
					</div>
					<!-- 
					<div class="quantity">
						<p>Quantity</p>
                        <div class="pro-qty"><input type="text" value="1"></div>
                    </div>
                     -->
                    <%
                    	String mss = "Please complete login!";
						if (session.getAttribute("user") == null){
							
					%>
					<a href="#"class="site-btn">SHOP NOW</a>
					<div style="color: red"><%=mss%></div>	
					<% }%>
					<%
						if (session.getAttribute("user") != null){
					%>
					<a href="<%=request.getContextPath() %>/CartServlet?command=addCart&maSP=${product.getMaSP()}"class="site-btn">SHOP NOW</a>
					<% }%>
					
					<div id="accordion" class="accordion-area">
						<div class="panel">
							<div class="panel-header" id="headingOne">
								<button class="panel-link active" data-toggle="collapse" data-target="#collapse1" aria-expanded="true" aria-controls="collapse1">information</button>
							</div>
							<div id="collapse1" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
								<div class="panel-body">
									<p>${product.getThongtin() }</p>
								</div>
							</div>
						</div>
						<div class="panel">
							<div class="panel-header" id="headingTwo">
								<button class="panel-link" data-toggle="collapse" data-target="#collapse2" aria-expanded="false" aria-controls="collapse2">care details </button>
							</div>
							<div id="collapse2" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
								<div class="panel-body">
									<img src="./img/cards.png" alt="">
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra tempor so dales. Phasellus sagittis auctor gravida. Integer bibendum sodales arcu id te mpus. Ut consectetur lacus leo, non scelerisque nulla euismod nec.</p>
								</div>
							</div>
						</div>
						<div class="panel">
							<div class="panel-header" id="headingThree">
								<button class="panel-link" data-toggle="collapse" data-target="#collapse3" aria-expanded="false" aria-controls="collapse3">shipping & Returns</button>
							</div>
							<div id="collapse3" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
								<div class="panel-body">
									<h4>7 Days Returns</h4>
									<p>Cash on Delivery Available<br>Home Delivery <span>3 - 4 days</span></p>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra tempor so dales. Phasellus sagittis auctor gravida. Integer bibendum sodales arcu id te mpus. Ut consectetur lacus leo, non scelerisque nulla euismod nec.</p>
								</div>
							</div>
						</div>
					</div>
					<div class="social-sharing">
						<a href=""><i class="fa fa-google-plus"></i></a>
						<a href=""><i class="fa fa-pinterest"></i></a>
						<a href=""><i class="fa fa-facebook"></i></a>
						<a href=""><i class="fa fa-twitter"></i></a>
						<a href=""><i class="fa fa-youtube"></i></a>
					</div>
				</div>
			</div>
		<c:remove var="product" scope="request"/>
		</div>
	</section>
	<!-- product section end -->
	
	 <!-- RELATED PRODUCTS section -->
	<section class="related-product-section">
		<div class="container">
			<div class="section-title">
				<h2>RELATED PRODUCTS</h2>
			</div>
			<div class="product-slider owl-carousel">
			
		<c:forEach items="${List }" var="p" >
				<div class="product-item">
					<div class="pi-pic">
						<a href="<%=request.getContextPath() %>/product?maSP=${p.getMaSP() }"><img src="img/product/${p.getHinhanh() }" alt=""></a>
						<div class="pi-links">
						<a href="<%=request.getContextPath() %>/CartServlet?command=addCart&maSP=${p.getMaSP()}" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
						<a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
						</div>
						
					</div>
					<div class="pi-text">
						<h6>${p.getPrice() }$</h6>
						<p>${p.getTenSP() } </p>
					</div>
				</div>
		 </c:forEach>
		 
			</div>
		</div>
	</section>
	<!-- RELATED PRODUCTS section end -->
        
    </body>
</html>
