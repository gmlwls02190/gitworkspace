package controller.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import model.gallery.GalleryService;
import model.gallery.GalleryVO;
import model.page.Paging;

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
//		System.out.println("test: "+vo);
//		List<GalleryVO> datas=galleryService.getGalleryList(vo);
//		model.addAttribute("datas", datas);
		
		return "main.jsp";
	}
	
	@RequestMapping("/info.do")
	public String info() {
		return "info.jsp";
	}
	
	@RequestMapping("/galleryList.do")
	public String galleryList(GalleryVO vo,Paging paging,Model model,HttpServletRequest request) {
		int page=request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		int totalCount=galleryService.totalGalleryCnt(vo);
		System.out.println("totCnt: "+totalCount);
		paging.setPageNo(page);
		paging.setTotalCount(totalCount);
		
		page=((page-1)*6)+1;
		paging.setPageSize(page+5);
		
		List<GalleryVO> datas=galleryService.getGalleryList(vo,page,paging.getPageSize());
		model.addAttribute("datas", datas);
		model.addAttribute("paging", paging);
		System.out.println("paging: "+paging.toString());
		return "gallery.jsp";
	}
	
	@RequestMapping("/artistList.do")
	public String artistList(GalleryVO vo,Paging paging,Model model,HttpServletRequest request) {
		int page=request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		int totalCount=galleryService.totalGalleryCnt(vo);
		System.out.println("totCnt: "+totalCount);
		paging.setPageNo(page);
		paging.setTotalCount(totalCount);
		
		page=((page-1)*6)+1;
		paging.setPageSize(page+5);
		
		List<GalleryVO> datas=galleryService.getGalleryList(vo,page,paging.getPageSize());
		model.addAttribute("datas", datas);
		model.addAttribute("paging", paging);
		System.out.println("paging: "+paging.toString());
		return "gallery.jsp";
	}
	
	@RequestMapping("/myGallery.do")
	public String myGallery(Paging paging,GalleryVO vo,Model model,HttpServletRequest request) {
		int page=request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		int totalCount=galleryService.totalGalleryCnt(vo);
		paging.setPageNo(page);
		paging.setTotalCount(totalCount);
		
		page=((page-1)*6)+1;
		paging.setPageSize(page+5);
		
		List<GalleryVO> datas=galleryService.getGalleryList(vo,page,paging.getPageSize());
		model.addAttribute("datas", datas);
		model.addAttribute("paging", paging);
		model.addAttribute("stat", "my");
		
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
			gallery.transferTo(new File("D:\\JAVA\\HEEJIN_0622\\resource\\images\\"+randName+fileName));
			//-------------------------------------------------------------------------------------
			vo.setGallery(randName+fileName);
		}// /images/filename.jpg
		galleryService.insertGallery(vo);
		return "redirect:galleryList.do";
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
			gallery.transferTo(new File("D:\\JAVA\\HEEJIN_0622\\resource\\images\\"+randName+fileName));
			//-------------------------------------------------------------------------------------
			vo.setGallery(randName+fileName);
		}
		galleryService.updateGallery(vo);
		return "gallery.do?bid="+vo.getBid();
	}
	
	@RequestMapping("/deleteGallery.do")
	public String deleteGallery(GalleryVO vo,Model model) {
		galleryService.deleteGallery(vo);
		return "galleryList.do";
	}
}