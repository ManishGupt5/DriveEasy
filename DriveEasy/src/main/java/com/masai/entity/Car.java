package com.masai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int car_id;
	
	@Column(nullable = false)
	private String brand;
	
	@Column(nullable = false)
	private String model;
	
	@Column(nullable = false, precision = 2)
	private double rate_per_km;
	
	@Column(nullable = false)
	private boolean isAvailable;
	
	@Column(nullable = false, precision = 2)
	private int mileage;
	
	@Column(nullable = false)
	private boolean isDeleted = false;

	public Car() {
		super();
	}

	public Car(String brand, String model, double rate_per_km, boolean isAvailable, int mileage) {
		super();
		this.brand = brand;
		this.model = model;
		this.rate_per_km = rate_per_km;
		this.isAvailable = isAvailable;
		this.isDeleted = false;
		this.mileage = mileage;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getRate_per_km() {
		return rate_per_km;
	}

	public void setRate_per_km(double rate_per_km) {
		this.rate_per_km = rate_per_km;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "\n Car_id: " + getCar_id() + "\n brand:" + getBrand() + "\n model:" + getModel() + "\n rate_per_km:"
				+ getRate_per_km() + "\n isAvailable=" + isAvailable() + "\n isDeleted=" + isDeleted() + "\n mileage="
				+ getMileage() + "";
	}

}
