<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,test.testVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
ArrayList<testVO> products=new ArrayList<testVO>();

products.add(new testVO("양배추","불량"));
products.add(new testVO("사과","양호"));
products.add(new testVO("딸기","보통"));
products.add(new testVO("복숭아","부패"));

session.setAttribute("datas", products);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form>
	<input type="number" name="num">
	<input type="submit" value="정수입력">
</form>

<c:if test="${param.num%2==0}">
	${param.num}는(은) 짝수입니다.
</c:if>
<c:if test="${param.num%2==1}">
	${param.num}는(은) 홀수입니다.
</c:if>

<hr>
<table border="1">
		<tr>
			<td>상품명</td><td>상태</td>
		</tr>

<c:forEach var="vo" items="${datas}">
		<tr>
			<td>${vo.product}</td><td>${vo.status}</td>
		</tr>
</c:forEach>
</table>
</body>
</html>