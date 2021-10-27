<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>
</head>
<body>
<c:if test="${kakaoVO==null }">
<a href="kakaoLogin.do"><img alt="" src="images/kakaoLogin.png"></a>
</c:if>
<c:if test="${kakaoVO!=null }">
	<h2>${kakaoVO.user_name }</h2>
	<p>${kakaoVO.email }</p>
	<img alt="" src="${kakaoVO.profile_img}">
	<a href="kakaoLogout.do">kakaoLogout</a>
</c:if>

</body>
</html>