package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.msg.MessageDAO;
import model.msg.MsgSet;
import model.user.UserDAO;
import model.user.UserVO;

public class MainAllAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ActionForward forward= new ActionForward();
		HttpSession session=request.getSession();
		
		String stat=request.getParameter("stat");
		String mcntt=request.getParameter("mcnt");
		int mcnt=1;
		if(mcntt!=null){
			mcnt=Integer.parseInt(mcntt);
		}
		String cntt=request.getParameter("cnt");
		int cnt=1;
		if(cntt!=null){
			cnt=Integer.parseInt(cntt);
		}

		MessageDAO mDAO= new MessageDAO();
		UserDAO uDAO= new UserDAO();
		ArrayList<MsgSet> datas=mDAO.selectAll(null, mcnt);
		ArrayList<UserVO> newUsers=uDAO.selectAll();
		int memcnt=mDAO.selectTestCount(null);
		
		session.setAttribute("more", "mainAll");
		request.setAttribute("datas", datas);
		request.setAttribute("newUsers", newUsers);
		request.setAttribute("mcnt", mcnt);
		request.setAttribute("memcnt", memcnt);
		request.setAttribute("cnt", cnt);
		request.setAttribute("stat", stat);
		
		forward.setRedirect(false);
		forward.setPath("main.jsp");
		return forward;
	}
}