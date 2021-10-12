package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class BoardRowMapper implements RowMapper<BoardVO>{
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data=new BoardVO();
		data.setContent(rs.getString("content"));
		data.setId(rs.getInt("id"));
		data.setTitle(rs.getString("title"));
		data.setWdate(rs.getDate("wdate"));
		data.setWriter(rs.getString("writer"));
		return data;
	}
}
@Repository
public class SpringBoardDAO {
	
	private String insertSql="insert into board values((select nvl(max(id),0)+1 from board),?,?,?,sysdate)";
	private String selectAllSql="select * from board";
	private String selectOneSql="select * from board where id=?";
	private String updateSql="update board set title=?, content=? where id=?";
	private String deleteSql="delete board where id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("insertBoard!");
		Object[] args= {vo.getTitle(),vo.getWriter(),vo.getContent()};
		jdbcTemplate.update(insertSql, args);
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("getBoardList!");
		if(vo.getTitle()==null || vo.getTitle()=="") {
			return jdbcTemplate.query(selectAllSql, new BoardRowMapper());
		}
		else {
			String searchSql="select * from board where title like ?";
			Object[] args= {"%"+vo.getTitle()+"%"};
			return jdbcTemplate.query(searchSql, args, new BoardRowMapper());
		}
	}
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("getBoard!");
		Object[] args= {vo.getId()};
		return jdbcTemplate.queryForObject(selectOneSql, args, new BoardRowMapper());
	}
	public void updateBoard(BoardVO vo) {
		System.out.println("updateBoard!");
		Object[] args= {vo.getTitle(),vo.getContent(),vo.getId()};
		jdbcTemplate.update(updateSql, args);
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("deleteBoard!");
		Object[] args= {vo.getId()};
		jdbcTemplate.update(deleteSql, args);
	}

}
