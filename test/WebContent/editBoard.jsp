<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EditBoard</title>
<script type="text/javascript">
	function deleteBoard(bid){
		document.location.href="deleteBoard.do?bid="+bid;
	}
</script>
</head>
<body>

<a href="main.do">메인으로</a>
<hr>
<form action="updateBoard.do" method="post" name="editBoard">
	<input type="hidden" name="bid" value="${data.bid}">
	<table border="1">
		<tr>
			<td>작성자</td><td>${data.writer}</td>
		</tr>
		<tr>
			<td>작성일</td><td>${data.wdate}</td>
		</tr>
		<tr>
			<td>제목</td><td><input type="text" name="title" value="${data.title}" required></td>
		</tr>
		<tr>
			<td>내용</td><td><input type="text" name="content" value="${data.content}" required></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="글 수정"><input type="button" value="글 삭제" onClick="deleteBoard(${data.bid})"></td>
		</tr>
	</table>
</form>

</body>
</html>