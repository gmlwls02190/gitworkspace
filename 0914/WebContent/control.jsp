<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.msg.*,model.user.*"%>
<jsp:useBean id="mDAO" class="model.msg.MessageDAO" />
<jsp:useBean id="rDAO" class="model.msg.ReplyDAO" />
<jsp:useBean id="uDAO" class="model.user.UserDAO" />
<jsp:useBean id="mVO" class="model.msg.MessageVO" />
<jsp:setProperty property="*" name="mVO"/>
<jsp:useBean id="rVO" class="model.msg.ReplyVO" />
<jsp:setProperty property="*" name="rVO"/>
<jsp:useBean id="uVO" class="model.user.UserVO" />
<jsp:setProperty property="*" name="uVO"/>
<%
	String action=request.getParameter("action");
	String url="control.jsp?action=main";
	String url2="control.jsp?action=mainAll";
	/* System.out.println(request.getAttribute("mcnt")+"check"); */
	String mcntt=request.getParameter("mcnt");
	int mcnt=1;
	if(mcntt!=null){
		mcnt=Integer.parseInt(mcntt);
	}
	url= url+ "&mcnt="+mcnt;
	url2= url2+ "&mcnt="+mcnt;
	String mem=(String)session.getAttribute("mem");
	if(mem!=null){
		url= url+ "&mem="+mem;
		url2= url2+ "&mem="+mem;
	}
	
	System.out.println(action);
	
	if(action.equals("main")){
		if(session.getAttribute("mem")==null){
			ArrayList<MsgSet> datas=mDAO.selectAll(mem, mcnt);
			ArrayList<UserVO> newUsers=uDAO.selectAll();
			
			request.setAttribute("datas", datas);
			request.setAttribute("newUsers", newUsers);
			request.setAttribute("mcnt", mcnt);
			
			pageContext.forward("main.jsp");
		}
		else{
			ArrayList<MsgSet> datas=mDAO.selectAll(mem, mcnt);
			ArrayList<UserVO> newUsers=uDAO.selectAll();
			
			request.setAttribute("datas", datas);
			request.setAttribute("newUsers", newUsers);
			request.setAttribute("mcnt", mcnt);
			session.setAttribute("more", "more");
			pageContext.forward("main.jsp");
		}
		
	}
	else if(action.equals("mainAll")){
		ArrayList<MsgSet> datas=mDAO.selectAll(null, mcnt);
		/* ArrayList<UserVO> newUsers=uDAO.selectAll(); */
		session.setAttribute("more", null);
		request.setAttribute("datas", datas);
		/* request.setAttribute("newUsers", newUsers); */
		request.setAttribute("mcnt", mcnt);
		
		pageContext.forward("main.jsp");
	}
	else if(action.equals("login")){
		if(uDAO.login(uVO)!=null){
			String data=uDAO.login(uVO).getUserid();
			session.setAttribute("mem", data);
			response.sendRedirect(url2);
		}
		else{
			System.out.println(uVO);
			System.out.println(uDAO.login(uVO));
			response.sendRedirect("control.jsp?action=main");
		}
	}
	else if(action.equals("logout")){
		session.invalidate();
		response.sendRedirect("control.jsp?action=main");
	}
	else if(action.equals("insertM")){
		System.out.println(mVO);
		if(mDAO.insert(mVO)){
			response.sendRedirect("control.jsp?action=main");
		}
		else{
			out.println("<script>alert('추추가오류');history.go(-1);</script>");
		}
	}
	else if(action.equals("editM")){
		if(mem==null){
			out.println("<script>alert('로그인필요');history.go(-1);</script>");
		}
		else if(mem.equals(mDAO.selectOne(mVO).getUserid())){
			MessageVO data=mDAO.selectOne(mVO);
			request.setAttribute("data", data);
			pageContext.forward("editM.jsp");
		}
		else{
			out.println("<script>alert('아이디불일치');history.go(-1);</script>");
		}
	}
	else if(action.equals("updateM")){
		System.out.println(mVO);
		mDAO.update(mVO);
		response.sendRedirect("control.jsp?action=main");
	}
	else if(action.equals("deleteM")){
		mDAO.delete(mVO);
		response.sendRedirect("control.jsp?action=main");
	}
	else if(action.equals("insertR")){
		if(rDAO.insert(rVO)){
			System.out.println("fasdfsaf");
			response.sendRedirect(url2);
		}
		else{
			out.println("<script>alert('추가오류');history.go(-1);</script>");
		}
	}
	else if(action.equals("deleteR")){
		if(mem.equals(rDAO.selectOne(rVO).getUserid())){
			if(rDAO.delete(rVO)){
				response.sendRedirect("control.jsp?action=main");
			}
			else{
				out.println("<script>alert('삭제오류');history.go(-1);</script>");
			}
		}
		else{
			out.println("<script>alert('걍오류');history.go(-1);</script>");
		}
	}
%>