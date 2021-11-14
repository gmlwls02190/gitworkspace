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
		<header id="header" style="padding: 1em 0 0 0;">
			<div class="inner">
				<!-- Logo -->
				<a href="main.do" class="logo">
					<span class="symbol"><img src="images/logo.svg" alt="test" /></span><span class="title"><spring:message code="message.logoNnav.logo"/></span>
				</a>
			</div>
		</header>

		<!-- Main -->
		<div id="main" style="padding: 0 0 2em 0;">
			<div class="inner">
				<header>
					<h1><spring:message code="message.newPW.main"/></h1>
				</header>
				<section class="tiles">
					<form method="post" action="sendNewPW.do" name="newPWForm" style="width: 80%; margin: 0 auto;">
					<input type="hidden" name="to" value="ksh02190@gmail.com" />
								<div class="row gtr-uniform">
									<div class="col-12">
										<input type="text" name="id" id="checkId" class="signUpMenu" placeholder="<spring:message code='message.newPW.id'/>"/>
										<input type="button" value="<spring:message code='message.newPW.check'/>" onclick="newpwidcheck()" id="IDCheckBtn" class="signUpCheck">
										<span id="newpwCheck"></span>
									</div>
									<div class="col-12" id="checkCallNum">
										<input type="text" name="callNum" id="callNum" class="signUpMenu" placeholder="<spring:message code='message.newPW.callNum'/>"/>
										<input type="button" value="<spring:message code='message.newPW.check'/>" onclick="checknum()" id="checkNumBtn" class="signUpCheck">
										<input type="button" value="<spring:message code='message.newPW.send'/>" onclick="sendsms()" id="sendSMSBtn" class="signUpCheck">
										<input type="button" value="<spring:message code='message.newPW.resend'/>" onclick="sendsms()" id="reSendSMSBtn" class="signUpCheck">
										<br>
										<span id="callNumstr"></span>
									</div>
									<div class="col-12" id="checkSMSNum">
										<input type="text" name="SMSNum" id="SMSNum" class="signUpMenu" placeholder="<spring:message code='message.newPW.smsNum'/>"/>
										<input type="button" value="<spring:message code='message.newPW.check'/>" onclick="checksms()" id="SMSBtn" class="signUpCheck">
										<br>
										<span id="SMSCheck"></span>
										<span id="randNum" style="visibility: hidden;"></span>
									</div>
									<div class="col-12" id="sendEmail">
										<input type="text" name="firstemail" id="myEmail" class="signUpMenu" placeholder="<spring:message code='message.newPW.email'/>"/>
										<select name="lastemail" id="lastemail" class="signUpMenu">
											<option value="@gmail.com" selected>@gmail.com</option>
											<option value="@naver.com">@naver.com</option>
											<option value="@daum.net">@daum.net</option>
											<option value="@hotmail.com">@hotmail.com</option>
										</select>
									</div>
									<div class="col-12">
										<ul class="actions" id="confirmBtn">
											<li style="width: 100%"><input type="button" value="<spring:message code='message.newPW.confirm'/>" class="primary" onClick="sendnewpw()" style="width: 100%"/></li>
										</ul>
									</div>
								</div>
							</form>
				</section>
			</div>
		</div>

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery-3.6.0.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="assets/js/newPW.js"></script>

</body>
</html>