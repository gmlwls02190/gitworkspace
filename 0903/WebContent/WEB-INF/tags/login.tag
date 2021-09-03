<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>

<%
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
		%>