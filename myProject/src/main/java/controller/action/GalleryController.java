package controller.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	@RequestMapping("info.do")
	public String info() {
		return "info.jsp";
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
	
	@RequestMapping("/myGallery.do")
	public String myGallery(@RequestParam(value="stat",defaultValue="",required=false)String stat,GalleryVO vo,Model model) {
		ArrayList<GalleryVO> datas=galleryService.getGalleryList(vo);
		model.addAttribute("datas", datas);
		return "myGallery.jsp";
	}
	
	@RequestMapping("/gallery.do")
	public String gallery(GalleryVO vo,Model model) {
		GalleryVO data=galleryService.getGallery(vo);
		model.addAttribute("data", data);
		
		return "art.jsp";
	}
	
	@RequestMapping("insertArt.do")
	public String insertArt() {
		return "insertArt.jsp";
	}
	
	@RequestMapping("/addGallery.do")
	public String addGallery(GalleryVO vo) throws IllegalStateException, IOException {
		System.out.println("vo: "+vo);
		MultipartFile gallery=vo.getFileUpload();
		if(!gallery.isEmpty()) {
			String fileName=gallery.getOriginalFilename();
			System.out.println("fileName: "+fileName);
			String randName=UUID.randomUUID().toString();
			randName=randName.replace("-", "").substring(22);
			System.out.println(randName);
			gallery.transferTo(new File("D:\\JAVAKHJ_0622\\HEEJIN_0622\\resource\\images\\"+randName+fileName));
			//-------------------------------------------------------------------------------------
			vo.setGallery("\\images\\"+randName+fileName);
		}// /images/filename.jpg
		galleryService.insertGallery(vo);
		return "main.do";
	}
	
	@RequestMapping("/editGallery.do")
	public String editGallery(GalleryVO vo,Model model) {
		GalleryVO data=galleryService.getGallery(vo);
		model.addAttribute("data", data);
		
		return "editArt.jsp";
	}
	
	@RequestMapping("/updateGallery.do")
	public String updateGallery(GalleryVO vo,Model model) throws IllegalStateException, IOException {
		MultipartFile gallery=vo.getFileUpload();
		if(!gallery.isEmpty()) {
			String fileName=gallery.getOriginalFilename();
			System.out.println("fileName: "+fileName);
			String randName=UUID.randomUUID().toString();
			randName=randName.replace("-", "").substring(22);
			System.out.println(randName);
			gallery.transferTo(new File("D:\\JAVAKHJ_0622\\HEEJIN_0622\\resource\\images\\"+randName+fileName));
			//-------------------------------------------------------------------------------------
			vo.setGallery("\\images\\"+randName+fileName);
		}
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