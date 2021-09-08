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
		
		products.add(new testVO("양배추","불량"));
		products.add(new testVO("사과","양보"));
		products.add(new testVO("딸기","보통"));
		products.add(new testVO("복숭아","부패"));
		
		ServletContext context=sce.getServletContext();
		context.setAttribute("datas", products);
	}

}
