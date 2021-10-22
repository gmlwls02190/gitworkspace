<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<td>${data.title}</td><td>${data.wdate}</td>
	</tr>
	<tr>
		<td colspan="2">${data.writer}</td>
	</tr>
	<tr>
		<td colspan="2">${data.content}</td>
	</tr>
</table>

</body>
</html>