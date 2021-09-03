<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>

	<form method="post" action="control.jsp" name="form2">
		<input type="hidden" name="action" value="reg">
		<table>
			<tr>
				<th>회원가입</th>
			</tr>
			<tr>
				<td>이름입력</td>
				<td><input type="text" name="mname" required></td>
			</tr>
			<tr>
				<td>아이디입력</td>
				<td><input type="text" name="mid" required></td>
			</tr>
			<tr>
				<td>비밀번호입력</td>
				<td><input type="password" name="mpw" required></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="회원가입"></td>
			</tr>
		</table>
	</form>

</body>
</html>