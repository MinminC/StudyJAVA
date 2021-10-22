package com.kh.kimminjeong;

public class Practice5ClassIdol {
	//아이돌의 활동으로 유튜브 인기도(구독자 수 증가)를 예측하는 기능
	public String groupName;
	public int careerPeoriod;
	public int popularity;

	public void releaseAlbum() {
		popularity += 50;
	}
	public void releaseSingle() {
		popularity += 20;
	}

	public void updateYoutube() {
		popularity += 3;
	}
}
