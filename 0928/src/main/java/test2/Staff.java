package test2;

public class Staff implements Items{

	public Staff() {
		System.out.println("������");
	}
	@Override
	public void ad() {
		System.out.println("�������ݷ�+=0");
	}

	@Override
	public void ap() {
		System.out.println("�������ݷ�+=10");
	}

	@Override
	public void def() {
		System.out.println("����+=1");
	}

}
