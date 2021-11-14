package model.fav;

import java.util.Date;

public class FavArtVO {

	private int favId;
	private int bid;
	private String id;
	private String title;
	private String artist;
	private String gallery;
	private Date wdate;
	public int getFavId() {
		return favId;
	}
	public void setFavId(int favId) {
		this.favId = favId;
	}
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
		return "FavArtVO [favId=" + favId + ", bid=" + bid + ", id=" + id + ", title=" + title + ", artist=" + artist
				+ ", gallery=" + gallery + ", wdate=" + wdate + "]";
	}
}
