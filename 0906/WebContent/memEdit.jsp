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
<title>회원정보 수정 페이지</title>
<script type="text/javascript">
	function del(){
		document.form4.action.value="deleteMem";
		document.form4.submit();
	}
</script>
</head>
<body>

<form action="control.jsp" method="post" name="form4">
<input type="hidden" name="action" value="editMem">
<input type="hidden" name="userid" value="<%=mDAO.getMemData(mVO).getUserid() %>">
	<table>
		<tr>
			<td>아이디</td><td><%=mDAO.getMemData(mVO).getUserid() %></td>
		</tr>
		<tr>
			<td>비밀번호</td><td><input type="text" name="userpw" required></td>
		</tr>
		<tr>
			<td>이름</td><td><input type="text" name="username" required></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="회원정보수정"><input type="button" value="회원탈퇴" onClick="del()"></td>
	</table>
</form>

</body>
</html>