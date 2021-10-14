package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO bDAO;
	
	@Override
	public List<BoardVO> searchBoardList(BoardVO vo) {
		//System.out.println(bDAO.searchBoardList(content));
		return bDAO.searchBoardList(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return bDAO.getBoard(vo);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		bDAO.insertBoard(vo);
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
