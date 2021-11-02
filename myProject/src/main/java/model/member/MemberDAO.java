package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("memberDAO")
public class MemberDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String insertSQL ="insert into member values(?,?,?,?,?,?,?,?,?,'USER')";
	private final String updateSQL ="update member set pw=?, artist=?, firstemail=?, lastemail=?, addrNum=?, roadAddr=?, detailAddr=?, callNum=? where id=?";
	private final String deleteSQL ="delete from member where id=?";
	private final String getOneSQL ="select * from member where id=?";
	private final String getArtistSQL ="select * from member where artist=?";
	private final String getAllSQL ="select * from member";
	
	public boolean insertMember(MemberVO vo) {
		System.out.println("insertMember!!!");
		conn=JDBC.getConnection();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getArtist());
			pstmt.setString(4, vo.getFirstemail());
			pstmt.setString(5, vo.getLastemail());
			pstmt.setString(6, vo.getAddrNum());
			pstmt.setString(7, vo.getRoadAddr());
			pstmt.setString(8, vo.getDetailAddr());
			pstmt.setString(9, vo.getCallNum());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("insertMember error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return flag;
	}
	
	public boolean updateMember(MemberVO vo) {	
		System.out.println("updateMember!!!");
		conn=JDBC.getConnection();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getArtist());
			pstmt.setString(3, vo.getFirstemail());
			pstmt.setString(4, vo.getLastemail());
			pstmt.setString(5, vo.getAddrNum());
			pstmt.setString(6, vo.getRoadAddr());
			pstmt.setString(7, vo.getDetailAddr());
			pstmt.setString(8, vo.getCallNum());
			pstmt.setString(9, vo.getId());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("updateMember error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return flag;
	}

	public boolean deleteMember(MemberVO vo) {	
		System.out.println("deleteMember!!!");
		conn=JDBC.getConnection();
		pstmt=null;
		boolean flag=false;
		try {
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			System.out.println("deleteMember error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return flag;
	}
	
	public MemberVO getOneMember(MemberVO vo) {
		System.out.println("getOneMember!!!");
		conn=JDBC.getConnection();
		pstmt=null;
		MemberVO data=null;
		try {
			if(vo.getId()!=null || vo.getId()=="") {
				pstmt=conn.prepareStatement(getOneSQL);
				pstmt.setString(1, vo.getId());
			}
			if(vo.getArtist()!=null || vo.getArtist()=="") {
				pstmt=conn.prepareStatement(getArtistSQL);
				pstmt.setString(1, vo.getArtist());
			}
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemberVO();
				data.setAddrNum(rs.getString("addrNum"));
				data.setRoadAddr(rs.getString("roadAddr"));
				data.setDetailAddr(rs.getString("detailAddr"));
				data.setArtist(rs.getString("artist"));
				data.setCallNum(rs.getString("callNUm"));
				data.setFirstemail(rs.getString("firstemail"));
				data.setLastemail(rs.getString("lastemail"));
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				data.setRole(rs.getString("role"));
			}
			rs.close();
		}catch(Exception e) {
			System.out.println("getOneMember error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return data;
	}
	
	public ArrayList<MemberVO> getAllMember(){
		System.out.println("getAllMember");
		conn=JDBC.getConnection();
		pstmt=null;
		ArrayList<MemberVO> datas=new ArrayList<MemberVO>();
		try {
			pstmt=conn.prepareStatement(getAllSQL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo=new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setArtist(rs.getString("artist"));
				vo.setAddrNum(rs.getString("addrNum"));
				vo.setRoadAddr(rs.getString("roadAddr"));
				vo.setDetailAddr(rs.getString("detailAddr"));
				vo.setFirstemail(rs.getString("firstemail"));
				vo.setLastemail(rs.getString("lastemail"));
				vo.setCallNum(rs.getString("callNUm"));
				vo.setRole(rs.getString("role"));
				datas.add(vo);
			}
			rs.close();
		}catch(Exception e) {
			System.out.println("getAllMember error");
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}
}