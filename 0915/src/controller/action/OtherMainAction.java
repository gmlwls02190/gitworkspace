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

public class OtherMainAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward forward= new ActionForward();
		HttpSession session=request.getSession();
		
		String uid=request.getParameter("uid");
		String id=request.getParameter("userid");
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
		/*System.out.println("uid: "+uid+"||id: "+id);*/
		MessageDAO mDAO= new MessageDAO();
		UserDAO uDAO= new UserDAO();
		ArrayList<MsgSet> datas=null;
		ArrayList<UserVO> newUsers=null;
		int idcnt=0;
		
		if(uid!=null) {
			datas=mDAO.selectAll(uid, mcnt);
			newUsers=uDAO.selectAll();
			idcnt=mDAO.selectTestCount(uid);
		}
		else {
			datas=mDAO.selectAll(id, mcnt);
			newUsers=uDAO.selectAll();
			idcnt=mDAO.selectTestCount(id);
		}
		request.setAttribute("id", id);
		request.setAttribute("datas", datas);
		request.setAttribute("newUsers", newUsers);
		request.setAttribute("mcnt", mcnt);
		session.setAttribute("more", "other");
		request.setAttribute("idcnt", idcnt);
		request.setAttribute("cnt", cnt);
		
		forward.setRedirect(false);
		forward.setPath("main.jsp?mcnt="+mcnt+"&mem="+id+"&cnt"+cnt);
		return forward;
	}
}