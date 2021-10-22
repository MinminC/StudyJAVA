package com.kh.run;

import com.kh.kimminjeong.Practice5ClassIdol;

public class Practice5IdolRun {

	public static void main(String[] args) {
		Practice5ClassIdol ae = new Practice5ClassIdol();
		
		ae.groupName = "aespa";
		ae.careerPeoriod = 1;
		ae.popularity = 271;

		ae.releaseSingle();
		ae.updateYoutube();
		ae.updateYoutube();
		ae.releaseSingle();
		ae.releaseSingle();
		
		System.out.println(ae.careerPeoriod+"년차 그룹 "+ae.groupName+"의 구독자는 "
								+ae.popularity+"만 명 입니다.");
	}
}