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
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>
<meta name ="google-signin-client_id" content="334493542272-bm1lfpektcd2mmbhdt8upmrt4jjbsr2i.apps.googleusercontent.com">
<script type="text/javascript">
	function reg() {
		document.location.href = "toLogin.do?mode=signUp";
	}
	function kakaoLogin(){
		document.location.href="kakaoLogin.do";
	}
</script>
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
				<c:if test="${param.mode=='login'}">
					<header>
						<h1>Login</h1>
					</header>
					<section class="tiles">
						<article class="style4">
						<span class="image"> <img src="images/pic04.jpg" alt="" />
						</span> <a href="#">
							<h2>뭔가 넣을 곳</h2>
						</a>
					</article>
						<article class="style4">
							<form method="post" action="login.do">
								<div class="row gtr-uniform">
									<div class="col-12">
										<input type="text" name="id" id="id" value="" placeholder="ID" />
									</div>
									<div class="col-12">
										<input type="password" name="pw" id="pw" value="" placeholder="PW" />
									</div>
									<c:if test="${str!=null}">
										<div class="col-12">
											<span>${str}</span>
										</div>
									</c:if>
									<div class="col-12">
										<ul class="actions">
											<li><input type="submit" value="Login" class="primary" /></li>
											<li><input type="button" value="SignUp" onClick="reg()" /></li>
										</ul>
									</div>
								</div>
							</form>
						</article>
						<article class="style4">
							<ul class="actions">
								<li><img alt="" src="images/kakaoLogin.png" onclick="kakaoLogin()" style="cursor: pointer;"></li>
							</ul>
						</article>	
					</section>
				</c:if>

				<c:if test="${param.mode=='signUp'}">
					<header>
						<h1>SignUp</h1>
					</header>
					<section class="tiles">
						<article class="style4"></article>
						<article class="style4">
							<form method="post" action="signUp.do">
								<div class="row gtr-uniform">
									<div class="col-12">
										<input type="text" name="id" id="" value="" placeholder="ID" />
									</div>
									<div class="col-12">
										<input type="password" name="pw" id="" value="" placeholder="PW" />
									</div>
									<div class="col-12">
										<input type="password" name="repw" id="" value="" placeholder="RePW" />
									</div>
									<div class="col-12">
										<input type="text" name="artist" id="" value="" placeholder="Artist" />
									</div>
									<div class="col-12">
										<input type="text" name="address" id="" value="" placeholder="Address" />
									</div>
									<div class="col-12">
										<input type="text" name="firstemail" id="" value="" placeholder="Email" />
										<select name="lastemail">
											<option selected>@gmail.com</option>
											<option>@naver.com</option>
											<option>@daum.net</option>
											<option>@hotmail.com</option>
										</select>
									</div>
									<div class="col-12">
										<input type="text" name="callNum" id="" value=""
											placeholder="CallNumber" />
									</div>
									<div class="col-12">
										<ul class="actions">
											<li><input type="submit" value="SignUp" class="primary" /></li>
										</ul>
									</div>
								</div>
							</form>
						</article>
						<article class="style4"></article>
					</section>
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