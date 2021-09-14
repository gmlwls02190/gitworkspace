package model.msg;

import java.util.Date;

public class ReplyVO {
	private int rid;
	private int mid;
	private String userid;
	private Date wdate;
	private String rmsg;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public String getRmsg() {
		return rmsg;
	}
	public void setRmsg(String rmsg) {
		this.rmsg = rmsg;
	}
	@Override
	public String toString() {
		return "ReplyVO [rid=" + rid + ", mid=" + mid + ", uid=" + userid + ", date=" + wdate + ", rmsg=" + rmsg + "]";
	}
}
