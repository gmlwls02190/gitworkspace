<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<script type="text/javascript">
	function reg(){
		document.location.href="reg.jsp";
	}
</script>
</head>
<body>

<c:if test="${mem==null}">
	<form action="login.do" method="post">
	<table border="1">
		<tr>
			<td>아이디</td><td><input type="text" name="id" required></td>
		</tr>
		<tr>
			<td>비밀번호</td><td><input type="password" name="pw" required></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="로그인"><input type="button" value="회원가입" onClick="reg()"></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${mem!=null}">
	<h2>${mem.name}님 환영합니다</h2>
	<hr>
	<a href="main.do">전체글보기</a>
	<a href="main.do?id=${mem.id}">내글보기</a>
	<a href="editUser.jsp">회원정보수정</a>
	<a href="logout.do">로그아웃</a>
</c:if>
<hr>
<table border="1">
	<tr>
		<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
	</tr>
	<c:forEach var="v" items="${datas}">
		<tr>
			<td><a href="post.do?bid=${v.bid}">${v.bid}</a></td>
			<td>${v.title}</td>
			<td>${v.writer}</td>
			<td>${v.wdate}</td>
		</tr>
	</c:forEach>
</table>
<hr>
<c:if test="${mem!=null}">
	<a href="insertBoard.jsp">글 작성</a>
</c:if>

</body>
</html>