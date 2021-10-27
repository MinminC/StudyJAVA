package com.kh.examples.run;

import com.kh.examples.model.vo.Practice5ClassChange;

public class Practice5ChangeRun {

	public static void main(String[] args) {
		Practice5ClassChange tom = new Practice5ClassChange();
		tom.userId = "Tom";
		tom.userPwd = "ABDK";
		tom.userCode = "3425";
		System.out.println(tom.userId+"의 패스워드는 "+tom.userPwd+", 코드는 "+tom.userCode+"번입니다.");
		tom.changeCode();
		tom.changePwd();
		
		System.out.println(tom.userId+"의 새로운 패스워드는 "+tom.userPwd+", 새로운 코드는 "+tom.userCode+"번입니다.");
		
		System.out.println("- - -");
		
		Practice5ClassChange judy = new Practice5ClassChange();
		judy.userId = "Judy";
		judy.userPwd = "QWEK";
		judy.userCode = "3432";
		
		System.out.println(judy.userId+"의 패스워드는 "+judy.userPwd+", 코드는 "+judy.userCode+"번입니다.");
		judy.changeCode();
		judy.changePwd();
		System.out.println(judy.userId+"의 새로운 패스워드는 "+judy.userPwd+", 새로운 코드는 "+judy.userCode+"번입니다.");
	}

}
