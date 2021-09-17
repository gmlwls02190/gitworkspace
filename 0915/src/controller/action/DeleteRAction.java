package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.msg.ReplyDAO;
import model.msg.ReplyVO;

public class DeleteRAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ActionForward forward= null;
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		String mem=(String)session.getAttribute("mem");
		String uid=request.getParameter("uid");
		String rid=request.getParameter("rid");
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
		
		ReplyDAO rDAO=new ReplyDAO();
		ReplyVO rVO=new ReplyVO();
		rVO.setRid(Integer.parseInt(rid));
		rVO.setUserid(uid);
		
		if(mem.equals(rDAO.selectOne(rVO).getUserid())) {
			if(rDAO.delete(rVO)) {
				if(stat==null) {
					forward= new ActionForward();
					forward.setRedirect(true);
					forward.setPath("otherMain.do?rid="+rid+"&mcnt="+mcnt+"&cnt="+cnt+"&uid="+uid);
				}
				else {
					forward= new ActionForward();
					forward.setRedirect(true);
					forward.setPath("mainAll.do?rid="+rid+"&mcnt="+mcnt+"&cnt="+cnt+"&stat="+stat);
				}
			}
			else {
				out.println("<script>alert('삭제오류');history.go(-1);</script>");
			}
		}
		else {
			out.println("<script>alert('아이디불일치');history.go(-1);</script>");
		}
		
		return forward;
	}
}