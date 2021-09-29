package test2;

public class Garen implements Skill{

	private Items items;
	
	public Garen() {
		System.out.println("가렌!");
	}
	public Garen(Items items) {
		this.items=items;
		System.out.println("가렌아이템");
	}
	@Override
	public void q() {
		items.ad();
		System.out.println("결정타");
	}

	@Override
	public void w() {
		System.out.println("용기");
	}

	@Override
	public void e() {
		items.def();
		System.out.println("심판");
	}

	@Override
	public void r() {
		System.out.println("데마시아의 정의");
	}

}
