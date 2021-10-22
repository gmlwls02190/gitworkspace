package model.gallery;

import java.util.Date;

public class GalleryVO {
	
	private int bid;
	private String title;
	private String artist;
	private String info;
	private String gallery;
	private Date wdate;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getGallery() {
		return gallery;
	}
	public void setGallery(String gallery) {
		this.gallery = gallery;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "GalleryVO [bid=" + bid + ", title=" + title + ", artist=" + artist + ", info=" + info + ", gallery="
				+ gallery + ", wdate=" + wdate + "]";
	}
}