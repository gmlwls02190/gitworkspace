<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="v" items="${datas}">
	<c:set var="m" value="${v.m}"/>
	<h3>
	<c:if test="${mem==m.userid}">
	<a href="javascript:editM(${m.mid})">[${m.userid}]</a>
	</c:if>
	<c:if test="${mem==null || mem!=m.userid}">
	[${m.userid}]
	</c:if>
	 ${m.msg} &gt;&gt; [좋아요 ${m.favcount} | 댓글 ${m.replycount} | ${m.wdate}] 
	 <c:if test="${mem!=null}">
	 	<a class="fav" href="control.jsp?action=updateM&mid=${m.mid}&mcnt=${mcnt}">♥</a>
	 </c:if>
	 <c:if test="${mem==null}">
	 	♥
	 </c:if>
	 </h3>
	<ol><c:forEach  var="r" items="${v.rlist}">
		<li>${r.userid} >> ${r.rmsg} [${r.wdate}]
		<c:if test="${mem!=null && mem==r.userid}">
		<form action="control.jsp?action=deleteR" method="post">
		<input type="hidden" name="mcnt" value="${mcnt}">
		<input type="hidden" name="rid" value="${r.rid}">
		<input type="submit" value="댓글삭제">
		</form>
		</c:if></li>
	</c:forEach></ol>
	<c:if test="${mem!=null}">
	<form action="control.jsp?action=insertR" method="post">
	<input type="hidden" name="mid" value="${m.mid}">
	<input type="hidden" name="userid" value="${mem}">
	<input type="hidden" name="mcnt" value="${mcnt}">
		<textarea rows="3" cols="40" name="rmsg"></textarea>
		<input type="submit" value="댓글작성">
	</form>
	</c:if>
</c:forEach>