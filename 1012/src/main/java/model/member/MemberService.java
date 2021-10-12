package model.member;

import java.util.List;

public interface MemberService {
	void insertMember(MemberVO vo);
	List<MemberVO> getMemberList();
	MemberVO getMember(MemberVO vo);
	void updateMember(MemberVO vo);
	void deleteMember(MemberVO vo);
}
