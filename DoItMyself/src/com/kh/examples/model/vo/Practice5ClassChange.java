package com.kh.examples.model.vo;

public class Practice5ClassChange {
	public String userId;
	public String userPwd;// AAAA~ZZZZ���� �������� ���. �� ���� ���� ��ȣ�� ��� �ٽ� ����
	public String userCode;// ���̵�� ������ ������ �ĺ��ϴ� �ĺ��ڵ�(0~9999).
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