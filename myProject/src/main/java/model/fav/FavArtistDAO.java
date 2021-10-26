package model.fav;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("favDAO")
public class FavArtistDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String insertFavSQL="insert into favArtist values((select nvl(max(favId),0)+1 from favArtist),?,?,?,?,sysdate)";
	private final String getFavListSQL="select * from favArtist where id=? order by favId desc";
	private final String deleteFavSQL="delete favArtist where favId=?";
	
	public boolean insertFav(FavArtistVO vo) {
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
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("insertFav Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return flag;
	}
	
	public ArrayList<FavArtistVO> getFavList(FavArtistVO vo){
		System.out.println("getFavList!!");
		conn=JDBC.getConnection();
		pstmt=null;
		ArrayList<FavArtistVO> datas=new ArrayList<FavArtistVO>();
		try {
			pstmt=conn.prepareStatement(getFavListSQL);
			pstmt.setString(1, vo.getId());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				FavArtistVO data=new FavArtistVO();
				data.setArtist(rs.getString("artist"));
				data.setBid(rs.getInt("bid"));
				data.setFavId(rs.getInt("favId"));
				data.setId(rs.getString("id"));
				data.setTitle(rs.getString("title"));
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
	
	public boolean deleteFav(FavArtistVO vo) {
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
