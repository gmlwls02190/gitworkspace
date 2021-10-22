package model.gallery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("galleryDAO")
public class GalleryDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String getAllSQL="select * from gallery order by bid desc";
	private final String searchSQL="select * from gallery where ? like ? order by bid desc";
	private final String getOneSQL="select * from gallery where bid=?";
	private final String insertSQL="insert into gallery values((select nvl(max(id),0)+1 from gallery),?,?,?,?,sysdate)";
	private final String updateSQL="update gallery set title=?,info=?,gallery=?,wdate=sysdate where bid=?";
	private final String deleteSQL="delete gallery where bid=?";

	public ArrayList<GalleryVO> getGalleryList(GalleryVO vo,String condition,String content) {
		conn=JDBC.getConnection();
		pstmt=null;
		ArrayList<GalleryVO> datas=new ArrayList<GalleryVO>();
		try {
			if(content==null || content=="") {
				System.out.println("All!!");
				pstmt=conn.prepareStatement(getAllSQL);
			}
			else {
				System.out.println("Search!!");
				pstmt=conn.prepareStatement(searchSQL);
				pstmt.setString(1, condition);
				pstmt.setString(2, "%"+content+"%");
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				GalleryVO data=new GalleryVO();
				data.setArtist(rs.getString("artist"));
				data.setBid(rs.getInt("bid"));
				data.setGallery(rs.getString("gallery"));
				data.setInfo(rs.getString("info"));
				data.setTitle(rs.getString("title"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);
			}
			rs.close();
		}catch(Exception e) {
			System.out.println("getGalleryList Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}

	public GalleryVO getGallery(GalleryVO vo) {
		System.out.println("getGallery");
		conn=JDBC.getConnection();
		pstmt=null;
		GalleryVO data=null;
		try {
			pstmt=conn.prepareStatement(getOneSQL);
			pstmt.setInt(1, vo.getBid());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new GalleryVO();
				data.setArtist(rs.getString("artist"));
				data.setBid(rs.getInt("bid"));
				data.setGallery(rs.getString("gallery"));
				data.setInfo(rs.getString("info"));
				data.setTitle(rs.getString("title"));
				data.setWdate(rs.getDate("wdate"));
			}
			rs.close();
		}catch(Exception e) {
			System.out.println("getGallery Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return data;
	}

	public boolean insertGallery(GalleryVO vo) {
		System.out.println("insertGallery");
		conn=JDBC.getConnection();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getArtist());
			pstmt.setString(3, vo.getInfo());
			pstmt.setString(4, vo.getGallery());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("insertGallery Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return flag;
	}

	public boolean updateGallery(GalleryVO vo) {
		System.out.println("updateGallery");
		conn=JDBC.getConnection();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getInfo());
			pstmt.setString(3, vo.getGallery());
			pstmt.setInt(4, vo.getBid());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("updateGallery Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return flag;
	}

	public boolean deleteGallery(GalleryVO vo) {
		System.out.println("deleteGallery");
		conn=JDBC.getConnection();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, vo.getBid());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("deleteGallery Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return flag;
	}
}
