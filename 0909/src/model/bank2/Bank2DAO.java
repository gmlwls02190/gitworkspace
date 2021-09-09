package model.bank2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.DBCP;

public class Bank2DAO {
	
	public Bank2VO getB2One(){
		Connection conn = DBCP.connect();
		PreparedStatement pstmt = null;
		Bank2VO data=null;
		try{
			String sql = "select * from bank2 where b2id=201";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				data=new Bank2VO();
				data.setB2id(rs.getInt("b2id"));
				data.setB2name(rs.getString("b2name"));
				data.setB2balance(rs.getInt("b2balance"));
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
	
	public ArrayList<Bank2VO> B1List(){
		Connection conn = DBCP.connect();
		PreparedStatement pstmt = null;
		ArrayList<Bank2VO> datas=new ArrayList<Bank2VO>();
		try{
			String sql = "select * from bank2";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Bank2VO vo=new Bank2VO();
				vo.setB2id(rs.getInt("b2id"));
				vo.setB2name(rs.getString("b2name"));
				vo.setB2balance(rs.getInt("b2balance"));
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
			String sql1="update bank2 set b2balance=b2balance-? where b2id=201";
			pstmt=conn.prepareStatement(sql1);
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			String sql2="update bank1 set b1balance=b1balance+? where b1id=101";
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			String sql3="select b2balance from bank2 where b2id=201";
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
