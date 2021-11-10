package com.kh.team.abstractNInterface.view;

import java.util.Scanner;

import com.kh.team.abstractNInterface.controller.*;
import com.kh.team.abstractNInterface.model.vo.Player;

public class Mainmenu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SlotController s = new SlotController();
		BlackjackController b = new BlackjackController();
		Player p = new Player();
		
		
		System.out.println("KH 카지노에 오신 걸 환영합니다");
		System.out.println("=============================");
		System.out.println("플레이어명과 소지금을 입력하세요");

		System.out.print("이름 : ");
		String name = sc.nextLine();
		p.setPlayerName(name);

		System.out.print("소지금 : ");
		int Wallet = sc.nextInt();
		p.setWallet(Wallet);

		for (;;) {
			System.out.println("=============================");
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1. 블랙잭");
			System.out.println("2. 슬롯머신");
			System.out.println("3. 회원 돈 충전");
			System.out.println("4. 회원 정보");
			System.out.println("0. 나가기");
			System.out.print(">>");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("블랙잭 게임입니다");
				System.out.println("게임은 21에 맞추거나 21에 가까운 사람이 승리하는 게임으로 21을 넘어가면 탈락입니다.\n승리시 배팅금액에 두배를 돌려 드립니다.");
				b.makeBlackjack(p.getWallet());
				break;
			case 2:
				System.out.println("슬롯머신 게임입니다");
				System.out.println("게임은 같은 숫자 3개가 나올 경우나 3개의 숫자가 연속될 경우에 승리합니다. 등수에 따른 금액을 돌려 드립니다.\n");
				s.playSlot(p.getWallet());
				break;
			case 3:
				System.out.println("돈 충전 메뉴입니다.");
				System.out.print("충전 금액을 입력하세요 : ");
				int cash = sc.nextInt();
				p.setWallet(cash + p.getWallet());
				break;
			case 4:
				System.out.println("회원 이름 : " + p.getPlayerName());
				System.out.println("회원 지갑 : " + p.getWallet());
				break;
			case 0:
				System.out.println("수고 하셨습니다.");

				return;
			default:
				System.out.println("다시 입력하세요.");
				continue;
			}
		}
	}
}