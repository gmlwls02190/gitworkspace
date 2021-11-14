package model.gallery;

import java.util.List;

public interface GalleryService {
	List<GalleryVO> getGalleryList(GalleryVO vo,int start,int end);
	GalleryVO getGallery(GalleryVO vo);
	boolean insertGallery(GalleryVO vo);
	boolean updateGallery(GalleryVO vo);
	boolean deleteGallery(GalleryVO vo);
	int totalGalleryCnt(GalleryVO vo);
}
