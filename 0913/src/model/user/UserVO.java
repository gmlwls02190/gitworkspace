package model.user;

import java.util.Date;

public class UserVO {
	private String userid;
	private String uname;
	private String userpw;
	private Date wdate;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "UserVO [uid=" + userid + ", name=" + uname + ", passwd=" + userpw + ", date=" + wdate + "]";
	}
}
