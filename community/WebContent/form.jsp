<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="wuserDAO" class="model.wuser.WuserDAO" scope="application"/>
<jsp:useBean id="wuserVO" class="model.wuser.WuserVO" scope="session"/>
<jsp:setProperty property="*" name="wuserVO" />
<!DOCTYPE HTML>
<!--
	Forty by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>글 입력 화면</title>
<style type="text/css">
.datecolor{
	color: black;
}
</style>
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
						<h1>글 작성하기</h1>
					</header>
					<span class="image main"><img src="images/pic11.jpg" alt="" /></span>
					<div class="table-wrapper">

						<a href="control.jsp?action=list">메인으로 돌아가기</a>
						<hr>
						<form action="control.jsp" method="post" name="form1">
							<input type="hidden" name="action" value="insert">
							<input type="hidden" name="userid" value="<%=wuserDAO.getUserData(wuserVO).getUserid()%>">
							<table>
								<tr>
									<td>작성자</td>
									<td><input type="text" name="writer" value="<%=wuserDAO.getUserData(wuserVO).getUname()%>"></td>
								</tr>
								<tr>
									<td>제목</td>
									<td><input type="text" name="title"></td>
								</tr>
								<tr>
									<td>내용</td>
									<td><input type="text" name="content"></td>
								</tr>
								<tr>
									<td>작성일</td>
									<td class="font"><input type="date" name="date" class="datecolor"></td>
								</tr>
								<tr>
									<td colspan='2'><input type="submit" value="글 추가하기">
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