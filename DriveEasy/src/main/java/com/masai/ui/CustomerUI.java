package com.masai.ui;

import java.util.Scanner;

import com.masai.entity.Customer;
import com.masai.service.CustomerService;
import com.masai.service.CustomerServiceImpl;

public class CustomerUI {

	public static void CustomerHomepage(Scanner sc) {
		int choice = 0;
		do {
			System.out.println("====Customer HomePage====");
			System.out.println("Enter 1:  Customer Signup ");
			System.out.println("Enter 2:  Customer Login ");
			System.out.println("Enter 3:  for Change password ");
			System.out.println("Enter 0:  Back ");
			System.out.println("Enter your choice : ");
			try {
				choice = Integer.valueOf(sc.nextLine());
				switch (choice) {
				case 1:
					addnewCustomer(sc);
					break;
				case 2:
					customerLogin(sc);
					break;
				case 3:
					changePassword(sc);
					break;
				case 0:
					break;
				default:
					System.out.println("Invalid choice");
				}
			} catch (Exception e) {
				System.out.println("Invalid choice,only number allow");
				sc.next();
			}
		} while (choice != 0);
	}

	public static void customerLogin(Scanner sc) {
		try {
			System.out.println("Enter username:");
			String username = sc.nextLine();
			System.out.println("Enter password:");
			String password = sc.nextLine();

			CustomerService serv = new CustomerServiceImpl();
			serv.customerLogin(username, password);

			CustomerMainPage(sc);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static void addnewCustomer(Scanner sc) {
		try {
			System.out.println("Enter username:");
			String username = sc.nextLine();
			System.out.println("Enter password:");
			String password = sc.nextLine();
			System.out.println("Enter name:");
			String name = sc.nextLine();
			System.out.println("Enter phone number:");
			String phone_number = sc.nextLine();
			System.out.println("Enter email :");
			String email = sc.nextLine();

			Customer customer = new Customer(username, password, name, phone_number, email);
			CustomerService serv = new CustomerServiceImpl();
			serv.addnewCustomer(customer);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void CustomerMainPage(Scanner sc) {
		int choice = 0;
		do {
			System.out.println("====Customer MainPage====");
			System.out.println("Enter 1:  View all availabe car ");
			System.out.println("Enter 2:  Rent a car");
			System.out.println("Enter 3:  View transaction history ");
			System.out.println("Enter 4:  for Change password ");
			System.out.println("Enter 5:  for update Email ");
			System.out.println("Enter 6: End trip ");
			System.out.println("Enter 0:  Logout ");
			System.out.println("Enter your choice : ");
			try {
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					viewAvailabeCar();
					break;
				case 2:
					createTransaction(sc);
					break;
				case 3:
					viewTransactionHistories(sc);
					break;
				case 4:
					changePassword(sc);
					break;
				case 5:
					changeEmail(sc);
					break;
				case 0:
					System.out.println("Thank you for using ");
					break;
				default:
					System.out.println("Invalid choice");
				}
			} catch (Exception e) {
				System.out.println("Invalid choice,only number allow");
				sc.next();
			}

		} while (choice != 0);
	}



	public static void changeEmail(Scanner sc) {
		try {
			System.out.println("Enter username:");
			String username = sc.nextLine();
			System.out.println("Enter password:");
			String password = sc.nextLine();

			System.out.println("Enter new email :");
			String email = sc.nextLine();

			CustomerService serv = new CustomerServiceImpl();
			serv.changeEmail(username, password, email);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static void changePassword(Scanner sc) {
		try {
			System.out.println("Enter username:");
			String username = sc.nextLine();
			System.out.println("Enter password:");
			String password = sc.nextLine();

			System.out.println("Enter new password :");
			String newPassword = sc.nextLine();

			CustomerService serv = new CustomerServiceImpl();
			serv.changePassword(username, password, newPassword);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}



	public static void viewAvailabeCar() {
		try {
			CustomerService serv = new CustomerServiceImpl();
			serv.viewAvailabeCar();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}// order by rate

	public static void createTransaction(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter car id:");
		int car_id = Integer.valueOf(sc.nextLine());
		System.out.println("Enter customer id:");
		int customer_id = Integer.valueOf(sc.nextLine());
		System.out.println("enter distance:");
		double distance = Double.valueOf(sc.nextLine());
		System.out.println("Enter rate per km");
		double rate_per_km = Double.valueOf(sc.nextLine());
		try {
			CustomerService serv = new CustomerServiceImpl();
			serv.createTransaction(car_id, customer_id, distance, rate_per_km);

			changeAvailability(car_id);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static void endTrip(Scanner sc) {
		System.out.println("Enter car id");
		int car_id = Integer.valueOf(sc.nextLine());
		try {
			CustomerService serv = new CustomerServiceImpl();
			serv.changeAvailability(car_id);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static void changeAvailability(int car_id) {
		try {
			CustomerService serv = new CustomerServiceImpl();
			serv.changeAvailability(car_id);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static void viewTransactionHistories(Scanner sc) {
		try {
			CustomerService serv = new CustomerServiceImpl();
			System.out.println("Enter customer id");
			int customer_id = Integer.valueOf(sc.nextLine());
			serv.viewTransactionHistories(customer_id);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}// order by date desc

}