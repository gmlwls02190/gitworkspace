<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시판</h2>
<hr>
<a href="pContent.do">게시글</a>
<a href="search.do">검색</a>
<a href="write.jsp">게시글작성</a>
<a href="addFav.do">관심글추가</a>
<a href="main.do">메인</a>
<%-- <h2>게시판페이지</h2>
<hr>
<a href="controller.jsp?action=main">메인으로</a>
<hr>
<a href="controller.jsp?action=pLists&category=Notice">공지사항</a><br>
<a href="controller.jsp?action=pLists&category=Free">자유게시판</a><br>
<a href="controller.jsp?action=pLists&category=Study">스터디게시판</a>
<hr>
<table>	
	<tr>
		<td>번호</td><td>제목</td><td>닉네임</td><td>작성일</td><td>조회수</td>
	</tr>
	<c:forEach var="v" items="${datas}" varStatus="r">
	<tr>
		<td>${r.count}</td><td>[${v.category}]&nbsp;${v.ptitle}&nbsp;</td><td>${v.mname}&nbsp;</td><td>${v.pdate}&nbsp;</td><td>${v.cnt}</td>
	</tr>
	</c:forEach>
</table> --%>

</body>
</html>