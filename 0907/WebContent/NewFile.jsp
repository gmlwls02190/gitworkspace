<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- isErrorPage -->
<c:catch var="errMsg">
	<%= 10/0 %>
</c:catch>
${errMsg} <br>

<c:set var="msg" value="hello" /> <!-- 변수세팅 기본scope="page" -->

<c:remove var="msg"/>

<h1>${msg}</h1>

<hr>

<%-- <c:set target="${member}" property="emain" value="123123@naver.com"></c:set> <!-- 이니셜멤버.java에있는 member를 타겟으로하고 그곳의 이메일을 밸류값으로 변경 -->
${member.name } <br>
${member.email } --%>

</body>
</html>