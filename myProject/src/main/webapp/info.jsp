<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML>
<html>
<head>
<title>HJ Art Gallery</title>
<mytag:favicon/>
<style type="text/css">
#map {
	border: 2px solid pink;
	height: 400px;
}

.gmnoprint a, .gmnoprint span, .gm-style-cc {
	display: none;
}

.gmnoprint, .gm-control-active.gm-fullscreen-control {
	display: none;
}
</style>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<mytag:logoNnav />

		<!-- Menu -->
		<mytag:menuBar />

		<!-- Main -->
		<div id="main">
			<div class="inner">
				<h1><spring:message code="message.info.main"/></h1>
				<article>
					<span class="image main" id="map" style="width: 100%;"></span>
				</article>
				<p><strong><spring:message code="message.info.address"/></strong></p>
				<p><strong><spring:message code="message.info.callNum"/></strong></p>
				<p><strong>[<spring:message code="message.info.vehicle"/>]<br><spring:message code="message.info.subway"/><br><spring:message code="message.info.bus"/><br><b style="color: royalblue;">Blue</b> : 146, 341, 360, 740, N13, N61, 147, 463<br><b style="color: green;">Green</b> : 4211<br><b style="color: firebrick;">Red</b> : 1100, 1700, 2000, 2000-1, 7007, 8001, 3600, 9600</strong></p>
				
				<h1><spring:message code="message.info.contact"/></h1>
				<form method="post" action="qaMailSend.do">
					<input type="hidden" name="to" value="ksh02190@gmail.com" />
					<div class="row gtr-uniform">
						<div class="col-6 col-12-xsmall">
							<input type="text" name="title" id="demo-name" value="" placeholder="<spring:message code='message.info.title'/>" />
						</div>
						<div class="col-6 col-12-xsmall">
							<input type="text" name="name" id="demo-name" value="" placeholder="<spring:message code='message.info.name'/>" />
						</div>
						<div class="col-6 col-12-xsmall">
							<input type="text" name="firstemail" id="demo-email" value="" placeholder="<spring:message code='message.info.email'/>" />
						</div>
						<div class="col-6 col-12-xsmall">
							<select name="lastemail" id="demo-category">
								<option selected>@gmail.com</option>
								<option>@naver.com</option>
								<option>@daum.net</option>
								<option>@hotmail.com</option>
							</select>
						</div>
						<div class="col-12">
							<textarea name="content" id="demo-message" placeholder="<spring:message code='message.info.message'/>" rows="6"></textarea>
						</div>
						<div class="col-12">
							<ul class="actions">
								<li><input type="submit" value="<spring:message code='message.info.send'/>" class="primary" /></li>
								<li><input type="reset" value="<spring:message code='message.info.reset'/>" /></li>
							</ul>
						</div>
					</div>
				</form>
				
			</div>
		</div>

		<!-- Footer -->
		<mytag:footer />

	</div>

	<!-- Google -->
	<script src="http://maps.google.com/maps/api/js?key=앱키&region=kr"></script>
	
	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery-3.6.0.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="assets/js/info.js"></script>
	

</body>
</html>