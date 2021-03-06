<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.message.*" errorPage="error.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="messageDAO" class="model.message.MessageDAO"/>
<jsp:useBean id="messageVO" class="model.message.MessageVO"/>
<jsp:setProperty property="*" name="messageVO"/>
<%
	// 컨트롤러를 호출했을때의 요청 파라미터를 분석
	String action=request.getParameter("action");
	System.out.println(action);
	if(action.equals("list")){
		// list.jsp
		ArrayList<MessageVO> datas=messageDAO.getDBList();
		request.setAttribute("datas", datas); // 1.set 다음페이지가필요해서  2.request application을 사용해도 되나 서버부담을 덜어주기위해
		pageContext.forward("list.jsp");
	}
	else if(action.equals("insert")){
		// dao.insert()
		if(messageDAO.insertDB(messageVO)){
			response.sendRedirect("control.jsp?action=list");
		}
		else{
			throw new Exception("DB 추가 오류 발생!");
		}
	}
	else if(action.equals("delete")){
		// dao.delete()
		if(messageDAO.deleteDB(messageVO)){
			response.sendRedirect("control.jsp?action=list");
		}
		else{
			throw new Exception("DB 삭제 오류 발생!");
		}
	}
	else if(action.equals("update")){
		// dao.update()
		if(messageDAO.updateDB(messageVO)){
			// pageContext.forward("control.jsp?action=list"); 이렇게 안쓰는 이유는 스프링가면 알게됨
			response.sendRedirect("control.jsp?action=list");
		}
		else{
			throw new Exception("DB 변경 오류 발생!");
		}
	}
	else if(action.equals("edit")){
		// getDBData()
		// 사용자가 잘못된  mnum를 건네는 경우는 없다!
		// -> 오류페이지로 처리!
		MessageVO data=messageDAO.getDBData(messageVO);
		request.setAttribute("data", data);
		pageContext.forward("edit.jsp");
		
	}
	else{
		out.println("파라미터 확인");
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