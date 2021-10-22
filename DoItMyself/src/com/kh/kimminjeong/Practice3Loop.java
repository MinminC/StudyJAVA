package com.kh.kimminjeong;

import java.util.Scanner;

public class Practice3Loop {
	public void request1() {// �Ҽ��� �Ʒ� ���ڸ��� ������ ����
		Scanner sc = new Scanner(System.in);
		String op;
		int iNum1 = 0, iNum2 = 0;
		double calc = 0;
		System.out.println("-----1��. exit ���α׷�-----");

		for (;;) {
			System.out.print("������(+, -, *, /, %) : ");
//			op = sc.nextLine();
			op = sc.next();

			if (op.equals("exit")) {
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
			System.out.print("���� 1 : ");
			iNum1 = sc.nextInt();
			System.out.print("���� 2 : ");
			iNum2 = sc.nextInt();

			switch (op) {
			case "+":
				calc = iNum1 + iNum2;
				break;
			case "-":
				calc = iNum1 - iNum2;
				break;
			case "*":
				calc = iNum1 * iNum2;
				break;
			case "/":
				if (iNum2 == 0) {
					System.out.println("0���� ���� �� �����ϴ�. �ٽ� �Է����ּ���.");
					continue;
				}
				calc = (double) iNum1 / iNum2;
				break;
			case "%":
				calc = iNum1 % iNum2;
				break;
			default:
				System.out.println("���� �������Դϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			break;
		}
		System.out.printf("%d %s %d = %.2f\n", iNum1, op, iNum2, calc);
		System.out.println("-------------------------");
	}

	public void request2() {
		System.out.println("-----2��. ���� ������α׷�-----");
		Scanner sc = new Scanner(System.in);
		int i, n = 10;
		int arr[] = new int[n];
		System.out.print("�ʱⰪ�� �Է��ϼ���. : ");
		int stNum = sc.nextInt();
		System.out.print("������ �Է��ϼ���. : ");
		int inNum = sc.nextInt();
		System.out.println();

		int sum = stNum;
		String str = "";

		for (i = 1; i < 10; i++) {
			str += sum + (" ");
			sum += inNum;
		}
		System.out.println(str + sum);
		System.out.println("-------------------------");
//		for (i = 0; i < n; i++) {
//			arr[i] = stNum;
//			stNum += inNum;
//		}
//		n--;
//		for (i = 0; i < n; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println(arr[n]);
		sc.close();
	}
}
