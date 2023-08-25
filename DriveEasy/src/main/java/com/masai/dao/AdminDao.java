package com.masai.dao;

import java.util.List;

import com.masai.entity.Car;
import com.masai.entity.TransactionHistory;

public interface AdminDao {
	void addCar(Car car);
	void updateCar(Car car);
	void deleteCar(int car_id);
	Car getCardetails(int car_id);
	List<Car> getCarList();//filter available car ,filter order by rate

	List<TransactionHistory> viewAllTransactions();//view by date , earning group by car_id order by date 
	List<TransactionHistory> viewTransactionByCarId(int car_id);//order by date desc
	
	void changeActiveStatus(int car_id);
	
}
