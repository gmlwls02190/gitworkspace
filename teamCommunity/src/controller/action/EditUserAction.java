package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemDAO;
import model.member.MemVO;

public class EditUserAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=new ActionForward();
		
		MemDAO mDAO=new MemDAO();
		MemVO mVO=new MemVO();
		mVO.setMemail(request.getParameter("memail"));
		mVO.setMid(request.getParameter("mid"));
		mVO.setMname(request.getParameter("mname"));
		mVO.setMpw(request.getParameter("mpw"));
		
		forward.setRedirect(false);
		forward.setPath("logout.do");
		return forward;
	}

}
