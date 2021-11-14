package model.fav;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("favDAO")
public class FavArtDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String insertFavSQL="insert into favArt values((select nvl(max(favId),0)+1 from favArt),?,?,?,?,?,sysdate)";
	private final String getFavListSQL="select * from (select rownum as rnum, a.* from (select * from favArt where id=? order by favId desc) a) where rnum between ? and ?";
	private final String getFavSQL="select * from favArt where bid=? and id=?";
	private final String deleteFavSQL="delete favArt where favId=?";
	private final String totalFavSQL="select count(*) as cnt from favArt where id=?";
	
	public int totalFavCnt(FavArtVO vo) {
		conn=JDBC.getConnection();
		pstmt=null;
		int totalCnt=0;
		try {
			pstmt=conn.prepareStatement(totalFavSQL);
			pstmt.setString(1, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				totalCnt=rs.getInt(1);
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return totalCnt;
	}
	
	public boolean insertFav(FavArtVO vo) {
		System.out.println("insertFav!!");
		conn=JDBC.getConnection();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(insertFavSQL);
			pstmt.setInt(1, vo.getBid());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getArtist());
			pstmt.setString(5, vo.getGallery());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("insertFav Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return flag;
	}
	
	public FavArtVO getFav(FavArtVO vo) {
		System.out.println("getFav!!");
		conn=JDBC.getConnection();
		pstmt=null;
		FavArtVO data=null;
		try {
			pstmt=conn.prepareStatement(getFavSQL);
			pstmt.setInt(1, vo.getBid());
			pstmt.setString(2, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new FavArtVO();
				data.setArtist(rs.getString("artist"));
				data.setBid(rs.getInt("bid"));
				data.setFavId(rs.getInt("favId"));
				data.setId(rs.getString("id"));
				data.setTitle(rs.getString("title"));
				data.setGallery(rs.getString("gallery"));
				data.setWdate(rs.getDate("wdate"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return data;
	}
	
	public ArrayList<FavArtVO> getFavList(FavArtVO vo,int start,int end){
		System.out.println("getFavList!!");
		conn=JDBC.getConnection();
		pstmt=null;
		ArrayList<FavArtVO> datas=new ArrayList<FavArtVO>();
		try {
			pstmt=conn.prepareStatement(getFavListSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				FavArtVO data=new FavArtVO();
				data.setFavId(rs.getInt("favId"));
				data.setBid(rs.getInt("bid"));
				data.setId(rs.getString("id"));
				data.setTitle(rs.getString("title"));
				data.setArtist(rs.getString("artist"));
				data.setGallery(rs.getString("gallery"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);
			}
			rs.close();
		}catch(Exception e) {
			System.out.println("getFavList Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}
	
	public boolean deleteFav(FavArtVO vo) {
		System.out.println("deleteFav!!");
		conn=JDBC.getConnection();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(deleteFavSQL);
			pstmt.setInt(1, vo.getFavId());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("deleteFav Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return flag;
	}
}
