package model.heart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("heartDAO")
public class HeartDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String insertHeartSQL="insert into heart(hid,bid,id) values((select nvl(max(hid),0)+1 from heart),?,?)";
	private final String getHeartSQL="select * from heart where bid=? and id=?";
	private final String updateHeartSQL="update heart set heart=? where bid=? and id=?";
	private final String deleteHeartSQL="delete heart where id=?";
	
	public boolean insertHeart(HeartVO vo) {
		System.out.println("insertHeart");
		conn=JDBC.getConnection();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(insertHeartSQL);
			pstmt.setInt(1, vo.getBid());
			pstmt.setString(2, vo.getId());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("insertHeart Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return flag;
	}
	
	public HeartVO getHeart(HeartVO vo) {
		System.out.println("getHeart");
		conn=JDBC.getConnection();
		pstmt=null;
		HeartVO data=null;
		try {
			pstmt=conn.prepareStatement(getHeartSQL);
			pstmt.setInt(1, vo.getBid());
			pstmt.setString(2, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new HeartVO();
				data.setBid(rs.getInt("bid"));
				data.setHeart(rs.getInt("heart"));
				data.setHid(rs.getInt("hid"));
				data.setId(rs.getString("id"));
			}
			rs.close();
		}catch(Exception e) {
			System.out.println("getHeart Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return data;
	}
	
	public boolean updateHeart(HeartVO vo) {
		System.out.println("updateHeart");
		conn=JDBC.getConnection();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(updateHeartSQL);
			pstmt.setInt(1, vo.getHeart());
			pstmt.setInt(2, vo.getBid());
			pstmt.setString(3, vo.getId());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("updateHeart Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return flag;
	}
	
	public boolean deleteHeart(HeartVO vo) {
		System.out.println("deleteHeart");
		conn=JDBC.getConnection();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(deleteHeartSQL);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("deleteHeart Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return flag;
	}
}
