<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<%
	if(session.getAttribute("mem")!=null){
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
%>