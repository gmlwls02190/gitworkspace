package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class BoardRowMapper implements RowMapper<TestBoardVO>{

	@Override
	public TestBoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TestBoardVO data=new TestBoardVO();
		data.setId(rs.getInt("id"));
		data.setTitle(rs.getString("title"));
		data.setWriter(rs.getString("writer"));
		data.setContent(rs.getString("content"));
		data.setWdate(rs.getDate("wdate"));
		return data;
	}
	
}
// 1. extends 상속받아서 구현
// 2. jdbcTemplate을 <bean>등록, 의존성주입받아 사용
@Repository("springBoardDAO")
public class SpringBoardDAO{
	
	private final String insertSQL ="insert into testboard (id,title,writer,content) values((select nvl(max(id),0)+1 from testboard),?,?,?)";
	private final String updateSQL ="update testboard set title=?, content=? where id=?";
	private final String deleteSQL ="delete from testboard where id=?";
	private final String selectAllSQL ="select * from testboard";
	private final String selectOneSQL ="select * from testboard where id=?";
	
//	extends JdbcDaoSupport
//	@Autowired
//	public void setSuperDataSource(DataSource dataSource) {
//		super.setDataSource(dataSource);
//	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertTBoard(TestBoardVO vo) {
		System.out.println("jdbcTemplate으로 insert");
		jdbcTemplate.update(insertSQL,vo.getTitle(),vo.getWriter(),vo.getContent());
	}
	
	public void updateTBoard(TestBoardVO vo) {	
		System.out.println("jdbcTemplate으로 update");
		jdbcTemplate.update(updateSQL,vo.getTitle(),vo.getContent(),vo.getId());
	}
	
	public void deleteTBoard(TestBoardVO vo) {	
		System.out.println("jdbcTemplate으로 delete");
		jdbcTemplate.update(deleteSQL,vo.getId());
	}
	
	public List<TestBoardVO> selectAll() {
		System.out.println("jdbcTemplate으로 selectAll");
		return jdbcTemplate.query(selectAllSQL,new BoardRowMapper());
	}
	
	public TestBoardVO selectOne(TestBoardVO vo) {
		System.out.println("jdbcTemplate으로 selectOne");
		Object[] args= {vo.getId()};
		return jdbcTemplate.queryForObject(selectOneSQL,args,new BoardRowMapper());
	}
	
}
