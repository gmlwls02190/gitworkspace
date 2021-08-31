<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,model.message.*,model.wuser.*"
	errorPage="error.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="messageDAO" class="model.message.MessageDAO" />
<jsp:useBean id="messageVO" class="model.message.MessageVO" />
<jsp:setProperty property="*" name="messageVO" />

<jsp:useBean id="wuserDAO" class="model.wuser.WuserDAO" scope="application" />
<jsp:useBean id="wuserVO" class="model.wuser.WuserVO"  scope="session"/>
<jsp:setProperty property="*" name="wuserVO" />
<%
	// 컨트롤러를 호출했을때의 요청 파라미터를 분석
	String action = request.getParameter("action");
	System.out.println(action);
	if (action.equals("list")) {
		// list.jsp
		if (wuserDAO.checkUser(wuserVO)) {
			ArrayList<MessageVO> datas = messageDAO.getDBList();
			request.setAttribute("datas", datas); // 1.set 다음페이지에서필요해서  2.request application을 사용해도 되나 서버부담을 덜어주기위해
			pageContext.forward("list.jsp");
		}
		else {
			out.println("<script>alert('올바르지 않은 계정입니다!');history.go(-1);</script>");
		}
	}
	else if (action.equals("insert")) {
		// dao.insert()
		if (wuserDAO.getUserData(wuserVO).getUname().equals(request.getParameter("writer"))) {
			if (messageDAO.insertDB(messageVO)) {
				response.sendRedirect("control.jsp?action=list");
			}
			else {
				throw new Exception("DB 추가 오류 발생!");
			}
		}
		else {
			out.println("<script>alert('작성자명이 올바르지 않습니다!');history.go(-1);</script>");
		}

	}
	else if (action.equals("delete")) {
		// dao.delete()
		if (messageDAO.deleteDB(messageVO)) {
			response.sendRedirect("control.jsp?action=list");
		}
		else {
			throw new Exception("DB 삭제 오류 발생!");
		}
	}
	else if (action.equals("update")) {
		// dao.update()userVO.(messageDAO.updateDB(messageVO)) {
		// pageContext.forward("control.jsp?action=list"); 이렇게 안쓰는 이유는 스프링가면 알게됨
		if (wuserDAO.getUserData(wuserVO).getUname().equals(request.getParameter("writer"))) {
			if (messageDAO.updateDB(messageVO)) {
				response.sendRedirect("control.jsp?action=list");
			}
			else {
				throw new Exception("DB 수정 오류 발생!");
			}
		}
		else{
			out.println("<script>alert('작성자명이 올바르지 않습니다!');history.go(-1);</script>");
		}
		
	}
		else if (action.equals("edit")) {
		// getDBData()
		// 사용자가 잘못된  mnum를 건네는 경우는 없다!
		// -> 오류페이지로 처리!
		System.out.println("접속중 아이디:"+wuserDAO.getUserData(wuserVO).getUserid());
		System.out.println("게시글 아이디:"+messageDAO.getDBData(messageVO).getUserid());
		if (request.getParameter("user").equals(messageDAO.getDBData(messageVO).getUserid()) && request.getParameter("user").equals(wuserDAO.getUserData(wuserVO).getUserid())) {
			MessageVO data = messageDAO.getDBData(messageVO);
			request.setAttribute("data", data);
			pageContext.forward("edit.jsp");
		}
		else {
			out.println("<script>alert('수정권한이 없습니다!');history.go(-1);</script>");
		}
		
		
		/* if(session.getAttribute("mem")==null){
			// 로그인 안함 뒤로가기
		}
		else{
			WuserVO vo=(WuserVO)session.getAttribute("mem");
			if(vo.getUserpw().equals(request.getParameter("userpw"))){
				MessageVO data=messageDAO.getDBData(messageVO);
				request.setAttribute("data", data);
				pageContext.forward("edit.jsp");
			}
			else{
				// 입력오류
			}
		} */
		
	}
	else if (action.equals("login")) {
		pageContext.forward("login.jsp");
	}
	else if (action.equals("reg")) {
		if (wuserDAO.insertUser(wuserVO)) {
			response.sendRedirect("control.jsp?action=login");
		}
		else {
			throw new Exception("회원가입 오류 발생!");
		}
	}
	else if (action.equals("logout")) {
		session.invalidate();
		pageContext.forward("login.jsp");
	}
	else {
		out.println("<script>alert('파라미터 확인!');history.go(-1);</script>");
		// throw new Exception("파라미터 확인");
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컨트롤러</title>
</head>
<body>

</body>
</html>