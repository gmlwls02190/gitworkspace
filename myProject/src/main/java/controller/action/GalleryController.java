package controller.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.gallery.GalleryService;
import model.gallery.GalleryVO;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	
	@ModelAttribute("sm")
	public Map<String,String> searchMap(){
		Map<String,String> sm=new HashMap<String,String>();
		sm.put("제목", "title");
		sm.put("작성자", "writer");
		return sm;
	}
	
	@RequestMapping("/main.do")
	public String mainPage(GalleryVO vo,Model model) {
		ArrayList<GalleryVO> datas=galleryService.getGalleryList(vo);
		model.addAttribute("datas", datas);
		
		return "main.jsp";
	}
	
	@RequestMapping("/galleryList.do")
	public String galleryList(@RequestParam(value="stat",defaultValue="",required=false)String stat,GalleryVO vo,Model model) {
		ArrayList<GalleryVO> datas=galleryService.getGalleryList(vo);
		model.addAttribute("datas", datas);
		if(stat.equals("my")) {
			return "myGallery.jsp";
		}
		return "gallery.jsp";
	}
	
	@RequestMapping("/gallery.do")
	public String gallery(GalleryVO vo,Model model) {
		GalleryVO data=galleryService.getGallery(vo);
		model.addAttribute("data", data);
		
		return "art.jsp";
	}
	
	@RequestMapping("/addGallery.do")
	public String addGallery(GalleryVO vo,Model model) {
		if(galleryService.insertGallery(vo)) {
			return "galleryList.do";
		}
		return "main.do";
	}
	
	@RequestMapping("/editGallery.do")
	public String editGallery(GalleryVO vo,Model model) {
		GalleryVO data=galleryService.getGallery(vo);
		model.addAttribute("data", data);
		
		return "editArt.jsp";
	}
	
	@RequestMapping("/updateGallery.do")
	public String updateGallery(GalleryVO vo,Model model) {
		if(galleryService.updateGallery(vo)) {
			return "gallery.do?bid="+vo.getBid();
		}
		return "main.do";
	}
	
	@RequestMapping("/deleteGallery.do")
	public String deleteGallery(GalleryVO vo,Model model) {
		if(galleryService.deleteGallery(vo)) {
			return "galleryList.do";
		}
		return "main.do";
	}
}