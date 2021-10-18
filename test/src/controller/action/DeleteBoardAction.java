package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.testboard.TestBoardDAO;
import model.testboard.TestBoardVO;

public class DeleteBoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=null;
		int bid=Integer.parseInt(request.getParameter("bid"));
		
		TestBoardDAO bDAO=new TestBoardDAO();
		TestBoardVO bVO=new TestBoardVO();
		bVO.setBid(bid);
		
		if(bDAO.deleteBoard(bVO)) {
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("main.do");			
		}
		else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('deleteBoard error!');history.go(-1);</script>");
		}
		return forward;
	}

}
