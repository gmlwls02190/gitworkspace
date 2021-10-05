package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		// 1. ������ �����̳ʸ� ���۽��Ѻ���!~~
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. ��ü�� ��û�ϸ�, �ش� ��ü�� �ش�.
		// == Look up
//		Test t=(Test)factory.getBean("test");
//		t.print();
		
		Phone p=(Phone)factory.getBean("phone");
		p.powerOn();
		p.volumeUp();
		
		// 3. ������ �����̳� ����
		factory.close();
		
		// => Console
		// ���� <bean> ��ϵ� ��� Ŭ������ ���� ��ü�� �̸� ���������ϴ�!
		// pre-loading ��� �ε� <-> lazy loading ���� �ε�
	}
}