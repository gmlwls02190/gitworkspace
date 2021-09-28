package test;

public class GaPhone implements Phone{
	@Override
	public void powerOn() {
		System.out.println("傈盔 难咙");
	}
	@Override
	public void powerOff() {
		System.out.println("傈盔 波咙");
	}
	@Override
	public void volumeUp() {
		System.out.println("家府+=10");
	}
	@Override
	public void volumeDown() {
		System.out.println("家府-=10");
	}
	
}
