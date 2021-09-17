<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/editM.js"></script>
</head>
<body>

<form action="updateM.do" method="post" name="form2">
<input type="hidden" name="mid" value="${data.mid}">
<input type="hidden" name="userid" value="${data.userid}">
<input type="hidden" name="favcount" value="${data.favcount}">
<input type="hidden" name="replycount" value="${data.replycount}">
	<table>
		<tr>
			<td>아이디</td><td>${mem}</td>
		</tr>
		<tr>
			<td>내용</td><td><input type="text" name="msg" value="${data.msg }" required></td>
		</tr>
		<tr>
			<td>날짜</td><td><input type="date"></td>
		</tr>
		<tr>
			<td><input type="submit" value="수정"></td>
		</tr>
	</table>
</form>
<hr>
${data.mid}
<hr>
<a href="javascript:delM(${data.mid})">삭제</a>
</body>
</html>