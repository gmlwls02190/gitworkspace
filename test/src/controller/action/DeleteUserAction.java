package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.testmember.TestMemberDAO;
import model.testmember.TestMemberVO;

public class DeleteUserAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=null;
		HttpSession session=request.getSession();
		TestMemberVO mem=(TestMemberVO)session.getAttribute("mem");
		String id=mem.getId();
		
		TestMemberDAO mDAO=new TestMemberDAO();
		TestMemberVO mVO=new TestMemberVO();
		mVO.setId(id);
		
		if(mDAO.deleteMem(mVO)) {
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("logout.do");
		}
		else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('deleteMem error!');history.go(-1);</script>");
		}
		return forward;
	}

}
