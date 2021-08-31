package model.wuser;

public class WuserVO {
	private String uname;
	private String userid;
	private String userpw;

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	@Override
	public String toString() {
		return "WuserVO [uname=" + uname + ", userid=" + userid + ", userpw=" + userpw + "]";
	}
	
	
}
