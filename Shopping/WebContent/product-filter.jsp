<%-- 
    Document   : product-filter
    Created on : Oct 8, 2019, 8:18:45 PM
    Author     : Thinkpad
--%>

<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="DAO.ProductDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Filter</title>
    </head>
    <body>
        <!-- Product filter section -->
	<section class="product-filter-section">
		<div class="container">
			<div class="section-title">
				<h2>BROWSE TOP SELLING PRODUCTS</h2>
			</div>
			<ul class="product-filter-menu">
				<li><a href="#">TOPS</a></li>
				<li><a href="#">JUMPSUITS</a></li>
				<li><a href="#">LINGERIE</a></li>
				<li><a href="#">JEANS</a></li>
				<li><a href="#">DRESSES</a></li>
				<li><a href="#">COATS</a></li>
				<li><a href="#">JUMPERS</a></li>
				<li><a href="#">LEGGINGS</a></li>
			</ul>
			<div class="row">
			<%
			ProductDAOImpl p = new ProductDAOImpl();
			List<Product> list = p.getList();
			int i=0;
			for(Product product: list){
				if(i<12){
			%>
				<div class="col-lg-3 col-sm-6">
					<div class="product-item">
						<div class="pi-pic">
							<a href="<%=request.getContextPath() %>/product?maSP=<%=product.getMaSP()%>"><img src="img/product/<%=product.getHinhanh()%>" alt=""></a>
							<div class="pi-links">
								<%
								if(session.getAttribute("user") == null){
								%>
								<a href="#" class="add-card"><i class="flaticon-bag"></i><span>PLEASE LOGIN</span></a>
								<a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
								<%} %>
								<%if(session.getAttribute("user") != null){ %>
								<a href="<%=request.getContextPath() %>/CartServlet?command=addCart&maSP=<%=product.getMaSP()%>" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>
								<a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>
								<%} %>
								</div>					
							</div>
						<div class="pi-text">
							<h6><%=product.getPrice()%>$</h6>
							<p><%=product.getTenSP()%></p>
						</div>
					</div>
					</div>
					<%}
				i++;
			}
			%>
				</div>
			
				</div>
			</div>
			
			<div class="text-center pt-5">
				<button class="site-btn sb-line sb-dark">LOAD MORE</button>
			</div>
		</div>
	</section>
	<!-- Product filter section end -->
    </body>
</html>
