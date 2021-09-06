<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.board.*,model.member.*" errorPage="error.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="bDAO" class="model.board.BoardDAO" />
<jsp:useBean id="bVO" class="model.board.BoardVO" />
<jsp:setProperty property="*" name="bVO"/>

<jsp:useBean id="mDAO" class="model.member.MemberDAO"/>
<jsp:useBean id="mVO" class="model.member.MemberVO" scope="session"/>
<jsp:setProperty property="*" name="mVO"/>
<%
	String action=request.getParameter("action");
	String search=request.getParameter("search");
	System.out.println(action);
	if(action.equals("main")){
		ArrayList<BoardVO> datas=bDAO.getDBList();
		request.setAttribute("datas", datas);
		/* System.out.println(datas+"datas체크"); */
		pageContext.forward("main.jsp");
	}
	else if(action.equals("login")){
		if(mDAO.getMemData(mVO)!=null){
			MemberVO data=mDAO.getMemData(mVO);
			session.setAttribute("mem", data);
			response.sendRedirect("control.jsp?action=main");
		}
		else {
			out.println("<script>alert('회원정보불일치');</script>");
			response.sendRedirect("control.jsp?action=main");
		}
		
	}
	else if(action.equals("logout")){
		session.invalidate();
		response.sendRedirect("control.jsp?action=main");
	}
	else if(action.equals("insertB")){
		if(bDAO.insertDB(bVO)){
			response.sendRedirect("control.jsp?action=main");
		}
		else{
			throw new Exception("게시글 추가 오류");
		}
	}
	else if(action.equals("editB")){
		if(bDAO.updateDB(bVO)){
			response.sendRedirect("control.jsp?action=main");
		}
		else{
			throw new Exception("게시글 수정 오류");
		}
	}
	else if(action.equals("deleteB")){
		if(bDAO.deleteDB(bVO)){
			response.sendRedirect("control.jsp?action=main");
		}
		else{
			throw new Exception("게시글 삭제 오류");
		}
	}
	else if(action.equals("insertMem")){
		if(mDAO.insertMem(mVO)){
			response.sendRedirect("control.jsp?action=main");
		}
		else{
			throw new Exception("회원 추가 오류");
		}
	}
	else if(action.equals("editMem")){
		if(mDAO.updateMem(mVO)){
			out.println("<script>alert('회원정보변경으로 인해 다시 로그인해주세요.');</script>");
			response.sendRedirect("control.jsp?action=logout");
		}
		else{
			throw new Exception("회원 수정 오류");
		}
	}
	else if(action.equals("deleteMem")){
		if(mDAO.deleteMem(mVO)){
			response.sendRedirect("control.jsp?action=logout");
		}
		else{
			throw new Exception("회원 삭제 오류");
		}
	}
	else if(action.equals("search")){
		ArrayList<BoardVO> datas=bDAO.searchDBList(search);
		request.setAttribute("datas", datas);
		pageContext.forward("main.jsp");
	}
	else if(action.equals("myPage")){
		ArrayList<BoardVO> datas=bDAO.getMyDBList(mVO);
		request.setAttribute("datas", datas);
		pageContext.forward("myPage.jsp");
	}
	else if(action.equals("goEditB")){
		BoardVO data=bDAO.getDBData(bVO);
		request.setAttribute("data", data);
		pageContext.forward("EditB.jsp");
	}
	else if(action.equals("goEditMem")){
		MemberVO data=mDAO.getMemData(mVO);
		request.setAttribute("data", data);
		pageContext.forward("memEdit.jsp");
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>