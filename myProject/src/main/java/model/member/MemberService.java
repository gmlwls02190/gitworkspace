package model.member;

import java.util.List;

public interface MemberService {
	boolean insertMember(MemberVO vo);
	boolean updateMember(MemberVO vo);
	boolean updateMemberPW(MemberVO vo);
	boolean deleteMember(MemberVO vo);
	MemberVO getOneMember(MemberVO vo);
	List<MemberVO> getAllMember();
}
