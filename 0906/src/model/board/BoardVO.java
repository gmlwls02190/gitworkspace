package model.board;

public class BoardVO {
	private int bnum;
	private String writer;
	private String title;
	private String content;
	private String userid;
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String toString() {
		return "BoardVO [bnum=" + bnum + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", userid=" + userid + "]";
	}
	
}
