package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.testboard.TestBoardDAO;
import model.testboard.TestBoardVO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		String id=request.getParameter("id");
		
		TestBoardDAO bDAO=new TestBoardDAO();
		TestBoardVO bVO=new TestBoardVO();
		bVO.setId(id);
		ArrayList<TestBoardVO> datas=bDAO.getBoardList(bVO);
		
		request.setAttribute("datas", datas);
		forward.setRedirect(false);
		forward.setPath("main.jsp");
		
		return forward;
	}

}
