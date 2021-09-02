<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커스텀태그 실습</title>
</head>
<body>

<form action="D.jsp" method="post">
	<select name="data">
		<mytag:productOption />
	</select>
	<input type="number" name="cnt" min="0">
	<input type="submit" value="결제">
</form>

</body>
</html>