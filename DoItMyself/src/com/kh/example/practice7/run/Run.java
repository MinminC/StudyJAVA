package com.kh.example.practice7.run;

import com.kh.example.practice7.model.vo.Employee;

public class Run {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.setEmpNo(100);
		e1.setEmpName("ȫ�浿");
		e1.setDept("������");
		e1.setJob("����");
		e1.setAge(25);
		e1.setGender('��');
		e1.setSalary(2500000);
		e1.setBonusPoint(0.05);
		e1.setPhone("010-1234-5678");
		e1.setAddress("����� ������");

		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("�� empNo\t��empName��dept\t��job\t��age\t��gender\t��salary\t��bonusPoint\t��phone\t\t��address\t��");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("�� "+e1.getEmpNo()+"\t��"+ e1.getEmpName()+"\t��" + e1.getDept()+"\t��" + e1.getJob()+"\t��" + e1.getAge() +"\t��"+ e1.getGender()
		+"\t��"+ e1.getSalary() +"��"+ e1.getBonusPoint() +"\t\t��"+ e1.getPhone() +"\t��"+ e1.getAddress()+"\t��");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
	}

}
