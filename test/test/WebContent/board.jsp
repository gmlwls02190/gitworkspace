<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>

<a href="main.do">메인으로</a>
<hr>
<table border="1">
	<tr>
		<td>제목</td><td>${data.title}</td>
	</tr>
	<tr>
		<td>작성자</td><td>${data.writer}</td>
	</tr>
	<tr>
		<td>작성일</td><td>${data.wdate}</td>
	</tr>
	<tr>
		<td>내용</td><td>${data.content}</td>
	</tr>
</table>
<hr>
<c:if test="${mem.id==data.id}">
	<a href="editBoard.do?bid=${data.bid}">글 수정</a>
</c:if>

</body>
</html>