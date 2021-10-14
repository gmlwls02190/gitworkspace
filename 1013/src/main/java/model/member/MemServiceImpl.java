package model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memService")
public class MemServiceImpl implements MemService{

	@Autowired
	private MemDAO mDAO;

	@Override
	public void insertTMember(MemVO vo) {
		mDAO.insertTMember(vo);
	}

	@Override
	public void updateTMember(MemVO vo) {
		mDAO.updateTMember(vo);
	}

	@Override
	public void deleteTMember(MemVO vo) {
		mDAO.deleteTMember(vo);
	}

	@Override
	public List<MemVO> selectAll() {
		return mDAO.selectAll();
	}

	@Override
	public MemVO selectOne(MemVO vo) {
		return mDAO.selectOne(vo);
	}
	
}
