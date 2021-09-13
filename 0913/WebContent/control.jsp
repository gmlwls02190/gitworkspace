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
	String mcntt=request.getParameter("mcnt");
	int mcnt=2;
	if(mcntt!=null){
		mcnt=Integer.parseInt(mcntt);
	}
	url= url+ "&mcnt="+mcnt;
	String mem=(String)session.getAttribute("mem");
	if(mem!=null){
		url= url+ "&mem="+mem;
	}
			
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
			
			pageContext.forward("main.jsp");
		}
		
	}
	else if(action.equals("login")){
		if(uDAO.login(uVO)!=null){
			String data=uDAO.login(uVO).getUserid();
			System.out.println("asd");
			session.setAttribute("mem", data);
			response.sendRedirect("control.jsp?action=main");
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
%>