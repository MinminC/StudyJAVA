package com.kh.team.abstractNInterface.controller;

import java.util.*;

import com.kh.team.abstractNInterface.model.vo.Blackjack;

public class BlackjackController {
	static Scanner sc = new Scanner(System.in);

	public int makeBlackjack(int num) {
		Blackjack bj = new Blackjack();
		int a = 0;
		int b = 0;
		int wallet = num; // 플레이어 지갑

		bj.start();
		a += bj.getDealdeck()[0] + bj.getDealdeck()[1];
		b += bj.getMydeck()[0] + bj.getMydeck()[1];
		System.out.println("Welcome BlackJack");
		System.out.println("배팅 금액을 입력해주세요 :");
		try {
			int bat = sc.nextInt();
			if (num < bat) {
				System.out.println("잔액이 부족합니다. 메인으로 돌아갑니다.");
				System.out.println("현재 잔액 : " + num);
				return wallet;
			}
			wallet -= bat;
			sc.nextLine();
			System.out.println("Spinning the card--︎");
			System.out.println("계속하시려면 엔터를 눌러주세요");
			String str = sc.nextLine();

			int z = 2;
			while (a <= 21 && b <= 21) {
				System.out.println("현재 상대방의 패 : " + Arrays.toString(bj.getDealdeck()));
				System.out.println("현재 나의 패 : " + Arrays.toString(bj.getMydeck()));
				System.out.println("");
				System.out.println("카드를 계속 받으시려면 엔터를 입력하세요.");
				System.out.println("멈추려면 esc를 눌러주세요.");
				sc.nextLine();
				bj.hit();

				a += bj.getDealdeck()[z];
				b += bj.getMydeck()[z];
				z++;
				System.out.println("현재 상대방의 패 : " + Arrays.toString(bj.getDealdeck()));
				System.out.println("현재 나의 패 : " + Arrays.toString(bj.getMydeck()));
				if (a >= 21) {
					System.out.println("이기셨습니다.");
					wallet += bat * 2;
					break;
				} else if (b >= 21) {
					System.out.println("패배하셨습니다");
					break;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("잘못된 값을 입력하셔습니다. 메인으로 돌아갑니다.");
			sc.nextLine();
			return wallet;

		}
		return wallet;
	}
}