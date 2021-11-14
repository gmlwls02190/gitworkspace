package model.heart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("heartService")
public class HeartServiceImpl implements HeartService{

	@Autowired
	private HeartDAO dao;
	
	@Override
	public boolean insertHeart(HeartVO vo) {
		return dao.insertHeart(vo);
	}

	@Override
	public HeartVO getHeart(HeartVO vo) {
		return dao.getHeart(vo);
	}

	@Override
	public boolean updateHeart(HeartVO vo) {
		return dao.updateHeart(vo);
	}

	@Override
	public boolean deleteHeart(HeartVO vo) {
		return dao.deleteHeart(vo);
	}

}
