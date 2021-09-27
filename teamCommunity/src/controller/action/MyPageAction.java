package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.board.FreeBoDAO;
import model.board.FreeBoVO;
import model.board.StudyBoDAO;
import model.board.StudyBoVO;
import model.member.MemDAO;
import model.member.MemVO;

public class MyPageAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=null;
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		String memid=(String)session.getAttribute("mem");
		String category=request.getParameter("category");
		String stat=request.getParameter("stat");
		String myurl="mypage.jsp?category="+category;
		if(stat==null) {
			stat="Free";
		}
		myurl=myurl+"&stat"+stat;
		
		MemDAO mDAO=new MemDAO();
		MemVO mVO=new MemVO();
		mVO.setMid(memid);
		
		if(category.equals("myBoard")) {
			if(stat.equals("Free")) {
				FreeBoDAO fbDAO=new FreeBoDAO();
				ArrayList<FreeBoVO> datas=fbDAO.getFreePostList(mVO);
				request.setAttribute("datas", datas);
				forward=new ActionForward();
				forward.setRedirect(true);
				forward.setPath(myurl);
			}
			else if(stat.equals("Study")) {
				StudyBoDAO fbDAO=new StudyBoDAO();
				ArrayList<StudyBoVO> datas=fbDAO.getStudyPostList(mVO);
				request.setAttribute("datas", datas);
				forward=new ActionForward();
				forward.setRedirect(true);
				forward.setPath(myurl);
			}
			else {
				out.println("<script>alert('마이페이지게시글확인');history.go(-1);</script>");
			}
		}
		else if(category.equals("checkUser")) {
			if(mDAO.SelectOne(mVO).getMpw().equals(request.getParameter("mpw"))) {
				MemVO data=mDAO.SelectOne(mVO);
				request.setAttribute("data", data);
				forward=new ActionForward();
				forward.setRedirect(true);
				forward.setPath(myurl+"&check=t");
			}
			else {
				forward=new ActionForward();
				forward.setRedirect(true);
				forward.setPath(myurl+"&check=f");
			}
		}
		else if(category.equals("favBoard")) {
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath(myurl);
		}
		else {
			out.println("<script>alert('마이페이지확인');history.go(-1);</script>");
		}
		return forward;
	}
}