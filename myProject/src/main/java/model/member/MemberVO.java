package model.member;

public class MemberVO {
	
	private String id;
	private String pw;
	private String artist;
	private String firstemail;
	private String lastemail;
	private String address;
	private String callNum;
	private String role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getFirstemail() {
		return firstemail;
	}
	public void setFirstemail(String firstemail) {
		this.firstemail = firstemail;
	}
	public String getLastemail() {
		return lastemail;
	}
	public void setLastemail(String lastemail) {
		this.lastemail = lastemail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCallNum() {
		return callNum;
	}
	public void setCallNum(String callNum) {
		this.callNum = callNum;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", artist=" + artist + ", firstemail=" + firstemail
				+ ", lastemail=" + lastemail + ", address=" + address + ", callNum=" + callNum + ", role=" + role + "]";
	}
}