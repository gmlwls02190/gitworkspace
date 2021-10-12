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
		data.setId(rs.getString("id"));
		data.setName(rs.getString("name"));
		data.setPassword(rs.getString("password"));
		data.setRole(rs.getString("role"));
		return data;
	}
	
}
@Repository
public class SpringMemberDAO {
	
	private String insertSql="insert into member values(?,?,?,'USER')";
	private String selectAllSql="select * from member";
	private String selectOneSql="select * from member where id=?";
	private String updateSql="update member set password=?, name=? where id=?";
	private String deleteSql="delete member where id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertMember(MemberVO vo) {
		System.out.println("insertMember!");
		Object[] args= {vo.getId(),vo.getPassword(),vo.getName()};
		jdbcTemplate.update(insertSql,args);
	}
	public List<MemberVO> getMemberList() {
		System.out.println("getMemberList!");
		return jdbcTemplate.query(selectAllSql,new MemberRowMapper());
	}
	public MemberVO getMember(MemberVO vo) {
		System.out.println("getMember!");
		Object[] args= {vo.getId()};
		return jdbcTemplate.queryForObject(selectOneSql,args,new MemberRowMapper());
	}
	public void updateMember(MemberVO vo) {
		System.out.println("updateMember!");
		Object[] args= {vo.getPassword(),vo.getName(),vo.getId()};
		jdbcTemplate.update(updateSql,args);
	}
	public void deleteMember(MemberVO vo) {
		System.out.println("deleteMember!");
		Object[] args= {vo.getId()};
		jdbcTemplate.update(deleteSql,args);
	}
}
