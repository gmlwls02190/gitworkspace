package test;

public class Sword implements Items{

	public Sword() {
		System.out.println("검");
	}
	@Override
	public void ad() {
		System.out.println("물리공격력+=10");
	}

	@Override
	public void ap() {
		System.out.println("마법공격력+=1");
	}

	@Override
	public void def() {
		System.out.println("방어력+=5");
	}

}
