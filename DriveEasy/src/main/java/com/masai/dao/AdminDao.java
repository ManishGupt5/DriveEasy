package com.masai.dao;

import java.util.List;

import com.masai.entity.Admin;
import com.masai.entity.Car;
import com.masai.entity.TransactionHistory;
import com.masai.exception.CustomException;

public interface AdminDao {
	void addnewAdmin(Admin admin) throws CustomException;
	void login(String username ,String password)throws CustomException;

	void addCar(Car car) throws CustomException;
	void updateCar(Car car)throws CustomException;

	void deleteCar(int car_id) throws CustomException;
	Car getCardetails(int car_id)throws CustomException;
	List<Car> getCarList()throws CustomException;//filter available car ,filter order by rate

	List<TransactionHistory> viewAllTransactions()throws CustomException;//view by date , earning group by car_id order by date 
	List<TransactionHistory> viewTransactionByCarId(int car_id)throws CustomException;//order by date desc
	
	void changeActiveStatus(int car_id) throws CustomException;
	
}
