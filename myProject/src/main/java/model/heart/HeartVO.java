package model.heart;

public class HeartVO {
	
	private int hid;
	private int bid;
	private String id;
	private int heart;
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getHeart() {
		return heart;
	}
	public void setHeart(int heart) {
		this.heart = heart;
	}
	@Override
	public String toString() {
		return "HeartVO [hid=" + hid + ", bid=" + bid + ", id=" + id + ", heart=" + heart + "]";
	}
}
