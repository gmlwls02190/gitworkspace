<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="data" class="model.product.ProductVO" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="control.jsp" method="post" name="form4">
<input type="hidden" name="action" value="main">
	<table>
		<tr>
			<td>상품번호</td><td>${data.pnum}</td>
		</tr>
		<tr>
			<td>상품명</td><td>${data.pname}</td>
		</tr>
		<tr>
			<td>상품재고</td><td>${data.pcnt}</td>
		</tr>
		<tr>
			<td>상품상태</td><td>${data.pstatus}</td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="메인"></td>
		</tr>
	</table>
</form>

</body>
</html>