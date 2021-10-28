package controller.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.kakao.KakaoService;
import model.kakao.KakaoVO;

@Controller
public class KakaoController {
	
	@Autowired
	private KakaoService kakaoService;
	
	@RequestMapping(value="/kakaoLogin.do")
	public String kakaoLogin() {
		StringBuffer loginUrl = new StringBuffer();
		loginUrl.append("https://kauth.kakao.com/oauth/authorize?client_id=");
		loginUrl.append("a1a82c6ddf498743e99395481ba41136");
		loginUrl.append("&redirect_uri=");
		loginUrl.append("http://localhost:8088/app/kakaoCallback.do");
		loginUrl.append("&response_type=code");
		
		System.out.println("loginUrl: "+loginUrl.toString());
		
		return "redirect:"+loginUrl.toString(); // 카카오콜백으로 이동
	}
	
	@RequestMapping(value="/kakaoCallback.do", method=RequestMethod.GET)
	public String redirectKakao(@RequestParam String code, HttpSession session) throws IOException {
		System.out.println("##########"+code+"##########");
		
		// 접속토큰 get
		String kakaoToken=kakaoService.getReturnAccessToken(code);
		
		// 접속자정보 get
		Map<String,Object> result=kakaoService.getUserInfo(kakaoToken);
		System.out.println("result: "+result.toString());
		System.out.println("컨트롤러 출력: "+result.get("nickname")+"/"+result.get("profile_image")+"/"+result.get("email"));
		KakaoVO kakaoVO=new KakaoVO();
		kakaoVO.setUser_name((String)result.get("nickname"));
//		kakaoVO.setProfile_img((String)result.get("profile_image"));
		kakaoVO.setEmail((String)result.get("email"));
		
		session.setAttribute("kakaoVO", kakaoVO);
		session.setAttribute("kakaoToken", kakaoToken);
		System.out.println("check");
		return "redirect:main.do";
	}
	
	@RequestMapping(value="/kakaoLogout.do")
    public String logout(ModelMap modelMap, HttpSession session)throws IOException {
        if((String)session.getAttribute("kakaoToken")==null){
        }else {
            kakaoService.getLogout((String)session.getAttribute("kakaoToken"));
        }
        session.invalidate();
//        session.setAttribute("kakaoVO", null);
//        HashMap<String, String> message = new HashMap<String, String>();
//        message.put("title", "로그아웃");
//        message.put("script", "location.href='/'");
//        message.put("msg", "로그아웃 되었습니다");
//        message.put("type","alert");
//        modelMap.addAttribute("message",message);
        return "main.do";
    }

}
