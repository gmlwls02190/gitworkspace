package model.msg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.plaf.synth.SynthSpinnerUI;

import model.common.JNDI;

public class ReplyDAO {
	
	public ReplyVO selectOne(ReplyVO vo) {
		Connection conn = JNDI.getConnection();
		PreparedStatement pstmt= null;
		ReplyVO data=null;
		String sql = "select * from reply where rid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getRid());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				/*private int rid;
				private int mid;
				private String userid;
				private Date wdate;
				private String rmsg;*/
				
				data = new ReplyVO();
				data.setRid(rs.getInt("rid"));
				data.setMid(rs.getInt("mid"));
				data.setUserid(rs.getString("userid"));
				data.setWdate(rs.getDate("wdate"));
				data.setRmsg(rs.getString("rmsg"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public boolean insert(ReplyVO vo) {
		Connection conn = JNDI.getConnection();
		PreparedStatement pstmt= null;
		String sql = "insert into reply(rid, mid,userid,rmsg,wdate) values((select nvl(max(rid),0)+1 from reply),?,?,?,sysdate)";
		String sql2 = "update message set replycount=replycount+1 where mid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getRmsg());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	public boolean delete(ReplyVO vo) {
		Connection conn = JNDI.getConnection();
		PreparedStatement pstmt= null;
		String sql = "delete from reply where rid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getRid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;	
	}
}
