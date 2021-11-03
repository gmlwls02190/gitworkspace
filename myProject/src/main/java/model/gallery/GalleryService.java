package model.gallery;

import java.util.List;

public interface GalleryService {
	List<GalleryVO> getGalleryList(GalleryVO vo);
	GalleryVO getGallery(GalleryVO vo);
	boolean insertGallery(GalleryVO vo);
	boolean updateGallery(GalleryVO vo);
	boolean deleteGallery(GalleryVO vo);
}
