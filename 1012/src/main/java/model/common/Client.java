package model.common;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.board.BoardService;
import model.board.BoardVO;
import model.member.MemberService;
import model.member.MemberVO;

public class Client {
	public static void main(String[] args) {

		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");

		BoardService bs=(BoardService)factory.getBean("boardService");
		MemberService ms=(MemberService)factory.getBean("memberService");

		BoardVO bVO=new BoardVO();
//		bVO.setContent("글작성테스트");
//		bVO.setTitle("글작성");
//		bVO.setWriter("작성자");
//		bs.insertBoard(bVO);
		
		bVO.setId(3);
		BoardVO bdata=bs.getBoard(bVO);
		System.out.println(bdata);
		
		bVO.setTitle("2");
		List<BoardVO> bdatas=bs.getBoardList(bVO);
		for(BoardVO v:bdatas) {
			System.out.println(v);
		}
//		=====================================================
		MemberVO mVO=new MemberVO();
		mVO.setId("asd");
		mVO.setName("qwe");
		mVO.setPassword("qwe");
//		ms.insertMember(mVO);
		
		List<MemberVO> mdatas=ms.getMemberList();
		for(MemberVO v:mdatas) {
			System.out.println(v);
		}
		ms.getMember(mVO);

		factory.close();
	}
}