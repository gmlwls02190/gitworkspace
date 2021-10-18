package model.testboard;

import java.util.Date;

public class TestBoardVO {

	private int bid;
	private String id;
	private String writer;
	private String title;
	private String content;
	private Date wdate;
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
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "TestBoardVO [bid=" + bid + ", id=" + id + ", writer=" + writer + ", title=" + title + ", content="
				+ content + ", wdate=" + wdate + "]";
	}
}