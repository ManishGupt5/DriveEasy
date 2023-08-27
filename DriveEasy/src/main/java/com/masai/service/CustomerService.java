package com.masai.service;

import com.masai.entity.Car;
import com.masai.entity.Customer;
import com.masai.exception.CustomException;

public interface CustomerService {
	  void addnewCustomer(Customer customer);
		void customerLogin(Customer customer);
		void viewAvailabeCar();//order by rate
		
		void createTransaction(int car_id, int customer_id, double distance, double rate_per_km);
		void bookACar(Car car_id);//changing availibility
		void viewTransactionHistories();//order by date desc

}
