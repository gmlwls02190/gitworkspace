package model.testmember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;

public class TestMemberDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private String insertMemSql="insert into testmember values(?,?,?)";
	private String getMemListSql="select * from testmember";
	private String getMemSql="select * from testmember where id=?";
	private String updateMemSql="update testmember set pw=?, name=? where id=?";
	private String deleteMemSql="delete testmember where id=?";

	public boolean insertMem(TestMemberVO vo) {
		conn=JDBC.connect();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(insertMemSql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("insertMem!!");
			e.printStackTrace();
		}finally {
			JDBC.disconnect(conn, pstmt);
		}
		return flag;
	}
	public ArrayList<TestMemberVO> getMemList() {
		conn=JDBC.connect();
		pstmt=null;
		ArrayList<TestMemberVO> datas=new ArrayList<TestMemberVO>();
		try {
			pstmt=conn.prepareStatement(getMemListSql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TestMemberVO vo=new TestMemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("pw"));
				datas.add(vo);
			}
			rs.close();
		}catch(Exception e) {
			System.out.println("getMemList!!");
			e.printStackTrace();
		}finally {
			JDBC.disconnect(conn, pstmt);
		}
		return datas;
	}
	public TestMemberVO getMem(TestMemberVO vo) {
		conn=JDBC.connect();
		pstmt=null;
		TestMemberVO data=null;
		try {
			pstmt=conn.prepareStatement(getMemSql);
			pstmt.setString(1, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new TestMemberVO();
				data.setId(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setPw(rs.getString("pw"));
			}
			rs.close();
		}catch(Exception e) {
			System.out.println("getMem!!");
			e.printStackTrace();
		}finally {
			JDBC.disconnect(conn, pstmt);
		}
		return data;
	}
	public boolean updateMem(TestMemberVO vo) {
		conn=JDBC.connect();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(updateMemSql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getId());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("updateMem!!");
			e.printStackTrace();
		}finally {
			JDBC.disconnect(conn, pstmt);
		}
		return flag;
	}
	public boolean deleteMem(TestMemberVO vo) {
		conn=JDBC.connect();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(deleteMemSql);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("deleteMem!!");
			e.printStackTrace();
		}finally {
			JDBC.disconnect(conn, pstmt);
		}
		return flag;
	}
}
