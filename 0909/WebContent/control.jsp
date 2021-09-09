<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.bank1.*,model.bank2.*,java.util.*"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="b1DAO" class="model.bank1.Bank1DAO"/>
<jsp:useBean id="b1VO" class="model.bank1.Bank1VO"/>
<jsp:setProperty property="*" name="b1VO"/>

<jsp:useBean id="b2DAO" class="model.bank2.Bank2DAO"/>
<jsp:useBean id="b2VO" class="model.bank2.Bank2VO"/>
<jsp:setProperty property="*" name="b2VO"/>
<%
	String action=request.getParameter("action");

	if(action.equals("main")){
		Bank1VO b1=b1DAO.getB1One();
		Bank2VO b2=b2DAO.getB2One();
		session.setAttribute("b1", b1);
		session.setAttribute("b2", b2);
		pageContext.forward("main.jsp");
	}
	else if(action.equals("trans1")){
		if(b1DAO.trans1(Integer.parseInt(request.getParameter("bal")))){
			response.sendRedirect("control.jsp?action=main");
		}
		else{
			response.sendRedirect("control.jsp?action=main");
		}
	}
	else if(action.equals("trans2")){
		if(b2DAO.trans1(Integer.parseInt(request.getParameter("bal")))){
			response.sendRedirect("control.jsp?action=main");
		}
		else{
			response.sendRedirect("control.jsp?action=main");
		}
	}
%>