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
		
		System.out.println(ae.careerPeoriod+"���� �׷� "+ae.groupName+"�� �����ڴ� "
								+ae.popularity+"�� �� �Դϴ�.");
	}
}