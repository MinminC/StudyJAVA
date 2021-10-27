package com.kh.examples.run;

import com.kh.examples.model.vo.Practice5ClassSales;

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
		nabi.sell();
		nabi.sell();
		nabi.cancel();
		System.out.println(nabi.fundingName + "에 " + nabi.total + "만원 모였습니다.");

		Practice5ClassSales bookClub = new Practice5ClassSales();
		bookClub.fundingName = "nabi Project";
		bookClub.fCount = 10;
		bookClub.total = 20;
		bookClub.goal = 50;
		
		
		bookClub.cancel();
		bookClub.cancel();
		bookClub.cancel();
		System.out.println(bookClub.fundingName + "에 " + bookClub.total + "만원 모였습니다.");
	}

}
