<%-- 
    Document   : sidebar
    Created on : Oct 9, 2019, 10:45:21 PM
    Author     : Thinkpad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sidebar</title>
    </head>
    <body>
        <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">
          <li class="active">
            <a class="" href="ad_index.jsp">
            		<i class="zmdi zmdi-home zmdi-hc-fw"></i>
                          <span>Home</span>
                      </a>
          </li>
          <li class="sub-menu">
            <a href="javascript:;" class="">
                          <i class="icon_document_alt"></i>
                          <span>Product</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
            <ul class="sub">
              <li><a class="" href="<%=request.getContextPath() %>/adProduct"><i class="zmdi zmdi-menu"></i>Product List</a></li>
              <li><a class="" href="ad_addproduct.jsp"><i class="zmdi zmdi-plus"></i>Add Product</a></li>
            </ul>
          </li>
          <!--  <li class="sub-menu">
            <a href="javascript:;" class="">
                          <i class="icon_desktop"></i>
                          <span>UI Fitures</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
            <ul class="sub">
              <li><a class="" href="general.html">Elements</a></li>
              <li><a class="" href="buttons.html">Buttons</a></li>
              <li><a class="" href="grids.html">Grids</a></li>
            </ul>
          </li>-->
          <li>
            <a class="" href="<%=request.getContextPath() %>/doanhThu">
					<i class="zmdi zmdi-chart"></i>
                          <span>Revenue</span>
                      </a>
          </li>
          
          <li>
            <a class="" href="<%=request.getContextPath() %>/AdOrder">
					<i class="zmdi zmdi-assignment-o"></i>
                          <span>Order</span>
                      </a>
          </li>
          
          <li>
            <a class="" href="<%=request.getContextPath() %>/viewUser">
                          <i class="zmdi zmdi-accounts-list"></i>
                          <span>User List</span>
                      </a>
          </li>
          
          <li>
            <a class="" href="<%=request.getContextPath() %>/Contact">
                          <i class="zmdi zmdi-account-box-mail"></i>
                          <span>Contact</span>
                      </a>
          </li>
          
          <li class="sub-menu">
            <a href="javascript:;" class="">
                          <i class="icon_documents_alt"></i>
                          <span>Pages</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
            <ul class="sub">
              <li><a class="" href="index.jsp"><span>View Page</span></a></li>
              <li><a class="" href="ad_404.jsp">404 Error</a></li>
            </ul>
          </li>

        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--sidebar end-->
    </body>
</html>
