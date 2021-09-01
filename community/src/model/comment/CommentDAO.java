package model.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;
import model.message.MessageVO;

public class CommentDAO {
	
	public ArrayList<CommentVO> getCommentList(MessageVO vo){
		Connection conn=JDBC.getConnection();
		ArrayList<CommentVO> datas=new ArrayList();
		PreparedStatement pstmt=null;
		try{
			String sql="select * from comments where mnum=? order by mnum asc";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMnum());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				CommentVO data=new CommentVO();
				data.setCnum(rs.getInt("cnum"));
				data.setMnum(rs.getInt("mnum"));
				data.setCname(rs.getString("cname"));
				data.setComments(rs.getString("comments"));
				data.setCdate(rs.getDate("cdate"));
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
	
	public boolean insertComment(CommentVO vo){
		Connection conn=JDBC.getConnection();
		PreparedStatement pstmt=null;
		boolean res=false;
		try{
			String sql="insert into comments values((select nvl(max(cnum),0)+1 from comments),?,?,?,sysdate)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMnum());
			pstmt.setString(2, vo.getCname());
			pstmt.setString(3, vo.getComments());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("insertComment()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return res;
	}
}
