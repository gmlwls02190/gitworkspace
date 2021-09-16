<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

확인
<c:forEach var="v" items="${datas}">
	<c:set var="m" value="${v.m}"/>
	<h3>
	<c:if test="${mem!=null}">
	<a href="javascript:editM(${m.mid})">[${m.userid}]</a>
	</c:if>
	<c:if test="${mem==null}">
	[${m.userid}]
	</c:if>
	 ${m.msg} &gt;&gt; [좋아요 ${m.favcount} | 댓글 ${m.replycount} | ${m.wdate}]</h3>
	<ol><c:forEach  var="r" items="${v.rlist}">
		<li>${r.userid} >> ${r.rmsg} [${r.wdate}]</li>
	</c:forEach></ol>
</c:forEach>
</body>
</html>