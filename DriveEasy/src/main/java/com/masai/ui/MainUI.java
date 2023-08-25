package com.masai.ui;

import java.util.Scanner;

public class MainUI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("====    " + "Car Rental Project" + "    ====");

			System.out.println("Enter 1 for new customer");
			System.out.println("Enter 2 for Customer Login ");
			System.out.println("Enter 3 for Admin Login ");
			System.out.println("Enter 0 for Exit ");
			System.out.println("Enter your choice : ");
			try {

				choice = sc.nextInt();
				switch (choice) {
				case 1:
					CustomerUI.newCustomerRegistration(sc);
					break;
				case 2:
					CustomerUI.customerLogin(sc);
					break;
				case 3:
					AdminUI.adminLogin(sc);
					break;
				case 0:
					System.out.println("Thanks for using. ");
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid choice");
				sc.next();
			}

		} while (choice != 0);
		sc.close();
	}
}
