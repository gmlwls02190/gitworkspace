package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		// 1. 스프링 컨테이너를 동작시켜보자!~~
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 객체를 요청하면, 해당 객체를 준다.
		// == Look up
//		Test t=(Test)factory.getBean("test");
//		t.print();
		
		Phone p=(Phone)factory.getBean("phone");
		p.powerOn();
		p.volumeUp();
		
		// 3. 스프링 컨테이너 종료
		factory.close();
		
		// => Console
		// 현재 <bean> 등록된 모든 클래스에 대한 객체를 미리 만들어놓습니다!
		// pre-loading 즉시 로딩 <-> lazy loading 지연 로딩
	}
}
