package com.kh.kimminjeong;

import java.util.Scanner;

public class VariablePractice1 {
	// 클래스명 : VariablePractice1
	// 메인메소드를 제외한 모든 메소드 이 클래스에 작성
	Scanner sc = new Scanner(System.in);// 클래스 내내 계속 입력받아서 이쪽으로 옮김

	public void question1() {
		System.out.println("------1번 문제------");
		// 1번 문제
		// 키보드로 정수 두 개를 입력 받아 두 수의 합, 차, 곱, 나누기한 몫을 출력하세요.
		// ex.
		// 첫 번째 정수 : 23
		// 두 번째 정수 : 7
		//
		// 더하기 결과 : 30
		// 빼기 결과 : 16
		// 곱하기 결과 : 161
		// 나누기 몫 결과 : 3
		System.out.print("첫 번째 정수 : ");
		int iNum1 = sc.nextInt();
		System.out.print("두 번째 정수 : ");
		int iNum2 = sc.nextInt();

		System.out.println("\n더하기 결과 : " + (iNum1 + iNum2));
		System.out.println("빼기 결과 : " + (iNum1 - iNum2));
		System.out.println("곱하기 결과 : " + (iNum1 * iNum2));
		System.out.println("나누기 몫 결과 : " + (iNum1 / iNum2));
		System.out.println("-----------------\n");
	}

	public void question2() {
		System.out.println("------2번 문제------");
		// 2번 문제
		// 키보드로 가로, 세로 값을 실수형으로 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
		// 계산공식 ) 면적 : 가로 * 세로
		// 둘레 : (가로 + 세로) * 2
		// ex.
		// 가로 : 13.5
		// 세로 : 41.7
		//
		// 면적 : 562.95
		// 둘레 : 110.4
		System.out.print("가로 : ");
		double width = sc.nextDouble();
		System.out.print("세로 : ");
		double height = sc.nextDouble();
		double area = width * height;
		double perimeter = (width + height) * 2;

		System.out.println("\n면적 : " + area);
		System.out.println("둘레 : " + perimeter);
		System.out.println("-----------------\n");
	}

	public void question3() {
		System.out.println("------3번 문제------");
		// 3번 문제
		// 영어 알파벳 문자열 값을 키보드로 입력 받아 문자에서 앞에서 세 개를 출력하세요.
		//
		// ex.
		// 문자열을 입력하세요 : apple
		//
		// 첫 번째 문자 : a
		// 두 번째 문자 : p
		// 세 번째 문자 : p
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		char strFirst = str.charAt(0);
		char strSecond = str.charAt(1);
		char strThird = str.charAt(2);

		System.out.println("\n첫 번째 문자 : " + strFirst);
		System.out.println("두 번째 문자 : " + strSecond);
		System.out.println("세 번째 문자 : " + strThird);
		System.out.println("-----------------\n");
	}

	public void question4() {
		System.out.println("------4번 문제------");
		// 4번 문제
		// 키보드로 입력 받은 값들을 변수에 기록하고 저장된 변수 값을 화면에 출력하여 확인하세요.
		//
		// ex.
		// 이름 : 이승철
		// 학년(숫자만) : 3
		// 반(숫자만) : 4
		// 번호(숫자만) : 15
		// 성별(남/여) : 남 //임의로 추가
		// 성적(소수점 아래 둘째자리까지) : 85.75
		// 3학년 4반 15번 이승철 남학생의 성적은 85.75이다.
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("학년(숫자만) : ");
		int grade = sc.nextInt();
		System.out.print("반(숫자만) : ");
		int group = sc.nextInt();
		System.out.print("번호(숫자만) : ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("성별(남/여) : ");
		char gender = sc.nextLine().charAt(0);
		System.out.print("성적(소수점 아래 둘째자리까지) : ");
		double score = sc.nextDouble();

		System.out.println("\n" + grade + "학년 " + group + "반 " + number + "번 " 
		+ name + " " + gender + "학생의 성적은 " + score + "점이다.");
		System.out.println("-----------------\n");
	}
}
