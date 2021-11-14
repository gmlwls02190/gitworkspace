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
					<h1><spring:message code="message.myGallery.main"/></h1>
				</header>
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
					<c:if test="${stat=='fav'}">
						<div class="paging" style="text-align: center; margin: 2em 0 0 0;">
							<c:if test="${paging.pageNo==paging.firstPageNo}">
								<a href="myArtist.do?id=${mem.id}&page=${paging.prevPageNo}" class="button primary disabled"><spring:message code="message.myGallery.prev"/></a>
							</c:if>
							<c:if test="${paging.pageNo!=paging.firstPageNo}">
								<a href="myArtist.do?id=${mem.id}&page=${paging.prevPageNo}" class="button primary"><spring:message code="message.myGallery.prev"/></a>
							</c:if>
							<c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
								<c:if test="${paging.pageNo==i}">
									<a href="myArtist.do?id=${mem.id}&page=${i}" class="button disabled">${i}</a>
								</c:if>
								<c:if test="${paging.pageNo!=i}">
									<a href="myArtist.do?id=${mem.id}&page=${i}" class="button">${i}</a>
								</c:if>
							</c:forEach>
							<c:if test="${paging.pageNo==paging.finalPageNo}">
								<a href="myArtist.do?id=${mem.id}&page=${paging.nextPageNo}" class="button primary disabled"><spring:message code="message.myGallery.next"/></a>
							</c:if>
							<c:if test="${paging.pageNo!=paging.finalPageNo}">
								<a href="myArtist.do?id=${mem.id}&page=${paging.nextPageNo}" class="button primary"><spring:message code="message.myGallery.next"/></a>
							</c:if>
						</div>
					</c:if>
					<c:if test="${stat=='my'}">
						<div class="paging" style="text-align: center; margin: 2em 0 0 0;">
							<c:if test="${paging.pageNo==paging.firstPageNo}">
								<a href="myGallery.do?artist=${mem.artist}&page=${paging.prevPageNo}" class="button primary disabled"><spring:message code="message.myGallery.prev"/></a>
							</c:if>
							<c:if test="${paging.pageNo!=paging.firstPageNo}">
								<a href="myGallery.do?artist=${mem.artist}&page=${paging.prevPageNo}" class="button primary"><spring:message code="message.myGallery.prev"/></a>
							</c:if>
							<c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
								<c:if test="${paging.pageNo==i}">
									<a href="myGallery.do?artist=${mem.artist}&page=${i}" class="button disabled">${i}</a>
								</c:if>
								<c:if test="${paging.pageNo!=i}">
									<a href="myGallery.do?artist=${mem.artist}&page=${i}" class="button">${i}</a>
								</c:if>
							</c:forEach>
							<c:if test="${paging.pageNo==paging.finalPageNo}">
								<a href="myGallery.do?artist=${mem.artist}&page=${paging.nextPageNo}" class="button primary disabled"><spring:message code="message.myGallery.next"/></a>
							</c:if>
							<c:if test="${paging.pageNo!=paging.finalPageNo}">
								<a href="myGallery.do?artist=${mem.artist}&page=${paging.nextPageNo}" class="button primary"><spring:message code="message.myGallery.next"/></a>
							</c:if>
						</div>
					</c:if>
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
</html>