package model.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.DBCP;

public class ProductDAO {

	public ArrayList<ProductVO> getAllDB(){
		Connection conn = DBCP.JNDIConnect();
		PreparedStatement pstmt = null;
		ArrayList<ProductVO> datas=new ArrayList<ProductVO>();
		try{
			String sql = "select * from product";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				ProductVO vo=new ProductVO();
				vo.setPnum(rs.getInt("pnum"));
				vo.setPname(rs.getString("pname"));
				vo.setPcnt(rs.getInt("pcnt"));
				vo.setPstatus(rs.getString("pstatus"));
				datas.add(vo);
			}
			rs.close();
			DBCP.close(conn, pstmt);
		}
		catch(Exception e){
			System.out.println("getAllDB에서 출력");
			e.printStackTrace();
		}
		return datas;
	}
	
	public ProductVO getOneDB(ProductVO vo){
		Connection conn = DBCP.JNDIConnect();
		PreparedStatement pstmt = null;
		ProductVO data=null;
		try{
			String sql = "select * from product where pnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPnum());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				data=new ProductVO();
				data.setPnum(rs.getInt("pnum"));
				data.setPname(rs.getString("pname"));
				data.setPcnt(rs.getInt("pcnt"));
				data.setPstatus(rs.getString("pstatus"));
			}
			rs.close();
			DBCP.close(conn, pstmt);
		}
		catch(Exception e){
			System.out.println("getOneDB에서 출력");
			e.printStackTrace();
		}
		return data;
	}
	
	public boolean insertP(ProductVO vo){
		Connection conn = DBCP.JNDIConnect();
		PreparedStatement pstmt = null;
		boolean res=false;
		try{
			String sql="insert into product values((select nvl(max(pnum),0)+1 from product),?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPname());
			pstmt.setInt(2, vo.getPcnt());
			pstmt.setString(3, vo.getPstatus());
			pstmt.executeUpdate();
			res=true;
			DBCP.close(conn, pstmt);
		}
		catch(Exception e){
			System.out.println("insertP()에서 출력");
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean updateP(ProductVO vo){
		Connection conn = DBCP.JNDIConnect();
		PreparedStatement pstmt = null;
		boolean res=false;
		try{
			String sql="update product set pname=?, pcnt=?, pstatus=? where pnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPname());
			pstmt.setInt(2, vo.getPcnt());
			pstmt.setString(3, vo.getPstatus());
			pstmt.setInt(4, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
			DBCP.close(conn, pstmt);
		}
		catch(Exception e){
			System.out.println("updateP()에서 출력");
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean deleteP(ProductVO vo){
		Connection conn = DBCP.JNDIConnect();
		PreparedStatement pstmt = null;
		boolean res=false;
		try{
			String sql="delete from product where pnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
			DBCP.close(conn, pstmt);
		}
		catch(Exception e){
			System.out.println("deleteP()에서 출력");
			e.printStackTrace();
		}
		return res;
	}
	
}
