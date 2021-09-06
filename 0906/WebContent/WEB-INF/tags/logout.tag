<%@ tag language="java" pageEncoding="UTF-8"%>
<jsp:useBean id="mDAO" class="model.member.MemberDAO"/>
<jsp:useBean id="mVO" class="model.member.MemberVO" scope="session"/>
<jsp:setProperty property="*" name="mVO"/>

<form action="control.jsp" method="post" name="form7">
		<input type="hidden" name="action" value="myPage">
			<input type="submit" value="마이페이지">
			<input type="button" value="로그아웃" onClick="logout()">
			<input type="button" value="글등록" onClick="insertB()">
		</form>