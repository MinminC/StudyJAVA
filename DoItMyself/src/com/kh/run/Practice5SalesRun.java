package com.kh.run;

import com.kh.kimminjeong.Practice5ClassSales;

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
		System.out.println(nabi.total + "���� �𿴽��ϴ�.");
	}

}
