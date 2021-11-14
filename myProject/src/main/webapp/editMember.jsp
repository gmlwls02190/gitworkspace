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
					<h1><spring:message code="message.editMember.main"/></h1>
				</header>
				<section class="tiles">
					<article class="signUpform">
						<form method="post" action="updateMember.do">
							<div class="row gtr-uniform">
								<div class="col-12">
									<input type="text" name="id" id="checkId" class="signUpMenu" value="${mem.id}" readonly />
								</div>
								<div class="col-12">
									<input type="password" name="pw" id="checkPw" class="signUpMenu" value="${mem.pw}" />
								</div>
								<div class="col-12">
									<input type="text" name="artist" id="checkArtist" class="signUpMenu" value="${mem.artist}" />
									<input type="button" value="Artist" onclick="checkart()" id="checkArt" class="signUpCheck">
									<span id="artistCheck"></span>
								</div>
								<div class="col-12">
									<input type="text" name="addrNum" id="addrNum" class="signUpMenu" value="${mem.addrNum}" />
									<input type=button name="address" id="addrbtn" class="signUpCheck" value="<spring:message code='message.editMember.addr'/>" onClick="SearchAddr()" style="overflow: visible !important;"/>
									<input type="text" name="roadAddr" id="roadAddr" class="signUpMenu" value="${mem.roadAddr}" />
									<input type="text" name="detailAddr" id="detailAddr" class="signUpMenu" value="${mem.detailAddr}" />
								</div>
								<div class="col-12">
									<input type="text" name="firstemail" id="firstemail" class="signUpMenu" value="${mem.firstemail}" />
									<select name="lastemail" class="signUpMenu">
										<c:if test="${mem.lastemail=='@gmail.com'}">
											<option value="@gmail.com" selected>@gmail.com</option>
											<option value="@naver.com">@naver.com</option>
											<option value="@daum.net">@daum.net</option>
											<option value="@hotmail.com">@hotmail.com</option>
										</c:if>
										<c:if test="${mem.lastemail=='@naver.com'}">
											<option value="@naver.com" selected>@naver.com</option>
											<option value="@gmail.com">@gmail.com</option>
											<option value="@daum.net">@daum.net</option>
											<option value="@hotmail.com">@hotmail.com</option>
										</c:if>
										<c:if test="${mem.lastemail=='@daum.net'}">
											<option value="@daum.net" selected>@daum.net</option>
											<option value="@gmail.com">@gmail.com</option>
											<option value="@naver.com">@naver.com</option>
											<option value="@hotmail.com">@hotmail.com</option>
										</c:if>
										<c:if test="${mem.lastemail=='@hotmail.com'}">
											<option value="@hotmail.com" selected>@hotmail.com</option>
											<option value="@gmail.com">@gmail.com</option>
											<option value="@naver.com">@naver.com</option>
											<option value="@daum.net">@daum.net</option>
										</c:if>
									</select>
								</div>
								<div class="col-12">
									<input type="text" name="callNum" id="callNum" class="signUpMenu" value="${mem.callNum}" />
								</div>
								<div class="col-12">
									<ul class="actions">
										<li><input type="submit" value="<spring:message code='message.editMember.edit'/>" class="primary" /></li>
										<li><input type="button" onClick="deleteMember()" value="<spring:message code='message.editMember.delete'/>" /></li>
									</ul>
								</div>
							</div>
						</form>
					</article>
				</section>
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
	<script src="assets/js/editMember.js"></script>
	<script src="assets/js/login.js"></script>
	
	<!-- 다음주소 api -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</body>
</html>