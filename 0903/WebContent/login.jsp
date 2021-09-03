<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>

<form method="post" action="control.jsp" name="form1">
<input type="hidden" name="action" value="main">
	<table>
		<tr>
		<th align="left">로그인</th>
		</tr>
		<tr>
		<td><input type="text" name="mid" required></td>
		</tr>
		<tr>
		<td><input type="password" name="mpw" required></td>
		</tr>
		<tr>
			<td align="right">
			<input type="submit" value="로그인">
			<my:reg />
			</td>
		</tr>
	</table>
</form>

</body>
</html>