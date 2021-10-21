<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="main.do">Main</a>
<hr>
<table border="1">
	<tr>
		<td>제목: ${data.title}</td><td>작성일 : ${data.wdate}</td>
	</tr>
	<tr>
		<td colspan="2">작성자 : ${data.writer}</td>
	</tr>
	<tr>
		<td colspan="2">${data.content}</td>
	</tr>
</table>

</body>
</html>