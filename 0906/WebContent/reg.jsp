<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>

<form action="control.jsp?action=insertMem" method="post" name="form1">
	<table>
		<tr>
			<td>아이디</td><td><input type="text" name="userid" required></td>
		</tr>
		<tr>
			<td>비밀번호</td><td><input type="password" name="userpw" required></td>
		</tr>
		<tr>
			<td>이름</td><td><input type="text" name="username" required></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="회원가입"></td>
		</tr>
	</table>
</form>

</body>
</html>