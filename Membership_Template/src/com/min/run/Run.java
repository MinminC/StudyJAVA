package com.min.run;

import java.io.IOException;

import com.min.view.MemberView;

/**
 * 실행용 클래스
 * @author minmin
 * @since 1.0
 */
public class Run {
	public static void main(String[] args) {
		try {
			new MemberView().mainMenu();
		} catch (IOException e) {
			System.out.println("잘못된 항목을 입력하셨습니다. 프로그램을 종료합니다.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("오류가 발생했습니다. 프로그램을 종료합니다.");
			e.printStackTrace();
		}
	}
}
