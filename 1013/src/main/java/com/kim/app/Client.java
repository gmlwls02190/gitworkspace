package com.kim.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.member.MemService;
import model.member.MemVO;

public class Client {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		MemService ms=(MemService)factory.getBean("memService");
//		BoardService bs=(BoardService)factory.getBean("boardService");
		
		MemVO mVO=new MemVO();
		mVO.setId("qwe");
		mVO.setName("qweqwe");
		mVO.setPassword("qwe");
		ms.insertTMember(mVO);
		
//		MemVO data=ms.selectOne(mVO);
//		System.out.println(data);
		
//		List<MemVO> datas=ms.selectAll();
//		for(MemVO v:datas) {
//			System.out.println(v);
//		}
		
//		BoardVO bVO=new BoardVO();
//		bVO.setContent("게시글내용12");
//		bVO.setTitle("제");
//		bVO.setWriter("작성자12");
//		bs.insertBoard(bVO);
		
		
		
//		List<BoardVO> datas=bs.searchBoardList(bVO);
//		//datas=bs.getBoardList();
//		
//		System.out.println(datas.size());
//		//System.out.println("test: "+bs.searchBoardList("제목"));
//		for(BoardVO v:datas) { 
//			System.out.println(v);
//		}
		
		factory.close();
	}
}
