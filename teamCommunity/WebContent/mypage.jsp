<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function quit(){
		document.form4.action.value="quitUser";
		document.form4.submit();
	}
</script>
</head>
<body>

<h2>마이페이지</h2>
<hr>
<a href="editUser.do">회원수정</a>
<a href="quitUser.do">회원탈퇴</a>
<a href="myFav.do">관심글</a>
<a href="main.do">메인</a>

<%-- <h2>마이페이지</h2>
<hr>
<a href="controller.jsp?action=myPage&category=myBoard">내글보기</a>
<a href="controller.jsp?action=myPage&category=checkUser&mid=${mem}">회원정보수정</a>
<a href="controller.jsp?action=myPage&category=favBoard">관심글보기</a>
<a href="controller.jsp?action=main">메인으로</a>
<hr>
<!-- 회원정보 수정,  내 글 보기, 관심글 보기 -->
체크
<%
	if(request.getParameter("category").equals("checkUser")){
		if(request.getParameter("check").equals("t")){
			%>
			<h4>회원정보수정</h4>
			<form action="controller.jsp" method="post" name="form4">
			<input type="hidden" name="action" value="editUser">
			<input type="hidden" name="mid" value="${mem}">
				<table>
					<tr>
						<td>아이디</td><td>${mem}</td>
					</tr>
					<tr>
						<td>비밀번호</td><td><input type="password" value="${data.mpw}" name="mpw" required></td>
					</tr>
					<tr>
						<td>닉네임</td><td><input type="text" name="mname" value="${data.mname}" required></td>
					</tr>
					<tr>
						<td>이메일</td><td><input type="email" name="memail" value="${data.memail}" required></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><input type="submit" value="회원정보수정"><input type="button" value="회원탈퇴" onClick="quit()"></td>
					</tr>
				</table>
			</form>
			<%
		}
		else if(request.getParameter("check").equals("f")){
			%>
			<form action="controller.jsp?action=myPage&category=checkUser" method="post">
				<input type="hidden" name="mid" value="${mem}">
				<table>
					<tr>
						<td>비밀번호확인</td>
						<td><input type="password" name="mpw" required></td>
						<td><input type="submit" value="확인"></td>
					</tr>
				</table>
			</form>
			<%
		}
		
	}
	else if(request.getParameter("category").equals("myBoard")){
		%>
		<a href="controller.jsp?action=myPage&category=myBoard&stat=Free">자유게시판</a>
		<a href="controller.jsp?action=myPage&category=myBoard&stat=Study">스터디게시판</a>
		<hr>
		<%
		if(request.getParameter("stat").equals("Free")){
			%>
			<h4>자유게시판 내글보기</h4>
			<table>
				<tr>
					<td>번호</td><td>제목</td><td>닉네임</td><td>작성일</td><td>조회수</td>
				</tr>
			<c:forEach var="v" items="${datas}" varStatus="r">
				<tr>
					<td>${r.count}</td><td>[${v.category}]&nbsp;${v.ptitle}&nbsp;</td><td>${v.mname}&nbsp;</td><td>${v.pdate}&nbsp;</td><td>${v.cnt}</td>
				</tr>
			</c:forEach>
			</table>
			<%
		}
		else if(request.getParameter("stat").equals("Study")){
			%>
			<h4>스터디게시판 내글보기</h4>
			<table>
				<tr>
					<td>번호</td><td>제목</td><td>닉네임</td><td>작성일</td><td>조회수</td>
				</tr>
			<c:forEach var="v" items="${datas}" varStatus="r">
				<tr>
					<td>${r.count}</td><td>[${v.category}]&nbsp;${v.ptitle}&nbsp;</td><td>${v.mname}&nbsp;</td><td>${v.pdate}&nbsp;</td><td>${v.cnt}</td>
				</tr>
			</c:forEach>
			</table>
			<%
		}
	}
	else if(request.getParameter("category").equals("favBoard")){
		%>
		<h4>관심글보기</h4>
		<table>
			<tr>
				<td>a1</td><td>a2</td>
			</tr>
			<tr>
				<td>a3</td><td>a4</td>
			</tr>
		</table>
		<%
	}
%> --%>
</body>
</html>