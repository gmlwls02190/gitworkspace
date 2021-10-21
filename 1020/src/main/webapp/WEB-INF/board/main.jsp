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

<c:if test="${mem==null}">
<form action="login.do" method="post">
	<table>
		<tr>
			<td><input type="text" name="id" placeholder="ID"></td>
		</tr>
		<tr>
			<td><input type="password" name="pw" placeholder="PW"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Login"></td>
		</tr>
	</table>
</form>
</c:if>

<c:if test="${mem!=null}">
	<h2>${mem.name} Hi~</h2>
	<a href="logout.do">Logout</a>
</c:if>

<table border="1">
	<tr>
		<td>번호</td><td>제목</td><td>작성자</td><td>작성일</td>
	</tr>
	<c:forEach var="v" items="${datas}">
		<tr>
			<td>${v.id}</td><td><a href="board.do?id=${v.id}">${v.title}</a></td><td>${v.writer}</td><td>${v.wdate}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>