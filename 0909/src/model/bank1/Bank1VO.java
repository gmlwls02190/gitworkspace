package model.bank1;

public class Bank1VO {
	
	private int b1id;
	private String b1name;
	private int b1balance;
	public int getB1id() {
		return b1id;
	}
	public void setB1id(int b1id) {
		this.b1id = b1id;
	}
	public String getB1name() {
		return b1name;
	}
	public void setB1name(String b1name) {
		this.b1name = b1name;
	}
	public int getB1balance() {
		return b1balance;
	}
	public void setB1balance(int b1balance) {
		this.b1balance = b1balance;
	}
	@Override
	public String toString() {
		return "Bank1VO [b1id=" + b1id + ", b1name=" + b1name + ", b1balance=" + b1balance + "]";
	}
	
	
}
