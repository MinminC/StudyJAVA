package com.kh.practice.chap_02_abstractNInterface.model.vo;

public class GalaxyNote9 extends SmartPhone implements NotePen {
	public GalaxyNote9() {
		super.setMaker("�Ｚ");
	}

	public String makeCall() {
		return "��ȣ�� ������ ��ȭ��ư�� ����";
	}

	public String takeCall() {
		return "��ȭ�ޱ� ��ư�� ����";
	}

	public String picture() {
		return "1300�� ���ī�޶�";
	}

	public String charge() {
		return "�������, ��� ���� ����";
	}

	public String touch() {
		return "������, ������ ����";
	}

	public boolean bluetoothPen() {
		return true;
	}

	@Override
	public String printInformation() {
		return "������ ��Ʈ9�� "+super.getMaker()+"���� ��������� ������ ������ ����.\n"+makeCall()+"\n"+takeCall()
		+"\n"+picture()+"\n"+charge()+"\n"+touch()+"\n������� �� ž�� ���� : "+bluetoothPen();
	}
}
