package model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private SpringMemberDAO mDAO;
	
	@Override
	public void insertMember(MemberVO vo) {
		mDAO.insertMember(vo);
	}

	@Override
	public List<MemberVO> getMemberList() {
		return mDAO.getMemberList();
	}

	@Override
	public MemberVO getMember(MemberVO vo) {
		try {
			MemberVO data=mDAO.getMember(vo);
			System.out.println("Login Succeed");
			System.out.println(data.getName()+"님 환영합니다!");
			return data;
		}catch(Exception e) {
			System.out.println("Login Failed");
			return null;
		}
	}

	@Override
	public void updateMember(MemberVO vo) {
		mDAO.updateMember(vo);
	}

	@Override
	public void deleteMember(MemberVO vo) {
		mDAO.deleteMember(vo);
	}

}
