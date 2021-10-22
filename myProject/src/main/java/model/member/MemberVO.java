package model.member;

public class MemberVO {
	
	private String id;
	private String pw;
	private String artist;
	private String email;
	private String address;
	private int callNum;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCallNum() {
		return callNum;
	}
	public void setCallNum(int callNum) {
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
		return "MemVO [id=" + id + ", pw=" + pw + ", artist=" + artist + ", email=" + email + ", address=" + address
				+ ", callNum=" + callNum + ", role=" + role + "]";
	}
}