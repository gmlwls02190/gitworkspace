<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Phantom by HTML5 UP</title>
<!-- Kakao -->
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>

<!-- Google -->
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name ="google-signin-client_id" content="클라이언트아이디">

<!-- Naver -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- 다음주소 api -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script type="text/javascript">
	var btn=document.querySelector('#signUp');
	if(btn!=null){
		btn.onclick=function(){
			consol.log("2");
			var pw=document.getElementById('pw');
			var repw=document.getElementById('repw');
			var email=document.getElementById('firstemail');
			
			var checkPW= /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;
			
			if(!checkPW.test(pw.value)){
				alert('비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야합니다!');
				pw.focus();
				return false;
			}
			if(pw.value != repw.value){
				alert('비밀번호가 일치하지 않습니다!');
				repw.focus();
				return false;
			}
			
			var checkEmail= /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*$/i;
			
			if(!checkEmail.test(email.value)){
				alert('이메일 확인 후 다시 작성하시기 바랍니다!');
				email.focus();
				return false;
			}
			return false;
		}
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
						</span>
						<a href="#"><h2>뭔가 넣을 곳</h2></a>
					</article>
						<article class="style4">
							<form method="post" action="login.do">
								<div class="row gtr-uniform">
									<div class="col-12">
										<input type="text" name="id" id="id" placeholder="ID" required/>
									</div>
									<div class="col-12">
										<input type="password" name="pw" id="pw" placeholder="PW" required/>
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
						<h1>SignUp</h1>
					</header>
					<section class="tiles">
						<article class="signUpform">
							<form method="post" action="signUp.do">
								<div class="row gtr-uniform">
									<div class="col-12">
										<input type="text" name="id" id="checkId" class="signUpMenu" placeholder="ID"/>
										<input type="button" value="ID" onclick="check()" id="checkID" class="signUpCheck">
										<span id="idCheck"></span>
									</div>
									<div class="col-12">
										<input type="password" name="pw" id="checkPw" class="signUpMenu" placeholder="PW"/>
										<br>
										<span id="pwStr"></span>
										<span id="pwCheck"></span>
										<br>
										<span id="pwReg"></span>
									</div>
									<div class="col-12">
										<input type="password" name="repw" id="repw" class="signUpMenu" placeholder="RePW"/>
										<div class="signUpCheck">
											<span id="repwCheck"></span>
										</div>
									</div>
									<div class="col-12">
										<input type="text" name="artist" id="checkArtist" class="signUpMenu" placeholder="Artist"/>
										<input type="button" value="Artist" onclick="checkart()" id="checkArt" class="signUpCheck">
										<span id="artistCheck"></span>
									</div>
									<div class="col-12">
										<input type="text" name="addrNum" id="addrNum" class="signUpMenu" placeholder="AddressNumber"/>
										<input type=button name="address" id="addrbtn" class="signUpCheck" value="Address" onClick="SearchAddr()" style="overflow: visible !important;"/>
										<input type="text" name="roadAddr" id="roadAddr" class="signUpMenu" placeholder="Address"/>
										<input type="text" name="detailAddr" id="detailAddr" class="signUpMenu" placeholder="DetailAddress"/>
									</div>
									<div class="col-12">
										<input type="text" name="firstemail" id="firstemail" class="signUpMenu" placeholder="Email"/>
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
										<input type="text" name="callNum" id="callNum" class="signUpMenu" placeholder="CallNumber"/>
										<div class="signUpCheck">
											<span id="callNumCheck"></span>
										</div>
										<br>
										<span id="wrongNum"></span>
									</div>
									<div class="col-12">
										<ul class="actions">
											<li><input type="button" value="SignUp" class="primary" id="signBtn" onclick="emptycheck()"/></li>
											<li><input type="submit" value="SignUp" class="primary" id="signUp"/></li>
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

</body>
</html>