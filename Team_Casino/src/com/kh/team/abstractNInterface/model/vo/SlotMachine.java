package com.kh.team.abstractNInterface.model.vo;

public class SlotMachine extends Game {//Game을 상속받은 자식 클래스
	public String makeSlot() {//슬롯을 만드는 메소드

		int[] cardSlot = new int[3];//카드를 분배할 배열 3칸을 만든다.
		int temp;//정렬을 위한 임시값 선언
		for (int i = 0; i < cardSlot.length; i++) {
			cardSlot[i] = (int)( Math.random()*7)+1;//카드 배열에 1~7까지의 카드를 3장 분배한다.
		}
		
		for (int i = 0; i < cardSlot.length; i++) {   //카드를 오름차순 정렬하는 for문을 작성한다.
			for (int j = i+1; j <cardSlot.length ; j++) {
				if (cardSlot[i] > cardSlot[j]) {

					temp = cardSlot[i];
					cardSlot[i] = cardSlot[j];
					cardSlot[j] = temp;
				}
			}
		}
		return cardSlot[0]+" "+cardSlot[1]+" "+cardSlot[2];//카드의 배열을 한칸씩 띄워서 연결한 문자열을 반환한다.
	}
	@Override//부모메소드의 payFee()를 오버라이드
	public int payFee() {//10000의 값을 반환하는 메소드 payFee()...
		return 10000;
	}
}
