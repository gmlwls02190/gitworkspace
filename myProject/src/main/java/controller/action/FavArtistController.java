package controller.action;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.fav.FavArtistService;
import model.fav.FavArtistVO;

@Controller
public class FavArtistController {

	@Autowired
	private FavArtistService favService;
	
	@RequestMapping("/addArtist.do")
	public String addArtist(FavArtistVO vo) {
		if(favService.insertFav(vo)) {
			return "galleryList.do";
		}
		return "main.do";
	}
	
	@RequestMapping("/deleteArtist.do")
	public String deleteArtist(FavArtistVO vo) {
		if(favService.deleteFav(vo)) {
			return "myArtist.do";
		}
		return "main.do";
	}
	
	@RequestMapping("/myArtist.do")
	public String myArtist(FavArtistVO vo,Model model) {
		ArrayList<FavArtistVO> datas=favService.getFavList(vo);
		model.addAttribute("datas", datas);
		
		return "myGallery.jsp?stat=fav";
	}
}
