package model.msg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;

public class MessageDAO {

	public ArrayList<MsgSet> selectAll(String uid,int cnt) {
		ArrayList<MsgSet> datas = new ArrayList<MsgSet>();
		Connection conn = JNDI.getConnection();
		PreparedStatement pstmt= null;
		String sql;
		try {
			// 전체
			if((uid == null) || (uid.equals(""))) {
				sql = "select * from message where rownum <= ? order by wdate asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cnt);
			}
			// 특정 회원
			else{
				sql = "select * from message where userid=? and rownum <= ? order by wdate asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,uid);
				pstmt.setInt(2,cnt);
			}
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MsgSet ms = new MsgSet();
				MessageVO m = new MessageVO();
				ArrayList<ReplyVO> rlist = new ArrayList<ReplyVO>();
				
				m.setMid(rs.getInt("mid"));
				m.setMsg(rs.getString("msg"));
				m.setFavcount(rs.getInt("favcount"));
				m.setUserid(rs.getString("userid"));
				m.setWdate(rs.getDate("wdate"));
				
				String rsql = "select * from reply where mid=? order by wdate desc";
				pstmt = conn.prepareStatement(rsql);
				pstmt.setInt(1,rs.getInt("mid"));
				ResultSet rrs = pstmt.executeQuery();
				int rcnt=0;
				while(rrs.next()) {
					ReplyVO r = new ReplyVO();
					r.setWdate(rrs.getDate("wdate"));
					r.setMid(rrs.getInt("mid"));
					r.setRid(rrs.getInt("rid"));
					r.setRmsg(rrs.getString("rmsg"));
					r.setUserid(rrs.getString("userid"));
					rlist.add(r);
					rcnt++;
				}
				m.setReplycount(rcnt);
				
				ms.setM(m);
				ms.setRlist(rlist);
				datas.add(ms);
				rrs.close();
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
		return datas;
	}
	public boolean insert(MessageVO vo) {
		Connection conn = JNDI.getConnection();
		PreparedStatement pstmt= null;
		String sql = "insert into message(userid, msg, wdate) values(?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getMsg());
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
	public boolean delete(MessageVO vo) {
		Connection conn = JNDI.getConnection();
		PreparedStatement pstmt= null;
		String sql = "delete from message where mid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
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
	public void update(MessageVO vo) {
		Connection conn = JNDI.getConnection();
		PreparedStatement pstmt= null;
		String sql = "update message set favcount=favcount+1 where mid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			pstmt.executeUpdate();
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
	}
}
