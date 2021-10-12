package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private SpringBoardDAO bDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		bDAO.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return bDAO.getBoardList(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return bDAO.getBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		bDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		bDAO.deleteBoard(vo);
	}

}
