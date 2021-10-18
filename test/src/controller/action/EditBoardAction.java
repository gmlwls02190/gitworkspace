package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.testboard.TestBoardDAO;
import model.testboard.TestBoardVO;

public class EditBoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=new ActionForward();
		int bid=Integer.parseInt(request.getParameter("bid"));
		
		TestBoardDAO bDAO=new TestBoardDAO();
		TestBoardVO bVO=new TestBoardVO();
		bVO.setBid(bid);
		
		TestBoardVO data=bDAO.getBoard(bVO);
		
		request.setAttribute("data", data);
		forward.setRedirect(false);
		forward.setPath("editBoard.jsp");
		
		return forward;
	}

}
