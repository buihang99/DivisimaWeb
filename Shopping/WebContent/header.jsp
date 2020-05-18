<%-- 
    Document   : header
    Created on : Oct 8, 2019, 9:29:32 PM
    Author     : Thinkpad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
    </head>
    <body>
        <!-- Header section -->
	<header class="header-section">
		<div class="header-top">
			<div class="container">
				<div class="row">
					<div class="col-lg-2 text-center text-lg-left">
						<!-- logo -->
						<a href="./index.html" class="site-logo">
							<img src="img/logo.png" alt="">
						</a>
					</div>
					<div class="col-xl-6 col-lg-5">
						<form method="post" action="<%=request.getContextPath() %>/SearchServlet" class="header-search-form">
							<input name="search" type="text" placeholder="Search on divisima ....">
							<button type="submit"><i class="flaticon-search"></i></button>
						</form>
					</div>
					<div class="col-xl-4 col-lg-5">
						<div class="user-panel">
							<div class="up-item">
								<% String mess="";
								if (session.getAttribute("user")!= null){
									mess= (String) session.getAttribute("username");
								%>
								<div class="main-menu">
									<li>
									<i class="flaticon-profile"></i>
									<span style="color: red"><%=mess%><br></span>
									<ul class="sub-menu">
										<li><i class="zmdi zmdi-lock-outline"></i><span><a href="<%=request.getContextPath() %>/CartServlet?command=Logout&maSP=0">Logout</a></span></li>
										<li><a href="<%=request.getContextPath() %>/udPass.jsp">Update password</a></li>
									</ul>
									</li>
								</div>
								<%}%>
								<% 
								if (session.getAttribute("user")== null){
								%>
								<div><i class="flaticon-profile"></i><a href="signin.jsp">Sign In</a> or <a href="sign_up.jsp">Create Account</a></div>
								<%}%>
								<!--  -->
							</div>
							<div class="up-item">
								<div class="shopping-card">
									<i class="flaticon-bag"></i>
								</div>
								<a href="cart.jsp">Shopping Cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<nav class="main-navbar">
			<div class="container">
				<!-- menu -->
				<ul class="main-menu">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="<%=request.getContextPath() %>/productList?maTL=1">Women</a></li>
					<li><a href="<%=request.getContextPath() %>/productList?maTL=2">Men</a></li>
					<li><a href="<%=request.getContextPath() %>/productList?maTL=3">Jewelry
						<span class="new">New</span>
					</a></li>
					<li><a href="<%=request.getContextPath() %>/productList?maTL=4">Shoes</a>
						<!-- <ul class="sub-menu">
							<li><a href="#">Sneakers</a></li>
							<li><a href="#">Sandals</a></li>
							<li><a href="#">Formal Shoes</a></li>
							<li><a href="#">Boots</a></li>
							<li><a href="#">Flip Flops</a></li>
						</ul> -->
					</li>
					<li><a href="#">Pages</a>
						<ul class="sub-menu">
							<li><a href="product.jsp">Product Page</a></li>
							<li><a href="category.jsp">Category Page</a></li>
							<li><a href="cart.jsp">Cart Page</a></li>
							<li><a href="checkout.jsp">Checkout Page</a></li>
							<li><a href="contact.jsp">Contact Page</a></li>
							<li><a href="<%=request.getContextPath() %>/history">History Page</a></li>
						</ul>
					</li>
					<li><a href="index.jsp">Blog</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<!-- Header section end -->
        
    </body>
</html>
