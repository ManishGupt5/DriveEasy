package com.masai.ui;

import java.util.Scanner;

import com.masai.entity.Customer;

public class CustomerUI {

	public static void CustomerHomepage(Scanner sc, Customer customer) {

		int choice = 0;
		do {
			System.out.println("====Customer HomePage====");
			System.out.println("Enter 1:  for book rental car");
			System.out.println("Enter 2:  for view transaction history ");
			System.out.println("Enter 3:  for Change password ");
			System.out.println("Enter 4:  for Change email ");
			System.out.println("Enter 0:  for Logout ");
			System.out.println("Enter your choice : ");
			try {
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					bookRentalCar(sc, customer);
					break;
				case 2:
					showTransactionHistory(customer);
					break;
				case 3:
					updateCustomerPassword(sc, customer);
					break;
				case 4:
					updateCustomerEmail(sc, customer);
					break;
				case 0:
					System.out.println("Thanks for using ,Logout successfuly ");
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

	public static void bookRentalCar(Scanner sc, Customer customer) {
		
	}

	static void showTransactionHistory(Customer customer) {
		
	}

	static void updateCustomerPassword(Scanner sc, Customer customer) {
	

	}

	static void updateCustomerEmail(Scanner sc, Customer customer) {
	

	}

	public static void newCustomerRegistration(Scanner sc) {
	

	}

	public static void customerLogin(Scanner sc) {
		
	}
}