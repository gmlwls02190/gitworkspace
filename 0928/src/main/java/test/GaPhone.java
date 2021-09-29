package test;

public class GaPhone implements Phone{
	
	private Watch watch;
	
	public GaPhone() {
		System.out.println("갤럭시 기본생성자!");
	}
	public GaPhone(Watch watch) {
		this.watch=watch;
		System.out.println("갤럭시 생성자!");
	}
	@Override
	public void powerOn() {
		System.out.println("전원 켜짐");
	}
	@Override
	public void powerOff() {
		System.out.println("전원 꺼짐");
	}
	@Override
	public void volumeUp() {
		watch.volumeUp();
		// System.out.println("소리+=10");
	}
	@Override
	public void volumeDown() {
		watch.volumeDown();
		// System.out.println("소리-=10");
	}
	
}
