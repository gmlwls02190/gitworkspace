<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,model.comment.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="data" class="model.message.MessageVO" scope="request" />
<jsp:useBean id="cdatas" class="java.util.ArrayList" scope="request" />

<jsp:useBean id="wuserDAO" class="model.wuser.WuserDAO" scope="application" />
<jsp:useBean id="wuserVO" class="model.wuser.WuserVO" scope="session" />
<jsp:setProperty property="*" name="wuserVO" />
<!DOCTYPE HTML>
<!--
	Forty by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>게시글 내용 페이지</title>
<style type="text/css">
.datecolor {
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
						<h1>게시글</h1>
					</header>
					<span class="image main"><img src="images/pic11.jpg" alt="" /></span>
					<div class="table-wrapper">

						<a href="control.jsp?action=list">메인으로 돌아가기</a>
						<hr>
						<table>
							<tr>
								<td>작성자</td>
								<td><%=wuserDAO.getUserData(wuserVO).getUname()%></td>
							</tr>
							<tr>
								<td>제목</td>
								<td><%=data.getTitle()%></td>
							</tr>
							<tr>
								<td>내용</td>
								<td><%=data.getContent()%></td>
							</tr>
							<tr>
								<td>작성일</td>
								<td><%=data.getWdate()%></td>
							</tr>
						</table>
						<h3>댓글</h3>
						<table>
							<%
								for (CommentVO vo : (ArrayList<CommentVO>) cdatas) {
							%>
							<tr>
								<td><%=vo.getCname()%></td>
								<td><%=vo.getCdate()%></td>
							</tr>
							<tr>
								<td colspan="2"><%=vo.getComments()%></td>
							</tr>
							<%
								}
							%>
						</table>

						<form action="control.jsp?action=comment" method="post"
							name="form1">
							<input type="hidden" name="mnum" value="<%=data.getMnum()%>">
							<input type="hidden" name="cname"
								value="<%=wuserDAO.getUserData(wuserVO).getUname()%>">
							<table>
								<tr>
									<td><textarea style="resize: vertical" rows="4" cols="100"
											name="comments" placeholder="댓글을 입력해주세요"></textarea></td>
									<td align="center" style="vertical-align: middle"><input
										type="submit" value="댓글작성"></td>
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