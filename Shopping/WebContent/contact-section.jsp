<%-- 
    Document   : contact-section
    Created on : Oct 8, 2019, 9:52:14 PM
    Author     : Thinkpad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact</title>
    </head>
    <body>
        <!-- Contact section -->
	<section class="contact-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 contact-info">
					<h3>Get in touch</h3>
					<p>So 1, Dai Co Viet, Hai Ba Trung, Ha Noi</p>
					<p>+123456789</p>
					<p>hosting@contact.com</p>
					<div class="contact-social">
						<a href="https://www.facebook.com/hangbui1999"><i class="fa fa-pinterest"></i></a>
						<a href="https://www.facebook.com/hangbui1999"><i class="fa fa-facebook"></i></a>
						<a href="https://www.facebook.com/hangbui1999"><i class="fa fa-twitter"></i></a>
						<a href="https://www.facebook.com/hangbui1999"><i class="fa fa-dribbble"></i></a>
						<a href="https://www.facebook.com/hangbui1999"><i class="fa fa-behance"></i></a>
					</div>
					<form method="post" action="<%=request.getContextPath() %>/Contact" class="contact-form">
						<input name="name" type="text" placeholder="Your name">
						<input name="email" type="text" placeholder="Your e-mail">
						<input name="subject" type="text" placeholder="Subject">
						<textarea name="message" placeholder="Message"></textarea>
						<button type="submit" class="site-btn">SEND NOW</button>
					</form>
				</div>
			</div>
		</div>
		<div class="map"><iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.6308739031238!2d105.84039951440698!3d21.00742869388322!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab8a922653a9%3A0x6c2ec19683313eab!2zMSDEkOG6oWkgQ-G7kyBWaeG7h3QsIEPhuqd1IEThu4FuLCBIYWkgQsOgIFRyxrBuZywgSMOgIE7hu5lpLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1572973444031!5m2!1svi!2s" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen=""></iframe></div>
	</section>
	<!-- Contact section end -->
    </body>
</html>
