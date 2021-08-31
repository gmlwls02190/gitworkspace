<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE HTML>
<!--
	Forty by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>회원가입 페이지</title>
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
		<header id="header">
			<a href="index.html" class="logo"><strong>Forty</strong> <span>by
					HTML5 UP</span></a>
			<nav>
				<a href="#menu">Menu</a>
			</nav>
		</header>

		<!-- Menu -->
		<nav id="menu">
			<ul class="links">
				<li><a href="index.html">Home</a></li>
				<li><a href="landing.html">Landing</a></li>
				<li><a href="generic.html">Generic</a></li>
				<li><a href="elements.html">Elements</a></li>
			</ul>
			<ul class="actions stacked">
				<li><a href="#" class="button primary fit">Get Started</a></li>
				<li><a href="#" class="button fit">Log In</a></li>
			</ul>
		</nav>

		<!-- Main -->
		<div id="main" class="alt">

			<!-- One -->
			<section id="one">
				<div class="inner">
					<header class="major">
						<h1>회원가입</h1>
					</header>
					<span class="image main"><img src="images/pic11.jpg" alt="" /></span>
					<div class="table-wrapper">

						<a href="control.jsp?action=login">메인으로 돌아가기</a>
						<hr>
						<form action="control.jsp" method="post" name="form1">
							<input type="hidden" name="action" value="reg">
							<table border="1">
								<tr>
									<td>이름</td>
									<td><input type="text" name="uname" required></td>
								</tr>
								<tr>
									<td>아이디</td>
									<td><input type="text" name="userid" required></td>
								</tr>
								<tr>
									<td>비밀번호</td>
									<td><input type="password" name="userpw" required></td>
								</tr>
								<tr>
									<td colspan='2' align="right"><input type="submit" value="회원가입">
								</tr>
							</table>
						</form>

					</div>
				</div>
			</section>
		</div>
	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>