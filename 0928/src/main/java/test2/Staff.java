package test2;

public class Staff implements Items{

	public Staff() {
		System.out.println("지팡이");
	}
	@Override
	public void ad() {
		System.out.println("물리공격력+=0");
	}

	@Override
	public void ap() {
		System.out.println("마법공격력+=10");
	}

	@Override
	public void def() {
		System.out.println("방어력+=1");
	}

}
