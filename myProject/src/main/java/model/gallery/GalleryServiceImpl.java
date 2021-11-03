package model.gallery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("galleryService")
public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	private GalleryDAO dao;
	
	@Override
	public List<GalleryVO> getGalleryList(GalleryVO vo) {
		return dao.getGalleryList(vo);
	}

	@Override
	public GalleryVO getGallery(GalleryVO vo) {
		return dao.getGallery(vo);
	}

	@Override
	public boolean insertGallery(GalleryVO vo) {
		return dao.insertGallery(vo);
	}

	@Override
	public boolean updateGallery(GalleryVO vo) {
		return dao.updateGallery(vo);
	}

	@Override
	public boolean deleteGallery(GalleryVO vo) {
		return dao.deleteGallery(vo);
	}

}
