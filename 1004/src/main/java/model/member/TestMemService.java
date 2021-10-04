package model.member;

import java.util.List;

public interface TestMemService {
	public void insertTMember(TestMemVO vo);
	public void updateTMember(TestMemVO vo);
	public void deleteTMember(TestMemVO vo);
	public List<TestMemVO> selectAll();
	public TestMemVO selectOne(TestMemVO vo);
}
