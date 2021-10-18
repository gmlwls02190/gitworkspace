package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.testboard.TestBoardDAO;
import model.testboard.TestBoardVO;

public class UpdateBoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=null;
		int bid=Integer.parseInt(request.getParameter("bid"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		TestBoardDAO bDAO=new TestBoardDAO();
		TestBoardVO bVO=new TestBoardVO();
		bVO.setBid(bid);
		bVO.setContent(content);
		bVO.setTitle(title);
		
		if(bDAO.updateBoard(bVO)) {
			forward= new ActionForward();
			forward.setRedirect(true);
			forward.setPath("main.do");
		}
		else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('updateBoard error!');history.go(-1);</script>");
		}
		return forward;
	}

}
