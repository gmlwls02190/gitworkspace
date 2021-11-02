<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE HTML>
<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>Generic - Phantom by HTML5 UP</title>
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
<script
	src="http://maps.google.com/maps/api/js?key=앱키&region=kr"></script>
<script src="assets/js/jquery-3.6.0.min.js"></script>
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
				<h1>HJ Art Gallery</h1>
				<article>
					<span class="image main" id="map" style="width: 100%;"></span>
				</article>
				<p>우리 사이트 설명문1</p>
				<p>우리 사이트 설명문2</p>
				
				<h1>Contact</h1>
				<form method="post" action="qaMailSend.do">
					<input type="hidden" name="to" value="ksh02190@gmail.com" />
					<div class="row gtr-uniform">
						<div class="col-6 col-12-xsmall">
							<input type="text" name="title" id="demo-name" value="" placeholder="Title" />
						</div>
						<div class="col-6 col-12-xsmall">
							<input type="text" name="name" id="demo-name" value="" placeholder="Name" />
						</div>
						<div class="col-6 col-12-xsmall">
							<input type="text" name="firstemail" id="demo-email" value="" placeholder="Email" />
						</div>
						<div class="col-6 col-12-xsmall">
							<select name="lastemail" id="demo-category">
								<option selected>@gmail.com</option>
								<option>@naver.com</option>
								<option>@daum.net</option>
								<option>@hotmail.com</option>
							</select>
						</div>
						<div class="col-6 col-12-small">
							<input type="checkbox" id="demo-copy" name="demo-copy">
							<label for="demo-copy">Email me a copy</label>
						</div>
						<div class="col-6 col-12-small">
							<input type="checkbox" id="demo-human" name="demo-human" checked>
							<label for="demo-human">Not a robot</label>
						</div>
						<div class="col-12">
							<textarea name="content" id="demo-message" placeholder="Enter your message" rows="6"></textarea>
						</div>
						<div class="col-12">
							<ul class="actions">
								<li><input type="submit" value="Send Message"
									class="primary" /></li>
								<li><input type="reset" value="Reset" /></li>
							</ul>
						</div>
					</div>
				</form>
				
			</div>
		</div>

		<!-- Footer -->
		<mytag:footer />

	</div>

	<!-- Scripts -->

	<script type="text/javascript">
	(function($){
		var map;
		function initMap(){
			var ll={
				lat : 37.50003,
				lng : 127.03559
			};
			map = new google.maps.Map(document.getElementById('map'),{
				zoom : 17,
				center : ll
			});
			var marker = new google.maps.Marker({
				position : ll,
				map : map
			});
		}
		initMap();
	})(jQuery);
</script>

	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>