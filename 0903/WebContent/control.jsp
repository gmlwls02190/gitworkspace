<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"
	import="java.util.*, model.member.MemberVO"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="memDAO" class="model.member.MemberDAO" />
<jsp:useBean id="memVO" class="model.member.MemberVO" />
<jsp:setProperty property="*" name="memVO" />

<%
	String action = request.getParameter("action");
	if (action.equals("login")) {
		if (memDAO.checkMem(memVO)) {
			session.setAttribute("mem", memDAO.getMemData(memVO).getMname());
			response.sendRedirect("control.jsp?action=main");
		}
		else {
			System.out.println(session.getAttribute("mem"));
			response.sendRedirect("control.jsp?action=main");
		}
	}
	else if (action.equals("main")) {
		// 로그인유효성검사 통과후 메인
		ArrayList<MemberVO> datas = memDAO.getMemList();
		request.setAttribute("datas", datas);
		pageContext.forward("main.jsp");
	}
	else if (action.equals("logout")) {
		// 세션단위로 가지고 있던 멤버정보 초기화
		session.invalidate();
		response.sendRedirect("control.jsp?action=main");
	}
	else if (action.equals("reg")) {
		// 멤버 DB에 정보추가
		if (memDAO.insertMem(memVO)) {
			response.sendRedirect("login.jsp");
		}
		else {
			throw new Exception("회원가입 오류 발생!");
		}
	}
%>