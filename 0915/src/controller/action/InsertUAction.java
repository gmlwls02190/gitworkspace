package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user.UserDAO;
import model.user.UserVO;

public class InsertUAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward forward= null;
		PrintWriter out=response.getWriter();
		
		UserDAO uDAO=new UserDAO();
		UserVO uVO=new UserVO();
		uVO.setUname(request.getParameter("uname"));
		uVO.setUserid(request.getParameter("userid"));
		uVO.setUserpw(request.getParameter("userpw"));
		
		if(uDAO.insert(uVO)) {
			forward= new ActionForward();
			forward.setRedirect(false);
			forward.setPath("closeWin.jsp");
		}
		else {
			out.println("<script>alert('회원가입오류');history.go(-1);</script>");
		}
		System.out.println("name: "+request.getParameter("uname"));
		System.out.println("userid: "+request.getParameter("userid"));
		System.out.println("userpw: "+request.getParameter("userpw"));
		System.out.println("forward: "+forward);
		
		return forward;

	}

}
