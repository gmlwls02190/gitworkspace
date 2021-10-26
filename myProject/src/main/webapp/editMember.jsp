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
<script type="text/javascript">
	function deleteMem(id){
		document.location.href="deleteMember.do?id="+id;
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
				<header>
						<h1>Edit the Artist</h1>
					</header>
					<section class="tiles">
						<article class="style4">
						<span class="image"> <img src="images/pic04.jpg" alt="" />
						</span> <a href="#">
							<h2>뭔가 넣을 곳</h2>
						</a>
					</article>
						<article class="style4">
							<form method="post" action="updateMember.do">
								<div class="row gtr-uniform">
									<div class="col-12">
										<input type="text" name="id" id="" value="" placeholder="ID" />
									</div>
									<div class="col-12">
										<input type="password" name="pw" id="" value="" placeholder="PW" />
									</div>
									<div class="col-12">
										<input type="text" name="id" id="" value="" placeholder="Artist" />
									</div>
									<div class="col-12">
										<input type="email" name="email" id="" value=""
											placeholder="Email" />
									</div>
									<div class="col-12">
										<input type="text" name="address" id="" value=""
											placeholder="Address" />
									</div>
									<div class="col-12">
										<input type="text" name="callNum" id="" value=""
											placeholder="CallNumber" />
									</div>
									<div class="col-12">
										<ul class="actions">
											<li><input type="submit" value="Edit" class="primary" /></li>
											<li><input type="button" value="Delete" onClick="deleteMem(id)" /></li>
										</ul>
									</div>
								</div>
							</form>
						</article>
						<article class="style4"></article>	
					</section>
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