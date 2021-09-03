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
		// DB데이터를 생성
		// -> Member.java
		
		ArrayList<Member> datas=new ArrayList<Member>();
		for(int i=1;i<=5;i++) {
			Member data=new Member("티모"+i, "timo"+i+"@naver.com");
			datas.add(data);
		}
		datas.add(new Member("아리",null));
		datas.add(new Member("아무무",null));
		
		// 현재 만든 데이터들은 톰캣이시작될때 생성된 것들
		// scope: application에 저장하고싶다!
		
		ServletContext context= arg0.getServletContext();
		context.setAttribute("members", datas);
		context.setAttribute("member", new Member());
		// application scope에 저장됨!!
		
	}
	
	
	
}
