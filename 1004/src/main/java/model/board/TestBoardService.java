package model.board;

import java.util.List;

public interface TestBoardService {
	void insertTBoard(TestBoardVO vo); // 메서드 시그니처
	void updateTBoard(TestBoardVO vo);
	void deleteTBoard(TestBoardVO vo);
	List<TestBoardVO> selectAll();
	TestBoardVO selectOne(TestBoardVO vo);
}