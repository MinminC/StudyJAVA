package com.kh.kimminjeong;

import java.util.Scanner;

public class Practice5ClassLots {
	// 한글을 무작위(가~힇)로 n글자(사용자가 호출한 횟수만큼) 추출하여,
	// 닉네임로 사용할 수 있도록 희귀한 이름을 생성.
	public int count = 8;// 뽑는 최대 글자수.8글자 이내로 지정
	public String userId;// 유저아이디
	public String userPwd;
	public char[] nick = new char[count];// 뽑은 글자가 들어가는 배열.count개

	public void lotteryHan(int count) {
		for (int i = 0; i < count; i++) {// nick[0]~nick[count-1]개까지
			nick[i] = (char) (Math.random() * 11143 + 44032);
		}
		for (int i = 0; i < count; i++) {
			System.out.print(nick[i]);
		}
		System.out.println();
	}

	public void insert() {
		Scanner sc = new Scanner(System.in);
		// plusCount()와 minusCount()를 조절해서 원하는 글자 수를 출력한다.

		System.out.print(userId + "님. 몇글자를 출력할까요?(1~8글자) : ");
		count = sc.nextInt();

		System.out.println(userId + "님의 " + count + "글자 닉네임은 ▼▼");
		sc.close();
	}

	public void plusCount() {
		if (count == 8) {
			System.out.println("못늘려요");
			return;
		}
		count++;
		System.out.println(count + "글자 뽑을까요?");
	}

	public void minusCount() {
		if (count == 1) {
			System.out.println("못줄어요");
			return;
		}
		count--;
		System.out.println(count + "글자 뽑을까요?");
	}
}
