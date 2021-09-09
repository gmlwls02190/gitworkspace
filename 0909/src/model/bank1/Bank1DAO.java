package model.bank1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.DBCP;

public class Bank1DAO {
	
	public Bank1VO getB1One(){
		Connection conn = DBCP.connect();
		PreparedStatement pstmt = null;
		Bank1VO data=null;
		try{
			String sql = "select * from bank1 where b1id=101";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				data=new Bank1VO();
				data.setB1id(rs.getInt("b1id"));
				data.setB1name(rs.getString("b1name"));
				data.setB1balance(rs.getInt("b1balance"));
			}
			rs.close();
			DBCP.close(conn, pstmt);
		}
		catch(Exception e){
			System.out.println("getB1One에서 출력");
			e.printStackTrace();
		}
		return data;
	}
	
	public ArrayList<Bank1VO> B1List(){
		Connection conn = DBCP.connect();
		PreparedStatement pstmt = null;
		ArrayList<Bank1VO> datas=new ArrayList<Bank1VO>();
		try{
			String sql = "select * from bank1";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Bank1VO vo=new Bank1VO();
				vo.setB1id(rs.getInt("b1id"));
				vo.setB1name(rs.getString("b1name"));
				vo.setB1balance(rs.getInt("b1balance"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("B1List에서 출력");
			e.printStackTrace();
		}
		finally {
			DBCP.close(conn, pstmt);
		}
		return datas;
	}
	
	public boolean trans1(int bal) {
		Connection conn=DBCP.connect();
		PreparedStatement pstmt=null;
		try {
			conn.setAutoCommit(false);
			String sql1="update bank1 set b1balance=b1balance-? where b1id=101";
			pstmt=conn.prepareStatement(sql1);
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			String sql2="update bank2 set b2balance=b2balance+? where b2id=201";
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			String sql3="select b1balance from bank1 where b1id=101";
			pstmt=conn.prepareStatement(sql3);
			ResultSet rs=pstmt.executeQuery(sql3);
			rs.next();
			if(rs.getInt(1)<0) {
				conn.rollback();
				return false;
			}
			else {
				conn.commit();
			}
			conn.setAutoCommit(true);
		}
		catch(Exception e) {
			System.out.println("B1trans1에서 출력");
			e.printStackTrace();
		}
		finally {
			DBCP.close(conn, pstmt);
		}
		return true;
	}
}
