
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class="page-top-info">
		<div class="container">
			<h4>Update Password</h4>
			<div class="site-pagination">
				<a href="#">User</a> /
				<a href="#">Update Password</a> /
			</div>
		</div>
	</div>
        <br>
        <div class="container">
        <%
		if(request.getAttribute("err")!=null){%>
		<div style="color:red"><%= request.getAttribute("err") %><br></div>
		<%
		};
		%>
				<form method="post" action="<%=request.getContextPath() %>/UpdateUser" class="contact-form">
						<input name="username" type="hidden" value=<%=session.getAttribute("username") %>>
						<input name="old_pass" type="password" placeholder="Old Password">
						<input name="new_pass" type="password" placeholder="New Password">
						<input name="re_newpass" type="password" placeholder="Re Password">
						<button type="submit" class="site-btn">SUBMIT</button>
				</form>
		</div>
        <br><br>
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
