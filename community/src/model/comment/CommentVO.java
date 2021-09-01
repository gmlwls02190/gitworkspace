package model.comment;

import java.sql.Date;

public class CommentVO {
	private int cnum;
	private int mnum;
	private String cname;
	private String comments;
	private Date cdate;
	
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public String toString() {
		return "CommentVO [cnum=" + cnum + ", mnum=" + mnum + ", cname=" + cname + ", comments=" + comments + ", cdate="
				+ cdate + "]";
	}
	
}