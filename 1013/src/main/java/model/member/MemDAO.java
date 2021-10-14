package model.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class MemRowMapper implements RowMapper<MemVO>{
	@Override
	public MemVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemVO data=new MemVO();
		data.setId(rs.getString("id"));
		data.setPassword(rs.getString("password"));
		data.setName(rs.getString("name"));
		data.setRole(rs.getString("role"));
		return data;
	}
}

@Repository("memDAO")
public class MemDAO {
	private final String insertSQL ="insert into member values(?,?,?,'USER')";
	private final String updateSQL ="update member set password=?, name=? where id=?";
	private final String deleteSQL ="delete from member where id=?";
	private final String selectAllSQL ="select * from member";
	private final String selectOneSQL ="select * from member where id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	public void insertTMember(MemVO vo) {
		System.out.println("jdbcTemplate insert");
		Object[] args= {vo.getId(),vo.getPassword(),vo.getName()};
		jdbcTemplate.update(insertSQL,args);
	}
	
	public void updateTMember(MemVO vo) {	
		System.out.println("jdbcTemplate update");
		Object[] args= {vo.getPassword(),vo.getName(),vo.getId()};
		jdbcTemplate.update(updateSQL,args);
	}

	public void deleteTMember(MemVO vo) {	
		System.out.println("jdbcTemplate delete");
		Object[] args= {vo.getId()};
		jdbcTemplate.update(deleteSQL,args);
	}
	
	public List<MemVO> selectAll() {
		System.out.println("jdbcTemplate selectAll");
		return jdbcTemplate.query(selectAllSQL,new MemRowMapper());
	}
	
	public MemVO selectOne(MemVO vo) {
		System.out.println("jdbcTemplate delete");
		Object[] args= {vo.getId()};
		return jdbcTemplate.queryForObject(selectOneSQL,args,new MemRowMapper());
	}
}
// 1. Support 상속
// 2. <bean> 주입