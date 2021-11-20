package com.kh.parking.controller;

import java.util.ArrayList;

import com.kh.parking.model.vo.Car;

public class ParkingController {
	private ArrayList<Car> carList = new ArrayList<>(2);

	public boolean checkCarNumber(int carNumber) {
		for (Car c : carList) {// 동일한 차량번호 확인하는 로직
			if (c.getCarNumber() == carNumber) {
				return true;
			}
		}
		return false;
	}
	public boolean parkIn(int carNumber, String carType, String carOwner) {
//		for(Car c : carList) {//동일한 차량 확인하는 로직
//			if(c.getCarNumber()==carNumber) {
//				return false;
//			}
//		}
		for (int i = 0;; i++) {
			if (carList.size() == i) {// 빈자리 없이 리스트에 다 차있을때
				carList.add(new Car(i, carNumber, carType, carOwner));
				break;
			}
			if (carList.get(i).getParkingNum() != i) {// 비어있는 자리에 끼워넣기
				carList.add(i, new Car(i, carNumber, carType, carOwner));
				break;
			}
		}
		return true;
	}

	public boolean parkOut(int carNumber) {
		for (int i = 0; i < carList.size(); i++) {
			if (carList.get(i).getCarNumber() == carNumber) {
				carList.remove(i);
				return true;// 차량번호 존재 시
			}
		}
		return false;// 차량번호 없을 시
	}

	public ArrayList<Car> searchCar(String carOwner) {
		ArrayList<Car> searchedCar = new ArrayList<>();

		for (int i = 0; i < carList.size(); i++) {// 오너 이름으로 차량 조회
			if (carList.get(i).getCarOwner().equals(carOwner))
				searchedCar.add(carList.get(i));
		}
		return searchedCar;
	}

	public ArrayList<Car> selectAll() {
		return carList;
	}

	

}
