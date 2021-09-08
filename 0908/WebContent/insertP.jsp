<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="control.jsp?action=insertP" method="post" name="form2">
	<table>
		<tr>
			<td>상품명</td><td><input type="text" name="pname" required></td>
		</tr>
		<tr>
			<td>상품재고</td><td><input type="number" name="pcnt" required min="1"></td>
		</tr>
		<tr>
			<td>상품상태</td><td><input type="text" name="pstatus" required></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="상품추가"></td>
		</tr>
	</table>
</form>

</body>
</html>