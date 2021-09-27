package test2;

public class Timo implements Skill{

	@Override
	public void q() {
		System.out.println("실명 다트");
	}

	@Override
	public void w() {
		System.out.println("신속한 이동");
	}

	@Override
	public void e() {
		System.out.println("맹독 다트");
	}

	@Override
	public void r() {
		System.out.println("유독성 함정");
	}

}
