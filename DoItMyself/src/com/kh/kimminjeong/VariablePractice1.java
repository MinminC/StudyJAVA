package com.kh.kimminjeong;

import java.util.Scanner;

public class VariablePractice1 {
	// Ŭ������ : VariablePractice1
	// ���θ޼ҵ带 ������ ��� �޼ҵ� �� Ŭ������ �ۼ�
	Scanner sc = new Scanner(System.in);// Ŭ���� ���� ��� �Է¹޾Ƽ� �������� �ű�

	public void question1() {
		System.out.println("------1�� ����------");
		// 1�� ����
		// Ű����� ���� �� ���� �Է� �޾� �� ���� ��, ��, ��, �������� ���� ����ϼ���.
		// ex.
		// ù ��° ���� : 23
		// �� ��° ���� : 7
		//
		// ���ϱ� ��� : 30
		// ���� ��� : 16
		// ���ϱ� ��� : 161
		// ������ �� ��� : 3
		System.out.print("ù ��° ���� : ");
		int iNum1 = sc.nextInt();
		System.out.print("�� ��° ���� : ");
		int iNum2 = sc.nextInt();

		System.out.println("\n���ϱ� ��� : " + (iNum1 + iNum2));
		System.out.println("���� ��� : " + (iNum1 - iNum2));
		System.out.println("���ϱ� ��� : " + (iNum1 * iNum2));
		System.out.println("������ �� ��� : " + (iNum1 / iNum2));
		System.out.println("-----------------\n");
	}

	public void question2() {
		System.out.println("------2�� ����------");
		// 2�� ����
		// Ű����� ����, ���� ���� �Ǽ������� �Է� �޾� �簢���� ������ �ѷ��� ����Ͽ� ����ϼ���.
		// ������ ) ���� : ���� * ����
		// �ѷ� : (���� + ����) * 2
		// ex.
		// ���� : 13.5
		// ���� : 41.7
		//
		// ���� : 562.95
		// �ѷ� : 110.4
		System.out.print("���� : ");
		double width = sc.nextDouble();
		System.out.print("���� : ");
		double height = sc.nextDouble();
		double area = width * height;
		double perimeter = (width + height) * 2;

		System.out.println("\n���� : " + area);
		System.out.println("�ѷ� : " + perimeter);
		System.out.println("-----------------\n");
	}

	public void question3() {
		System.out.println("------3�� ����------");
		// 3�� ����
		// ���� ���ĺ� ���ڿ� ���� Ű����� �Է� �޾� ���ڿ��� �տ��� �� ���� ����ϼ���.
		//
		// ex.
		// ���ڿ��� �Է��ϼ��� : apple
		//
		// ù ��° ���� : a
		// �� ��° ���� : p
		// �� ��° ���� : p
		System.out.print("���ڿ��� �Է��ϼ��� : ");
		String str = sc.nextLine();
		char strFirst = str.charAt(0);
		char strSecond = str.charAt(1);
		char strThird = str.charAt(2);

		System.out.println("\nù ��° ���� : " + strFirst);
		System.out.println("�� ��° ���� : " + strSecond);
		System.out.println("�� ��° ���� : " + strThird);
		System.out.println("-----------------\n");
	}

	public void question4() {
		System.out.println("------4�� ����------");
		// 4�� ����
		// Ű����� �Է� ���� ������ ������ ����ϰ� ����� ���� ���� ȭ�鿡 ����Ͽ� Ȯ���ϼ���.
		//
		// ex.
		// �̸� : �̽�ö
		// �г�(���ڸ�) : 3
		// ��(���ڸ�) : 4
		// ��ȣ(���ڸ�) : 15
		// ����(��/��) : �� //���Ƿ� �߰�
		// ����(�Ҽ��� �Ʒ� ��°�ڸ�����) : 85.75
		// 3�г� 4�� 15�� �̽�ö ���л��� ������ 85.75�̴�.
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("�г�(���ڸ�) : ");
		int grade = sc.nextInt();
		System.out.print("��(���ڸ�) : ");
		int group = sc.nextInt();
		System.out.print("��ȣ(���ڸ�) : ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("����(��/��) : ");
		char gender = sc.nextLine().charAt(0);
		System.out.print("����(�Ҽ��� �Ʒ� ��°�ڸ�����) : ");
		double score = sc.nextDouble();

		System.out.println("\n" + grade + "�г� " + group + "�� " + number + "�� " 
		+ name + " " + gender + "�л��� ������ " + score + "���̴�.");
		System.out.println("-----------------\n");
	}
}
