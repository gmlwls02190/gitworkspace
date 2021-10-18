package model.testboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;

public class TestBoardDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String insertBoardSql="insert into testboard values((select nvl(max(bid),0)+1 from testboard),?,?,?,?,sysdate)";
	private String getBoardListSql="select * from testboard order by bid desc";
	private String getBoardSql="select * from testboard where bid=?";
	private String updateBoardSql="update testboard set title=?, content=? where bid=?";
	private String deleteBoardSql="delete testboard where bid=?";

//	bid int primary key,
//	writer varchar(30) not null,
//	title varchar(50) not null,
//	content varchar(100) not null,
//	wdate date default sysdate not null
	public boolean insertBoard(TestBoardVO vo) {
		conn=JDBC.connect();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(insertBoardSql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("insertBoard!!");
			e.printStackTrace();
		}finally {
			JDBC.disconnect(conn, pstmt);
		}
		return flag;
	}
	public ArrayList<TestBoardVO> getBoardList(TestBoardVO vo) {
		conn=JDBC.connect();
		pstmt=null;
		ArrayList<TestBoardVO> datas=new ArrayList<TestBoardVO>();
		try {
			if(vo.getId()==null || vo.getId()=="") {
				pstmt=conn.prepareStatement(getBoardListSql);
			}
			else {
				String myBoardListSql="select * from testboard where id=? order by bid desc";
				pstmt=conn.prepareStatement(myBoardListSql);
				pstmt.setString(1, vo.getId());
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TestBoardVO data=new TestBoardVO();
				data.setBid(rs.getInt("bid"));
				data.setId(rs.getString("id"));
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setWdate(rs.getDate("wdate"));
				data.setWriter(rs.getString("writer"));
				datas.add(data);
			}
			rs.close();
		}catch(Exception e) {
			System.out.println("getBoardList!!");
			e.printStackTrace();
		}finally {
			JDBC.disconnect(conn, pstmt);
		}
		return datas;
	}
	public TestBoardVO getBoard(TestBoardVO vo) {
		conn=JDBC.connect();
		pstmt=null;
		TestBoardVO data=null;
		try {
			pstmt=conn.prepareStatement(getBoardSql);
			pstmt.setInt(1, vo.getBid());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new TestBoardVO();
				data.setBid(rs.getInt("bid"));
				data.setId(rs.getString("id"));
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setWdate(rs.getDate("wdate"));
				data.setWriter(rs.getString("writer"));
			}
			rs.close();
		}catch(Exception e) {
			System.out.println("getBoard!!");
			e.printStackTrace();
		}finally {
			JDBC.disconnect(conn, pstmt);
		}
		return data;
	}
	public boolean updateBoard(TestBoardVO vo) {
		conn=JDBC.connect();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(updateBoardSql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBid());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("updateBoard!!");
			e.printStackTrace();
		}finally {
			JDBC.disconnect(conn, pstmt);
		}
		return flag;
	}
	public boolean deleteBoard(TestBoardVO vo) {
		conn=JDBC.connect();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(deleteBoardSql);
			pstmt.setInt(1, vo.getBid());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("deleteBoard!!");
			e.printStackTrace();
		}finally {
			JDBC.disconnect(conn, pstmt);
		}
		return flag;
	}
}
