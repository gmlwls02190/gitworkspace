<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${mem!=null}">
	<form action="control.jsp?action=insertR" method="post">
	<input type="hidden" name="mid" value="${m.mid}">
	<input type="hidden" name="userid" value="${mem}">
		<textarea rows="3" cols="40" name="rmsg"></textarea>
		<input type="submit" value="댓글작성">
	</form>
	</c:if>