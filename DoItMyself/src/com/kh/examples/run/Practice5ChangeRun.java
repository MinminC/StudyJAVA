package com.kh.examples.run;

import com.kh.examples.model.vo.Practice5ClassChange;

public class Practice5ChangeRun {

	public static void main(String[] args) {
		Practice5ClassChange tom = new Practice5ClassChange();
		tom.userId = "Tom";
		tom.userPwd = "ABDK";
		tom.userCode = "3425";
		System.out.println(tom.userId+"�� �н������ "+tom.userPwd+", �ڵ�� "+tom.userCode+"���Դϴ�.");
		tom.changeCode();
		tom.changePwd();
		
		System.out.println(tom.userId+"�� ���ο� �н������ "+tom.userPwd+", ���ο� �ڵ�� "+tom.userCode+"���Դϴ�.");
		
		System.out.println("- - -");
		
		Practice5ClassChange judy = new Practice5ClassChange();
		judy.userId = "Judy";
		judy.userPwd = "QWEK";
		judy.userCode = "3432";
		
		System.out.println(judy.userId+"�� �н������ "+judy.userPwd+", �ڵ�� "+judy.userCode+"���Դϴ�.");
		judy.changeCode();
		judy.changePwd();
		System.out.println(judy.userId+"�� ���ο� �н������ "+judy.userPwd+", ���ο� �ڵ�� "+judy.userCode+"���Դϴ�.");
	}

}
