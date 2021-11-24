package com.kh.run;

import java.io.IOException;

import com.kh.view.MemberView;

public class Run {
	public static void main(String[] args) {
		try {
			new MemberView().mainMenu();
		} catch (IOException e) {
			System.out.println("오류가 발생했습니다. 프로그램을 종료합니다.");
			e.printStackTrace();
		}
	}
}
