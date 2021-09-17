<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/ad.css">
<script type="text/javascript" src="script/main.js"></script>
</head>
<body>
<div class="main">
<ol>
	<li><a href="mainAll.do?stat=all">전체목록보기</a></li>
	<my:more/>
</ol>
<hr>
<h2>전체목록</h2>
<my:forEach/>
<hr>
<my:login/>
<hr>
<h3>회원목록</h3>
<c:forEach var="v" items="${newUsers}">
<a href="otherMain.do?mcnt=${mcnt}&userid=${v.userid}&cnt=${cnt}">[${v.uname}]</a>님 환영! <br>
</c:forEach>
cnt: ${cnt }<br>
memcnt: ${memcnt }<br>
idcnt: ${idcnt }<br>
<a href="control2.jsp">페이징 되냐?</a>
</div>

<div class="ad">
<a href="https://petoria.co.kr/?gclid=EAIaIQobChMIrf-ts7yA8wIVlQ6RCh39oQXnEAAYASAAEgJ8CPD_BwE" target="_blank"><img alt="puppy" src="img/puppy.jpg" width="100%" height="300px"></a>
<br>
<p align="center">뭘 보냐? 간식이나 줘라</p>
</div>

</body>
</html>