package com.masai.service;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.entity.Car;
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
	public void customerLogin(Customer customer) {
		try {
			CustomerDao dao = new CustomerDaoImpl();
			dao.customerLogin(customer);
			System.out.println("Login successfuly");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void viewAvailabeCar() {
		try {
			CustomerDao dao = new CustomerDaoImpl();
			dao.viewAvailabeCar();
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
	public void bookACar(Car car_id) {
		try {
			CustomerDao dao = new CustomerDaoImpl();
			dao.bookACar(car_id);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void viewTransactionHistories() {
		try {
			CustomerDao dao = new CustomerDaoImpl();
			dao.viewTransactionHistories();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
