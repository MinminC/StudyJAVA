package com.kh.kimminjeong;

import java.util.Scanner;

public class Practice5ClassLots {
	// �ѱ��� ������(��~Ş)�� n����(����ڰ� ȣ���� Ƚ����ŭ) �����Ͽ�,
	// �г��ӷ� ����� �� �ֵ��� ����� �̸��� ����.
	public int count = 8;// �̴� �ִ� ���ڼ�.8���� �̳��� ����
	public String userId;// �������̵�
	public String userPwd;
	public char[] nick = new char[count];// ���� ���ڰ� ���� �迭.count��

	public void lotteryHan(int count) {
		for (int i = 0; i < count; i++) {// nick[0]~nick[count-1]������
			nick[i] = (char) (Math.random() * 11143 + 44032);
		}
		for (int i = 0; i < count; i++) {
			System.out.print(nick[i]);
		}
		System.out.println();
	}

	public void insert() {
		Scanner sc = new Scanner(System.in);
		// plusCount()�� minusCount()�� �����ؼ� ���ϴ� ���� ���� ����Ѵ�.

		System.out.print(userId + "��. ����ڸ� ����ұ��?(1~8����) : ");
		count = sc.nextInt();

		System.out.println(userId + "���� " + count + "���� �г����� ���");
		sc.close();
	}

	public void plusCount() {
		if (count == 8) {
			System.out.println("���÷���");
			return;
		}
		count++;
		System.out.println(count + "���� �������?");
	}

	public void minusCount() {
		if (count == 1) {
			System.out.println("���پ��");
			return;
		}
		count--;
		System.out.println(count + "���� �������?");
	}
}
