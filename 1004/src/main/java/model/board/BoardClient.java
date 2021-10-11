package model.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		TestBoardService tbs=(TestBoardService)factory.getBean("testBoardService");
		
		TestBoardVO vo=new TestBoardVO();
		vo.setContent("jdbcTemplate Ŭ������ �̿��� �ǽ��Ϸ�");
		vo.setTitle("�����Դϴ�");
		vo.setWriter("������");
		tbs.insertTBoard(vo);
		
		List<TestBoardVO> datas=tbs.selectAll();
		for(TestBoardVO data:datas) {
			System.out.println(data);
		}
		
		factory.close();
	}
}