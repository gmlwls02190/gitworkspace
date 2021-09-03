package test;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitialMember implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
	public void contextInitialized(ServletContextEvent arg0) {
		// DB�����͸� ����
		// -> Member.java
		
		ArrayList<Member> datas=new ArrayList<Member>();
		for(int i=1;i<=5;i++) {
			Member data=new Member("Ƽ��"+i, "timo"+i+"@naver.com");
			datas.add(data);
		}
		datas.add(new Member("�Ƹ�",null));
		datas.add(new Member("�ƹ���",null));
		
		// ���� ���� �����͵��� ��Ĺ�̽��۵ɶ� ������ �͵�
		// scope: application�� �����ϰ�ʹ�!
		
		ServletContext context= arg0.getServletContext();
		context.setAttribute("members", datas);
		context.setAttribute("member", new Member());
		// application scope�� �����!!
		
	}
	
	
	
}
