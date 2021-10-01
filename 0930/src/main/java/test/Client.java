package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		Skill skill=(Skill)factory.getBean("champ");
		skill.q();
		skill.w();
		skill.e();
		
		/*LevList ll=(LevList)factory.getBean("ll");
		List<String> list=ll.getList();
		for(String v:list) {
			System.out.println(v);
		}*/
		
		
		/*CBean cb=(CBean)factory.getBean("cb");
		Map<String,String> map=cb.getMap();
		System.out.println(map);*/
		/*List<String> list=cb.getList();
		for(String v:list) {
			System.out.println(v);
		}*/
		
		factory.close();
		
	}
}