package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("testMemDAO")
public class TestMemDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String insertSQL ="insert into testmember values(?,?,?,'USER')";
	private final String updateSQL ="update testmember set password=?, name=? where id=?";
	private final String deleteSQL ="delete from testmember where id=?";
	private final String selectAllSQL ="select * from testmember";
	private final String selectOneSQL ="select * from testmember where id=?";
	
	public void insertTMember(TestMemVO vo) {
		System.out.println("DAO insert");
		try {
			conn = JDBC.getConnection();
			pstmt= conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void updateTMember(TestMemVO vo) {	
		System.out.println("DAO update");
		try {
			conn = JDBC.getConnection();
			pstmt= conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}

	public void deleteTMember(TestMemVO vo) {	
		System.out.println("DAO delete");
		try {
			conn = JDBC.getConnection();
			pstmt= conn.prepareStatement(deleteSQL);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public List<TestMemVO> selectAll() {
		System.out.println("DAO selectAll");
		List<TestMemVO> datas=new ArrayList<TestMemVO>();
		
		try {
			conn = JDBC.getConnection();
			pstmt= conn.prepareStatement(selectAllSQL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TestMemVO data=new TestMemVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
				datas.add(data);
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}
	
	public TestMemVO selectOne(TestMemVO vo) {
		// 로그인에 성공한다면, TestMemVO 객체가 리턴(반환)
		// 실패한다면, 리턴이 null
		System.out.println("DAO selectOne");
		TestMemVO data=null;
		
		try {
			conn = JDBC.getConnection();
			pstmt= conn.prepareStatement(selectOneSQL);
			pstmt.setString(1, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new TestMemVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return data;
	}
}