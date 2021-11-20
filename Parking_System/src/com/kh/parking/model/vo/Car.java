package com.kh.parking.model.vo;

import java.util.Objects;

public class Car {
	private int parkingNum;
	private int carNumber;
	private String carType;
	private String carOwner;
	
	public Car() {
	}

	public Car(int parkingNum, int carNumber, String carType, String carOwner) {
		this.parkingNum = parkingNum;
		this.carNumber = carNumber;
		this.carType = carType;
		this.carOwner = carOwner;
	}

	


	public int getParkingNum() {
		return parkingNum;
	}

	public void setParkingNum(int parkingNum) {
		this.parkingNum = parkingNum;
	}

	public int getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarOwner() {
		return carOwner;
	}

	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}

	@Override
	public String toString() {
		return "Car [parkingNum="+(parkingNum+1)+", carNum=" + carNumber + ", carType=" + carType + ", owner=" + carOwner + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return carNumber == other.carNumber && Objects.equals(carOwner, other.carOwner)
				&& Objects.equals(carType, other.carType) && parkingNum == other.parkingNum;
	}

	
	
}
