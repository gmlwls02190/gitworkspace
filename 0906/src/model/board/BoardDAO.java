package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;
import model.member.MemberVO;

public class BoardDAO {

	public ArrayList<BoardVO> getDBList(){
		Connection conn=JDBC.getConnection();
		ArrayList<BoardVO> datas=new ArrayList();
		PreparedStatement pstmt=null;
		try{
			String sql="select * from board order by bnum desc";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				BoardVO vo=new BoardVO();
				vo.setContent(rs.getString("content"));
				vo.setBnum(rs.getInt("bnum"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setUserid(rs.getString("userid"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getDBList()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}
	
	public ArrayList<BoardVO> getMyDBList(MemberVO vo){
		Connection conn=JDBC.getConnection();
		ArrayList<BoardVO> datas=new ArrayList();
		PreparedStatement pstmt=null;
		try{
			String sql="select * from board where userid=? order by bnum desc";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				BoardVO data=new BoardVO();
				data.setContent(rs.getString("content"));
				data.setBnum(rs.getInt("bnum"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setUserid(rs.getString("userid"));
				datas.add(data);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getMyDBList()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}
	
	public ArrayList<BoardVO> searchDBList(String str){
		Connection conn=JDBC.getConnection();
		ArrayList<BoardVO> datas=new ArrayList();
		PreparedStatement pstmt=null;
		try{
			String sql="select * from board where lower(writer) like lower(?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+str+"%");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				BoardVO vo=new BoardVO();
				vo.setContent(rs.getString("content"));
				vo.setBnum(rs.getInt("bnum"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setUserid(rs.getString("userid"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("searchDBList()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}

	public BoardVO getDBData(BoardVO vo){
		Connection conn=JDBC.getConnection();
		BoardVO data=null;
		PreparedStatement pstmt=null;
		try{
			String sql="select * from board where bnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBnum());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new BoardVO();
				data.setContent(rs.getString("content"));
				data.setBnum(rs.getInt("bnum"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setUserid(rs.getString("userid"));
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getDBData()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return data;
	}

	public boolean insertDB(BoardVO vo){
		Connection conn=JDBC.getConnection();
		PreparedStatement pstmt=null;
		boolean res=false;
		try{
			String sql="insert into board values((select nvl(max(bnum),0)+1 from board),?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getUserid());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("insertDB()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return res;
	}
	
	public boolean deleteDB(BoardVO vo){
		Connection conn=JDBC.getConnection();
		PreparedStatement pstmt=null;
		boolean res=false;
		try{
			String sql="delete from board where bnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("deleteDB()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return res;
	}
	
	public boolean updateDB(BoardVO vo){
		Connection conn=JDBC.getConnection();
		PreparedStatement pstmt=null;
		boolean res=false;
		try{
			String sql="update board set writer=?, title=?, content=? where bnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getBnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("updateDB()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return res;
	}
}
