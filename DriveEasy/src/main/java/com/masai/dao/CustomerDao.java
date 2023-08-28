package com.masai.dao;

import java.util.List;

import com.masai.entity.Car;
import com.masai.entity.Customer;
import com.masai.entity.TransactionHistory;
import com.masai.exception.CustomException;

public interface CustomerDao {

	void addnewCustomer(Customer customer) throws CustomException;

	void customerLogin(String username, String password) throws CustomException;

	void changePassword(String username, String password, String newpassword) throws CustomException;

	void changeEmail(String username, String password, String email) throws CustomException;

	List<Car> viewAvailabeCar() throws CustomException;

	void createTransaction(int car_id, int customer_id, double distance, double rate_per_km);

	void changeAvailability(int car_id) throws CustomException;

	List<TransactionHistory> viewTransactionHistories(int customer_id) throws CustomException;

}
