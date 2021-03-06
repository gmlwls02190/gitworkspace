package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.MessageDAO;
import model.msg.MsgSet;
import model.user.UserDAO;
import model.user.UserVO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward= new ActionForward();
		String mcntt=request.getParameter("mcnt");
		int mcnt=1;
		if(mcntt!=null){
			mcnt=Integer.parseInt(mcntt);
		}
		String mem=request.getParameter("mem");
		
		MessageDAO mDAO= new MessageDAO();
		UserDAO uDAO= new UserDAO();
		ArrayList<MsgSet> datas=mDAO.selectAll(mem, mcnt);
		ArrayList<UserVO> newUsers=uDAO.selectAll();
		
		request.setAttribute("datas", datas);
		request.setAttribute("newUsers", newUsers);
		request.setAttribute("mem", mem);
		request.setAttribute("mcnt", mcnt);
		
		forward.setRedirect(false);
		forward.setPath("main.jsp");
		return forward;
	}

}

/*

		pageContext.forward("main.jsp");
	}*/