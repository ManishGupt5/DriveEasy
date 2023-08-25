package com.masai.ui;

import java.util.Scanner;

public class AdminUI {

	static void homepage(Scanner sc) {
		int choice = 0;
		do {
			System.out.println("====Admin HomePage====");
			System.out.println("Enter 1:  for add new rental car ");
			System.out.println("Enter 2:  for view all cars ");
			System.out.println("Enter 3:  for update car rent ");
			System.out.println("Enter 0:  for Logout ");
			System.out.println("Enter your choice : ");
			try {
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					addCarForRent(sc);
					break;
				case 2:
					viewAllRentalCars();
					break;
				case 3:
					updateCarRent(sc);
					break;
				case 0:
					System.out.println("Thanks for using ,Logout successfuly ");
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid input,Only number input allow");
				sc.next();
			}

		} while (choice != 0);
	}

	static void updateCarRent(Scanner sc) {

	}

	static void viewAllRentalCars() {

	}

	static void addCarForRent(Scanner sc) {

	}

	public static void adminLogin(Scanner sc) {

		System.out.println("Enter username : ");
		sc.nextLine();
		String username = sc.nextLine();
		System.out.println("Enter Password : ");
		String password = sc.nextLine();

	}
}
