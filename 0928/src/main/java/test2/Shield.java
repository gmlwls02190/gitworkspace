package test2;

public class Shield implements Items{

	public Shield() {
		System.out.println("����");
	}
	@Override
	public void ad() {
		System.out.println("�������ݷ�+=5");
	}

	@Override
	public void ap() {
		System.out.println("�������ݷ�+=0");
	}

	@Override
	public void def() {
		System.out.println("����+=10");
	}

}
