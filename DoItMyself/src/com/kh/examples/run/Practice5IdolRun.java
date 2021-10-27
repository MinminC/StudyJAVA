package com.kh.examples.run;

import com.kh.examples.model.vo.Practice5ClassIdol;

public class Practice5IdolRun {
	
//	class student {
//		String groupName;
//		int careerPeoriod;
//		int popularity;
//	}

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

		System.out.println(ae.careerPeoriod + "년차 그룹 " + ae.groupName + "의 구독자는 " + ae.popularity + "만 명 입니다.");

		Practice5ClassIdol exo = new Practice5ClassIdol();

		exo.groupName = "exo";
		exo.careerPeoriod = 9;
		exo.popularity = 843;

		exo.releaseAlbum();
		exo.releaseAlbum();
		exo.releaseSingle();
		exo.updateYoutube();
		exo.updateYoutube();
		exo.releaseAlbum();
		exo.releaseSingle();

		System.out.println(exo.careerPeoriod + "년차 그룹 " + exo.groupName + "의 구독자는 " + exo.popularity + "만 명 입니다.");
	}
}