<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.board.*"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request"/>

<jsp:useBean id="mDAO" class="model.member.MemberDAO"/>
<jsp:useBean id="mVO" class="model.member.MemberVO" scope="session"/>
<jsp:setProperty property="*" name="mVO"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script type="text/javascript">
	function check(bnum){
		res=confirm("글을수정하시겠습니까?");
		if(res){
			document.location.href="control.jsp?action=goEditB&bnum="+bnum;
		}
		else{
			return;
		}
	}
</script>
</head>
<body>

<h2>마이페이지</h2>
<hr>
<h4><%=mDAO.getMemData(mVO).getUsername() %>님 반갑습니다</h4>
<hr>
<a href="control.jsp?action=main">메인으로</a><a href="control.jsp?action=goEditMem">회원정보수정</a>
<hr>
<table>
			<tr>
				<td>번호</td><td>작성자</td><td>제목</td>
			</tr>
			<c:forEach var="v" items="${datas}">
				<tr>
					<td><a href="javascript:check(${v.bnum })">${v.bnum}</a></td><td>${v.writer}</td><td>${v.title}</td>
				</tr>
			</c:forEach>
			<%-- <%
				for(BoardVO vo:(ArrayList<BoardVO>)datas){
					%>
					<tr>
						<td><a href="javascript:check(<%=vo.getBnum() %>)"><%=vo.getBnum() %></a></td><td><%=vo.getWriter() %></td><td><%=vo.getTitle() %></td>
					</tr>
					<%
				}
			%> --%>
		</table>

</body>
</html>