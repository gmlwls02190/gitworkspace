package test2;

public class Shield implements Items{

	public Shield() {
		System.out.println("방패");
	}
	@Override
	public void ad() {
		System.out.println("물리공격력+=5");
	}

	@Override
	public void ap() {
		System.out.println("마법공격력+=0");
	}

	@Override
	public void def() {
		System.out.println("방어력+=10");
	}

}
