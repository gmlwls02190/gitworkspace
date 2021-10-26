package model.fav;

import java.util.ArrayList;

public interface FavArtistService {
	boolean insertFav(FavArtistVO vo);
	ArrayList<FavArtistVO> getFavList(FavArtistVO vo);
	boolean deleteFav(FavArtistVO vo);
}
