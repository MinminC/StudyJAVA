package com.kh.chap02_string.run;

import java.util.*;

public class SpaceUpper {
	public static void main(String[] args) {
		System.out.print("영어를 입력하세요 (띄어쓰기 포함) : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		while (st.hasMoreTokens()) {
			String strA = st.nextToken();// 토큰으로 받아오기
			String strB = (strA.charAt(0) + "").toUpperCase();// 첫글자 대문자
			String strC = strB.concat(strA.substring(1));// 모두 연결
			if (st.countTokens() > 0) {
				System.out.print(strC + " ");// 한자씩 띄우고 출력
			} else {
				System.out.print(strC);// 마지막 문자는 띄어쓰기 없이
			}
		}
	}
}
