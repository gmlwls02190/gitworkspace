<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="mDAO" class="model.member.MemberDAO"/>
<jsp:useBean id="mVO" class="model.member.MemberVO" scope="session"/>
<jsp:setProperty property="*" name="mVO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 추가 페이지</title>
</head>
<body>
<%
System.out.println(mDAO.getMemData(mVO).getUsername());
%>
<form action="control.jsp?action=insertB" method="post" name="form2">
<input type="hidden" name="userid" value="<%=mDAO.getMemData(mVO).getUserid() %>">
<input type="hidden" name="writer" value="<%=mDAO.getMemData(mVO).getUsername() %>">
	<table>
		<tr>
			<td>작성자</td><td><%=mDAO.getMemData(mVO).getUsername() %></td>
		</tr>
		<tr>
			<td>제목</td><td><input type="text" name="title" required></td>
		</tr>
		<tr>
			<td>내용</td><td><input type="text" name="content" required></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="게시글작성"></td>
		</tr>
	</table>
</form>

</body>
</html>