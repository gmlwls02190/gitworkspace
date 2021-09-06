<%@ tag language="java" pageEncoding="UTF-8"%>
<jsp:useBean id="mDAO" class="model.member.MemberDAO"/>
<jsp:useBean id="mVO" class="model.member.MemberVO" scope="session"/>
<jsp:setProperty property="*" name="mVO"/>

<h4>로그인/회원가입</h4>
		<form action="control.jsp" method="post" name="form5">
		<input type="hidden" name="action" value="login">
			<table>
				<tr>
					<td>아이디</td><td><input type="text" name="userid" required></td>
				</tr>
				<tr>
					<td>비밀번호</td><td><input type="password" name="userpw" required></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="로그인"><input type="button" value="회원가입" onClick="reg()"></td>
				</tr>
			</table>
		</form>