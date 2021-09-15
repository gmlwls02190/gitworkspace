package model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;

public class UserDAO {
	
	public boolean insert(UserVO vo) {
		Connection conn = JNDI.getConnection();
		PreparedStatement pstmt= null;
		String sql = "insert into users(userid,uname,userpw,wdate) values(?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getUname());
			pstmt.setString(3, vo.getUserpw());
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
	public UserVO login(UserVO vo) {
		Connection conn = JNDI.getConnection();
		PreparedStatement pstmt= null;
		String sql = "select * from users where userid = ? and userpw= ?";
		UserVO data=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getUserpw());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data=new UserVO();
				data.setWdate(rs.getDate("wdate"));
				data.setUname(rs.getString("uname"));
				data.setUserpw(rs.getString("userpw"));
				data.setUserid(rs.getString("userid"));
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
	public ArrayList<UserVO> selectAll() {
		ArrayList<UserVO> datas = new ArrayList<UserVO>();
		Connection conn = JNDI.getConnection();
		PreparedStatement pstmt= null;
		String sql = "select * from users where rownum <= 10 order by wdate desc";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO data=new UserVO();
				data.setWdate(rs.getDate("wdate"));
				data.setUname(rs.getString("uname"));
				data.setUserpw(rs.getString("userpw"));
				data.setUserid(rs.getString("userid"));
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
}
