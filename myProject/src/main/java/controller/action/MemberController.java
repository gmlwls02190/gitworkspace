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
	
	@RequestMapping("toLogin.do")
	public String toLogin() {
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(HttpServletRequest request,MemberVO vo) {
		MemberVO mem=memberService.getOneMember(vo);
		
		if(vo.getId()==null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디 공백에러");
		}
		
		if(mem==null) {
			// id error
			System.out.println("ID Error!!");
			return "redirect:toLogin.do?mode=login";
		}
		else {
			if(mem.getPw().equals(vo.getPw())) {
				HttpSession session=request.getSession();
				session.setAttribute("mem", mem);
				return "redirect:main.do"; // VR의 설정을 무시하고 redirect
			}
			else {
				// pw error
				System.out.println("PW Error!!");
				return "redirect:toLogin.do?mode=login";
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
	public String signUp(HttpServletRequest request,MemberVO vo) {
		if(memberService.insertMember(vo)) {
			return "toLogin.do?mode=login";
		}
		else {
			return "redirect:main.do";
		}
	}
	
	@RequestMapping("/editMember.do")
	public String editMember() {
		return "editMember.jsp";
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
