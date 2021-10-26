package model.fav;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("favArtistService")
public class FavArtistServiceImpl implements FavArtistService{

	@Autowired
	private FavArtistDAO dao;
	
	@Override
	public boolean insertFav(FavArtistVO vo) {
		return dao.insertFav(vo);
	}

	@Override
	public ArrayList<FavArtistVO> getFavList(FavArtistVO vo) {
		return dao.getFavList(vo);
	}

	@Override
	public boolean deleteFav(FavArtistVO vo) {
		return dao.deleteFav(vo);
	}

}
