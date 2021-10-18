package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.testmember.TestMemberDAO;
import model.testmember.TestMemberVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=null;
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		TestMemberDAO mDAO=new TestMemberDAO();
		TestMemberVO mVO=new TestMemberVO();
		mVO.setId(id);
		mVO.setPw(pw);
		
		if(mDAO.getMem(mVO)!=null) {
			if(mDAO.getMem(mVO).getPw().equals(pw)) {
				HttpSession session=request.getSession();
				TestMemberVO data=mDAO.getMem(mVO);
				session.setAttribute("mem", data);
				forward= new ActionForward();
				forward.setRedirect(true);
				forward.setPath("main.do");
			}
			else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>alert('Wrong pw!');history.go(-1);</script>");				
			}
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>alert('Wrong id!');history.go(-1);</script>");
		}
		return forward;
	}

}
