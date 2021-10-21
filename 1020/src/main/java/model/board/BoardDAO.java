package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("boardDAO")
public class BoardDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String getAllSQL="select * from board";
	private final String searchSQL="select * from board where title like ?";
	private final String getOneSQL="select * from board where id=?";
	private final String insertSQL="insert into board values((select nvl(max(id),0)+1 from board),?,?,?,sysdate)";
	private final String updateSQL="update board set title=?,content=? where id=?";
	private final String deleteSQL="delete board where id=?";

	public ArrayList<BoardVO> searchBoardList(BoardVO vo) {
		conn=JDBC.getConnection();
		pstmt=null;
		ArrayList<BoardVO> datas=new ArrayList<BoardVO>();
		try {
			if(vo.getTitle()==null || vo.getTitle()=="") {
				System.out.println("All!!");
				pstmt=conn.prepareStatement(getAllSQL);
			}
			else {
				System.out.println("Search!!");
				pstmt=conn.prepareStatement(searchSQL);
				pstmt.setString(1, vo.getTitle());
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data=new BoardVO();
				data.setContent(rs.getString("content"));
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWdate(rs.getDate("wdate"));
				data.setWriter(rs.getString("writer"));
				datas.add(data);
			}
			rs.close();
		}catch(Exception e) {
			System.out.println("searchBoardList Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("getBoard");
		conn=JDBC.getConnection();
		pstmt=null;
		BoardVO data=null;
		try {
			pstmt=conn.prepareStatement(getOneSQL);
			pstmt.setInt(1, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new BoardVO();
				data.setContent(rs.getString("content"));
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWdate(rs.getDate("wdate"));
				data.setWriter(rs.getString("writer"));
			}
			rs.close();
		}catch(Exception e) {
			System.out.println("getBoard Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return data;
	}

	public void insertBoard(BoardVO vo) {
		System.out.println("insertBoard");
		conn=JDBC.getConnection();
		pstmt=null;
		try {
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("insertBoard Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("updateBoard");
		conn=JDBC.getConnection();
		pstmt=null;
		try {
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("updateBoard Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("deleteBoard");
		conn=JDBC.getConnection();
		pstmt=null;
		try {
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, vo.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("deleteBoard Error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}
}
