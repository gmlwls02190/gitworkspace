package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("memDAO")
public class MemDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String insertSQL ="insert into member values(?,?,?,'USER')";
	private final String updateSQL ="update member set password=?, name=? where id=?";
	private final String deleteSQL ="delete from member where id=?";
	private final String selectAllSQL ="select * from member";
	private final String selectOneSQL ="select * from member where id=?";
	
	public void insertMember(MemVO vo) {
		System.out.println("insertMember!!!");
		conn=JDBC.getConnection();
		pstmt=null;
		try {
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("insertMember error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void updateMember(MemVO vo) {	
		System.out.println("updateMember!!!");
		conn=JDBC.getConnection();
		pstmt=null;
		try {
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateMember error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}

	public void deleteMember(MemVO vo) {	
		System.out.println("deleteMember!!!");
		conn=JDBC.getConnection();
		pstmt=null;
		try {
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("deleteMember error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public ArrayList<MemVO> getAllMember() {
		System.out.println("getAllMember!!!");
		conn=JDBC.getConnection();
		pstmt=null;
		ArrayList<MemVO> datas=new ArrayList<MemVO>();
		try {
			pstmt=conn.prepareStatement(selectAllSQL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemVO data=new MemVO();
				data.setId(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setPassword(rs.getString("password"));
				data.setRole(rs.getString("role"));
				datas.add(data);
			}
			rs.close();
		}catch(Exception e) {
			System.out.println("getAllMember error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}
	
	public MemVO getOneMember(MemVO vo) {
		System.out.println("getOneMember!!!");
		conn=JDBC.getConnection();
		pstmt=null;
		MemVO data=null;
		try {
			pstmt=conn.prepareStatement(selectOneSQL);
			pstmt.setString(1, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemVO();
				data.setId(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setPassword(rs.getString("password"));
				data.setRole(rs.getString("role"));
			}
			rs.close();
		}catch(Exception e) {
			System.out.println("getOneMember error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return data;
	}
}