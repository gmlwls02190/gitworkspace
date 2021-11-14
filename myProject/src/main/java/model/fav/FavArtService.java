package model.fav;

import java.util.List;

public interface FavArtService {
	boolean insertFav(FavArtVO vo);
	FavArtVO getFav(FavArtVO vo);
	List<FavArtVO> getFavList(FavArtVO vo,int start,int end);
	boolean deleteFav(FavArtVO vo);
	int totalFavCnt(FavArtVO vo);
}
