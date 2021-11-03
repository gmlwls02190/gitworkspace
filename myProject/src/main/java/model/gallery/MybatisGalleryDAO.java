package model.gallery;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mybatisGalleryDAO")
public class MybatisGalleryDAO {
	
	// ÀÚ·áÇü(Data Type)
	@Autowired
	private SqlSessionTemplate mybatis;

	public boolean insertGallery(GalleryVO vo) {
		System.out.println("Mybatis insertGallery");
		return (mybatis.insert("galleryDAO.insertGallery",vo)>=1)? true:false;
	}
	public boolean updateGallery(GalleryVO vo) {
		System.out.println("Mybatis updateGallery");
		return (mybatis.update("galleryDAO.updateGallery",vo)>=1)? true:false;
	}
	public boolean deleteGallery(GalleryVO vo) {
		System.out.println("Mybatis deleteGallery");
		return (mybatis.delete("galleryDAO.deleteGallery",vo)>=1)? true:false;
	}
	public GalleryVO getGallery(GalleryVO vo) {
		System.out.println("Mybatis getGallery");
		return (GalleryVO)mybatis.selectOne("galleryDAO.getGallery",vo);
	}
	public List<GalleryVO> getGalleryList(GalleryVO vo) {
		System.out.println("Mybatis getGalleryList");
		return mybatis.selectList("galleryDAO.getGalleryList",vo);
	}
}
