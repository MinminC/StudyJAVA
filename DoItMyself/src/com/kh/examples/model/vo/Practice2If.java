package com.kh.examples.model.vo;

import java.util.Scanner;

public class Practice2If {
	static Scanner sc = new Scanner(System.in);// 모든 메소드에서 사용하여 위로 옮김
	public void question1() {
		System.out.println("------1번 문제------");
//		1. 키보드로 정수 두 개를 입력 받아 각각 변수(num1, num2)에 저장하세요.
//		그리고 또 다른 정수를 입력 받아 그 수가 num1 이하거나 num2 초과이면 true를 출력하고
//		아니면 false를 출력하세요.
//		(단, num1은 num2보다 작아야 함)

//		ex.
//		정수1 : 4
//		정수2 : 11
//		입력 : 13

//		true
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력 : ");
		int input = sc.nextInt();
		boolean result;

		if (num1 > num2) {
			System.out.println("num1는 num2보다 작아야 합니다.");
		} else {
			result = input <= num1 || input > num2 ? true : false;
			System.out.println("\n" + result);
		}
		System.out.println("-----------------\n");
	}

	public void question2() {
		System.out.println("------2번 문제------");
//		2. 3개의 수를 키보드로 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.

//		ex.
//		입력1 : 5
//		입력2 : -8
//		입력3 : 5

//		false		
		System.out.print("입력1 : ");
		int iNum1 = sc.nextInt();
		System.out.print("입력2 : ");
		int iNum2 = sc.nextInt();
		System.out.print("입력3 : ");
		int iNum3 = sc.nextInt();
		boolean result;

		result = iNum1 == iNum2 && iNum1 == iNum3 ? true : false;
		System.out.println("\n" + result);

		System.out.println("-----------------\n");
	}

	public void question3() {
		System.out.println("------3번 문제------");
//		3. 키보드로 정수를 입력 받은 정수가 양수이면서 짝수일 때만 “짝수다”를 출력하고
//		짝수가 아니면 “홀수다“를 출력하세요.
//		양수가 아니면 “양수만 입력해주세요.”를 출력하세요.

//		ex.
//		숫자를 한 개 입력하세요 : -8
//		양수만 입력해주세요.
		System.out.print("숫자를 한 개 입력하세요 : ");
		int iNum = sc.nextInt();
		if (iNum < 0) {
			System.out.println("양수만 입력해주세요.");
		} else {
			if (iNum % 2 == 0) {
				System.out.println("짝수다");
			} else {
				System.out.println("홀수다");
			}
		}
		System.out.println("-----------------\n");
	}

	public void question4() {
		System.out.println("------4번 문제------");
//	4. 키보드로 두 개의 정수와 연산 기호를 입력 받아 연산 기호에 맞춰 연산 결과를 출력(double)하세요.
//	(단, 두 개의 정수 모두 양수일 때만 작동하며 없는 연산 기호를 입력 했을 시
//	“잘못 입력하셨습니다. 프로그램을 종료합니다.” 출력)

//	ex.
//	피연산자1 입력 : 15
//	피연산자2 입력 : 4
//	연산자를 입력(+,-,*,/,%) : /
//	15 / 4 = 3.75000
		System.out.print("피연산자1 입력 : ");
		int iNum1 = sc.nextInt();
		System.out.print("피연산자2 입력 : ");
		int iNum2 = sc.nextInt();
		sc.nextLine();
		System.out.print("연산자를 입력(+,-,*,/,%) : ");
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
				System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
			} else {
				System.out.printf("%d %c %d = %.5f\n", iNum1, operator, iNum2, calc);
			}
		}
		System.out.println("-----------------\n");
		sc.close();
	}
}
