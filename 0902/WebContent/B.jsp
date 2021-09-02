<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제</title>
</head>
<body>

${param.data}(를)을 ${param.cnt}개 구매<br>
<hr>
총 결제 금액: ${product.calc(param.data,param.cnt)}원

</body>
</html>