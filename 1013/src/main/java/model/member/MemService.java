package model.member;

import java.util.List;

public interface MemService {
	public void insertTMember(MemVO vo);
	public void updateTMember(MemVO vo);
	public void deleteTMember(MemVO vo);
	public List<MemVO> selectAll();
	public MemVO selectOne(MemVO vo);
}
