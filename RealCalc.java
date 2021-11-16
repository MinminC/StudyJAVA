package com.kh.hw.member.run;

import java.util.Scanner;

public class RealCalc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double dNum1 = 13.44;
		double dNum2 = 2.44;
		
		System.out.print(dNum1 + "과 " + dNum2 + "를 무슨 연산 할까요? : ");
		char oper = sc.next().charAt(0);
		double calc = 0;
		
		switch (oper) {
		case '+':
			calc = dNum1 + dNum2;
			break;
		case '-':
			calc = dNum1 - dNum2;
			break;
		case '*':
			calc = dNum1 * dNum2;
			break;
		case '/':
			calc = dNum1 / dNum2;
			break;
		case '%':
			calc = dNum1 % dNum2;
			break;
		default:
			System.out.println("다시 입력하시오");
		}
		if (oper == '+' || oper == '-') {//부동소숫점이 문제가 되는 경우 : 덧셈, 뺄셈
			double temp1;
			double temp2;
			int count = 0;// 현재 소숫점 자리수
			for (;;) {// 연속으로 9가 두번 나오면 그 시작 자릿수를 반환
				count++;// 첫번째 자리부터 시작
				temp1 = (calc * 10) - (int) calc * 10;// 소숫점 첫번째 자리가 뭔지 반환
//			System.out.println(count+"번째 자리는 "+(int)temp1);//첫번째 자리 확인
				if ((int) temp1 == 9 || (int) temp1 == 0) {
					temp2 = (temp1 * 10) - (int) temp1 * 10;
//				System.out.println(count+1+"번째 자리는 "+(int)temp2);//두번째 자리 확인
					if ((int) temp2 == 9 || (int) temp1 == 0) {
						break;
					}
				}
				calc *= 10;// 다음 연산에 가기 전 10을 곱함
			}
			count--;// 9가 나오는 첫번째 자리수이므로, 10을 곱하거나 빼는 최종 자리수에 가려면 하나 줄어야함
			double result = Math.round((calc) * Math.pow(10, count)) / Math.pow(10, count + count);
			// for문에서 사용한 *10까지 빼줘야하므로, 두번 count
			System.out.println(result);
		} else {
			System.out.println(calc);

		}
	}
}
