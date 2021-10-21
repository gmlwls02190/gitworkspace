package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.member.MemDAO;
import model.member.MemVO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		MemVO vo=new MemVO();
		vo.setId(id);
		vo.setPassword(pw);
		
		MemDAO mdao=new MemDAO();
		MemVO mem=mdao.getOneMember(vo);
		
		ModelAndView mav=new ModelAndView();
		
		if(mem==null) {
			// id error
			mav.setViewName("redirect:index.jsp");
		}
		else {
			if(mem.getPassword().equals(pw)) {
				System.out.println();
				HttpSession session=request.getSession();
				session.setAttribute("mem", mem);
				mav.setViewName("redirect:main.do"); // VR의 설정을 무시하고 redirect
			}
			else {
				// pw error
				mav.setViewName("redirect:index.jsp");
			}
		}
		
		return mav;
	}

}
