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
			String sql="select * from member";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				MemberVO vo=new MemberVO();
				vo.setMname(rs.getString("mname"));
				vo.setMid(rs.getString("mid"));
				vo.setMpw(rs.getString("mpw"));
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
	
	public boolean insertMem(MemberVO vo){
		Connection conn=JDBC.getConnection();
		PreparedStatement pstmt=null;
		boolean res=false;
		try{
			String sql="insert into member values(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMname());
			pstmt.setString(2, vo.getMid());
			pstmt.setString(3, vo.getMpw());
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
	
	public boolean checkMem(MemberVO vo){
		Connection conn=JDBC.getConnection();
		PreparedStatement pstmt=null;
		MemberVO data=null;
		try{
			String sql="select * from member where mid=? and mpw=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new MemberVO();
				data.setMname(rs.getString("mname"));
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				return true;
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("checkMem()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return false;
	}
	
	public MemberVO getMemData(MemberVO vo){
		Connection conn=JDBC.getConnection();
		PreparedStatement pstmt=null;
		MemberVO data=null;
		try{
			String sql="select * from member where mid=? and mpw=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new MemberVO();
				data.setMname(rs.getString("mname"));
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
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
	
}
