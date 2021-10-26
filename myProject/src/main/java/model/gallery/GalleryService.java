package model.gallery;

import java.util.ArrayList;

public interface GalleryService {
	ArrayList<GalleryVO> getGalleryList(GalleryVO vo);
	GalleryVO getGallery(GalleryVO vo);
	boolean insertGallery(GalleryVO vo);
	boolean updateGallery(GalleryVO vo);
	boolean deleteGallery(GalleryVO vo);
}
