package com.kh.practice.chap_02_abstractNInterface.run;

import com.kh.practice.chap_02_abstractNInterface.controller.PhoneController;

public class Run {

	public static void main(String[] args) {
		PhoneController pc = new PhoneController();
		String[] sArr=new String[2];
		sArr=pc.method();//result�� ���� ������ 2ĭ¥�� �迭
		for(int i=0;i<sArr.length;i++) {
			System.out.println(sArr[i]+"\n");
		}
	}
}
