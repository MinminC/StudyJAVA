package practice3.controller;

import practice3.model.vo.*;

public class AnimalManager {

	public static void main(String[] args) {
		Animal[] aArr = new Animal[5];
		
		aArr[0]=new Cat("����", "�����", "��", "�����");
		aArr[1]=new Dog("����", "������", 5);
		aArr[2]=new Cat("�糪", "�����", "����", "����");
		aArr[3]=new Dog("����", "������", 3);
		aArr[4]=new Cat("ŰƼ", "�����", "�Ͼ��", "TV");
		
		//�䷸�Ե� Ǯ���~~ �� ���� ���� aArr[index] 0~4 �Ҵ��� ��� �ּ�ó��!
//		int countCat = 0;//����̶� ������ �� ���� ����
//		int countDog = 0;
//		String name;
//		for (int i = 0; i < aArr.length; i++) {
//			if ((int) (Math.random() * 2) == 0) {//�����,������ ��������� 0�̸� �����
//				aArr[i] = new Cat();
//				String color;
//				String location;
//				switch (countCat) {
//				case 0: name = "����";color = "�����";location = "��";
//					break;
//				case 1:name = "�糪";location = "����";color = "����";
//					break;
//				case 2:name = "ŰƼ";color = "�Ͼ��";location = "TV";
//					break;
//				case 3:name = "����";color = "����";location = "��";
//					break;
//				default:name = "�ǹ�";color = "ȸ��";location = "�б�";
//				}
//				aArr[i].setName(name);
//				aArr[i].setKinds("�����");
//				((Cat) aArr[i]).setColor(color);
//				((Cat) aArr[i]).setLocation(location);
//				countCat++;//������ �ٸ� �̸����� �ޱ����� ����� count �߰�
//			} else {
//				aArr[i] = new Dog();
//				aArr[i].setKinds("������");
//				int weight;
//				switch (countDog) {
//				case 0:name = "����";weight=5;
//					break;
//				case 1:name = "����";weight=3;
//					break;
//				case 2:name = "ȣ��";weight=8;
//					break;
//				case 3:name = "�ƽ�";weight=6;
//					break;
//				default:name = "���";weight=9;
//				}
//				aArr[i].setName(name);
//				aArr[i].setKinds("������");
//				((Dog) aArr[i]).setWeight(weight);
//				countDog++;
//			}
//		}

		for (int i = 0; i < aArr.length; i++) {
			aArr[i].speak();
		}
	}
}
