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

	private final String insertSQL ="insert into member values(?,?,?,?,?,?,?,'USER')";
	private final String updateSQL ="update member set pw=?, artist=?, firstemail=?, lastemail=?, address=?, callNum=? where id=?";
	private final String deleteSQL ="delete from member where id=?";
	private final String getOneSQL ="select * from member where id=?";
	
	public boolean insertMember(MemberVO vo) {
		System.out.println("insertMember!!!");
		conn=JDBC.getConnection();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getArtist());
			pstmt.setString(4, vo.getFirstemail());
			pstmt.setString(5, vo.getLastemail());
			pstmt.setString(6, vo.getAddress());
			pstmt.setString(7, vo.getCallNum());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("insertMember error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return flag;
	}
	
	public boolean updateMember(MemberVO vo) {	
		System.out.println("updateMember!!!");
		conn=JDBC.getConnection();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getArtist());
			pstmt.setString(3, vo.getFirstemail());
			pstmt.setString(4, vo.getLastemail());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getCallNum());
			pstmt.setString(7, vo.getId());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("updateMember error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return flag;
	}

	public boolean deleteMember(MemberVO vo) {	
		System.out.println("deleteMember!!!");
		conn=JDBC.getConnection();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("deleteMember error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return flag;
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
				data.setCallNum(rs.getString("callNUm"));
				data.setFirstemail(rs.getString("firstemail"));
				data.setLastemail(rs.getString("lastemail"));
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