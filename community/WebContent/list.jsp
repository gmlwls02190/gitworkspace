<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.message.*, java.util.*"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />

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
<title>글 목록 화면</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
<script type="text/javascript">
	function check(mnum) {
		/* prompt("글 정보 변경을 위해 작성자아이디를 입력하시오."); */
		user = prompt("글 정보 변경을 위해 작성자아이디를 입력하시오.");
		document.location.href = "control.jsp?action=edit&mnum=" + mnum + "&user=" + user;
	}
</script>
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
						<h1>게시글 목록</h1>
						<h2><%=wuserDAO.getUserData(wuserVO).getUname()%>님 환영합니다</h2>
					</header>
					<span class="image main"><img src="images/pic11.jpg" alt="" /></span>
					<div class="table-wrapper">

						<a href="form.jsp">글 등록</a> <a href="control.jsp?action=logout">로그아웃</a>
						<hr>
						<table>
							<tr>
								<th>글 번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
							</tr>
							<%
								for (MessageVO vo : (ArrayList<MessageVO>) datas) {
							%>
							<tr>
								<!-- "control.jsp?action=edit&mnum=<%=vo.getMnum()%>" -->
								<td><a href="javascript:check(<%=vo.getMnum()%>)"><%=vo.getMnum()%></a></td>
								<!-- 글 변경을 위한 비밀번호 등의 인증작업처리 필요! -->
								<td><%=vo.getTitle()%></td>
								<td><%=vo.getWriter()%></td>
								<td><%=vo.getWdate()%></td>
							</tr>
							<%
								}
							%>
						</table>


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