package com.masai.service;

import java.util.List;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.entity.Admin;
import com.masai.entity.Car;
import com.masai.entity.TransactionHistory;

public class AdminServiceImpl implements AdminService {

	public AdminServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void login(String username, String password) {
		try {
			AdminDao dao = new AdminDaoImpl();
			dao.login(username, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void addCar(Car car) {
		try {
			AdminDao dao = new AdminDaoImpl();
			dao.addCar(car);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateCar(Car car) {
		try {
			AdminDao dao = new AdminDaoImpl();
			dao.updateCar(car);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteCar(int car_id) {
		try {
			AdminDao dao = new AdminDaoImpl();
			dao.deleteCar(car_id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void getCardetails(int car_id) {
		try {
			AdminDao dao = new AdminDaoImpl();
			Car car = dao.getCardetails(car_id);
			System.out.println(car);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void getCarList() {
		try {
			AdminDao dao = new AdminDaoImpl();
			List<Car> cars = dao.getCarList();
			cars.stream().sorted((o1, o2) -> Double.compare(o2.getRate_per_km(), o1.getRate_per_km()))
					.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void viewAllTransactions() {
		try {
			AdminDao dao = new AdminDaoImpl();
			List<TransactionHistory> list = dao.viewAllTransactions();
			list.stream().sorted((o1, o2) -> o1.getBooking_date().compareTo(o2.getBooking_date()))
					.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void viewTransactionByCarId(int car_id) {
		try {
			AdminDao dao = new AdminDaoImpl();
			List<TransactionHistory> list = dao.viewTransactionByCarId(car_id);
			list.stream().sorted((o1, o2) -> o1.getBooking_date().compareTo(o2.getBooking_date()))
					.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}


	@Override
	public void changeActiveStatus(int car_id) {
		try {
			AdminDao dao = new AdminDaoImpl();
			dao.changeActiveStatus(car_id);
			System.out.println("Active status Updated");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void addnewAdmin(Admin admin) {
		try {
			AdminDao dao = new AdminDaoImpl();
			dao.addnewAdmin(admin);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
