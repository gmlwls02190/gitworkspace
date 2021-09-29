package test;

public class GaPhone implements Phone{
	
	private Watch watch;
	
	public GaPhone() {
		System.out.println("������ �⺻������!");
	}
	public GaPhone(Watch watch) {
		this.watch=watch;
		System.out.println("������ ������!");
	}
	@Override
	public void powerOn() {
		System.out.println("���� ����");
	}
	@Override
	public void powerOff() {
		System.out.println("���� ����");
	}
	@Override
	public void volumeUp() {
		watch.volumeUp();
		// System.out.println("�Ҹ�+=10");
	}
	@Override
	public void volumeDown() {
		watch.volumeDown();
		// System.out.println("�Ҹ�-=10");
	}
	
}
