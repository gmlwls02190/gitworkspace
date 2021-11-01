package controller.action;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.member.MemberService;
import model.member.MemberVO;
import web.mail.MailAuth;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("toLogin.do")
	public String toLogin() {
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(HttpServletRequest request,MemberVO vo,Model model) {
		MemberVO mem=memberService.getOneMember(vo);
		String str="";
		if(vo.getId()==null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디 공백에러");
		}
		
		if(mem==null) {
			// id error
			System.out.println("ID Error!!");
			str="존재하지 않는 아이디입니다";
			model.addAttribute("str", str);
			return "toLogin.do?mode=login";
		}
		else {
			if(mem.getPw().equals(vo.getPw())) {
				HttpSession session=request.getSession();
				session.setAttribute("mem", mem);
				return "redirect:main.do"; // 'redirect:xxx.do' <-- VR의 설정을 무시하고 redirect
			}
			else {
				// pw error
				System.out.println("PW Error!!");
				str="잘못된 비밀번호 입니다";
				model.addAttribute("str", str);
				return "toLogin.do?mode=login";
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
	
	@RequestMapping("/qaMailSend.do")
	public String qaMailSend(HttpServletRequest request) {
		String to=request.getParameter("to");
		String title=request.getParameter("title");
		String name=request.getParameter("name");
		String firstemail=request.getParameter("firstemail");
		String lastemail=request.getParameter("lastemail");
		String from=firstemail+lastemail;
		String content=request.getParameter("content");
		
		Properties prop=System.getProperties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.required", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		Authenticator auth=new MailAuth();
		
		Session session=Session.getDefaultInstance(prop,auth);
		
		MimeMessage msg=new MimeMessage(session);
		
		try {
			session.setDebug(true);
			
			Address fromAddr=new InternetAddress(from);
			Address toAddr=new InternetAddress(to);
			msg.setSubject(title);
			msg.setFrom(fromAddr);
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent("<h3>답변수신 주소:"+fromAddr+"</h3><hr><h2>문의내용</h2><h3>문의자:"+name+"</h3><br><span>"+content+"</span>","text/html;charset=UTF-8");
			
			Transport.send(msg);
		}catch(Exception e) {
			System.out.println("QAMailSend Error!!");
			e.printStackTrace();
		}
		
		return "info.do";
	}
	
	@RequestMapping("/checkID.do")
	public String checkID(MemberVO vo) {
		if(memberService.getOneMember(vo)==null) {
			System.out.println("if success");
		}
		else {
			System.out.println("if failed");
		}
		return null;
	}
}
