package model.wuser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;

public class WuserDAO {
	
	public ArrayList<WuserVO> getUserList(){
		Connection conn=JDBC.getConnection();
		ArrayList<WuserVO> datas=new ArrayList();
		PreparedStatement pstmt=null;
		try{
			String sql="select * from wuser order by asc";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				WuserVO vo=new WuserVO();
				vo.setUname(rs.getString("uname"));
				vo.setUserid(rs.getString("userid"));
				vo.setUserpw(rs.getString("userpw"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getUserList()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}
	
	public WuserVO getUserData(WuserVO vo){
		Connection conn=JDBC.getConnection();
		PreparedStatement pstmt=null;
		WuserVO data=null;
		try{
			String sql="select * from wuser where userid=? and userpw=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getUserpw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new WuserVO();
				data.setUname(rs.getString("uname"));
				data.setUserid(rs.getString("userid"));
				data.setUserpw(rs.getString("userpw"));
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getUserData()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return data;
	}
	
	public boolean checkUser(WuserVO vo){
		Connection conn=JDBC.getConnection();
		PreparedStatement pstmt=null;
		WuserVO data=null;
		try{
			String sql="select * from wuser where userid=? and userpw=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getUserpw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new WuserVO();
				data.setUname(rs.getString("uname"));
				data.setUserid(rs.getString("userid"));
				data.setUserpw(rs.getString("userpw"));
				return true;
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getUserData()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return false;
	}
	
	public boolean insertUser(WuserVO vo){
		Connection conn=JDBC.getConnection();
		PreparedStatement pstmt=null;
		boolean res=false;
		try{
			String sql="insert into wuser values(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUname());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getUserpw());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("insertUser()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return res;
	}
	
	
}
