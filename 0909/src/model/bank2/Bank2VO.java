package model.bank2;

public class Bank2VO {
	
	private int b2id;
	private String b2name;
	private int b2balance;
	public int getB2id() {
		return b2id;
	}
	public void setB2id(int b2id) {
		this.b2id = b2id;
	}
	public String getB2name() {
		return b2name;
	}
	public void setB2name(String b2name) {
		this.b2name = b2name;
	}
	public int getB2balance() {
		return b2balance;
	}
	public void setB2balance(int b2balance) {
		this.b2balance = b2balance;
	}
	@Override
	public String toString() {
		return "Bank2VO [b2id=" + b2id + ", b2name=" + b2name + ", b2balance=" + b2balance + "]";
	}
	
}
