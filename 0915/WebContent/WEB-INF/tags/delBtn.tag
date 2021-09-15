<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${mem!=null}"><input type="button" value="댓글삭제" onClick="delR(${r.rid})"></c:if>