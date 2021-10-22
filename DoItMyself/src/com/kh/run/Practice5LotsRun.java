package com.kh.run;

import com.kh.kimminjeong.Practice5ClassLots;

public class Practice5LotsRun {

	public static void main(String[] args) {
		Practice5ClassLots nick = new Practice5ClassLots();
		nick.userId = "angel1004";
		nick.userPwd= "1234";
		nick.count=2;
		
		System.out.println(nick.userId+"의 비밀번호는 "+nick.userPwd);
		nick.insert();
		
		nick.lotteryHan(nick.count);
		
		nick.plusCount();
		nick.plusCount();
		nick.plusCount();
		nick.plusCount();
		nick.plusCount();
		nick.plusCount();
		nick.plusCount();
		nick.plusCount();//for문으로 남는/모자란 글자수를 다시 카운트해서 함수모음 클래스로 보냈다가 들아오려고했다가 고건 나중에
		
		
		nick.lotteryHan(nick.count);
		
//		nick.minusCount();
//		nick.lotteryHan();

	}
}
