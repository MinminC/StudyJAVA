package com.kh.model.vo;

import java.sql.Date;

public class Video {
	//필드부
	private int videoNo ;
	private String videoTitle;
	private String videoGenre;
	private String videoRuntime;
	private int stock;
	private int rentCount;
	private Date enrollDate;
	
	//생성자부
	//기본생성자
	public Video() {		
	}
	
	//모든필드가 들어있는 생성자
	public Video(int videoNo, String videoTitle, String videoGenre, String videoRuntime, int stock, int rentCount,
			Date enrollDate) {		
		this.videoNo = videoNo;
		this.videoTitle = videoTitle;
		this.videoGenre = videoGenre;
		this.videoRuntime = videoRuntime;
		this.stock = stock;
		this.rentCount = rentCount;
		this.enrollDate = enrollDate;
	}	
	
	
	// 기본값 설정이 되어있는 필드 빼고 생성자
	public Video(String videoTitle, String videoGenre, String videoRuntime, int stock) {		
		this.videoTitle = videoTitle;
		this.videoGenre = videoGenre;
		this.videoRuntime = videoRuntime;
		this.stock = stock;
	}


	//메소드부
	// 게터, 세터 메소드
	public int getVideoNo() {
		return videoNo;
	}
	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getVideoGenre() {
		return videoGenre;
	}
	public void setVideoGenre(String videoGenre) {
		this.videoGenre = videoGenre;
	}
	public String getVideoRuntime() {
		return videoRuntime;
	}
	public void setVideoRuntime(String videoRuntime) {
		this.videoRuntime = videoRuntime;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getRentCount() {
		return rentCount;
	}
	public void setRentCount(int rentCount) {
		this.rentCount = rentCount;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	
	@Override
	public String toString() {
		return "Video [videoNo=" + videoNo + ", videoTitle=" + videoTitle + ", videoGenre=" + videoGenre
				+ ", videoRuntime=" + videoRuntime + ", stock=" + stock + ", rentCount=" + rentCount + ", enrollDate="
				+ enrollDate + "]";
	}		
	

}
