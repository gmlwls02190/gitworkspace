package test;

public class Sword implements Items{

	public Sword() {
		System.out.println("��");
	}
	@Override
	public void ad() {
		System.out.println("�������ݷ�+=10");
	}

	@Override
	public void ap() {
		System.out.println("�������ݷ�+=1");
	}

	@Override
	public void def() {
		System.out.println("����+=5");
	}

}
