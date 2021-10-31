<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Kakao -->
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>

<!-- Google -->
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name ="google-signin-client_id" content="334493542272-bm1lfpektcd2mmbhdt8upmrt4jjbsr2i.apps.googleusercontent.com">

<!-- Naver -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>

<c:if test="${kakaoVO==null }">
<a href="kakaoLogin.do"><img alt="" src="images/kakaoLogin.png"></a>
</c:if>
<c:if test="${kakaoVO!=null }">
	<h2>NAME: ${kakaoVO.user_name }</h2>
	<p>EMAIL: ${kakaoVO.email }</p>
	<img alt="" src="${kakaoVO.profile_img}">
	<a href="kakaoLogout.do">kakaoLogout</a>
</c:if>
<br>
<hr>
<br>
<c:if test="${googleVO==null}">
	<a href="googleLogin.do"><img alt="" src="images/googleLogin.png"></a>
</c:if>
<c:if test="${googleVO!=null }">
	<h2>NAME: ${googleVO.user_name }</h2>
	<p>EMAIL: ${googleVO.email }</p>
	<p>ID: ${googleVO.id }</p>
	<a href="googleLogout.do">googleLogout</a>
</c:if>
<br>
<hr>
<br>
<c:if test="${naverVO==null}">
	<a href="naverLogin.do"><img alt="" src="images/naverLogin.png"></a>
</c:if>
<c:if test="${naverVO!=null }">
	<h2>NICKNAME: ${naverVO.nickname }</h2>
	<p>NAME: ${naverVO.name }</p>
	<p>EMAIL: ${naverVO.email }</p>
	<p>GENDER: ${naverVO.gender }</p>
	<p>AGE: ${naverVO.age }</p>
	<p>MOBILE: ${naverVO.mobile }</p>
	<a href="naverLogout.do">naverLogout</a>
</c:if>

</body>
</html>