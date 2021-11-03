package model.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class MemberRowMapper implements RowMapper<MemberVO>{
	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
		data.setAddrNum(rs.getString("addrNum"));
		data.setArtist(rs.getString("artist"));
		data.setCallNum(rs.getString("callNum"));
		data.setDetailAddr(rs.getString("detailAddr"));
		data.setFirstemail(rs.getString("firstemail"));
		data.setId(rs.getString("id"));
		data.setLastemail(rs.getString("lastemail"));
		data.setPw(rs.getString("pw"));
		data.setRoadAddr(rs.getString("roadAddr"));
		data.setRole(rs.getString("user"));
		return data;
	}
}

@Repository("springMemberDAO")
public class SpringMemberDAO {
	
	private final String insertSQL ="insert into member values(?,?,?,?,?,?,?,?,?,'USER')";
	private final String updateSQL ="update member set pw=?, artist=?, firstemail=?, lastemail=?, addrNum=?, roadAddr=?, detailAddr=?, callNum=? where id=?";
	private final String deleteSQL ="delete from member where id=?";
	private final String getOneSQL ="select * from member where id=?";
	private final String getArtistSQL ="select * from member where artist=?";
	private final String getAllSQL ="select * from member";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean insertMember(MemberVO vo) {
		System.out.println("insertMember!!!");
		Object[] args= {vo.getId(),vo.getPw(),vo.getArtist(),vo.getFirstemail(),vo.getLastemail(),vo.getAddrNum(),vo.getRoadAddr(),vo.getDetailAddr(),vo.getCallNum()};
		return (jdbcTemplate.update(insertSQL,args)>=1)? true:false;
	}
	
	public boolean updateMember(MemberVO vo) {	
		System.out.println("updateMember!!!");
		Object[] args= {vo.getPw(),vo.getArtist(),vo.getFirstemail(),vo.getLastemail(),vo.getAddrNum(),vo.getRoadAddr(),vo.getDetailAddr(),vo.getCallNum(),vo.getId()};
		return (jdbcTemplate.update(updateSQL,args)>=1)? true:false;
	}

	public boolean deleteMember(MemberVO vo) {	
		System.out.println("deleteMember!!!");
		Object[] args= {vo.getId()};
		return (jdbcTemplate.update(deleteSQL,args)>=1)? true:false;
	}
	
	public MemberVO getOneMember(MemberVO vo) {
		System.out.println("getOneMember!!!");
		if(vo.getArtist()!=null || vo.getId()=="") {
			Object[] args= {vo.getArtist()};
			return jdbcTemplate.queryForObject(getArtistSQL, args, new MemberRowMapper());
		}
		Object[] args= {vo.getId()};
		return jdbcTemplate.queryForObject(getOneSQL, args, new MemberRowMapper());
	}
	
	public List<MemberVO> getAllMember(){
		System.out.println("getAllMember");
		return jdbcTemplate.query(getAllSQL, new MemberRowMapper());
	}
	
}
