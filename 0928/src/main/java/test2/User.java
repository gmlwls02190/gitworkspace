package test2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class User {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		Skill skill=(Skill)factory.getBean("champ");
		skill.q();
		System.out.println();
		skill.w();
		System.out.println();
		skill.e();
		System.out.println();
		skill.r();
		
		factory.close();
	}
}
