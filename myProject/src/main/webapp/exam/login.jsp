<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="login.do" method="post">
	<table>
		<tr>
			<td>ID</td><td><input type="text" name="id" value="${guest.id}"></td>
		</tr>
		<tr>
			<td>PW</td><td><input type="password" name="password" value="${guest.password}"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Login"></td>
		</tr>
	</table>
</form>

</body>
</html>