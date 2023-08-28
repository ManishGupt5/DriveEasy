package com.masai.service;

import com.masai.entity.Customer;

public interface CustomerService {
	  void addnewCustomer(Customer customer);

		void customerLogin(String username, String password);
		void viewAvailabeCar();//order by rate
		
		void createTransaction(int car_id, int customer_id, double distance, double rate_per_km);

		void changeAvailability(int car_id);// changing availibility

		void viewTransactionHistories(int car_id);// order by date desc

		void changePassword(String username, String password, String newpassword);

		void changeEmail(String username, String password, String email);

}
