<%@ tag language="java" pageEncoding="UTF-8" import="java.util.*"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="mem" class="model.MemberBean" />

<h2>로그인/로그아웃</h2>
<hr>
<%
	if(session.getAttribute("member")==null){
		%>
		<form method="post" name="form1" action="E.jsp">
		<table>
			<tr>
				<td><input type="text" name="userID" placeholder="아이디입력"></td>
			</tr>
			<tr>
				<td><input type="password" name="userPW"></td>
			</tr>
		</table>
		<input type="submit" value="로그인">
		
		<%
		String userID=request.getParameter("userID");
		String userPW=request.getParameter("userPW");
		/* System.out.println(userID); */
		if(userID!=null){
			if(mem.checkUser(userID, userPW)==1){
				out.println("<script>alert('로그인성공!');</script>");
				ArrayList<String> member=new ArrayList();
				member.add(userID);
				member.add(userPW);
				/* System.out.println(member); */
				session.setAttribute("member", member);
				response.sendRedirect("E.jsp");
			}
			else if(mem.checkUser(userID, userPW)==-1){
				out.println("<script>alert('비밀번호오류!');</script>");
			}
			else if(mem.checkUser(userID, userPW)==0){
				out.println("<script>alert('존재하지않는 계정!');</script>");
			}
		}
	}
	else{
		%>
		<script type="text/javascript">
			function logout(){
				res=confirm("로그아웃하시겠습니까?");
				if(res){
					<%
					/* System.out.println(session.getAttribute("member")); */
						session.invalidate();
					%>
					document.location.href="E.jsp";
				}
				else{
					return;
				}
			}
		</script>
		<input type="button" value="로그아웃" onClick="logout()">
		
		<%
	}
%>
</form>