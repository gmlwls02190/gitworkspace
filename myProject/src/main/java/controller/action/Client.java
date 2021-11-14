package controller.action;

import java.util.List;

import model.gallery.GalleryVO;
import model.gallery.MybatisGalleryDAO;

public class Client {
	public static void main(String[] args) {

		MybatisGalleryDAO dao=new MybatisGalleryDAO();

		GalleryVO vo=new GalleryVO();
		List<GalleryVO> datas=dao.getGalleryList(vo);
		for(GalleryVO v:datas) {
			System.out.println(v);
		}
	}
}
