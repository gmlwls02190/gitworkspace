package test2;

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
		System.out.println("�������ݷ�+=0");
	}

	@Override
	public void def() {
		System.out.println("����+=1");
	}

}
