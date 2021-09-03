<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인/아웃 페이지</title>
</head>
<body>

<my:login/>
<my:logout/>

<%-- <%
	if(session.getAttribute("mem")==null){
		%>
		<form method="post" action="control.jsp" name="form1">
<input type="hidden" name="action" value="login">
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
		<%
	}
	else{
		%>
		<h2><my:memName/>님 환영합니다</h2>
<hr>
<form action="control.jsp?action=logout" method="post">
<table>
	<thead>회원정보 목록</thead>
	<tr>
		<td>이름</td><td>아이디</td><td>비밀번호</td>
	</tr>
	<my:foreachMemData />
	<tr>
		<td colspan="3" align="right"><input type="submit" value="로그아웃"></td>
	</tr>
</table>
</form>
		<%
	}
%> --%>

</body>
</html>