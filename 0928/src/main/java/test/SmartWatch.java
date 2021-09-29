package test;

public class SmartWatch implements Watch{

	public SmartWatch() {
		System.out.println("스마트워치 기본생성자!");
	}
	@Override
	public void volumeUp() {
		System.out.println("스마트워치로 소리업");
	}

	@Override
	public void volumeDown() {
		System.out.println("스마트워치로 소리다운");
	}

}
