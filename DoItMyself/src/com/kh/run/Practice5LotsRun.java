package com.kh.run;

import com.kh.kimminjeong.Practice5ClassLots;

public class Practice5LotsRun {

	public static void main(String[] args) {
		Practice5ClassLots nick = new Practice5ClassLots();
		nick.userId = "angel1004";
		nick.userPwd= "1234";
		nick.count=2;
		
		System.out.println(nick.userId+"�� ��й�ȣ�� "+nick.userPwd);
		nick.insert();
		
		nick.lotteryHan(nick.count);
		
		nick.plusCount();
		nick.plusCount();
		nick.plusCount();
		nick.plusCount();
		nick.plusCount();
		nick.plusCount();
		nick.plusCount();
		nick.plusCount();//for������ ����/���ڶ� ���ڼ��� �ٽ� ī��Ʈ�ؼ� �Լ����� Ŭ������ ���´ٰ� ��ƿ������ߴٰ� ��� ���߿�
		
		
		nick.lotteryHan(nick.count);
		
//		nick.minusCount();
//		nick.lotteryHan();

	}
}
