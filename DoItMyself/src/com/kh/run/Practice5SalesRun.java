package com.kh.run;

import com.kh.kimminjeong.Practice5ClassSales;

public class Practice5SalesRun {

	public static void main(String[] args) {
		Practice5ClassSales nabi = new Practice5ClassSales();
		nabi.fundingName = "nabi Project";
		nabi.fCount = 10;
		nabi.total = 180;
		nabi.goal = 200;

		System.out.println("현재 " + nabi.fundingName + "의 예상 펀딩액은 " + nabi.total + "입니다.");
//		nabi.nowFunds();//총 자산을 입력해서 초기화

		nabi.sell();
		nabi.sell();
		nabi.sell();
		System.out.println(nabi.total + "만원 모였습니다.");
	}

}
