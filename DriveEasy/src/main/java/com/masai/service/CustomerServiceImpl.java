package com.masai.service;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	public CustomerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addnewCustomer(Customer customer) {
		try {
			CustomerDao dao = new CustomerDaoImpl();
			dao.addnewCustomer(customer);
			System.out.println("Sign up successfuly");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void customerLogin(String username, String password) {
		try {
			CustomerDao dao = new CustomerDaoImpl();
			dao.customerLogin(username, password);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void viewAvailabeCar() {
		try {
			CustomerDao dao = new CustomerDaoImpl();
			dao.viewAvailabeCar().forEach(System.out::println);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void createTransaction(int car_id, int customer_id, double distance, double rate_per_km) {
		try {
			CustomerDao dao = new CustomerDaoImpl();
			dao.createTransaction(car_id, customer_id, distance, rate_per_km);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void changeAvailability(int car_id) {
		try {
			CustomerDao dao = new CustomerDaoImpl();
			dao.changeAvailability(car_id);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void viewTransactionHistories(int car_id) {
		try {
			CustomerDao dao = new CustomerDaoImpl();
			dao.viewTransactionHistories(car_id);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void changePassword(String username, String password, String newpassword) {
		try {
			CustomerDao dao = new CustomerDaoImpl();
			dao.changePassword(username, password, newpassword);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void changeEmail(String username, String password, String email) {
		try {
			CustomerDao dao = new CustomerDaoImpl();
			dao.changePassword(username, password, email);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}
