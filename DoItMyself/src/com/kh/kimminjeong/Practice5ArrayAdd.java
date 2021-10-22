package com.kh.kimminjeong;

import java.util.Scanner;

public class Practice5ArrayAdd {
	public void selectChar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.next();
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		String count = "";

		char[] arr = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
			if (arr[i] == ch) {
				count += i + " ";// 과제에 스페이스 남아있어서 고냥 출력
			}
		}
		System.out.print(str + "에 " + ch + "가 존재하는 위치(인덱스): " + count);
	}

	public void sumArray() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int iNum = sc.nextInt();
		int[] arr = new int[iNum];
		int sum = 0;

		for (int i = 0; i < iNum; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		for (int i = 0; i < iNum; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n총 합 : " + sum);
	}

	public void searchMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("치킨 이름을 입력하세요 : ");
		String menu = sc.next();
		String[] pan = { "고추바사삭", "황금올리브", "새우치킨", "통큰치킨" };
		boolean haveIt=false;

		for (int i = 0; i < 4; i++) {
			if (pan[i].equals(menu)) {
				haveIt = true;
				break;
			}
		}
		if (haveIt) {
			System.out.println(menu + " 치킨 배달 가능");
		} else {
			System.out.println(menu + " 치킨은 없는 메뉴입니다.");
		}
	}

	public void stars() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
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