package model.member;

public class MemberVO {
	
	private String id;
	private String pw;
	private String artist;
	private String firstemail;
	private String lastemail;
	private String addrNum;
	private String roadAddr;
	private String detailAddr;
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
	public String getAddrNum() {
		return addrNum;
	}
	public void setAddrNum(String addrNum) {
		this.addrNum = addrNum;
	}
	public String getRoadAddr() {
		return roadAddr;
	}
	public void setRoadAddr(String roadAddr) {
		this.roadAddr = roadAddr;
	}
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
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
				+ ", lastemail=" + lastemail + ", addrNum=" + addrNum + ", roadAddr=" + roadAddr + ", detailAddr="
				+ detailAddr + ", callNum=" + callNum + ", role=" + role + "]";
	}
}