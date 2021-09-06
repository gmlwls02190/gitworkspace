<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="bDAO" class="model.board.BoardDAO" />
<jsp:useBean id="bVO" class="model.board.BoardVO" />
<jsp:setProperty property="*" name="bVO"/>

<jsp:useBean id="mDAO" class="model.member.MemberDAO"/>
<jsp:useBean id="mVO" class="model.member.MemberVO" scope="session"/>
<jsp:setProperty property="*" name="mVO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정/삭제 페이지</title>
<script type="text/javascript">
	function del(){
		document.form3.action.value="deleteB";
		document.form3.submit();
	}
</script>
</head>
<body>

<form action="control.jsp" method="post" name="form3">
<input type="hidden" name="action" value="editB">
<input type="hidden" name="bnum" value="<%=bDAO.getDBData(bVO).getBnum() %>">
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
			<td colspan="2" align="right"><input type="submit" value="게시글수정"><input type="button" value="게시글삭제" onClick="del()"></td>
		</tr>
	</table>
</form>

</body>
</html>