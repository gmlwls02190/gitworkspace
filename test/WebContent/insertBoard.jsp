<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertBoard</title>
</head>
<body>

<a href="main.do">메인으로</a>
<hr>
<form action="insertBoard.do" method="post">
<input type="hidden" name="id" value="${mem.id}">
	<table border="1">
		<tr>
			<td>작성자</td><td><input type="text" name="writer" value="${mem.name}" readonly></td>
		</tr>
		<tr>
			<td>제목</td><td><input type="text" name="title" required></td>
		</tr>
		<tr>
			<td>내용</td><td><input type="text" name="content" required></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="글 작성"></td>
		</tr>
	</table>
</form>

</body>
</html>