package test;

public class IPhone implements Phone{

	public IPhone() {
		System.out.println("아이폰 기본생성자!");
	}
	public void volumeUp() {
		System.out.println("소리++");
	}
	public void volumeDown() {
		System.out.println("소리--");
	}
	public void powerOn() {
		System.out.println("전원 ON");
	}
	public void powerOff() {
		System.out.println("전원 OFF");
	}
	
}
