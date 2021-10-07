package model.member;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		TestMemService tms=(TestMemService)factory.getBean("testMemService");
		
		TestMemVO vo=new TestMemVO();
		vo.setId("admin");
		vo.setPassword("1234");
		/*tms.insertTMember(vo);*/
		
		/*tms.deleteTMember(vo);*/
		
		TestMemVO data=tms.selectOne(vo);
		if(data==null) {
			System.out.println("login failed");
		}
		else{
			System.out.println("login success");
		}
		
		List<TestMemVO> datas=tms.selectAll();
		for(TestMemVO v:datas) {
			System.out.println(v);
		}
		
		factory.close();
	}
}