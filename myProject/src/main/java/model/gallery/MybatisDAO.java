//package model.gallery;
//
//import java.util.List;
//
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository("mybatisDAO")
//public class MybatisDAO {
//	
//	// ÀÚ·áÇü(Data Type)
//	@Autowired
//	private SqlSessionTemplate mybatis;
//
//	public void insertGallery(GalleryVO vo) {
//		mybatis.insert("dao.insertGallery",vo);
//	}
//	public void updateGallery(GalleryVO vo) {
//		mybatis.update("dao.updateGallery",vo);
//	}
//	public void deleteGallery(GalleryVO vo) {
//		mybatis.delete("dao.deleteGallery",vo);
//	}
//	public GalleryVO getGallery(GalleryVO vo) {
//		return (GalleryVO)mybatis.selectOne("dao.selectOneGallery",vo);
//	}
//	public List<GalleryVO> getGalleryList(GalleryVO vo) {
//		return mybatis.selectList("dao.selectAllGallery",vo);
//	}
//}
