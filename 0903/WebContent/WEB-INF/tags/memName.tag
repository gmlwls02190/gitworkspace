<%@ tag language="java" pageEncoding="UTF-8"%>
<jsp:useBean id="memDAO" class="model.member.MemberDAO"/>
<jsp:useBean id="memVO" class="model.member.MemberVO"/>
<jsp:setProperty property="*" name="memVO"/>

<%=session.getAttribute("mem") %>