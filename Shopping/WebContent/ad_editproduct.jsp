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
               <p style="color: red">${err }</p>
              </header>
              <c:if test="${not empty product}">
              <form method="POST" action="<%=request.getContextPath() %>/editProduct">
             	<input type="hidden" name="MaSP" value="${product.getMaSP()}" />
               <table>
               <tr>
		        <th colspan="3">EDIT PRODUCT</th>
		    	</tr>
		       <tr>
		       	<td>Mã Sản Phẩm</td>
		       	<td style="color:red;">${product.getMaSP() }</td>
		       </tr>
		       <tr>
		       	<td>Mã Thể Loại</td>
		       	<td><input type="text" name="MaTL" value="${product.getMaTL() }"/></td>
		       </tr>
		       <tr>
		       	<td>Tên Sản Phẩm </td>
		       	<td><input type="text" name="TenSP" value="${product.getTenSP() }"/></td>
		       </tr>
		       <tr>
		       	<td>Hình ảnh</td>
		       	<td><input type="text" name="Hinhanh" value="${product.getHinhanh() }"/></td>
		       </tr>
		       <tr>
		       	<td>Giá</td>
		       	<td><input type="number" name="Price" value="${product.getPrice() }"/></td>
		       </tr>
		       <tr>
		       	<td>Thông tin</td>
		       	<td><input type="text" name="Thongtin" value="${product.getThongtin() }"/></td>
		       </tr>
		       </table>
		       <br>
              <input type="submit" name="edit" id="signup" value="Submit" id ="edit_product" ></input>
              <a href="<%=request.getContextPath() %>/adProduct">Cancel</a>
             </form>
             </c:if>
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