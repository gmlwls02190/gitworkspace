package test2;

public class BeanFactory {
	
	public Object getBean(String beanName) {
		if(beanName.equals("teemo") || beanName.equals("Ƽ��")) {
			return new Timo();
		}
		else if(beanName.equals("garen") || beanName.equals("����")) {
			return new Garen();
		}
		return null;
	}
}
