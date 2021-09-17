package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.MessageDAO;
import model.msg.MessageVO;

public class DeleteMAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ActionForward forward= new ActionForward();
		
		String mid=request.getParameter("mid");
		
		System.out.println("mid: "+mid);
		
		MessageDAO mDAO=new MessageDAO();
		MessageVO mVO=new MessageVO();
		mVO.setMid(Integer.parseInt(mid));
		mDAO.delete(mVO);
		
		forward.setRedirect(true);
		forward.setPath("main.do");
		
		return forward;
	}
}
