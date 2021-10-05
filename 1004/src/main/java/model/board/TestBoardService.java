package model.board;

import java.util.List;

public interface TestBoardService {
	void insertTBoard(TestBoardVO vo); // �޼��� �ñ״�ó
	void updateTBoard(TestBoardVO vo);
	void deleteTBoard(TestBoardVO vo);
	List<TestBoardVO> selectAll();
	TestBoardVO selectOne(TestBoardVO vo);
}