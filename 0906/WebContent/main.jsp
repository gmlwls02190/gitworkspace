<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.board.*"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />

<jsp:useBean id="mDAO" class="model.member.MemberDAO"/>
<jsp:useBean id="mVO" class="model.member.MemberVO" scope="session"/>
<jsp:setProperty property="*" name="mVO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<script type="text/javascript">
	function reg(){
		document.location.href="reg.jsp";
	}
	function logout(){
		document.form7.action.value="logout";
		document.form7.submit();
	}
	function insertB(){
		document.location.href="insertB.jsp";
	}
</script>
</head>
<body>

<h2>게시글 목록</h2>
<hr>
<form action="control.jsp?action=search" method="post" name="form6">
	<input type="text" name="search" placeholder="작성자검색"><input type="submit" value="검색">
</form>
<hr>
		<table>
			<tr>
				<td>번호</td><td>작성자</td><td>제목</td>
			</tr>
			<c:forEach var="v" items="${datas}">
				<tr>
					<td>${v.bnum}</td><td>${v.writer}</td><td>${v.title}</td>
				</tr>
			</c:forEach>
			<!-- <hr>
			<h4>체크</h4>
			<hr> -->
			<%-- <%
			System.out.println(request.getAttribute("datas")+"1212");
				for(BoardVO vo:(ArrayList<BoardVO>) datas){
					%>
					<tr>
						<td><%=vo.getBnum() %></td><td><%=vo.getWriter() %></td><td><%=vo.getTitle() %></td>
					</tr>
					<%
				}
			%> --%>
		</table>
<hr>
<%
	if(session.getAttribute("mem")==null){
		%>
		<my:login/>
		<%
	}
	else{
		%>
		<my:logout/>
		<%
	}
%>

</body>
</html>