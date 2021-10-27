package com.kh.examples.model.vo;

import java.util.Scanner;

public class Practice4Array {
	public void minMax() {
		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10 + 1);
			System.out.print(arr[i] + " ");
		}
		int min = arr[0];
		int max = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("배열의 최솟값 : " + min);
		System.out.println("배열의 최댓값 : " + max);
	}

	public void lotto() {
//		int[] arr = new int[6];
//		int i, j;
//		for (i = 0; i < arr.length; i++) {
//			arr[i] = (int) (Math.random() * 10 + 1);
//			if (i > 0) {
//				for (j = 0; j <i; j++) {
//					if (arr[i] == arr[j]) {
//						i--;
//						break;
//					}
//				}
//			}
//		}
//		for (i = 0; i < arr.length - 1; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println(arr[arr.length - 1]);
		
		int[] arr = new int[6];
		int i, j;
		for (i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10 + 1);
			for (j = i - 1; j >= 0; j--) {
				if (arr[i] == arr[j]) {
					i--;
					break;
					//break; 반복 구문 탈출
					//continue;밑의 코드를 수행하지 않고 증감식으로 이동
				}
			}
		}
		//Arrays.sort(arr);오름차순 정리
		for (i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(arr[arr.length - 1]);
	}

	public void selectChar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 : ");
		String str = sc.nextLine();
		char[] arr = new char[str.length()];
		int i;
		int strL = str.length();

		System.out.print("문자열에 있는 문자 : ");

		for (i = 0; i < strL; i++) {
			arr[i] = str.charAt(i);// 0부터 배열 입력
		}
		String comma = ", ";
		String charSet = arr[0] + "";

		for (i = 1; i < strL; i++) {
			if (arr[i - 1] != arr[i]) {
				charSet += comma + arr[i];
			}
		}
		System.out.println(charSet);
		System.out.print("중복되지 않는 문자 개수 : ");
		System.out.println((charSet.length() + 2) / 3);
		sc.close();
	}
	
	//sort();
	//문자열.equals();
}
