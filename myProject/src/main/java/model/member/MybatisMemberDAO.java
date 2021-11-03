package model.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mybatisMemberDAO")
public class MybatisMemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public boolean insertMember(MemberVO vo) {
		System.out.println("Mybatis insertMember");
		return (mybatis.insert("memberDAO.insertMember",vo)>=1)? true:false;
	}
	
	public boolean updateMember(MemberVO vo) {	
		System.out.println("Mybatis updateMember");
		return (mybatis.insert("memberDAO.updateMember",vo)>=1)? true:false;
	}
	
	public boolean deleteMember(MemberVO vo) {	
		System.out.println("Mybatis deleteMember");
		return (mybatis.insert("memberDAO.deleteMember",vo)>=1)? true:false;
	}
	
	public MemberVO getOneMember(MemberVO vo) {
		System.out.println("Mybatis getOneMember");
		return (MemberVO)mybatis.selectOne("memberDAO.getOneMember", vo);
	}
	
	public List<MemberVO> getAllMember(){
		System.out.println("Mybatis getAllMember");
		return mybatis.selectList("memberDAO.getAllMember");
	}
}
