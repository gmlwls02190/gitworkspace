package test;

public class Test {
	
	int a;
	public Test(){
		System.out.println("기본 생성자!");
	}
	public void print() {
		System.out.println("출력!");
	}
	public void initFunc() {
		System.out.println("변수 초기화 가능");
		a=100;
	}
}
