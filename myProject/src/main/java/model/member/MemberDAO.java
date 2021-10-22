package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("memberDAO")
public class MemberDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String insertSQL ="insert into member values(?,?,?,?,?,?,'USER')";
	private final String updateSQL ="update member set password=?, artist=?, email=?, address=?, callNum=? where id=?";
	private final String deleteSQL ="delete from member where id=?";
	private final String getOneSQL ="select * from member where id=?";
	
	public void insertMember(MemberVO vo) {
		System.out.println("insertMember!!!");
		conn=JDBC.getConnection();
		pstmt=null;
		try {
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getArtist());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			pstmt.setInt(6, vo.getCallNum());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("insertMember error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void updateMember(MemberVO vo) {	
		System.out.println("updateMember!!!");
		conn=JDBC.getConnection();
		pstmt=null;
		try {
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getArtist());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getAddress());
			pstmt.setInt(5, vo.getCallNum());
			pstmt.setString(6, vo.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateMember error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}

	public void deleteMember(MemberVO vo) {	
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
	
	public MemberVO getOneMember(MemberVO vo) {
		System.out.println("getOneMember!!!");
		conn=JDBC.getConnection();
		pstmt=null;
		MemberVO data=null;
		try {
			pstmt=conn.prepareStatement(getOneSQL);
			pstmt.setString(1, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemberVO();
				data.setAddress(rs.getString("address"));
				data.setArtist(rs.getString("artist"));
				data.setCallNum(rs.getInt("callNUm"));
				data.setEmail(rs.getString("email"));
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
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