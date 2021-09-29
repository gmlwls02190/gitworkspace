package test2;

public class Teemo implements Skill{

	private Items items;
	
	public Teemo() {
		System.out.println("티모!");
	}
	public Teemo(Items items) {
		this.items=items;
		System.out.println("티모아이템");
	}
	@Override
	public void q() {
		items.ad();
		System.out.println("실명 다트");
	}

	@Override
	public void w() {
		items.def();
		System.out.println("신속한 이동");
	}

	@Override
	public void e() {
		System.out.println("맹독 다트");
	}

	@Override
	public void r() {
		items.ap();
		System.out.println("유독성 함정");
	}

}
