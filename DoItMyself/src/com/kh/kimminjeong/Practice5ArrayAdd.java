package com.kh.kimminjeong;

import java.util.Scanner;

public class Practice5ArrayAdd {
	public void selectChar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� : ");
		String str = sc.next();
		System.out.print("���� : ");
		char ch = sc.next().charAt(0);
		String count = "";

		char[] arr = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
			if (arr[i] == ch) {
				count += i + " ";// ������ �����̽� �����־ ��� ���
			}
		}
		System.out.print(str + "�� " + ch + "�� �����ϴ� ��ġ(�ε���): " + count);
	}

	public void sumArray() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int iNum = sc.nextInt();
		int[] arr = new int[iNum];
		int sum = 0;

		for (int i = 0; i < iNum; i++) {
			System.out.print("�迭 " + i + "��° �ε����� ���� �� : ");
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		for (int i = 0; i < iNum; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n�� �� : " + sum);
	}

	public void searchMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ġŲ �̸��� �Է��ϼ��� : ");
		String menu = sc.next();
		String[] pan = { "���߹ٻ��", "Ȳ�ݿø���", "����ġŲ", "��ūġŲ" };
		boolean haveIt=false;

		for (int i = 0; i < 4; i++) {
			if (pan[i].equals(menu)) {
				haveIt = true;
				break;
			}
		}
		if (haveIt) {
			System.out.println(menu + " ġŲ ��� ����");
		} else {
			System.out.println(menu + " ġŲ�� ���� �޴��Դϴ�.");
		}
	}

	public void stars() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int iNum = sc.nextInt();

		for (int i = 0; i < iNum; i++) {
			for (int j = iNum; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}