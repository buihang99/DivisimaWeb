<%-- 
    Document   : index
    Created on : Oct 9, 2019, 10:46:59 PM
    Author     : Thinkpad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
        <meta name="author" content="GeeksLabs">
        <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
        <link rel="shortcut icon" href="img/favicon.png">

        <title>Creative - Bootstrap Admin Template</title>

        <!-- Bootstrap CSS -->
        <link href="ad_css/bootstrap.min.css" rel="stylesheet">
        <!-- bootstrap theme -->
        <link href="ad_css/bootstrap-theme.css" rel="stylesheet">
        <!--external css-->
        <!-- font icon -->
        <link href="ad_css/elegant-icons-style.css" rel="stylesheet" />
        <link href="ad_css/font-awesome.min.css" rel="stylesheet" />
        <!-- full calendar css-->
        <link href="ad_assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
        <link href="ad_assets/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" />
        <!-- easy pie chart-->
        <link href="ad_assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen" />
        <!-- owl carousel -->
        <link rel="stylesheet" href="ad_css/owl.carousel.css" type="text/css">
        <link href="ad_css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
        <!-- Custom styles -->
        <link rel="stylesheet" href="ad_css/fullcalendar.css">
        <link href="ad_css/widgets.css" rel="stylesheet">
        <link href="ad_css/style.css" rel="stylesheet">
        <link href="ad_css/style-responsive.css" rel="stylesheet" />
        <link href="ad_css/xcharts.min.css" rel=" stylesheet">
        <link href="ad_css/jquery-ui-1.10.4.min.css" rel="stylesheet">
        <!-- =======================================================
          Theme Name: NiceAdmin
          Theme URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
          Author: BootstrapMade
          Author URL: https://bootstrapmade.com
        ======================================================= -->
    </head>
    <body>
    <%
	if(session.getAttribute("admin") == null){ %>
	<jsp:include page="ad_404.jsp"></jsp:include>
	<%
	}
	%>
	<%
	if(session.getAttribute("admin") != null){ %>
	
         <!-- container section start -->
        <section id="container" class="">
            <jsp:include page="ad_header.jsp"></jsp:include>
            
            <jsp:include page="ad_sidebar.jsp"></jsp:include>
            
            <jsp:include page="ad_main-content.jsp"></jsp:include>
            
        </section>
      <%
	}
	%>
  <!-- container section start -->

  <!-- javascripts -->
  <script src="ad_js/jquery.js"></script>
  <script src="ad_js/jquery-ui-1.10.4.min.js"></script>
  <script src="ad_js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="ad_js/jquery-ui-1.9.2.custom.min.js"></script>
  <!-- bootstrap -->
  <script src="ad_js/bootstrap.min.js"></script>
  <!-- nice scroll -->
  <script src="ad_js/jquery.scrollTo.min.js"></script>
  <script src="ad_js/jquery.nicescroll.js" type="text/javascript"></script>
  <!-- charts scripts -->
  <script src="ad_assets/jquery-knob/js/jquery.knob.js"></script>
  <script src="ad_js/jquery.sparkline.js" type="text/javascript"></script>
  <script src="ad_assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
  <script src="ad_js/owl.carousel.js"></script>
  <!-- jQuery full calendar -->
  <script src="ad_js/fullcalendar.min.js"></script>
    <!-- Full Google Calendar - Calendar -->
    <script src="ad_assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
    <!--script for this page only-->
    <script src="ad_js/calendar-custom.js"></script>
    <script src="ad_js/jquery.rateit.min.js"></script>
    <!-- custom select -->
    <script src="ad_js/jquery.customSelect.min.js"></script>
    <script src="ad_assets/chart-master/Chart.js"></script>

    <!--custome script for all page-->
    <script src="ad_js/scripts.js"></script>
    <!-- custom script for this page-->
    <script src="ad_js/sparkline-chart.js"></script>
    <script src="ad_js/easy-pie-chart.js"></script>
    <script src="ad_js/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="ad_js/jquery-jvectormap-world-mill-en.js"></script>
    <script src="ad_js/xcharts.min.js"></script>
    <script src="ad_js/jquery.autosize.min.js"></script>
    <script src="ad_js/jquery.placeholder.min.js"></script>
    <script src="ad_js/gdp-data.js"></script>
    <script src="ad_js/morris.min.js"></script>
    <script src="ad_js/sparklines.js"></script>
    <script src="ad_js/charts.js"></script>
    <script>
      //knob
      $(function() {
        $(".knob").knob({
          'draw': function() {
            $(this.i).val(this.cv + '%')
          }
        })
      });

      //carousel
      $(document).ready(function() {
        $("#owl-slider").owlCarousel({
          navigation: true,
          slideSpeed: 300,
          paginationSpeed: 400,
          singleItem: true

        });
      });

      //custom select box

      $(function() {
        $('select.styled').customSelect();
      });

      /* ---------- Map ---------- */
      $(function() {
        $('#map').vectorMap({
          map: 'world_mill_en',
          series: {
            regions: [{
              values: gdpData,
              scale: ['#000', '#000'],
              normalizeFunction: 'polynomial'
            }]
          },
          backgroundColor: '#eef3f7',
          onLabelShow: function(e, el, code) {
            el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
          }
        });
      });
    </script>
    </body>
</html>

