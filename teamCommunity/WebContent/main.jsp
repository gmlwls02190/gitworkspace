<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function reg(){
		document.location.href="join.jsp";
	}
</script>
</head>
<body>
<h2>메인</h2>
<hr>
<a href="login.jsp">로그인</a>
<a href="logout.do">로그아웃</a>
<a href="goNotice.do">공지게시판</a>
<a href="goFree.do">자유게시판</a>
<a href="goTip.do">팁게시판</a>
<a href="myPage.do">마이</a>
<a href="info.jsp">사이트소개</a>
<a href="contact.jsp">오시는길</a>


<%-- <h2>메인페이지</h2>
<hr>
<%
	if(session.getAttribute("mem")==null){
		%>
		<form action="controller.jsp" method="post" name="form1">
		<input type="hidden" name="action" value="login">
			<table>
				<tr>
					<td>아이디</td><td><input type="text" name="mid" required></td>
				</tr>
				<tr>
					<td>비밀번호</td><td><input type="password" name="mpw" required></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="button" value="회원가입" onClick="reg()"><input type="submit" value="로그인"></td>
				</tr>
			</table>
		</form>
		<%
	}
	else{
		%>
		<h4>${mem}님 환영합니다!</h4>
		<hr>
		<a href="controller.jsp?action=myPage&category=myBoard&mid=${mem}">마이페이지</a>
		<a href="controller.jsp?action=logout">로그아웃</a>
		<hr>
		<a href="controller.jsp?action=pLists&category=Notice">공지사항</a><br>
		<a href="controller.jsp?action=pLists&category=Free">자유게시판</a><br>
		<a href="controller.jsp?action=pLists&category=Study">스터디게시판</a>
		<%
	}
%> --%>

</body>
</html>