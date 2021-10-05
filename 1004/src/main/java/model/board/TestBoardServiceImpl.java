package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kim.app.common.LogPlusAdvice;

@Service("testBoardService")
public class TestBoardServiceImpl implements TestBoardService{

	@Autowired
	private TestBoardDAO tbDAO;
	private LogPlusAdvice logPlusAdvice;
	
	public TestBoardServiceImpl() {
		this.logPlusAdvice=new LogPlusAdvice();
	}
	
	@Override
	public void insertTBoard(TestBoardVO vo) {
		logPlusAdvice.printPlusLog();
		tbDAO.insertTBoard(vo);
	}

	@Override
	public void updateTBoard(TestBoardVO vo) {
		logPlusAdvice.printPlusLog();
		tbDAO.updateTBoard(vo);
	}

	@Override
	public void deleteTBoard(TestBoardVO vo) {
		logPlusAdvice.printPlusLog();
		tbDAO.deleteTBoard(vo);
	}

	@Override
	public List<TestBoardVO> selectAll() {
		logPlusAdvice.printPlusLog();
		return tbDAO.selectAll();
	}

	@Override
	public TestBoardVO selectOne(TestBoardVO vo) {
		logPlusAdvice.printPlusLog();
		return tbDAO.selectOne(vo);
	}

}
