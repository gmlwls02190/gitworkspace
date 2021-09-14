<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function insertM(){
		document.location.href="insertM.jsp"
	}
	function editM(mid){
		document.location.href="control.jsp?action=editM&mid="+mid;
	}
	function delR(rid){
		document.location.href="control.jsp?action=deleteR&rid="+rid;
	}
	function myPage(){
		document.location.href="control.jsp?action=main";
	}
/* 	function more(){
		document.location.href="control.jsp?action=main&mcnt=${mcnt+1}&mem="${mem}
	} */
</script>
</head>
<body>

<ol>
	<li><a href="control.jsp?action=mainAll">전체목록보기</a></li>
</ol>

<hr>

<h2>전체목록</h2>
<c:forEach var="v" items="${datas}">
	<c:set var="m" value="${v.m}"/>
	<h3>
	<c:if test="${mem!=null}">
	<a href="javascript:editM(${m.mid})">[${m.userid}]</a>
	</c:if>
	<c:if test="${mem==null}">
	[${m.userid}]
	</c:if>
	 ${m.msg} &gt;&gt; [좋아요 ${m.favcount} | 댓글 ${m.replycount} | ${m.wdate}]</h3>
	<ol><c:forEach  var="r" items="${v.rlist}">
		<li>${r.userid} >> ${r.rmsg} [${r.wdate}] <c:if test="${mem!=null}"><input type="button" value="댓글삭제" onClick="delR(${r.rid})"></c:if></li>
	</c:forEach></ol>
	<c:if test="${mem!=null}">
	<form action="control.jsp?action=insertR" method="post">
	<input type="hidden" name="mid" value="${m.mid}">
	<input type="hidden" name="userid" value="${mem}">
		<textarea rows="3" cols="40" name="rmsg"></textarea>
		<input type="submit" value="댓글작성">
	</form>
	</c:if>
</c:forEach>

<hr>
<c:if test="${more==null}">
<a href="control.jsp?action=mainAll&mcnt=${mcnt+1}&mem=${mem}">더보기</a>
</c:if>
<c:if test="${more!=null}">
<a href="control.jsp?action=main&mcnt=${mcnt+1}&mem=${mem}">더보기</a>
</c:if>
<hr>

<c:if test="${mem==null}">
<form action="control.jsp?action=login" method="post">
<input type="hidden" name="mcnt" value="${mcnt}">
			<table>
				<tr>
					<td>아이디</td><td><input type="text" name="userid"></td>
				</tr>
				<tr>
					<td>비밀번호</td><td><input type="password" name="userpw"></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="로그인"></td>
				</tr>
			</table>
		</form>
</c:if>
<c:if test="${mem!=null}">
<form action="control.jsp" method="post" name="form1">
<input type="hidden" name="action" value="logout">
<input type="hidden" name="userid" value="${mem}">
			<table>
				<tr>
					<td><input type="button" value="내글보기" onClick="myPage()"></td><td><input type="button" value="글작성" onClick="insertM()"></td><td><input type="submit" value="로그아웃"></td>
				</tr>
			</table>
		</form>
</c:if>

</body>
</html>