package com.masai.service;

import com.masai.entity.Admin;
import com.masai.entity.Car;
import com.masai.exception.CustomException;

public interface AdminService {
	void addnewAdmin(Admin admin);

	void login(String username, String password) throws CustomException;
	void addCar(Car car);
	void updateCar(Car car);
	void deleteCar(int car_id);
	void getCardetails(int car_id);
	void getCarList();//filter available car ,filter order by rate

	void viewAllTransactions();//view by date desc;	

	void viewTransactionByCarId(int car_id);// view by date desc;
	void changeActiveStatus(int car_id);

}
