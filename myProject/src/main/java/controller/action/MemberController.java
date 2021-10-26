package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.member.MemberService;
import model.member.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(HttpServletRequest request,MemberVO vo) {
		MemberVO mem=memberService.getOneMember(vo);
		
		if(mem==null) {
			// id error
			return "redirect:login.jsp";
		}
		else {
			if(mem.getPw().equals(vo.getPw())) {
				HttpSession session=request.getSession();
				session.setAttribute("mem", mem);
				return "redirect:main.do"; // VR의 설정을 무시하고 redirect
			}
			else {
				// pw error
				return "redirect:login.jsp";
			}
		}
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String loginPrint(@ModelAttribute("guest")MemberVO vo) {
		// 로그인하러가기
		vo.setId("test");
		vo.setPw("1234");
		
		return "login.jsp";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:main.do";
	}
	
	@RequestMapping("/signUp.do")
	public String signUp(MemberVO vo) {
		if(memberService.insertMember(vo)) {
			return "login.jsp";
		}
		else {
			return "redirect:main.do";
		}
	}
	
	@RequestMapping("/updateMember.do")
	public String updateMember(MemberVO vo) {
		if(memberService.updateMember(vo)) {
			return "logout.do";
		}
		else {
			return "redirect:main.do";
		}
	}
	
	@RequestMapping("/deleteMember.do")
	public String deleteMember(MemberVO vo) {
		if(memberService.deleteMember(vo)) {
			return "logout.do";
		}
		else {
			return "redirect:main.do";
		}
	}
}
