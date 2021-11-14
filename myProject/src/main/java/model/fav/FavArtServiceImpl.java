package model.fav;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("favArtistService")
public class FavArtServiceImpl implements FavArtService{

	@Autowired
	private FavArtDAO dao;
	
	@Override
	public boolean insertFav(FavArtVO vo) {
		return dao.insertFav(vo);
	}

	@Override
	public FavArtVO getFav(FavArtVO vo) {
		return dao.getFav(vo);
	}

	@Override
	public List<FavArtVO> getFavList(FavArtVO vo,int start,int end) {
		return dao.getFavList(vo,start,end);
	}

	@Override
	public boolean deleteFav(FavArtVO vo) {
		return dao.deleteFav(vo);
	}

	@Override
	public int totalFavCnt(FavArtVO vo) {
		return dao.totalFavCnt(vo);
	}

}
