<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${more eq 'mainAll'}">
	<c:if test="${cnt < memcnt}">
	<li><a href="mainAll.do?mcnt=${mcnt+1}&mem=${mem}&cnt=${cnt+1}&stat=${stat}">더보기</a></li>
	</c:if>
</c:if>
<c:if test="${more eq 'more'}">
	<c:if test="${cnt < memcnt}">
	<li><a href="main.do?mcnt=${mcnt+1}&mem=${mem}&cnt=${cnt+1}">더보기</a></li>
	</c:if>
</c:if>
<c:if test="${more eq 'other'}">
	<c:if test="${cnt < idcnt}">
	<li><a href="otherMain.do?mcnt=${mcnt+1}&userid=${id}&cnt=${cnt+1}">더보기</a></li>
	</c:if>
</c:if>