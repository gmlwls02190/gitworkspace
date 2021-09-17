package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.msg.MessageDAO;
import model.msg.MessageVO;

public class InsertMAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ActionForward forward= null;
		
		MessageDAO mDAO= new MessageDAO();
		MessageVO mVO= new MessageVO();
		mVO.setUserid(request.getParameter("userid"));
		mVO.setMsg(request.getParameter("msg"));
		
		if(mDAO.insert(mVO)) {
			forward= new ActionForward();
			forward.setRedirect(true);
			forward.setPath("main.do");
		}
		else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('메세지추가오류');history.go(-1);</script>");
		}
		
		return forward;
	}
}