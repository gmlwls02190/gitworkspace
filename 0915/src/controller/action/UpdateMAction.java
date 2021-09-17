package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.MessageDAO;
import model.msg.MessageVO;

public class UpdateMAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ActionForward forward= null;
		
		String id=request.getParameter("userid");
		String stat=request.getParameter("stat");
		String mcntt=request.getParameter("mcnt");
		/*String favcount=request.getParameter("favcount");
		String replycount=request.getParameter("replycount");*/
		String mid=request.getParameter("mid");
		int mcnt=1;
		if(mcntt!=null){
			mcnt=Integer.parseInt(mcntt);
		}
		String cntt=request.getParameter("cnt");
		int cnt=1;
		if(cntt!=null){
			cnt=Integer.parseInt(cntt);
		}
		System.out.println("==================");
		/*System.out.println("fav: "+favcount);
		System.out.println("re: "+replycount);*/
		MessageDAO mDAO= new MessageDAO();
		MessageVO mVO= new MessageVO();
		mVO.setMid(Integer.parseInt(mid));
		mVO.setUserid(id);
		/*mVO.setFavcount(Integer.parseInt(favcount));
		mVO.setReplycount(Integer.parseInt(replycount));*/
		mVO.setMsg(request.getParameter("msg"));
		mDAO.update(mVO);
		if(stat==null) {
			forward= new ActionForward();
			forward.setRedirect(true);
			forward.setPath("otherMain.do?userid="+id+"&mcnt="+mcnt+"&cnt="+cnt);
		}
		else {
			forward= new ActionForward();
			forward.setRedirect(true);
			forward.setPath("mainAll.do?userid="+id+"&mcnt="+mcnt+"&cnt="+cnt+"&stat="+stat);
		}
		
		return forward;
	}
}