package com.masai.ui;

import java.util.Scanner;

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
				choice = sc.nextInt();
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

	public static void CustomerMainPage(Scanner sc) {
		int choice = 0;
		do {
			System.out.println("====Customer MainPage====");
			System.out.println("Enter 1:  View all availabe car ");
			System.out.println("Enter 2:  Rent a car");
			System.out.println("Enter 3:  View transaction history ");
			System.out.println("Enter 4:  for Change password ");
			System.out.println("Enter 5:  for update Email ");
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
					viewTransactionHistories();
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
	
	public static void addnewCustomer(Scanner sc) {
//		Customer customer
	}

	public static void changeEmail(Scanner sc) {
//		Customer customer
	}
	
	public static void changePassword(Scanner sc) {
//		Customer customer
	}

	
	public static void customerLogin(Scanner sc) {
//		Customer customer
	}

	public static void viewAvailabeCar() {

	}// order by rate

	public static void createTransaction(Scanner sc) {
//		int car_id, int customer_id, double distance, double rate_per_km
	}

	public static void bookACar(Scanner sc) {
//		Car car_id
	}// changing availibility

	public static void viewTransactionHistories() {

	}// order by date desc

}