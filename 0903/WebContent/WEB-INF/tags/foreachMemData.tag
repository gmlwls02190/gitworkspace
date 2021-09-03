<%@ tag language="java" pageEncoding="UTF-8" import="java.util.*, model.member.MemberVO"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="memDAO" class="model.member.MemberDAO"/>
<jsp:useBean id="memVO" class="model.member.MemberVO"/>
<jsp:setProperty property="*" name="memVO"/>
<%
	for(MemberVO vo: (ArrayList<MemberVO>)datas){
		%>
		<tr>
			<td><%=vo.getMname()%></td>
			<td><%=vo.getMid()%></td>
			<td><%=vo.getMpw()%></td>
		</tr>
		<%
		}
%>