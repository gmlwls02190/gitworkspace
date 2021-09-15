<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${mem}
<form action="control.jsp?action=insertM" method="post">
<input type="hidden" name="userid" value="${mem}">
	<table>
		<tr>
			<td>아이디</td><td>${mem}</td>
		</tr>
		<tr>
			<td>내용</td><td><input type="text" name="msg" required></td>
		</tr>
		<tr>
			<td><input type="submit" value="작성"></td>
		</tr>
	</table>
</form>

</body>
</html>