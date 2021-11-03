package model.fav;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class FavArtistRowMapper implements RowMapper<FavArtistVO>{
	@Override
	public FavArtistVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		FavArtistVO data=new FavArtistVO();
		data.setArtist(rs.getString("artist"));
		data.setFavId(rs.getInt("favId"));
		data.setId(rs.getString("id"));
		data.setWdate(rs.getDate("wdate"));
		return data;
	}
}
@Repository("springFavArtistDAO")
public class SpringFavArtistDAO {
	
	private final String insertFavSQL="insert into favArtist values((select nvl(max(favId),0)+1 from favArtist),?,?,sysdate)";
	private final String getFavListSQL="select * from favArtist where id=? order by favId desc";
	private final String deleteFavSQL="delete favArtist where favId=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean insertFav(FavArtistVO vo) {
		System.out.println("insertFav!!");
		Object[] args= {vo.getId(),vo.getArtist()};
		return (jdbcTemplate.update(insertFavSQL, args)>=1)? true:false;
	}
	
	public List<FavArtistVO> getFavList(FavArtistVO vo){
		System.out.println("getFavList!!");
		Object[] args= {vo.getId()};
		return jdbcTemplate.query(getFavListSQL, args, new FavArtistRowMapper());
	}
	
	public boolean deleteFav(FavArtistVO vo) {
		System.out.println("deleteFav!!");
		Object[] args= {vo.getFavId()};
		return (jdbcTemplate.update(deleteFavSQL, args)>=1)? true:false;
	}
}
