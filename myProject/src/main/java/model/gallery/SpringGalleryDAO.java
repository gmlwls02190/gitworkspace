package model.gallery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class GalleryRowMapper implements RowMapper<GalleryVO>{
	@Override
	public GalleryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		GalleryVO data=new GalleryVO();
		data.setArtist(rs.getString("artist"));
		data.setBid(rs.getInt("bid"));
		data.setGallery(rs.getString("gallery"));
		data.setId(rs.getString("id"));
		data.setInfo(rs.getString("info"));
		data.setTitle(rs.getString("title"));
		data.setWdate(rs.getDate("wdate"));
		return data;
	}
}
@Repository("springGalleryDAO")
public class SpringGalleryDAO {
	
	private final String getAllSQL="select * from gallery order by bid desc";
//	private final String myAllSQL="select * from gallery where id=? order by bid desc";
	private final String artistAllSQL="select * from gallery where artist=? order by bid desc";
	private final String getOneSQL="select * from gallery where bid=?";
	private final String insertSQL="insert into gallery values((select nvl(max(bid),0)+1 from gallery),?,?,?,?,?,sysdate)";
	private final String updateSQL="update gallery set title=?,info=?,gallery=?,wdate=sysdate where bid=?";
	private final String deleteSQL="delete gallery where bid=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean insertGallery(GalleryVO vo) {
		System.out.println("insertGallery");
		Object[] args= {vo.getId(),vo.getTitle(),vo.getArtist(),vo.getInfo(),vo.getGallery()};
		return (jdbcTemplate.update(insertSQL,args)>=1)? true:false;
	}

	public boolean updateGallery(GalleryVO vo) {
		System.out.println("updateGallery");
		Object[] args= {vo.getTitle(),vo.getInfo(),vo.getGallery(),vo.getBid()};
		return (jdbcTemplate.update(updateSQL, args)>=1)? true:false;
	}

	public boolean deleteGallery(GalleryVO vo) {
		System.out.println("deleteGallery");
		Object[] args= {vo.getBid()};
		return (jdbcTemplate.update(deleteSQL, args)>=1)? true:false;
	}
	
	public List<GalleryVO> getGalleryList(GalleryVO vo) {
		System.out.println("getGalleryList");
		if(vo.getArtist()!=null || vo.getArtist()=="") {
			Object[] args= {vo.getArtist()};
			return jdbcTemplate.query(artistAllSQL, args, new GalleryRowMapper());
		}
		return jdbcTemplate.query(getAllSQL, new GalleryRowMapper());
	}
	
	public GalleryVO getGallery(GalleryVO vo) {
		System.out.println("getGallery");
		Object[] args= {vo.getBid()};
		return jdbcTemplate.queryForObject(getOneSQL, args, new GalleryRowMapper());
	}
}
