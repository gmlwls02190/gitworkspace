<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="data" class="model.product.ProductVO" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function del(){
		document.form3.action.value="deleteP";
		document.form3.submit();
	}
</script>
</head>
<body>

<form action="control.jsp" method="post" name="form3">
<input type="hidden" name="action" value="updateP">
<input type="hidden" name="pnum" value="${data.pnum}">
	<table>
		<tr>
			<td>상품명</td><td><input type="text" name="pname" value="${data.pname}" required></td>
		</tr>
		<tr>
			<td>상품재고</td><td><input type="number" name="pcnt" value="${data.pcnt}" required min="1"></td>
		</tr>
		<tr>
			<td>상품상태</td><td><input type="text" name="pstatus" value="${data.pstatus}" required></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="상품수정"><input type="button" value="상품삭제" onclick="del()"></td>
		</tr>
	</table>
</form>

</body>
</html>