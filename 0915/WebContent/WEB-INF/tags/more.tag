<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${more eq 'mainAll'}">
	<c:if test="${cnt < memcnt}">
	<li><a href="control.jsp?action=mainAll&mcnt=${mcnt+1}&mem=${mem}&cnt=${cnt+1}&stat=${stat}">더보기</a></li>
	</c:if>
<%-- <a href="control.jsp?action=mainAll&mcnt=${mcnt+1}&mem=${mem}&cnt=${cnt+1}">더보기</a> --%>
</c:if>
<c:if test="${more eq 'more'}">
	<c:if test="${cnt < memcnt}">
	<li><a href="control.jsp?action=main&mcnt=${mcnt+1}&mem=${mem}&cnt=${cnt+1}">더보기</a></li>
	</c:if>
<%-- <a href="control.jsp?action=main&mcnt=${mcnt+1}&mem=${mem}&cnt=${cnt+1}">더보기</a> --%>
</c:if>
<c:if test="${more eq 'other'}">
	<c:if test="${cnt < idcnt}">
	<li><a href="control.jsp?action=otherMain&mcnt=${mcnt+1}&userid=${id}&cnt=${cnt+1}">더보기</a></li>
	</c:if>
<%-- <a href="control.jsp?action=otherMain&mcnt=${mcnt+1}&userid=${id}&cnt=${cnt+1}">더보기</a> --%>
</c:if>