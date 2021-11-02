package model.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	@Override
	public boolean insertMember(MemberVO vo) {
		return dao.insertMember(vo);
	}

	@Override
	public boolean updateMember(MemberVO vo) {
		return dao.updateMember(vo);
	}

	@Override
	public boolean deleteMember(MemberVO vo) {
		return dao.deleteMember(vo);
	}

	@Override
	public MemberVO getOneMember(MemberVO vo) {
		return dao.getOneMember(vo);
	}

	@Override
	public ArrayList<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

}
