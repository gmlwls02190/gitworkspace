package model.msg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
				/*sql = "select * from message where rownum <= ? order by mid desc";*/
				sql = "select * from (select * from message order by mid desc) where rownum <= ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cnt);
			}
			// 특정 회원
			else{
				/*sql = "select * from message where userid=? and rownum <= ? order by mid desc";*/
				sql = "select * from (select * from message order by mid desc) where userid=? and rownum <= ?";
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
				
				String rsql = "select * from reply where mid=? order by rid desc";
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
	
	public ArrayList<MessageVO> selectTest(int cPage,int numPerPage) {
		ArrayList<MessageVO> datas = new ArrayList<MessageVO>();
		Connection conn = JNDI.getConnection();
		PreparedStatement pstmt= null;
		String sql;
		try {
			sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, V.* FROM( SELECT * FROM message ORDER BY mid DESC) V ) V WHERE RNUM BETWEEN ? AND ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MessageVO data = new MessageVO();
				data.setMid(rs.getInt("mid"));
				data.setMsg(rs.getString("msg"));
				data.setFavcount(rs.getInt("favcount"));
				data.setUserid(rs.getString("userid"));
				data.setWdate(rs.getDate("wdate"));
				data.setReplycount(rs.getInt("replycount"));
				datas.add(data);
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
	
	public int selectTestCount() {
		Connection conn = JNDI.getConnection();
        PreparedStatement pstmt = null;
        int result =0 ;
        String sql = "select count(*) as cnt from message";
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                result = rs.getInt("cnt");
                
            }
        }catch (Exception e) {
            // TODO: handle exception
        }finally {
        	try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return result;
    }
	
	public MessageVO selectOne(MessageVO vo) {
		Connection conn = JNDI.getConnection();
		PreparedStatement pstmt= null;
		MessageVO data=null;
		String sql = "select * from message where mid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				/*private int mid;
				private String userid;
				private String msg;
				private int favcount;
				private int replycount;
				private Date wdate;*/
				
				data = new MessageVO();
				data.setMid(rs.getInt("mid"));
				data.setUserid(rs.getString("userid"));
				data.setMsg(rs.getString("msg"));
				data.setFavcount(rs.getInt("favcount"));
				data.setReplycount(rs.getInt("replycount"));
				data.setWdate(rs.getDate("wdate"));
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
	
	public boolean insert(MessageVO vo) {
		Connection conn = JNDI.getConnection();
		PreparedStatement pstmt= null;
		String sql = "insert into message(mid, userid, msg, wdate) values((select nvl(max(mid),0)+1 from message),?,?,sysdate)";
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
		String sql;
		try {
			if(vo.getMsg()==null) {
				sql = "update message set favcount=favcount+1 where mid=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, vo.getMid());
				System.out.println("fas");
			}
			else {
				sql = "update message set favcount=favcount+1, msg=? where mid=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getMsg());
				pstmt.setInt(2, vo.getMid());
			}
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
