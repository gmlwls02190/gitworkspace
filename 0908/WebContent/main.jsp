<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.product.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function editP(pnum){
		document.location.href="control.jsp?action=editP&pnum="+pnum;
	}
	function showOne(pnum){
		document.location.href="control.jsp?action=showOne&pnum="+pnum;
	}
	
</script>
</head>
<body>

<table>
	<tr>
		<td>상품번호</td><td>상품명</td><td>상품재고</td><td>상품상태</td>
	</tr>
	<c:forEach var="vo" items="${datas}">
		<tr>
			<td><a href="javascript:editP(${vo.pnum})">${vo.pnum}</a></td><td><a href="javascript:showOne(${vo.pnum})">${vo.pname}</a></td><td>${vo.pcnt}</td><td>${vo.pstatus}</td>
		</tr>
	</c:forEach>
<%-- 	<%
		for(ProductVO vo: (ArrayList<ProductVO>)datas){
			%>
			
			<tr>
				<td><a href="javascript:editP(<%=vo.getPnum()%>)"><%=vo.getPnum() %></a></td><td><a href="javascript:showOne(<%=vo.getPnum()%>)"><%=vo.getPname() %></a></td><td><%=vo.getPcnt() %></td><td><%=vo.getPstatus() %></td>
			</tr>
			
			<%
		}
	%> --%>
</table>

<form action="insertP.jsp" method="post" name="form1">
	<input type="submit" value="상품추가">
</form>

</body>
</html>