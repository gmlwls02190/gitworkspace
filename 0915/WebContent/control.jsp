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
	System.out.println("=========");	
	System.out.println("컨트롤시작");
	System.out.println("=========");
	String action=request.getParameter("action");
	String url="main.jsp?";
	String url2="control.jsp?action=mainAll";
	String url3="control.jsp?action=otherMain";
	String mcntt=request.getParameter("mcnt");
	String id=request.getParameter("userid");
	String uid=request.getParameter("uid");
	String rid=request.getParameter("rid");
	String mid=request.getParameter("mid");
	String stat=request.getParameter("stat");
	request.setAttribute("stat", stat);
	System.out.println("stat: "+stat);
	int mcnt=1;
	if(mcntt!=null){
		mcnt=Integer.parseInt(mcntt);
	}
	url= url+ "&mcnt="+mcnt;
	url2= url2+ "&mcnt="+mcnt;
	url3= url3+ "&mcnt="+mcnt;
	String mem=(String)session.getAttribute("mem");
	if(mem!=null){
		url2= url2+ "&mem="+mem;
	}
	if(id!=null){
		url= url+ "&mem="+id;
		url3= url3+ "&mem="+id;
	}
	String cntt=request.getParameter("cnt");
	int cnt=1;
	if(cntt!=null){
		cnt=Integer.parseInt(cntt);
	}
	System.out.println(cnt);
	url= url+ "&cnt="+cnt;
	url3= url3+ "&cnt="+cnt;
	System.out.println("action:"+action);
	
	if(action.equals("main")){
		if(session.getAttribute("mem")==null){
			ArrayList<MsgSet> datas=mDAO.selectAll(mem, mcnt);
			ArrayList<UserVO> newUsers=uDAO.selectAll();
			session.setAttribute("more", "mainAll");
			request.setAttribute("datas", datas);
			request.setAttribute("newUsers", newUsers);
			request.setAttribute("mcnt", mcnt);
			int memcnt=mDAO.selectTestCount(mem);
			request.setAttribute("memcnt", memcnt);
			request.setAttribute("cnt", cnt);
			
			pageContext.forward("main.jsp");
		}
		else{
			ArrayList<MsgSet> datas=mDAO.selectAll(mem, mcnt);
			ArrayList<UserVO> newUsers=uDAO.selectAll();
			
			request.setAttribute("datas", datas);
			request.setAttribute("newUsers", newUsers);
			request.setAttribute("mcnt", mcnt);
			session.setAttribute("more", "more");
			int memcnt=mDAO.selectTestCount(mem);
			request.setAttribute("memcnt", memcnt);
			request.setAttribute("cnt", cnt);
			
			pageContext.forward("main.jsp");
		}
		
	}
	else if(action.equals("otherMain")){
		if(uid!=null){
			System.out.println("=============");
			ArrayList<MsgSet> datas=mDAO.selectAll(uid, mcnt);
			ArrayList<UserVO> newUsers=uDAO.selectAll();
			request.setAttribute("id", id);
			request.setAttribute("datas", datas);
			request.setAttribute("newUsers", newUsers);
			request.setAttribute("mcnt", mcnt);
			session.setAttribute("more", "other");
			int idcnt=mDAO.selectTestCount(uid);
			request.setAttribute("idcnt", idcnt);
			request.setAttribute("cnt", cnt);
			pageContext.forward(url);
		}
		else{
			System.out.println("=============");
			ArrayList<MsgSet> datas=mDAO.selectAll(id, mcnt);
			ArrayList<UserVO> newUsers=uDAO.selectAll();
			request.setAttribute("id", id);
			request.setAttribute("datas", datas);
			request.setAttribute("newUsers", newUsers);
			request.setAttribute("mcnt", mcnt);
			session.setAttribute("more", "other");
			int idcnt=mDAO.selectTestCount(id);
			request.setAttribute("idcnt", idcnt);
			request.setAttribute("cnt", cnt);
			pageContext.forward(url);
		}
	}
	else if(action.equals("mainAll")){
		ArrayList<MsgSet> datas=mDAO.selectAll(null, mcnt);
		ArrayList<UserVO> newUsers=uDAO.selectAll();
		session.setAttribute("more", "mainAll");
		request.setAttribute("datas", datas);
		request.setAttribute("newUsers", newUsers);
		request.setAttribute("mcnt", mcnt);
		int memcnt=mDAO.selectTestCount(null);
		request.setAttribute("memcnt", memcnt);
		request.setAttribute("cnt", cnt);
		
		pageContext.forward("main.jsp");
	}
	else if(action.equals("login")){
		if(uDAO.login(uVO)!=null){
			String data=uDAO.login(uVO).getUserid();
			session.setAttribute("mem", data);
			response.sendRedirect(url2);
		}
		else{
			/* System.out.println(uVO);
			System.out.println(uDAO.login(uVO)); */
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
		/* System.out.println(mVO); */
		mDAO.update(mVO);
		System.out.println("cnt: "+cnt);
		if(stat==null){
			response.sendRedirect("control.jsp?action=otherMain&userid="+id+"&mcnt="+mcnt+"&cnt="+cnt);
		}
		else{
			response.sendRedirect("control.jsp?action=mainAll&userid="+id+"&mcnt="+mcnt+"&cnt="+cnt+"&stat="+stat);
		}
	}
	else if(action.equals("deleteM")){
		mDAO.delete(mVO);
		response.sendRedirect("control.jsp?action=main");
	}
	else if(action.equals("insertR")){
		if(rDAO.insert(rVO)){
			System.out.println("=================");
			if(stat==null){
				response.sendRedirect("control.jsp?action=otherMain&mcnt="+mcnt+"&uid="+uid+"&cnt="+cnt+"&mid="+mid);
			}
			else{
				response.sendRedirect("control.jsp?action=mainAll&mcnt="+mcnt+"&uid="+uid+"&cnt="+cnt+"&mid="+mid+"&stat="+stat);
			}
		}
		else{
			out.println("<script>alert('추가오류');history.go(-1);</script>");
		}
	}
	else if(action.equals("deleteR")){
		if(mem.equals(rDAO.selectOne(rVO).getUserid())){
			if(rDAO.delete(rVO)){
				if(stat==null){
					System.out.println("uid: "+uid);
					response.sendRedirect("control.jsp?action=otherMain&rid="+rid+"&mcnt="+mcnt+"&cnt="+cnt+"&uid="+uid);
				}
				else{
					response.sendRedirect("control.jsp?action=mainAll&rid="+rid+"&mcnt="+mcnt+"&cnt="+cnt+"&stat="+stat);
				}
			}
			else{
				out.println("<script>alert('삭제오류');history.go(-1);</script>");
			}
		}
		else{
			out.println("<script>alert('아이디불일치');history.go(-1);</script>");
		}
	}
	else if(action.equals("insertU")){
		if(uDAO.insert(uVO)){
			out.println("<script>window.close();</script>");
		}
		else{
			out.println("<script>alert('회원가입오류');history.go(-1);</script>");
		}
	}
%>