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

<ol>
	<li><a href="control.jsp?action=main">전체목록보기</a></li>
</ol>

<hr>

<h2>전체목록</h2>
<c:forEach var="v" items="${datas}">
	<c:set var="m" value="${v.m}"/>
	<h3>[${m.userid}] ${m.msg} &gt;&gt; [좋아요 ${m.favcount} | 댓글 ${m.replycount} | ${m.wdate}]</h3>
	<ol><c:forEach  var="r" items="${v.rlist}">
		<li>${r.userid} >> ${r.rmsg} [${r.wdate}]</li>
	</c:forEach></ol>
</c:forEach>

<hr>
<a href="control.jsp?action=main&mcnt=${mcnt+2}&mem=${mem}">더보기</a>
<hr>

<%
	if(session.getAttribute("mem")==null){
		%>
		<form action="control.jsp?action=login" method="post">
			<table>
				<tr>
					<td>아이디</td><td><input type="text" name="userid"></td>
				</tr>
				<tr>
					<td>비밀번호</td><td><input type="password" name="userpw"></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="로그인"></td>
				</tr>
			</table>
		</form>
		<%
	}
	else{
		%>
		<form action="control.jsp?action=logout" method="post">
			<table>
				<tr>
					<td><input type="submit" value="로그아웃"></td>
				</tr>
			</table>
		</form>
		<%
	}
%>

</body>
</html>