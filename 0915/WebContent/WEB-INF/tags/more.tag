<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${more eq 'mainAll'}">
<a href="control.jsp?action=mainAll&mcnt=${mcnt+1}&mem=${mem}">더보기</a>
</c:if>
<c:if test="${more eq 'more'}">
<a href="control.jsp?action=main&mcnt=${mcnt+1}&mem=${mem}">더보기</a>
</c:if>
<c:if test="${more eq 'other'}">
<a href="control.jsp?action=otherMain&mcnt=${mcnt+1}&userid=${id}">더보기</a>
</c:if>