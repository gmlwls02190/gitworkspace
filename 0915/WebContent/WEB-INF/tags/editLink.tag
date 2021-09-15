<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${mem!=null}">
	<a href="javascript:editM(${m.mid})">[${m.userid}]</a>
	</c:if>
	<c:if test="${mem==null}">
	[${m.userid}]
	</c:if>
	${m.userid}