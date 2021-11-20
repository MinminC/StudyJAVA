package com.kh.parking.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.parking.controller.ParkingController;
import com.kh.parking.model.vo.Car;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private ParkingController pc = new ParkingController();

	public void mainMenu() {

		System.out.println("=== 주차 타워 관리 프로그램 ===");
		System.out.println("1. 차량 주차");
		System.out.println("2. 차량 출차");
		System.out.println("3. 주차된 차량 검색");
		System.out.println("4. 전체 출력");
		System.out.println("0. 프로그램 종료하기");
		System.out.println("------------------------");
		System.out.print("메뉴 선택 : ");
		try {
			int button = sc.nextInt();
			switch (button) {
			case 1:
				parkIn();
				break;
			case 2:
				parkOut();
				break;
			case 3:
				searchCar();
				break;
			case 4:
				selectAll();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 처음으로 돌아갑니다.\n");
				mainMenu();
			}
		} catch (InputMismatchException e) {
			System.out.println("잘못 입력하셨습니다. 처음으로 돌아갑니다.\n");
			sc.nextLine();
			mainMenu();
		}
	}

	public void parkIn() {
		System.out.print("차량 번호 : ");
		int carNumber = sc.nextInt();

		if (pc.selectAll().size() != 0) {//동일한 차량번호 존재 여부 조회
			if (pc.checkCarNumber(carNumber)) {
				System.out.println("동일한 차량 번호가 존재합니다.\n");
				mainMenu();
			}
		}

		String carType = null;
		System.out.print("차량 종류 (1. 경차 / 2. 세단 / 3. SUV / 4. 트럭) : ");
		int carTypeNum = sc.nextInt();
		switch (carTypeNum) {
		case 1:
			carType = "경차";
			break;
		case 2:
			carType = "세단";
			break;
		case 3:
			carType = "SUV";
			break;
		case 4:
			carType = "트럭";
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 처음으로 돌아갑니다.\n");
		}
		if (carType != null) {
			System.out.print("차주 : ");
			String carOwner = sc.next();
			if(pc.parkIn(carNumber, carType, carOwner)) {
				System.out.println("차량이 성공적으로 주차되었습니다.\n");
			}else {
				System.out.println("동일한 차량이 존재합니다. 다시 확인해주세요.\n");
			}
		}

		mainMenu();

	}

	public void parkOut() {
		System.out.print("차량 번호 : ");
		int carNumber = sc.nextInt();
		if (pc.parkOut(carNumber)) {
			System.out.println("출차가 완료되었습니다.\n");
		} else {
			System.out.println("차량이 존재하지 않습니다.\n");
		}
		mainMenu();
	}

	public void searchCar() {
		System.out.print("주차 차량 차주 검색 : ");
		String carOwner = sc.next();

		System.out.println("검색 결과 " + pc.searchCar(carOwner).size() + "개의 차량이 조회되었습니다.");

		for (Car c : pc.searchCar(carOwner)) {
			System.out.println(c);
		}
		System.out.println();
		mainMenu();
	}

	public void selectAll() {
		System.out.println("현재 주차된 차량은 " + pc.selectAll().size() + "대 입니다.");
		for (Car c : pc.selectAll()) {
			System.out.println(c);
		}
		System.out.println();
		mainMenu();
	}
}
