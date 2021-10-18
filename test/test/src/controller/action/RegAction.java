package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.testmember.TestMemberDAO;
import model.testmember.TestMemberVO;

public class RegAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward= null;
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		
		TestMemberDAO mDAO=new TestMemberDAO();
		TestMemberVO mVO=new TestMemberVO();
		mVO.setId(id);
		mVO.setPw(pw);
		mVO.setName(name);
		
		if(mDAO.insertMem(mVO)) {
			forward= new ActionForward();
			forward.setRedirect(true);
			forward.setPath("main.do");
		}
		else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('insertMem error!');history.go(-1);</script>");
		}
		return forward;
	}

}
