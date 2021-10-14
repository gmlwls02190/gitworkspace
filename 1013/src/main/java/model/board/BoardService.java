package model.board;

import java.util.List;

public interface BoardService {
	List<BoardVO> searchBoardList(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	void insertBoard(BoardVO vo);
	void updateBoard(BoardVO vo);
	void deleteBoard(BoardVO vo);
}
