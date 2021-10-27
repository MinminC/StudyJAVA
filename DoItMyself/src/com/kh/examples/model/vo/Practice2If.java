package com.kh.examples.model.vo;

import java.util.Scanner;

public class Practice2If {
	static Scanner sc = new Scanner(System.in);// ��� �޼ҵ忡�� ����Ͽ� ���� �ű�
	public void question1() {
		System.out.println("------1�� ����------");
//		1. Ű����� ���� �� ���� �Է� �޾� ���� ����(num1, num2)�� �����ϼ���.
//		�׸��� �� �ٸ� ������ �Է� �޾� �� ���� num1 ���ϰų� num2 �ʰ��̸� true�� ����ϰ�
//		�ƴϸ� false�� ����ϼ���.
//		(��, num1�� num2���� �۾ƾ� ��)

//		ex.
//		����1 : 4
//		����2 : 11
//		�Է� : 13

//		true
		System.out.print("����1 : ");
		int num1 = sc.nextInt();
		System.out.print("����2 : ");
		int num2 = sc.nextInt();
		System.out.print("�Է� : ");
		int input = sc.nextInt();
		boolean result;

		if (num1 > num2) {
			System.out.println("num1�� num2���� �۾ƾ� �մϴ�.");
		} else {
			result = input <= num1 || input > num2 ? true : false;
			System.out.println("\n" + result);
		}
		System.out.println("-----------------\n");
	}

	public void question2() {
		System.out.println("------2�� ����------");
//		2. 3���� ���� Ű����� �Է� �޾� �Է� ���� ���� ��� ������ true, �ƴϸ� false�� ����ϼ���.

//		ex.
//		�Է�1 : 5
//		�Է�2 : -8
//		�Է�3 : 5

//		false		
		System.out.print("�Է�1 : ");
		int iNum1 = sc.nextInt();
		System.out.print("�Է�2 : ");
		int iNum2 = sc.nextInt();
		System.out.print("�Է�3 : ");
		int iNum3 = sc.nextInt();
		boolean result;

		result = iNum1 == iNum2 && iNum1 == iNum3 ? true : false;
		System.out.println("\n" + result);

		System.out.println("-----------------\n");
	}

	public void question3() {
		System.out.println("------3�� ����------");
//		3. Ű����� ������ �Է� ���� ������ ����̸鼭 ¦���� ���� ��¦���١��� ����ϰ�
//		¦���� �ƴϸ� ��Ȧ���١��� ����ϼ���.
//		����� �ƴϸ� ������� �Է����ּ���.���� ����ϼ���.

//		ex.
//		���ڸ� �� �� �Է��ϼ��� : -8
//		����� �Է����ּ���.
		System.out.print("���ڸ� �� �� �Է��ϼ��� : ");
		int iNum = sc.nextInt();
		if (iNum < 0) {
			System.out.println("����� �Է����ּ���.");
		} else {
			if (iNum % 2 == 0) {
				System.out.println("¦����");
			} else {
				System.out.println("Ȧ����");
			}
		}
		System.out.println("-----------------\n");
	}

	public void question4() {
		System.out.println("------4�� ����------");
//	4. Ű����� �� ���� ������ ���� ��ȣ�� �Է� �޾� ���� ��ȣ�� ���� ���� ����� ���(double)�ϼ���.
//	(��, �� ���� ���� ��� ����� ���� �۵��ϸ� ���� ���� ��ȣ�� �Է� ���� ��
//	���߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.�� ���)

//	ex.
//	�ǿ�����1 �Է� : 15
//	�ǿ�����2 �Է� : 4
//	�����ڸ� �Է�(+,-,*,/,%) : /
//	15 / 4 = 3.75000
		System.out.print("�ǿ�����1 �Է� : ");
		int iNum1 = sc.nextInt();
		System.out.print("�ǿ�����2 �Է� : ");
		int iNum2 = sc.nextInt();
		sc.nextLine();
		System.out.print("�����ڸ� �Է�(+,-,*,/,%) : ");
		char operator = sc.nextLine().charAt(0);
		double calc = 0.0;
		System.out.println();

		if (iNum1 > 0 && iNum2 > 0) {
			switch (operator) {
			case '+':
				calc = iNum1 + iNum2;
				break;
			case '-':
				calc = iNum1 - iNum2;
				break;
			case '*':
				calc = iNum1 * iNum2;
				break;
			case '/':
				calc = (double) iNum1 / (double) iNum2;
				break;
			case '%':
				calc = iNum1 % iNum2;
				break;
			default:
				calc = 0;
			}
			if (calc == 0) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
			} else {
				System.out.printf("%d %c %d = %.5f\n", iNum1, operator, iNum2, calc);
			}
		}
		System.out.println("-----------------\n");
		sc.close();
	}
}
