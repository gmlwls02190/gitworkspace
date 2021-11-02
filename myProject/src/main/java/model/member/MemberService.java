package model.member;

import java.util.ArrayList;

public interface MemberService {
	boolean insertMember(MemberVO vo);
	boolean updateMember(MemberVO vo);
	boolean deleteMember(MemberVO vo);
	MemberVO getOneMember(MemberVO vo);
	ArrayList<MemberVO> getAllMember();
}
