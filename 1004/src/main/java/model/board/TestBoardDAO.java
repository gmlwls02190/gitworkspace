package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

// DAO-> 드라이버, CP, MyBatis, JPA, ...
// Service를 DAO 객체를 이용하여 CRUD 기능을 제공할 예정!
// 폰Service <-> 시계DAO
@Repository("boardDAO")
public class TestBoardDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String insertSQL ="insert into testboard (id,title,writer,content) values((select nvl(max(id),0)+1 from testboard),?,?,?)";
	private final String updateSQL ="update testboard set title=?, content=? where id=?";
	private final String deleteSQL ="delete from testboard where id=?";
	private final String selectAllSQL ="select * from testboard";
	private final String selectOneSQL ="select * from testboard where id=?";
	
	public void insertTBoard(TestBoardVO vo) {
		System.out.println("DAO insert");
		try {
			conn = JDBC.getConnection();
			pstmt= conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void updateTBoard(TestBoardVO vo) {	
		System.out.println("DAO update");
		try {
			conn = JDBC.getConnection();
			pstmt= conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void deleteTBoard(TestBoardVO vo) {	
		System.out.println("DAO delete");
		try {
			conn = JDBC.getConnection();
			pstmt= conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, vo.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public List<TestBoardVO> selectAll() {
		System.out.println("DAO selectAll");
		List<TestBoardVO> datas=new ArrayList<TestBoardVO>();
		
		try {
			conn = JDBC.getConnection();
			pstmt= conn.prepareStatement(selectAllSQL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TestBoardVO data=new TestBoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
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
	
	public TestBoardVO selectOne(TestBoardVO vo) {
		System.out.println("DAO selectOne");
		TestBoardVO data=null;
		
		try {
			conn = JDBC.getConnection();
			pstmt= conn.prepareStatement(selectOneSQL);
			pstmt.setInt(1, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new TestBoardVO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("data"));
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
