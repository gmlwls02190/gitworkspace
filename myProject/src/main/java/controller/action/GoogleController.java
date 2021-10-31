package controller.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.google.GoogleService;
import model.google.GoogleVO;

@Controller
public class GoogleController {
	
	@Autowired
	private GoogleService googleService;
	
	@RequestMapping("/googleLogin.do")
	public String googleLogin() {
		StringBuffer loginUrl=new StringBuffer();
		loginUrl.append("https://accounts.google.com/o/oauth2/v2/auth?client_id=");
		loginUrl.append("334493542272-bm1lfpektcd2mmbhdt8upmrt4jjbsr2i.apps.googleusercontent.com");
		loginUrl.append("&redirect_uri=");
		loginUrl.append("http://localhost:8088/app/googleCallback.do");
		loginUrl.append("&response_type=code");
		loginUrl.append("&scope=email%20profile%20openid");
		loginUrl.append("&access_type=offline");
		
		System.out.println("loginUrl: "+loginUrl.toString());
		return "redirect:"+loginUrl.toString();
	}
	
	@RequestMapping(value="googleCallback.do", method=RequestMethod.GET)
	public String redirectGoogle(@RequestParam String code, HttpSession session,String authCode, HttpServletRequest request) {
		System.out.println("#########"+code+"#########");
		
		String googleToken=googleService.getReturnAccessToken(code);
		
		Map<String,Object> result=googleService.getUserInfo(googleToken);
		System.out.println("result: "+result.toString());
		System.out.println("컨트롤러 출력: "+result.get("name")+"/"+result.get("email")+"/"+result.get("id"));
		GoogleVO googleVO=new GoogleVO();
		googleVO.setUser_name((String)result.get("name"));
		googleVO.setEmail((String)result.get("email"));
		googleVO.setEmail((String)result.get("email"));
		googleVO.setId((String)result.get("id"));
		
		session.setAttribute("googleVO", googleVO);
		session.setAttribute("googleToken", googleToken);
		System.out.println("googleCheck");
		
		
		return "externalLogin.jsp";
	}
	
	@RequestMapping("googleLogout.do")
	public String googleLogout(HttpSession session) {
		if((String)session.getAttribute("googleToken")==null){
			System.out.println("googleToken NULL!!");
        }
        else {
        	System.out.println("googleToken NOT NULL!!");
            googleService.getLogout((String)session.getAttribute("googleToken"));
        }
        session.invalidate();
		return "externalLogin.jsp";
	}
}
