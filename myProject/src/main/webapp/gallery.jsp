<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>HJ Art Gallery</title>
<mytag:favicon/>
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
				<header>
					<h1><spring:message code="message.gallery.main" /></h1>
				</header>
				<div style="text-align: end;">
					<a href="insertArt.do" class="button primary"><spring:message code="message.gallery.addArt" /></a>
				</div>
				<section class="tiles">
					<c:forEach var="v" items="${datas}">
						<article class="style1">
							<span class="image"><img src="/images/${v.gallery}" alt="${v.title}" /></span>
							<a href="gallery.do?bid=${v.bid}">
								<h2>${v.title}</h2>
								<div class="content">
									<strong><p style="color: black;">${v.artist}</p></strong>
								</div>
							</a>
						</article>
					</c:forEach>
				</section>
					<div class="paging" style="text-align: center; margin: 2em 0 0 0;">
						<c:if test="${paging.pageNo==paging.firstPageNo}">
							<a href="galleryList.do?page=${paging.prevPageNo}" class="button primary disabled"><spring:message code="message.gallery.prev" /></a>
						</c:if>
						<c:if test="${paging.pageNo!=paging.firstPageNo}">
							<a href="galleryList.do?page=${paging.prevPageNo}" class="button primary"><spring:message code="message.gallery.prev" /></a>
						</c:if>
						<c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
							<c:if test="${paging.pageNo==i}">
								<a href="galleryList.do?page=${i}" class="button disabled">${i}</a>
							</c:if>
							<c:if test="${paging.pageNo!=i}">
								<a href="galleryList.do?page=${i}" class="button">${i}</a>
							</c:if>
						</c:forEach>
						<c:if test="${paging.pageNo==paging.finalPageNo}">
							<a href="galleryList.do?page=${paging.nextPageNo}" class="button primary disabled"><spring:message code="message.gallery.next" /></a>
						</c:if>
						<c:if test="${paging.pageNo!=paging.finalPageNo}">
							<a href="galleryList.do?page=${paging.nextPageNo}" class="button primary"><spring:message code="message.gallery.next" /></a>
						</c:if>
					</div>
			</div>
		</div>

		<!-- Footer -->
		<mytag:footer />

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>