package test2;

public class Garen implements Skill{

	private Items items;
	
	public Garen() {
		System.out.println("����!");
	}
	public Garen(Items items) {
		this.items=items;
		System.out.println("����������");
	}
	@Override
	public void q() {
		items.ad();
		System.out.println("����Ÿ");
	}

	@Override
	public void w() {
		System.out.println("���");
	}

	@Override
	public void e() {
		items.def();
		System.out.println("����");
	}

	@Override
	public void r() {
		System.out.println("�����þ��� ����");
	}

}
