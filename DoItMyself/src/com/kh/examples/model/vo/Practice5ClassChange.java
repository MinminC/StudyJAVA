package com.kh.examples.model.vo;

public class Practice5ClassChange {
	public String userId;
	public String userPwd;// AAAA~ZZZZ까지 무작위로 출력. 그 전과 같은 번호일 경우 다시 뽑음
	public String userCode;// 아이디와 별개로 개인을 식별하는 식별코드(0~9999).
	int n = 4;
	int[] codeN = new int[n];

	public void changePwd() {
		userPwd = "";
		for (int i = 0; i < n; i++) {
			codeN[i] = (int) (Math.random() * 25 + 65);
			for (int j = i - 1; j >= 0; j--) {
				if (codeN[i] == codeN[j]) {
					i--;
					continue;
				}
			}
			userPwd += (char) codeN[i] + "";
		}
	}

	public void changeCode() {
		userCode = "";
		for (int i = 0; i < n; i++) {
			codeN[i] = (int) (Math.random() * 9 + 1);
			userCode += codeN[i] + "";
		}
	}
}