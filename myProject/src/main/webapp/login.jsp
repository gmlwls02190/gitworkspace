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
				<c:if test="${param.mode=='login'}">
					<header>
						<h1><spring:message code="message.login.loginMain"/></h1>
					</header>
					<section class="tiles">
						<article class="artImg">
							<form method="post" action="login.do">
							<c:if test="${loginCnt==null}">
								<input type="hidden" name="loginCnt" value="0">
							</c:if>
							<c:if test="${loginCnt!=null}">
								<input type="hidden" name="loginCnt" value="${loginCnt}">
							</c:if>
								<div class="row gtr-uniform">
									<div class="col-12">
										<input type="text" name="id" id="id" placeholder="<spring:message code='message.login.id'/>" required/>
									</div>
									<div class="col-12">
										<input type="password" name="pw" id="pw" placeholder="<spring:message code='message.login.pw'/>" required/>
									</div>
									<c:if test="${str!=null}">
										<div class="col-12">
											<span>${str}</span>
										</div>
									</c:if>
									<div class="col-12">
										<ul class="actions" style="justify-content: flex-end;">
											<li><input type="submit" value="<spring:message code='message.login.login'/>" class="primary" /></li>
											<li><input type="button" value="<spring:message code='message.login.signUp'/>" onClick="reg()" /></li>
											<c:if test="${loginCnt>=3}">
												<li><input type="button" value="<spring:message code='message.login.newPW'/>" onClick="newpw()" /></li>
											</c:if>
										</ul>
									</div>
								</div>
							</form>
						</article>
						<article class="artImg">
							<ul class="loginMenu">
								<li><img alt="" src="images/kakaoLogin.png" onclick="kakaoLogin()" class="exLogin"></li>
								<li><img alt="" src="images/googleLogin.png" onclick="googleLogin()" class="exLogin"></li>
								<li><img alt="" src="images/naverLogin.png" onclick="naverLogin()" class="exLogin"></li>
							</ul>
						</article>	
					</section>
				</c:if>

				<c:if test="${param.mode=='signUp'}">
					<header>
						<h1><spring:message code="message.login.signUpMain"/></h1>
					</header>
					<section class="tiles">
						<article class="signUpform">
							<form method="post" action="signUp.do" name="signUpForm">
								<div class="row gtr-uniform">
									<div class="col-12">
										<input type="text" name="id" id="checkId" class="signUpMenu" placeholder="<spring:message code='message.login.id'/>"/>
										<input type="button" value="ID" onclick="check()" id="checkID" class="signUpCheck">
										<span id="idCheck"></span>
									</div>
									<div class="col-12">
										<input type="password" name="pw" id="checkPw" class="signUpMenu" placeholder="<spring:message code='message.login.pw'/>"/>
										<br>
										<span id="pwStr"></span>
										<span id="pwCheck"></span>
										<br>
										<span id="pwReg"></span>
									</div>
									<div class="col-12">
										<input type="password" name="repw" id="repw" class="signUpMenu" placeholder="<spring:message code='message.login.rePW'/>"/>
										<div class="signUpCheck">
											<span id="repwCheck"></span>
										</div>
									</div>
									<div class="col-12">
										<input type="text" name="artist" id="checkArtist" class="signUpMenu" placeholder="<spring:message code='message.login.artist'/>"/>
										<input type="button" value="Artist" onclick="checkart()" id="checkArt" class="signUpCheck">
										<span id="artistCheck"></span>
									</div>
									<div class="col-12">
										<input type="text" name="addrNum" id="addrNum" class="signUpMenu" placeholder="<spring:message code='message.login.addrNum'/>"/>
										<input type=button name="address" id="addrbtn" class="signUpCheck" value="<spring:message code='message.login.addr'/>" onClick="SearchAddr()" style="overflow: visible !important;"/>
										<input type="text" name="roadAddr" id="roadAddr" class="signUpMenu" placeholder="<spring:message code='message.login.roadAddr'/>"/>
										<input type="text" name="detailAddr" id="detailAddr" class="signUpMenu" placeholder="<spring:message code='message.login.detailAddr'/>"/>
									</div>
									<div class="col-12">
										<input type="text" name="firstemail" id="firstemail" class="signUpMenu" placeholder="<spring:message code='message.login.email'/>"/>
										<div class="signUpCheck">
											<span id="emailCheck"></span>
										</div>
										<br>
										<span id="wrongEmail"></span>
										<select name="lastemail" class="signUpMenu">
											<option value="@gmail.com" selected>@gmail.com</option>
											<option value="@naver.com">@naver.com</option>
											<option value="@daum.net">@daum.net</option>
											<option value="@hotmail.com">@hotmail.com</option>
										</select>
									</div>
									<div class="col-12">
										<input type="text" name="callNum" id="callNum" class="signUpMenu" placeholder="<spring:message code='message.login.callNum'/>"/>
										<div class="signUpCheck">
											<span id="callNumCheck"></span>
										</div>
										<br>
										<span id="wrongNum"></span>
									</div>
									<div class="col-12">
										<ul class="actions">
											<li><input type="button" value="<spring:message code='message.login.signUp'/>" class="primary" id="signBtn" onclick="emptycheck()"/></li>
										</ul>
									</div>
								</div>
							</form>
						</article>
					</section>
				</c:if>
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
	<script src="assets/js/login.js"></script>
	
	<!-- Kakao -->
	<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>
	
	<!-- Google -->
	<script src="https://apis.google.com/js/platform.js" async defer></script>
	
	<!-- Naver -->
	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	
	<!-- 다음주소 api -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	

</body>
</html>