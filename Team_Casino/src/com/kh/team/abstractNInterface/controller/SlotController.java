package com.kh.team.abstractNInterface.controller;

import java.util.Scanner;

import com.kh.team.abstractNInterface.model.vo.*;

public class SlotController {
	private Scanner sc = new Scanner(System.in);
	private SlotMachine sm = new SlotMachine(); // 슬롯머신 객체를 생성한다.
	private Player p = new Player(); // 플레이어 객체를 생성한다.
	private char[] slot = new char[3];// 슬롯 배열(크기 3)을 만든다.

	public int playSlot(int num) {// 매개변수로 플레이어의 현재 지갑 잔액을 가져온다.

		System.out.println("슬롯머신 게임을 시작합니다.");
		System.out.println("계속하시려면 엔터를 눌러주세요");
		String str = sc.nextLine();// 엔터를 눌러 게임을 시작한다.

		int wallet = num;// 지갑을 매개변수로 초기화한다.
		if (num < sm.payFee()) {// 소지하고 있는 금액이 요금보다 적을 경우 게임을 시작하지 않고, 현재 잔액을 보여준 후 메인으로 돌아간다.
			System.out.println("잔액이 부족합니다. 메인으로 돌아갑니다.");
			System.out.println("현재 잔액 : " + num);
		} else {// 그 외의 경우 게임 시작.
			wallet = num - sm.payFee(); // 게임을 시작하면 플레이어의 지갑에서 요금을 차감한다.

			String cardSlot = sm.makeSlot();// 슬롯머신에서 카드 슬롯을 문자열로 받아온다.
			for (int i = 0; i < slot.length; i++) {
				slot[i] = cardSlot.charAt(2 * i);// 슬롯 배열에 3개의 카드를 넣는다.
			}
			System.out.println("지금 뽑으신 번호는\n" + cardSlot);//현재 카드를 보여준다.

			if (slot[0] == slot[1] && slot[1] == slot[2]) {//3장의 카드가 같은 경우
				if (slot[0] == 7) {// 모두 7일 경우 7배의 금액을 돌려준다.
					System.out.println("1등상입니다. 축하합니다. 7배를 드립니다.");
					p.setWallet(p.getWallet() + sm.payFee() * 7);
				} else {//7이 아닌 경우 4배의 금액을 돌려준다.
					System.out.println("2등상입니다. 4배을 드립니다.");
					p.setWallet(p.getWallet() + sm.payFee() * 4);
				}
			} else if (slot[1] - slot[0] == 1 && slot[2] - slot[1] == 1) {//세개의 숫자가 연속인 경우 2배를 돌려준다.
				System.out.println("3등상입니다. 2배을 드립니다.");
				p.setWallet(p.getWallet() + sm.payFee() * 2);
			} else {// 이 외의 경우 상금 없이 끝난다.
				System.out.println("다시 한번 도전하세요!"); 
			}
			System.out.println("\n남은 소지금 : " + wallet);// 남은 소지금을 화면에 표시한다.
		}
		return wallet;// 지갑의 잔액을 return한다.
	}
}
