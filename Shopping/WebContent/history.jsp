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

<%@page import="DAO.ProductDAOImpl"%>
<%@page import="model.Cart"%>
<%@page import="java.util.List"%>
<%@page import="DAO.HistoryDAOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="model.History" %>
<%@page import="model.DoanhSo" %>
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
						<h3>Your History</h3>
						<%
						HttpSession t = request.getSession();
						ProductDAOImpl p = new ProductDAOImpl();
						HistoryDAOImpl historyDAO = new HistoryDAOImpl();
						List<History> history = null;
						if(t.getAttribute("ttt") != null){
						history = (List<History>) t.getAttribute("ttt");
						}
						if (history != null) {  
							for (History h : history) {
								List<DoanhSo> l = new ArrayList<DoanhSo>();
								l = historyDAO.getListProduct(h.order_id);
								for(DoanhSo d : l){
									System.out.println(d.getMaSP()) ;
						%>
						<div class="cart-table-warp">
							<h6>OrderId: #<%=h.order_id %></h6>
							<table>
							<thead>
								<tr>
									<th class="product-th">Product</th> 
									<th class="quy-th">Quantity</th>
									<th class="total-th">Price</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="product-col">
										<img src="img/product/<%=p.getProduct(d.getMaSP()).getHinhanh()%>" alt="">
										<div class="pc-title">
											<h4><%=d.getTenSP()%></h4>
											<p><%=p.getProduct(d.getMaSP()).getPrice()%>$</p>
										</div>
									</td>
									<td class="quy-col">
										<div class="quantity">
											<p><%=d.getSoluong()%></p>
                    					</div>
									</td>
									<td class="quy-col">
										<div class="quantity">
											<p><%=d.getThanhtien()%>$</p>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="col-lg-4 card-right">
						</div>
						</div>
						<%
									}
							} 
						}
						 %>
						 
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
