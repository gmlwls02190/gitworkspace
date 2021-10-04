package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testBoardService")
public class TestBoardServiceImpl implements TestBoardService{

	@Autowired
	private TestBoardDAO tbDAO;
	
	@Override
	public void insertTBoard(TestBoardVO vo) {
		tbDAO.insertTBoard(vo);
	}

	@Override
	public void updateTBoard(TestBoardVO vo) {
		tbDAO.updateTBoard(vo);
	}

	@Override
	public void deleteTBoard(TestBoardVO vo) {
		tbDAO.deleteTBoard(vo);
	}

	@Override
	public List<TestBoardVO> selectAll() {
		return tbDAO.selectAll();
	}

	@Override
	public TestBoardVO selectOne(TestBoardVO vo) {
		return tbDAO.selectOne(vo);
	}

}
