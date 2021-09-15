<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.msg.*,model.user.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ArrayList<MessageVO> list=(ArrayList)request.getAttribute("list");
	int numPerPage=(int)request.getAttribute("numPerPage");
	String pageBar=(String)request.getAttribute("pageBar");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="v" items="${list}">
	<h3>[${v.userid}] ${v.msg} &gt;&gt; [좋아요 ${v.favcount} | 댓글 ${v.replycount} | ${v.wdate}]</h3>
</c:forEach>

<div>
	<%=pageBar %>
</div>

</body>
</html>