<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
					<td colspan="2" align="right"><input type="button" value="회원가입" onClick="reg()"><input type="submit" value="로그인"></td>
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