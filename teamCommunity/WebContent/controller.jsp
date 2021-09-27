<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.board.*,model.comment.*,model.mypage.*,model.member.*"%>
<!-- ============================DAO===================================== -->
<jsp:useBean id="fbDAO" class="model.board.FreeBoDAO"/>
<jsp:useBean id="fcDAO" class="model.comment.FreeCoDAO"/>
<jsp:useBean id="nbDAO" class="model.board.NoticeBoDAO"/>
<jsp:useBean id="ncDAO" class="model.comment.NoticeCoDAO"/>
<jsp:useBean id="sbDAO" class="model.board.StudyBoDAO"/>
<jsp:useBean id="scDAO" class="model.comment.StudyCoDAO"/>
<jsp:useBean id="cDAO" class="model.mypage.ConcermDAO"/>
<jsp:useBean id="mDAO" class="model.member.MemDAO"/>
<!-- ============================VO===================================== -->
<jsp:useBean id="fbVO" class="model.board.FreeBoVO"/>
<jsp:setProperty property="*" name="fbVO"/>
<jsp:useBean id="fcVO" class="model.comment.FreeCoVO"/>
<jsp:setProperty property="*" name="fcVO"/>
<jsp:useBean id="nbVO" class="model.board.NoticeBoVO"/>
<jsp:setProperty property="*" name="nbVO"/>
<jsp:useBean id="ncVO" class="model.comment.NoticeCoVO"/>
<jsp:setProperty property="*" name="ncVO"/>
<jsp:useBean id="sbVO" class="model.board.StudyBoVO"/>
<jsp:setProperty property="*" name="sbVO"/>
<jsp:useBean id="scVO" class="model.comment.StudyCoVO"/>
<jsp:setProperty property="*" name="scVO"/>
<jsp:useBean id="cVO" class="model.mypage.ConcermVO"/>
<jsp:setProperty property="*" name="cVO"/>
<jsp:useBean id="mVO" class="model.member.MemVO"/>
<jsp:setProperty property="*" name="mVO"/>
<%
	String action=request.getParameter("action");
	String category=request.getParameter("category");
	String check=request.getParameter("check");
	String memid=(String)session.getAttribute("mem");
	String stat=request.getParameter("stat");
	
	String myurl="mypage.jsp?category="+category;
	String url="controller.jsp?action=main";
	String burl="board.jsp?category="+category;
	
	if(stat==null){
		stat="Free";
	}
	myurl=myurl+"&stat="+stat;
	if(memid!=null){
		url= url+"&mid="+memid;
	}
	System.out.println("================");
	System.out.println("memid: "+memid);
	System.out.println("mid: "+mVO.getMid());
	
//==========Action============================================================================
	if(action.equals("main")){
		pageContext.forward("main.jsp");
	}
	else if(action.equals("pLists")){
		if(category.equals("Notice")){
			ArrayList<NoticeBoVO> datas=nbDAO.getNoticePostList();
			request.setAttribute("datas", datas);
		}
		else if(category.equals("Free")){
			ArrayList<FreeBoVO> datas=fbDAO.getFreePostList(null);
			request.setAttribute("datas", datas);
		}
		else if(category.equals("Study")){
			ArrayList<StudyBoVO> datas=sbDAO.getStudyPostList(null);
			request.setAttribute("datas", datas);
		}
		pageContext.forward(burl);
	}
	else if(action.equals("login")){
		if(mDAO.SelectOne(mVO)!=null){
			MemVO mem=mDAO.SelectOne(mVO);
			session.setAttribute("mem", mem.getMid());
			response.sendRedirect(url);
		}
		else{
			out.println("<script>alert('로그인확인');history.go(-1);</script>");
		}
	}
	else if(action.equals("logout")){
		session.invalidate();
		response.sendRedirect("controller.jsp?action=main");
	}
	else if(action.equals("join")){
		if(mDAO.InsertDB(mVO)){
			response.sendRedirect("controller.jsp?action=main");
		}
		else{
			out.println("<script>alert('회원가입확인');history.go(-1);</script>");
		}
	}
	else if(action.equals("checkid")){
		if(mDAO.SelectOne(mVO)==null){
			out.println("<script>alert('아이디사용가능');history.go(-1);</script>");
		}
		else{
			out.println("<script>alert('아이디사용불가');history.go(-1);</script>");
		}
	}
	else if(action.equals("myPage")){
		if(category.equals("myBoard")){
			if(stat.equals("Free")){
				ArrayList<FreeBoVO> datas=fbDAO.getFreePostList(mVO);
				request.setAttribute("datas", datas);
			}
			else if(stat.equals("Study")){
				ArrayList<StudyBoVO> datas=sbDAO.getStudyPostList(mVO);
				request.setAttribute("datas", datas);
			}
			else{
				out.println("<script>alert('마이페이지게시글확인');history.go(-1);</script>");
			}
			pageContext.forward(myurl);
		}
		else if(category.equals("checkUser")){
			if(mDAO.SelectOne(mVO).getMpw().equals(mVO.getMpw())){
				System.out.println(myurl);
				MemVO data=mDAO.SelectOne(mVO);
				request.setAttribute("data", data);
				pageContext.forward(myurl+"&check=t");
			}
			else{
				System.out.println("check");
				pageContext.forward(myurl+"&check=f");
			}
		}
		else if(category.equals("favBoard")){
			
			pageContext.forward(myurl);
		}
		else {
			out.println("<script>alert('마이페이지확인');history.go(-1);</script>");
		}
	}
	else if(action.equals("editUser")){
		if(mDAO.UpdateDB(mVO)){
			response.sendRedirect("controller.jsp?action=logout");
		}
		else{
			out.println("<script>alert('회원수정확인');history.go(-1);</script>");
		}
	}
	else if(action.equals("quitUser")){
		if(mDAO.DeleteDB(mVO)){
			response.sendRedirect("controller.jsp?action=logout");
		}
		else{
			out.println("<script>alert('회원탈퇴확인');history.go(-1);</script>");
		}
	}
	else if(action.equals("")){
		
	}
%>