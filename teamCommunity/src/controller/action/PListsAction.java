package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.FreeBoDAO;
import model.board.FreeBoVO;
import model.board.NoticeBoDAO;
import model.board.NoticeBoVO;
import model.board.StudyBoDAO;
import model.board.StudyBoVO;
import model.member.MemVO;

public class PListsAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=new ActionForward();
		
		String category=request.getParameter("category");
		MemVO mVO=new MemVO();
		
		if(category.equals("Notice")) {
			NoticeBoDAO nbDAO=new NoticeBoDAO();
			ArrayList<NoticeBoVO> datas=nbDAO.getNoticePostList();
			request.setAttribute("datas", datas);
		}
		else if(category.equals("Free")) {
			FreeBoDAO fbDAO=new FreeBoDAO();
			ArrayList<FreeBoVO> datas=fbDAO.getFreePostList(mVO);
			request.setAttribute("datas", datas);
		}
		else if(category.equals("Study")) {
			StudyBoDAO sbDAO=new StudyBoDAO();
			ArrayList<StudyBoVO> datas=sbDAO.getStudyPostList(mVO);
			request.setAttribute("datas", datas);
		}
		forward.setRedirect(false);
		forward.setPath("board.jsp");
		return forward;
	}
}