package test2;

public class Teemo implements Skill{

	private Items items;
	
	public Teemo() {
		System.out.println("Ƽ��!");
	}
	public Teemo(Items items) {
		this.items=items;
		System.out.println("Ƽ�������");
	}
	@Override
	public void q() {
		items.ad();
		System.out.println("�Ǹ� ��Ʈ");
	}

	@Override
	public void w() {
		items.def();
		System.out.println("�ż��� �̵�");
	}

	@Override
	public void e() {
		System.out.println("�͵� ��Ʈ");
	}

	@Override
	public void r() {
		items.ap();
		System.out.println("������ ����");
	}

}
