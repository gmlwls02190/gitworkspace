package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.msg.MessageDAO;
import model.msg.MessageVO;

public class EditMAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ActionForward forward= null;
		HttpSession session=request.getSession();
		
		String mem=(String)session.getAttribute("mem");
		
		MessageDAO mDAO=new MessageDAO();
		MessageVO mVO=new MessageVO();
		mVO.setMid(Integer.parseInt(request.getParameter("mid")));
		
		if(mem.equals(mDAO.selectOne(mVO).getUserid())) {
			MessageVO data=mDAO.selectOne(mVO);
			request.setAttribute("data", data);
			forward= new ActionForward();
			forward.setRedirect(false);
			forward.setPath("editM.jsp");
		}
		else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('아이디불일치');history.go(-1);</script>");
		}
		
		System.out.println("editM: "+request.getParameter("mid"));
		return forward;
	}
}