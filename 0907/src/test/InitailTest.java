package test;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitailTest implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ArrayList<testVO> products=new ArrayList<testVO>();
		
		products.add(new testVO("�����","�ҷ�"));
		products.add(new testVO("���","�纸"));
		products.add(new testVO("����","����"));
		products.add(new testVO("������","����"));
		
		ServletContext context=sce.getServletContext();
		context.setAttribute("datas", products);
	}

}
