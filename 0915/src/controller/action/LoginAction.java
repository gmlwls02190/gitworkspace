package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user.UserDAO;
import model.user.UserVO;

public class LoginAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward forward= null;
		HttpSession session=request.getSession();
		
		String mem=(String)session.getAttribute("mem");
		// 1. uVO를 만들수있는 인자들을 get()
		// 2. 로그인 성공,실패여부 판단
		// 3. 성공: 세션 / 실패: 스크립트 출력
		UserDAO uDAO=new UserDAO();
		UserVO uVO=new UserVO();
		uVO.setUserid(request.getParameter("userid"));
		uVO.setUserpw(request.getParameter("userpw"));
		
		String mcntt=request.getParameter("mcnt");
		int mcnt=1;
		if(mcntt!=null){
			mcnt=Integer.parseInt(mcntt);
		}
		
		if(uDAO.login(uVO)!=null) {
			session.setAttribute("mem", uVO.getUserid());
			request.setAttribute("mcnt", mcnt);
			forward= new ActionForward();
			forward.setRedirect(true);
			forward.setPath("mainAll.do?mcnt="+mcnt+"&mem="+mem);
		}
		else {
			PrintWriter out=response.getWriter();
			out.println("<script>alert('로그인 실패!');history.go(-1);</script>");
		}
		
		return forward;
	}
}