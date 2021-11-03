package model.fav;

import java.util.List;

public interface FavArtistService {
	boolean insertFav(FavArtistVO vo);
	List<FavArtistVO> getFavList(FavArtistVO vo);
	boolean deleteFav(FavArtistVO vo);
}
