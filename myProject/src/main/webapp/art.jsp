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
<title>Phantom by HTML5 UP</title>
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
			<section class="tiles">
					<article class="artImg">
						<span class="image"><img src="${data.gallery}" alt="${data.title}" /></span>
					</article>
					<article class="artImg">
						<%-- <div>
							<div>
								<strong>${data.title}</strong>
							</div>
							<div class="heart"></div>
						</div> --%>
						<div class="image">
						<h1>${data.title}</h1>
							<table>
								<tr>
									<td>작가</td><td>${data.artist}</td>
								</tr>
								<tr>
									<td>작품번호</td><td>${data.bid}</td>
								</tr>
								<tr>
									<td>작품설명</td><td>${data.info}</td>
								</tr>
								<tr>
									<td>등록일</td><td>${data.wdate}</td>
								</tr>
								<c:if test="${mem.id==data.id}">
									<tr>
										<td colspan="2" style="text-align:end;"><a href="editGallery.do?bid=${data.bid}" class="button">수정</a></td>
									</tr>
								</c:if>
							</table>
						</div>
					</article>
				</section>
				<div class="content" style="text-align: center; border: ridge;">
					<img src="${data.gallery}" alt="${data.title}" style="width:100%; height:100%; display:block;"/>
				</div>
				<div style="padding-top: 1.5em; text-align: center;">
					<a class="button primary" href="galleryList.do">목록</a>
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
</html>