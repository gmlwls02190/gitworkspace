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
		if(vo.getId()==0) { // 일부러 예외발생시키기 위해서 작성
			throw new IllegalArgumentException("id PK : 0 불가능!");
			// 런타임 예외(실생시에 발생, 체크되는 예외)
		}
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
