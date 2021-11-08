package com.kh.practice.chap_02_abstractNInterface.controller;

import com.kh.practice.chap_02_abstractNInterface.model.vo.*;

public class PhoneController {
	private String[] result = new String[2];

	public String[] method() {
		Phone[] pArr = new Phone[2];
		pArr[0] = new GalaxyNote9();
		pArr[1] = new V40();

		for (int i = 0; i < pArr.length; i++) {
			if (pArr[i] instanceof GalaxyNote9) {
				result[i] = ((GalaxyNote9) pArr[i]).printInformation();
			} else {
				result[i] = ((V40) pArr[i]).printInformation();
			}
		}
		return result;
	}
}
