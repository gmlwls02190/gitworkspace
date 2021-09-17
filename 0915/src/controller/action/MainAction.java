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

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		ActionForward forward= null;
		MessageDAO mDAO= new MessageDAO();
		UserDAO uDAO= new UserDAO();
		
		String mem=(String)session.getAttribute("mem");
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
		ArrayList<MsgSet> datas=null;
		ArrayList<UserVO> newUsers=null;
		int memcnt=0;
		
		if(session.getAttribute("mem")==null) {
			datas=mDAO.selectAll(mem, mcnt);
			newUsers=uDAO.selectAll();
			memcnt=mDAO.selectTestCount(mem);
			session.setAttribute("more", "mainAll");
		}
		else {
			datas=mDAO.selectAll(mem, mcnt);
			newUsers=uDAO.selectAll();
			memcnt=mDAO.selectTestCount(mem);
			session.setAttribute("more", "more");
		}
		request.setAttribute("datas", datas);
		request.setAttribute("newUsers", newUsers);
		request.setAttribute("mcnt", mcnt);
		request.setAttribute("memcnt", memcnt);
		request.setAttribute("cnt", cnt);
		
		forward= new ActionForward();
		forward.setRedirect(false);
		forward.setPath("main.jsp");
		
		return forward;
	}
	
}