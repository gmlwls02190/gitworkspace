<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="control.jsp?action=insertU" method="post" name="form3">
	<table>
		<tr>
			<td>아이디</td><td><input type="text" name="userid" required></td>
		</tr>
		<tr>
			<td>비밀번호</td><td><input type="password" name="userpw" required></td>
		</tr>
		<tr>
			<td>이름</td><td><input type="text" name="uname" required></td>
		</tr>
		<tr>
			<td><input type="submit" value="회원가입"></td>
		</tr>
	</table>
</form>

</body>
</html>