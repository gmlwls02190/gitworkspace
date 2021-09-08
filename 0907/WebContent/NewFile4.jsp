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
<!-- delims는 구분을 해주는 속성이여서 ','를 기준으로 나눠준다 -->
<ul>
<c:forTokens var="v" items="홍길동,아무무,가렌,파이크" delims=",">
	<li>${v}</li>
</c:forTokens>
</ul>
<hr>

<c:forEach var="v" items="${datas}" begin="0" end="3" varStatus="vs">
	${vs.index} / ${vs.count } <br>
	${v.product} / ${v.status}<hr>
</c:forEach>

</body>
</html>