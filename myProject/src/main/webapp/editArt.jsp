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
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
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
				<header>
					<h1><spring:message code="message.editArt.main" /></h1>
				</header>
				<form action="updateGallery.do" method="post" enctype="multipart/form-data">
					<input type="hidden" name="bid" value="${data.bid}">
					<input type="hidden" name="id" value="${data.id}">
					<input type="hidden" name="gallery" value="${data.gallery}">
					<div class="row gtr-uniform">
						<div class="col-12">
							<input type="text" name="title" value="${data.title}">
						</div>
						<div class="col-12">
							<input type="text" name="artist" value="${data.artist}">
						</div>
						<div class="col-12">
							<span class="image"><img id="preImg"/></span>
							<span class="image" id="nowImg"><img src="/images/${data.gallery}" alt="${data.title}"/></span>
							<span><input type="file" name="fileUpload" id="fileUpload" ></span>
						</div>
						<div class="col-12">
							<textarea rows="1" cols="200" placeholder="<spring:message code='message.editArt.info' />" name="info">${data.info}</textarea>
						</div>
						<div class="col-12">
							<ul class="actions">
								<li><input type="submit" value="<spring:message code='message.editArt.edit' />" class="primary"></li>
								<li><input type="button" onClick="deleteArt()" value="<spring:message code='message.editArt.delete' />"></li>
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
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery-3.6.0.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="assets/js/editArt.js"></script>

</body>
</html>