package model.member;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		TestMemService tms=(TestMemService)factory.getBean("testMemService");
		
		TestMemVO vo=new TestMemVO();
		vo.setId("qwe");
		/*vo.setPassword("qwe");
		vo.setName("teemo");
		tms.insertTMember(vo);*/
		
		tms.deleteTMember(vo);
		
		List<TestMemVO> datas=tms.selectAll();
		for(TestMemVO data:datas) {
			System.out.println(data);
		}
		
		factory.close();
	}
}