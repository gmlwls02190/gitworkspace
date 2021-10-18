<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EditUser</title>
<script type="text/javascript">
	function quit(id){
		document.location.href="deleteUser.do";
	}
</script>
</head>
<body>

<form action="updateUser.do" method="post">
<input type="hidden" name="id" value="${mem.id}">
	<table border="1">
		<tr>
			<td>아이디</td><td>${mem.id}</td>
		</tr>
		<tr>
			<td>비밀번호</td><td><input type="password" name="pw" value="${mem.pw}"></td>
		</tr>
		<tr>
			<td>이름</td><td><input type="text" name="name" value="${mem.name}"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="회원수정"><input type="button" value="회원탈퇴" onClick="quit()"></td>
		</tr>
	</table>
</form>

</body>
</html>