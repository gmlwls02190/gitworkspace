package model.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		TestBoardService tbs=(TestBoardService)factory.getBean("testBoardService");
		
		TestBoardVO vo=new TestBoardVO();
		vo.setContent("jdbcTemplate 클래스를 이용한 실습완료");
		vo.setTitle("제목입니다");
		vo.setWriter("관리자");
		tbs.insertTBoard(vo);
		
		List<TestBoardVO> datas=tbs.selectAll();
		for(TestBoardVO data:datas) {
			System.out.println(data);
		}
		
		factory.close();
	}
}