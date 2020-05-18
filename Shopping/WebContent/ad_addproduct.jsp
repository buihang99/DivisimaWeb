<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
        <meta name="author" content="GeeksLabs">
        <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
        <link rel="shortcut icon" href="ad_img/favicon.png">

        <title>Basic Table | Creative - Bootstrap 3 Responsive Admin Template</title>
        <!-- Bootstrap CSS -->
        <link href="ad_css/bootstrap.min.css" rel="stylesheet">
        <!-- bootstrap theme -->
        <link href="ad_css/bootstrap-theme.css" rel="stylesheet">
        <!--external css-->
        <!-- font icon -->
        <link href="ad_css/elegant-icons-style.css" rel="stylesheet" />
        <link href="ad_css/font-awesome.min.css" rel="stylesheet" />
        <!-- Custom styles -->
        <link href="ad_css/style.css" rel="stylesheet">
        <link href="ad_css/style-responsive.css" rel="stylesheet" />

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
        <!--[if lt IE 9]>
            <script src="ad_js/html5shiv.js"></script>
            <script src="ad_js/respond.min.js"></script>
            <script src="ad_js/lte-ie7.js"></script>
          <![endif]-->

          <!-- =======================================================
            Theme Name: NiceAdmin
            Theme URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
            Author: BootstrapMade
            Author URL: https://bootstrapmade.com
          ======================================================= -->
    </head>
<body>
	<!-- container section start -->
        <section id="container" class=""> 
            <jsp:include page = "ad_header.jsp"></jsp:include>
            <jsp:include page = "ad_sidebar.jsp"></jsp:include>
		<!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-table"></i> Table</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="ad_index.jsp">Home</a></li>
              <li><i class="fa fa-table"></i>Product</li>
              <li><i class="fa fa-th-list"></i>Add Product</li>
            </ol>
          </div>
        </div>
        <!-- start -->
        <div class="col-sm-6">
            <section ><!-- class="panel" -->
              <header ><!-- class="panel-heading" -->
              </header>
              <form method="POST" action="<%=request.getContextPath() %>/addProduct">
              <p style="color: red">${add_err }</p>
               <table border="1" cellpadding="5" cellspacing="5" width="100%">
               <tr>
		        <th colspan="3">ADD PRODUCT</th>
		    	</tr>
		       <tr>
		       	<td>Mã thể loại</td>
		       	<td><input type="text" name="MaTL" /></td>
		       </tr>
		       <tr>
		       	<td>Mã Sản Phẩm</td>
		       	<td><input type="text" name="MaSP" /></td>
		       </tr>
		       <tr>
		       	<td>Tên Sản Phẩm </td>
		       	<td><input type="text" name="TenSP" /></td>
		       </tr>
		       <tr>
		       	<td>Hình ảnh</td>
		       	<td><input type="text" name="Hinhanh"/></td>
		       </tr>
		       <tr>
		       	<td>Giá</td>
		       	<td><input type="number" name="Price" /></td>
		       </tr>
		       <tr>
		       	<td>Thông tin</td>
		       	<td><input type="text" name="Thongtin" /></td>
		       </tr>
		       </table>
		       <br>
              <input type="submit" name="add" id="signup" value="ADD" id ="add_product" ></input>
             </form>
            </section>
          </div>
       </section>
     </section>
     
            
        </section>
        <!-- container section end -->
        <!-- javascripts -->
        <script src="ad_js/jquery.js"></script>
        <script src="ad_js/bootstrap.min.js"></script>
        <!-- nicescroll -->
        <script src="ad_js/jquery.scrollTo.min.js"></script>
        <script src="ad_js/jquery.nicescroll.js" type="text/javascript"></script>
        <!--custome script for all page-->
        <script src="ad_js/scripts.js"></script>

</body>
</html>