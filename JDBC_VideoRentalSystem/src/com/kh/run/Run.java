package com.kh.run;

import com.kh.view.VideoView;

public class Run {

	public static void main(String[] args) {
		try {
			new VideoView().mainMenu();
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다. 다시 확인해주세요.\n");
			new VideoView().mainMenu();
		}
	}
}
