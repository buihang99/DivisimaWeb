<%-- 
    Document   : cart
    Created on : Oct 8, 2019, 9:33:26 PM
    Author     : Thinkpad
--%>

<%-- 
    Document   : cart
    Created on : Oct 8, 2019, 9:33:26 PM
    Author     : Thinkpad
--%>

<%@page import="model.Cart"%>
<%@page import="java.util.List"%>
<%@page import="DAO.ProductDAOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    	<% System.out.println("1") ;%>
    	<%
		String username = null;
		Cookie[] cookies = request.getCookies();
		if(cookies !=null)
		{
		for(Cookie cookie : cookies)
		{
		    if(cookie.getName().equals("username")) 
		    	username = cookie.getValue();
		}
		}
		%>
        <% System.out.println("3") ;%>
        <jsp:include page="page-preloder.jsp"></jsp:include>
        
        <jsp:include page="header.jsp"></jsp:include>
        
        <jsp:include page="page-info.jsp"></jsp:include>
        
        <section class="cart-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="cart-table">
						<h3>Your Cart</h3>
						<%
						ProductDAOImpl productDAO = new ProductDAOImpl();
						NumberFormat nf = NumberFormat.getInstance();
						nf.setMinimumIntegerDigits(0);
						double total = 0;
						ArrayList<Cart> cart=null;
						if(session.getAttribute("cart")!=null){
						cart = (ArrayList<Cart>) session
								.getAttribute("cart");}
							if (cart != null) {  
								for (Cart c : cart) {
									total = total + (c.getQuantity() * productDAO.getProduct(
													c.getP().getMaSP()).getPrice());
						%>
						<div class="cart-table-warp">
							<table>
							<thead>
								<tr>
									<th class="product-th">Product</th>
									<!-- 
									<th class="quy-th">Quantity</th>
									 -->
									 <th >Quantity</th>
									<th class="size-th">Size</th>
									<th class="total-th">Price</th>
									<th>Remove</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="product-col">
										<img src="img/product/<%=productDAO.getProduct(c.getP().getMaSP()).getHinhanh()%>" alt="">
										<div class="pc-title">
											<h4><%=productDAO.getProduct(c.getP().getMaSP()).getTenSP()%></h4>
											<p><%=nf.format(productDAO.getProduct(c.getP().getMaSP()).getPrice())%>$</p>
										</div>
									</td>
									<!-- 
									<td class="quy-col">
										<div class="quantity">
					                        <div class="pro-qty">
												<input type="text" value="1">
											</div>
                    					</div>
									</td>
									 -->
									<td>
									<a href="CartServlet?command=deleteCart&maSP=<%=c.getP().getMaSP()%>"> - </a>
									<input class="cart_quantity_input" type="number" value="<%=c.getQuantity() %>" disabled="disabled">
									<a class="cart_quantity_up" href="CartServlet?command=addCart&maSP=<%=c.getP().getMaSP()%>"> + </a>
									</td>
									<!-- 
									<td class="size-type"><h4>Size M</h4></td>
									 -->
									 <td class="quy-col">
										<div class="quantity">
					                        <div class="pro-qty">
												<input type="text" value="4">
											</div>
                    					</div>
									</td>
									<td class="total-col"><h4><%=nf.format(productDAO.getProduct(c.getP().getMaSP()).getPrice() * c.getQuantity())%>$</h4></td>
									<td><div><a href="CartServlet?command=removeCart&maSP=<%=c.getP().getMaSP()%>">xx<i class="flaticon-bag"></i>xx</div></a></td>
								</tr>
							</tbody>
						</table>
						<div class="col-lg-4 card-right">
						</div>
						</div>
						<%
							} 
						}
						 %>
						 
						<div class="total-cost">
							<h6>Total <span><%=nf.format(total)%>$</span></h6>
							<% System.out.println(total); %>
						</div>
						<br>
						<div class="col-lg-4 card-right">
							<%if(cart != null && cart.size() > 0){ %>
							<%
							String url = "";
							for(int i=0; i<cart.size();i++){
								url += "&soluong"+i+"="+cart.get(i).getQuantity()+"&maSP"+i+"="+cart.get(i).getP().getMaSP();
							}
							%>
							<a href="<%=request.getContextPath() %>/CheckoutServlet?size=<%=cart.size() %>&total=<%=nf.format(total) %><%=url %>" class="site-btn">Proceed to checkout</a>
							<%
							String link = "size="+String.valueOf(cart.size())+"&total="+String.valueOf(nf.format(total))+url;
							session.setAttribute("link", link);
							} %>
							<a href="index.jsp" class="site-btn sb-dark">Continue shopping</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		</section>
        
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
