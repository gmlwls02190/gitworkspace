package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.MessageDAO;
import model.msg.MsgSet;
import model.msg.ReplyDAO;
import model.msg.ReplyVO;
import model.user.UserDAO;
import model.user.UserVO;

public class InsertRAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward forward= null;
		
		String mid=request.getParameter("mid");
		String uid=request.getParameter("uid");
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
		// 1. rVO만들수있도록 get()
		// 2. rDAO로 insert()
		ReplyDAO rDAO=new ReplyDAO();
		ReplyVO rVO=new ReplyVO();
		rVO.setMid(Integer.parseInt(mid));
		rVO.setRmsg(request.getParameter("rmsg"));
		rVO.setUserid(request.getParameter("userid"));
		
		if(rDAO.insert(rVO)) {
			if(stat==null) {
				forward= new ActionForward();
				forward.setRedirect(true);
				forward.setPath("otherMain.do?mcnt="+mcnt+"&uid="+uid+"&cnt="+cnt+"&mid="+mid);
			}
			else {
				forward= new ActionForward();
				forward.setRedirect(true);
				forward.setPath("mainAll.do?mcnt="+mcnt+"&uid="+uid+"&cnt="+cnt+"&mid="+mid+"&stat="+stat);
			}
		}
		else {
			throw new IOException("메세지추가오류");
		}
		System.out.println("mcnt: "+mcnt);
		
		return forward;
	}
}