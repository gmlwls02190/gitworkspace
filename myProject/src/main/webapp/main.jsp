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
					<h1><spring:message code="message.main.main"/></h1>
				</header>
				<div>
					<p style="font-size: 2.5em; font-weight: 300;"><strong>여러 예술가와 작품</strong>을 통해<br><strong>희진아트갤러리</strong>만의 가치를<br>경혐해 보세요!</p>
					<p><strong>코로나19</strong>로 인해 <strong>작품활동</strong>과 <strong>작품감상</strong>이 힘들어진 시기<br><strong>희진아트갤러리</strong>를 통해 여러분의 꿈을 펼쳐보세요!<br><strong>누구나</strong> 손쉽게 <strong>작품활동</strong>과 <strong>작품감상</strong>을 즐기실 수 있습니다!</p>
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