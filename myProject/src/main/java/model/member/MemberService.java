package model.member;

public interface MemberService {
	boolean insertMember(MemberVO vo);
	boolean updateMember(MemberVO vo);
	boolean deleteMember(MemberVO vo);
	MemberVO getOneMember(MemberVO vo);
}
