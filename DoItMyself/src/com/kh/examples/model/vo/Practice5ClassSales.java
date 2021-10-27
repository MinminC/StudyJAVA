package com.kh.examples.model.vo;

import java.util.Scanner;

public class Practice5ClassSales {
	public String fundingName;// 펀딩 이름
	public int fPrice;// 펀딩 가격
	public int fCount;// 팔린 횟수
	public int total;// 총 자금
	public int goal;// 목표 금액

	public void nowFunds() {
		Scanner sc = new Scanner(System.in);
		System.out.println("현재 총 자금(만원 단위로 입력하세요.) : ");
		total = sc.nextInt();
		sc.close();
	}

	public void sell() {
		if (total >= goal) {
			System.out.println("펀딩이 완료되었습니다.\n완료금액 : " + total);
			return;
		}
		fCount++;
		total += 10;
	}

	public void cancel() {
		if (total <= 0) {
			System.out.println("취소할 금액이 없습니다.");
			return;
		}
		fCount--;
		total -= 10;
	}
}
