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
@Repository("boardDAO")
public class BoardDAO {
	
//	private String getAllSQL="select * from board";
//	private String searchSQL="select * from board where title like ?";
	private String getOneSQL="select * from board where id=?";
	private String insertSQL="insert into board values((select nvl(max(id),0)+1 from board),?,?,?,sysdate)";
	private String updateSQL="update board set title=?,content=? where id=?";
	private String deleteSQL="delete board where id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<BoardVO> searchBoardList(BoardVO vo) {
		System.out.println("searchBoardList!!!!");
		if(vo.getTitle()==null || vo.getTitle()=="") {
			System.out.println("??ü");
			String getAllSQL="select * from board";
			return jdbcTemplate.query(getAllSQL,new BoardRowMapper());
		}
		else {
			System.out.println("?˻?");
			String searchSQL="select * from board where title like ?";
			Object[] args= {"%"+vo.getTitle()+"%"};
			return jdbcTemplate.query(searchSQL,args,new BoardRowMapper());			
		}
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("getBoard");
		Object[] args= {vo.getId()};
		return jdbcTemplate.queryForObject(getOneSQL,args,new BoardRowMapper());
	}
	
	public void insertBoard(BoardVO vo) {
		System.out.println("insertBoard");
		Object[] args= {vo.getTitle(),vo.getWriter(),vo.getContent()};
		jdbcTemplate.update(insertSQL,args);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("updateBoard");
		Object[] args= {vo.getTitle(),vo.getContent(),vo.getId()};
		jdbcTemplate.update(updateSQL,args);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("deleteBoard");
		Object[] args= {vo.getId()};
		jdbcTemplate.update(deleteSQL,args);
	}
}
