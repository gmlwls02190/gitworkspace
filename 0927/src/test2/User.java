package test2;

public class User {
	public static void main(String[] args) {
		BeanFactory factory=new BeanFactory();
		Skill champ=(Skill)factory.getBean(args[0].toLowerCase());
		champ.q();
		champ.w();
		champ.e();
		champ.r();
	}
}
