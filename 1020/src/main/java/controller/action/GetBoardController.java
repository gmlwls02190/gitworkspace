package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.board.BoardDAO;
import model.board.BoardVO;

public class GetBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id=Integer.parseInt(request.getParameter("id"));
		
		BoardDAO bdao=new BoardDAO();
		BoardVO bvo=new BoardVO();
		bvo.setId(id);
		
		BoardVO data=bdao.getBoard(bvo);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("data", data);
		mav.setViewName("board");
		
		return mav;
	}

}
