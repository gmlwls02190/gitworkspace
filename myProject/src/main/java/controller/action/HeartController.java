package controller.action;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.heart.HeartService;
import model.heart.HeartVO;

@Controller
public class HeartController {

	@Autowired
	private HeartService heartService;
	
	@RequestMapping("/isHeart.do")
	public String isHeart(PrintWriter out,HeartVO vo) {
		if(heartService.getHeart(vo)==null) {
			out.print("unlike");
		}
		else {
			out.print("like");
		}
		return null;
	}
	
	@RequestMapping("/checkHeart.do")
	public String checkHeart(PrintWriter out,HeartVO vo) {
		if(heartService.getHeart(vo)==null) {
			return "addHeart.do";
		}
		else {
			return "updateHeart.do";
		}
	}
	
	@RequestMapping("/addHeart.do")
	public String addHeart(PrintWriter out,HeartVO vo) {
		if(heartService.insertHeart(vo)) {
			return "updateHeart.do";
		}
		else {
			out.print("error");
			return null;
		}
	}
	
	@RequestMapping("/updateHeart.do")
	public String updateHeart(PrintWriter out,HeartVO vo) {
		int check=heartService.getHeart(vo).getHeart();
		if(check==0) {
			vo.setHeart(1);
			heartService.updateHeart(vo);
			out.print("like");
		}
		else {
			vo.setHeart(0);
			heartService.updateHeart(vo);
			out.print("unlike");
		}
		return null;
	}
	
}
