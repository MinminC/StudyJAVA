package com.kh.examples.run;

import com.kh.examples.model.vo.Practice5ClassSales;

public class Practice5SalesRun {

	public static void main(String[] args) {
		Practice5ClassSales nabi = new Practice5ClassSales();
		nabi.fundingName = "nabi Project";
		nabi.fCount = 10;
		nabi.total = 180;
		nabi.goal = 200;

		System.out.println("���� " + nabi.fundingName + "�� ���� �ݵ����� " + nabi.total + "�Դϴ�.");
//		nabi.nowFunds();//�� �ڻ��� �Է��ؼ� �ʱ�ȭ

		nabi.sell();
		nabi.sell();
		nabi.sell();
		nabi.sell();
		nabi.sell();
		nabi.cancel();
		System.out.println(nabi.fundingName + "�� " + nabi.total + "���� �𿴽��ϴ�.");

		Practice5ClassSales bookClub = new Practice5ClassSales();
		bookClub.fundingName = "nabi Project";
		bookClub.fCount = 10;
		bookClub.total = 20;
		bookClub.goal = 50;
		
		
		bookClub.cancel();
		bookClub.cancel();
		bookClub.cancel();
		System.out.println(bookClub.fundingName + "�� " + bookClub.total + "���� �𿴽��ϴ�.");
	}

}
