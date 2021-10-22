package com.kh.kimminjeong;

import java.util.Scanner;

public class Practice3Loop {
	public void request1() {// 소수점 아래 두자리만 나오게 설정
		Scanner sc = new Scanner(System.in);
		String op;
		int iNum1 = 0, iNum2 = 0;
		double calc = 0;
		System.out.println("-----1번. exit 프로그램-----");

		for (;;) {
			System.out.print("연산자(+, -, *, /, %) : ");
//			op = sc.nextLine();
			op = sc.next();

			if (op.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			System.out.print("정수 1 : ");
			iNum1 = sc.nextInt();
			System.out.print("정수 2 : ");
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
					System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
					continue;
				}
				calc = (double) iNum1 / iNum2;
				break;
			case "%":
				calc = iNum1 % iNum2;
				break;
			default:
				System.out.println("없는 연산자입니다. 다시 입력해주세요.");
				continue;
			}
			break;
		}
		System.out.printf("%d %s %d = %.2f\n", iNum1, op, iNum2, calc);
		System.out.println("-------------------------");
	}

	public void request2() {
		System.out.println("-----2번. 공차 계산프로그램-----");
		Scanner sc = new Scanner(System.in);
		int i, n = 10;
		int arr[] = new int[n];
		System.out.print("초기값을 입력하세요. : ");
		int stNum = sc.nextInt();
		System.out.print("공차를 입력하세요. : ");
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
