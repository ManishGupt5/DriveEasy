package com.masai.dao;

import java.util.List;

import com.masai.entity.Car;
import com.masai.entity.Customer;
import com.masai.entity.TransactionHistory;
import com.masai.exception.CustomException;

public interface CustomerDao {

	void addnewCustomer(Customer customer) throws CustomException;

	void customerLogin(Customer customer)throws CustomException;

	void changePassword(Customer customer) throws CustomException;

	void changeEmail(Customer customer) throws CustomException;
	List<Car> viewAvailabeCar();
	
	void createTransaction(int car_id, int customer_id, double distance, double rate_per_km);
	void bookACar(Car car_id);
	List<TransactionHistory> viewTransactionHistories();
	

}
