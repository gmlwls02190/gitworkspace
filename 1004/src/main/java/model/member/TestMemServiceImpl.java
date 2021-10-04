package model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testMemService")
public class TestMemServiceImpl implements TestMemService{
	
	@Autowired
	private TestMemDAO tmDAO;
	
	@Override
	public void insertTMember(TestMemVO vo) {
		tmDAO.insertTMember(vo);
	}

	@Override
	public void updateTMember(TestMemVO vo) {
		tmDAO.updateTMember(vo);
	}

	@Override
	public void deleteTMember(TestMemVO vo) {
		tmDAO.deleteTMember(vo);
	}

	@Override
	public List<TestMemVO> selectAll() {
		return tmDAO.selectAll();
	}

	@Override
	public TestMemVO selectOne(TestMemVO vo) {
		return tmDAO.selectOne(vo);
	}

}
