package model.fav;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mybatisFavArtistDAO")
public class MybatisFavArtistDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public boolean insertFav(FavArtistVO vo) {
		System.out.println("Mybatis insertFav");
		return (mybatis.insert("favDAO.insertFav",vo)>=1)? true:false;
	}

	public List<FavArtistVO> getFavList(FavArtistVO vo){
		System.out.println("Mybatis getFavList");
		return mybatis.selectList("favDAO.getFavList", vo);
	}

	public boolean deleteFav(FavArtistVO vo) {
		System.out.println("Mybatis deleteFav");
		return (mybatis.delete("favDAO.deleteFav",vo)>=1)? true: false;
	}
}
