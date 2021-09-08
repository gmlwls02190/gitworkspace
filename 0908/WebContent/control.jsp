<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.product.*" errorPage="error.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="pDAO" class="model.product.ProductDAO" />
<jsp:useBean id="pVO" class="model.product.ProductVO" />
<jsp:setProperty property="*" name="pVO"/>
<%
	String action=request.getParameter("action");

	if(action.equals("main")){
		ArrayList<ProductVO> datas=pDAO.getAllDB();
		request.setAttribute("datas", datas);
		pageContext.forward("main.jsp");
	}
	else if(action.equals("showOne")){
		ProductVO data=pDAO.getOneDB(pVO);
		request.setAttribute("data", data);
		pageContext.forward("showOne.jsp");
	}
	else if(action.equals("insertP")){
		if(pDAO.insertP(pVO)){
			response.sendRedirect("control.jsp?action=main");
		}
		else{
			throw new Exception("추가 오류");
		}
	}
	else if(action.equals("editP")){
		ProductVO data=pDAO.getOneDB(pVO);
		request.setAttribute("data", data);
		pageContext.forward("editP.jsp");
	}
	else if(action.equals("updateP")){
		if(pDAO.updateP(pVO)){
			response.sendRedirect("control.jsp?action=main");
		}
		else{
			throw new Exception("수정 오류");
		}
	}
	else if(action.equals("deleteP")){
		if(pDAO.deleteP(pVO)){
			response.sendRedirect("control.jsp?action=main");
		}
		else{
			throw new Exception("삭제 오류");
		}
	}
%>