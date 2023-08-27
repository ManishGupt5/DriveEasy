package com.masai.ui;

import java.util.Scanner;

import com.masai.entity.Admin;
import com.masai.entity.Car;
import com.masai.service.AdminService;
import com.masai.service.AdminServiceImpl;

public class AdminUI {

	static void homepage(Scanner sc) {
		int choice = 0;
		do {
			System.out.println("====Admin MainPage====");
			System.out.println("Enter 1:  Admin Login ");
			System.out.println("Enter 2:  for add rental car ");
			System.out.println("Enter 3:  for update car rent ");
			System.out.println("Enter 4:  for delete car ");
			System.out.println();
			System.out.println("Enter 5:  for get car details by car id ");
			System.out.println("Enter 6:  for get all car List ");
			System.out.println("Enter 7:  for view all transactions ");
			System.out.println("Enter 8:  for view transaction by car id ");
			System.out.println();
			System.out.println("Enter 9:  for change car active status by car id");
			System.out.println("Enter 10: for add new Admin ");
			System.out.println("Enter 0:  for Logout ");
			System.out.print("Enter your choice : ");
			try {
				choice = Integer.valueOf(sc.nextLine());
				switch (choice) {
				case 1:
					login(sc);
					break;
				case 2:
					addCar(sc);
					break;
				case 3:
					updateCar(sc);
					break;
				case 4:
					deleteCar(sc);
					break;
				case 5:
					getCardetails(sc);
					break;
				case 6:
					getCarList();
					break;
				case 7:
					viewAllTransactions();
					break;
				case 8:
					viewTransactionByCarId(sc);
					break;
				case 9:
					changeActiveStatus(sc);
					break;
				case 10:
					addnewAdmin(sc);
					break;
				case 0:
					System.out.println("Thanks for using ,Logout successfuly ");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Invalid input,Only number input allow");
				sc.nextLine();
			}

		} while (choice != 0);
	}

	public static void addnewAdmin(Scanner sc) {
		try {
			System.out.println("Enter username (length=12 only allow) :");
			String username = sc.nextLine();
			System.out.println("Enter password");
			String password = sc.nextLine();
			Admin admin = new Admin(username, password);
			AdminService serv = new AdminServiceImpl();
			serv.addnewAdmin(admin);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static void login(Scanner sc) {
		try {
			System.out.println("Enter username");
			String username = sc.nextLine();
			System.out.println("Enter password");
			String password = sc.nextLine();
			AdminService serv = new AdminServiceImpl();
			serv.login(username, password);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void addCar(Scanner sc) {
		System.out.println("Enter car brand:");
		String brand = sc.nextLine();
		System.out.println("Enter model name:");
		String model = sc.nextLine();
		System.out.println("Enter rate/km :");
		double rate_per_km = Double.valueOf(sc.nextLine());
		boolean isAvailable = true;
		System.out.println("Enter mileage:");
		int mileage = Integer.valueOf(sc.nextLine());
		Car car = new Car(brand, model, rate_per_km, isAvailable, mileage);
		try {
			AdminService serv = new AdminServiceImpl();
			serv.addCar(car);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static void updateCar(Scanner sc) {
//		if car not present it will add a new car
		try {
			System.out.println("Enter car id");
			int car_id = Integer.valueOf(sc.nextLine());

			System.out.println("Enter car brand:");
			String brand = sc.nextLine();
			System.out.println("Enter model name:");
			String model = sc.nextLine();
			System.out.println("Enter rate/km :");
			double rate_per_km = Double.valueOf(sc.nextLine());
			boolean isAvailable = true;
			System.out.println("Enter mileage:");
			int mileage = Integer.valueOf(sc.nextLine());
			Car car = new Car(brand, model, rate_per_km, isAvailable, mileage);
			car.setCar_id(car_id);
			AdminService serv = new AdminServiceImpl();
			serv.updateCar(car);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static void deleteCar(Scanner sc) {
		try {
			System.out.println("Enter car id:");
			int car_id = Integer.valueOf(sc.nextLine());
			AdminService serv = new AdminServiceImpl();
			serv.deleteCar(car_id);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void getCardetails(Scanner sc) {
//		int car_id
		try {
			System.out.println("Enter car id:");
			int car_id = Integer.valueOf(sc.nextLine().trim());
			AdminService serv = new AdminServiceImpl();
			serv.getCardetails(car_id);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static void getCarList() {
		try {
			AdminService serv = new AdminServiceImpl();
			serv.getCarList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}// filter available car ,filter order by rate

	public static void viewAllTransactions() {
		try {
			AdminService serv = new AdminServiceImpl();
			serv.viewAllTransactions();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}// view by date , earning group by car_id order by date

	public static void viewTransactionByCarId(Scanner sc) {
//		int car_id
		try {
			System.out.println("Enter car id");
			int car_id = Integer.valueOf(sc.nextLine());
			AdminService serv = new AdminServiceImpl();
			serv.viewTransactionByCarId(car_id);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}// order by date desc

	public static void changeActiveStatus(Scanner sc) {
//		int car_id
		try {
			System.out.println("Enter car id");
			int car_id = Integer.valueOf(sc.nextLine());
			AdminService serv = new AdminServiceImpl();
			serv.changeActiveStatus(car_id);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
