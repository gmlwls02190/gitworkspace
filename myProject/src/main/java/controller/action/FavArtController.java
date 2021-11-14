package controller.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.fav.FavArtService;
import model.fav.FavArtVO;
import model.page.Paging;

@Controller
public class FavArtController {

	@Autowired
	private FavArtService favService;
	
	@RequestMapping("/checkFav.do")
	public String checkFav(FavArtVO vo,PrintWriter out) {
		if(favService.getFav(vo)==null) {
			out.print("fail");
		}
		else {
			out.print("success");
		}
		return null;
	}
	
	@RequestMapping("/addArtist.do")
	public String addArtist(FavArtVO vo,Model model,PrintWriter out) {
		System.out.println("addFavVO: "+vo);
		if(favService.getFav(vo)==null) {
			if(favService.insertFav(vo)) {
				System.out.println("addFav success!!");
				out.print("addSuccess");
			}
			else {
				out.print("error");
			}
		}
		else {
			return "deleteArtist.do";
		}
		
		return null;
	}
	
	@RequestMapping("/deleteArtist.do")
	public String deleteArtist(FavArtVO vo,PrintWriter out) {
		System.out.println("delFavVO: "+vo);
		int favId=favService.getFav(vo).getFavId();
		System.out.println("favId: "+favId);
		vo.setFavId(favId);
		if(favService.deleteFav(vo)) {
			System.out.println("delArt success!!");
			out.print("delSuccess");
		}
		else {
			out.print("error");
		}
		return null;
	}
	
	@RequestMapping("/myArtist.do")
	public String myArtist(FavArtVO vo,Paging paging,HttpServletRequest request,Model model) {
		int page=request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
		int totalCount=favService.totalFavCnt(vo);
		paging.setPageNo(page);
		paging.setTotalCount(totalCount);
		
		page=((page-1)*6)+1;
		paging.setPageSize(page+5);
		
		List<FavArtVO> datas=favService.getFavList(vo,page,paging.getPageSize());
		System.out.println(datas);
		model.addAttribute("datas", datas);
		model.addAttribute("paging", paging);
		model.addAttribute("stat", "fav");
		
		return "myGallery.jsp";
	}
}
