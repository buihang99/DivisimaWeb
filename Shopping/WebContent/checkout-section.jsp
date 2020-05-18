<%-- 
    Document   : checkout-section
    Created on : Oct 8, 2019, 9:18:14 PM
    Author     : Thinkpad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
    </head>
    <body>
        <!-- checkout section  -->
	<section class="checkout-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 order-2 order-lg-1">
				  	<% String link = String.valueOf(session.getAttribute("username"));
				  		String u = (String) session.getAttribute("link");
				  	%>
					<form method="post" action= "<%=request.getContextPath() %>/CartServlet?command=Order&<%=u %>"  class="checkout-form">
					<div class="cf-title">Fill Information Order</div>
					<%
					if(request.getAttribute("order_err") != null){%>
					<div><%= request.getAttribute("order_err") %></div>
					<%
					};
					%>
					 <!-- 
						<div class="cf-title">Billing Address</div>
						<div class="row">
							<div class="col-md-7">
								<p>*Billing Information</p>
							</div>
							<div class="col-md-5">
								<div class="cf-radio-btns address-rb">
									<div class="cfr-item">
										<input type="radio" name="pm" id="one">
										<label for="one">Use my regular address</label>
									</div>
									<div class="cfr-item">
										<input type="radio" name="pm" id="two">
										<label for="two">Use a different address</label>
									</div>
								</div>
							</div>
						</div>
						 -->
						<div class="row address-inputs">
							<div class="col-md-12">
								<input name="user_name" type="text" placeholder="Name">
								<input name = "user_address" type="text" placeholder="Address">
							</div>
							<!-- 
							<div class="col-md-6">
								<input type="text" placeholder="Zip code">
							</div>
							 -->
							<div class="col-md-6">
								<input name= "user_phone" type="text" placeholder="Phone no.">
							</div>
						</div>
						<!-- 
						<div class="cf-title">Delievery Info</div>
						<div class="row shipping-btns">
							<div class="col-6">
								<h4>Standard</h4>
							</div>
							<div class="col-6">
								<div class="cf-radio-btns">
									<div class="cfr-item">
										<input type="radio" name="shipping" id="ship-1">
										<label for="ship-1">Free</label>
									</div>
								</div>
							</div>
							<div class="col-6">
								<h4>Next day delievery  </h4>
							</div>
							<div class="col-6">
								<div class="cf-radio-btns">
									<div class="cfr-item">
										<input type="radio" name="shipping" id="ship-2">
										<label for="ship-2">$3.45</label>
									</div>
								</div>
							</div>
						</div>
						<div class="cf-title">Payment</div>
						<ul class="payment-list">
							<li>Paypal<a href="#"><img src="img/paypal.png" alt=""></a></li>
							<li>Credit / Debit card<a href="#"><img src="img/mastercart.png" alt=""></a></li>
							<li>Pay when you get the package</li>
						</ul>
						 -->
						 
						<button  type="submit" class="site-btn submit-order-btn">Place Order</button>
					</form>
				</div>
				<div class="col-lg-4 order-1 order-lg-2">
					<div class="checkout-cart">
						<h3>Your Cart</h3>
						
						<ul class="product-list">
						<c:forEach var="cart" items="${list_cart }">
							<li>
								<div class="pl-thumb"><img src="img/cart/${cart.getP().getHinhanh() }" alt=""></div>
								<h6>${cart.getP().getTenSP() }</h6>
								<p>${cart.getP().getPrice() }$</p>
							</li>
						</c:forEach>
						</ul>
						
						<ul class="price-list">
						<c:set scope="request" var="total" value="${total}" />
							<li>Total<span>${total }$</span></li>
							<li>Shipping<span>free</span></li>
							<li class="total">Total<span>${total }$</span></li>
						<c:remove var="total" scope="request"/>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- checkout section end -->
    </body>
</html>
