package com.masai.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class TransactionHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transaction_id;

	@Column(nullable = false)
	private int car_id;
		
	@Temporal(TemporalType.DATE)
	private LocalDate booking_date;

	@Column(nullable = false)
	private double distance;

	@Column(nullable = false)
	private double rate_per_km;

	@Column(nullable = false)
	private double total_rent;

	public TransactionHistory() {
		super();
	}

	public TransactionHistory(int car_id, double distance, double rate_per_km) {
		super();
		this.car_id = car_id;
		this.distance = distance;
		this.rate_per_km = rate_per_km;
		this.total_rent = Math.ceil(distance * rate_per_km);
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}


	public LocalDate getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(LocalDate booking_date) {
		this.booking_date = booking_date;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getRate_per_km() {
		return rate_per_km;
	}

	public void setRate_per_km(double rate_per_km) {
		this.rate_per_km = rate_per_km;
	}

	public double getTotal_rent() {
		return total_rent;
	}

	public void setTotal_rent(double total_rent) {
		this.total_rent = total_rent;
	}

	@Override
	public String toString() {
		return "\nTransaction_id:" + getTransaction_id() + "\n car_id:" + getCar_id()
				+ "\n booking_date:" + getBooking_date() + "\n distance=" + getDistance() + "\n rate_per_km="
				+ getRate_per_km() + "\n total_rent=" + getTotal_rent() + "";
	}

}
