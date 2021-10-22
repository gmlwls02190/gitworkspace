package controller.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.gallery.GalleryDAO;
import model.gallery.GalleryVO;

@Controller
public class GalleryController {
	
	@ModelAttribute("sm")
	public Map<String,String> searchMap(){
		Map<String,String> sm=new HashMap<String,String>();
		sm.put("제목", "title");
		sm.put("작성자", "writer");
		return sm;
	}
	
	@RequestMapping("/main.do")
	public String getBoardList(@RequestParam(value="condition",defaultValue="title",required=false)String condition,@RequestParam(value="keyword",defaultValue="",required=false)String keyword,GalleryVO vo,GalleryDAO dao,Model model) {
		System.out.println(condition+": "+keyword);
		
		ArrayList<GalleryVO> datas=dao.getGalleryList(vo,condition,keyword);
		model.addAttribute("datas", datas);
		
		return "main.jsp";
	}
	
	@RequestMapping("/board.do")
	public String getBoard(GalleryVO vo,GalleryDAO dao,Model model) {
		GalleryVO data=dao.getGallery(vo);
		model.addAttribute("data", data);
		
		return "board.jsp";
	}
//	@RequestMapping("/main.do")
//	public ModelAndView getBoardList(BoardVO bvo,BoardDAO bdao,ModelAndView mav) {
//		System.out.println(bvo.getCondition()+": "+bvo.getKeyword());
//		if(bvo.getCondition()==null) {
//			bvo.setCondition("title");
//		}
//		
//		ArrayList<BoardVO> datas=bdao.searchBoardList(bvo);
//		
//		mav.addObject("datas", datas);
//		mav.setViewName("main");
//		
//		return mav;
//	}
}