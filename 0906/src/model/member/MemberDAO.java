package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;

public class MemberDAO {
	
	public ArrayList<MemberVO> getMemList(){
		Connection conn=JDBC.getConnection();
		ArrayList<MemberVO> datas=new ArrayList();
		PreparedStatement pstmt=null;
		try{
			String sql="select * from member order by asc";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				MemberVO vo=new MemberVO();
				vo.setUsername(rs.getString("username"));
				vo.setUserid(rs.getString("userid"));
				vo.setUserpw(rs.getString("userpw"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getMemList()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}
	
	public MemberVO getMemData(MemberVO vo){
		Connection conn=JDBC.getConnection();
		PreparedStatement pstmt=null;
		MemberVO data=null;
		try{
			String sql="select * from member where userid=? and userpw=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getUserpw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new MemberVO();
				data.setUsername(rs.getString("username"));
				data.setUserid(rs.getString("userid"));
				data.setUserpw(rs.getString("userpw"));
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getMemData()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return data;
	}
	
	public boolean insertMem(MemberVO vo){
		Connection conn=JDBC.getConnection();
		PreparedStatement pstmt=null;
		boolean res=false;
		try{
			String sql="insert into member values(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getUserpw());
			pstmt.setString(3, vo.getUsername());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("insertMem()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return res;
	}
	
	public boolean updateMem(MemberVO vo){
		Connection conn=JDBC.getConnection();
		PreparedStatement pstmt=null;
		boolean res=false;
		try{
			String sql="update member set userpw=?, username=? where userid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserpw());
			pstmt.setString(2, vo.getUsername());
			pstmt.setString(3, vo.getUserid());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("updateMem()에서 출력");
			e.printStackTrace();
			// res=false;
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return res;
	}
	
	public boolean deleteMem(MemberVO vo){
		Connection conn=JDBC.getConnection();
		PreparedStatement pstmt=null;
		boolean res=false;
		try{
			String sql="delete from member where userid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("deleteMem()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return res;
	}
	
}
