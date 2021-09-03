package model.member;

public class MemberVO {
	private String mname;
	private String mid;
	private String mpw;
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String toString() {
		return "MemberVO [mname=" + mname + ", mid=" + mid + ", mpw=" + mpw + "]";
	}
}
