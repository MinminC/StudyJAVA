package com.kh.examples.model.vo;

import java.util.Scanner;

public class Practice5ClassSales {
	public String fundingName;// �ݵ� �̸�
	public int fPrice;// �ݵ� ����
	public int fCount;// �ȸ� Ƚ��
	public int total;// �� �ڱ�
	public int goal;// ��ǥ �ݾ�

	public void nowFunds() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �� �ڱ�(���� ������ �Է��ϼ���.) : ");
		total = sc.nextInt();
		sc.close();
	}

	public void sell() {
		if (total >= goal) {
			System.out.println("�ݵ��� �Ϸ�Ǿ����ϴ�.\n�Ϸ�ݾ� : " + total);
			return;
		}
		fCount++;
		total += 10;
	}

	public void cancel() {
		if (total <= 0) {
			System.out.println("����� �ݾ��� �����ϴ�.");
			return;
		}
		fCount--;
		total -= 10;
	}
}
