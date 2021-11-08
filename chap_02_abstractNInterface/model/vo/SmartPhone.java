package com.kh.practice.chap_02_abstractNInterface.model.vo;

public abstract class SmartPhone implements CellPhone, TouchDisplay{
	private String maker;

	public SmartPhone() {
	}

//public SmartPhone(String maker) {
//	this.maker = maker;
//}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public abstract String printInformation();

}
