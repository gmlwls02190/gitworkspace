package model.gallery;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class GalleryVO {
	
	private int bid;
	private String id;
	private String title;
	private String artist;
	private String info;
	private String gallery;
	private int likeCnt;
	private MultipartFile fileUpload;
	private Date wdate;
	
//	private String condition;
//	private String keyword;
//	public String getCondition() {
//		return condition;
//	}
//	public void setCondition(String condition) {
//		this.condition = condition;
//	}
//	public String getKeyword() {
//		return keyword;
//	}
//	public void setKeyword(String keyword) {
//		this.keyword = keyword;
//	}
	
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
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public MultipartFile getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(MultipartFile fileUpload) {
		this.fileUpload = fileUpload;
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