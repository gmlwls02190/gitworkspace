package model.fav;

import java.util.Date;

public class FavArtistVO {

	private int favId;
	private String id;
	private String artist;
	private Date wdate;
	public int getFavId() {
		return favId;
	}
	public void setFavId(int favId) {
		this.favId = favId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "FavArtistVO [favId=" + favId + ", id=" + id + ", artist=" + artist + ", wdate=" + wdate + "]";
	}
}
