package com.kim.app.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Gallery
 *
 */
@Entity
@Table(name="GALLERY")
public class Gallery {

	@Id
	@GeneratedValue // pk의 자동증가를 구현하기위해 사용
	private int bid; // 식별자 필드==pk
	private String id;
	private String title;
	private String artist;
	private String info;
	private String gallery;
//	@Transient // 스프링에서만 사용되는 변수는 해당 어노테이션으로 무시할수있다
//	private MultipartFile fileUpload;
	@Temporal(TemporalType.DATE)
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
		return "Gallery [bid=" + bid + ", id=" + id + ", title=" + title + ", artist=" + artist + ", info=" + info
				+ ", gallery=" + gallery + ", wdate=" + wdate + "]";
	}
   
}
