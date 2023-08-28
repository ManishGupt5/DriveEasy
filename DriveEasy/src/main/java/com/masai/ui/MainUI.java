package com.masai.ui;

import java.util.Scanner;

public class MainUI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("====    " + "Car Rental Project" + "    ====");
			System.out.println("Login Page");
			System.out.println("Enter 1 for customer");
			System.out.println("Enter 2 for Admin ");
			System.out.println("Enter 0 for Exit ");
			System.out.print("Enter your choice : ");
			try {

				choice = Integer.valueOf(sc.nextLine());
				switch (choice) {
				case 1:
					CustomerUI.CustomerHomepage(sc);
					break;
				case 2:
					AdminUI.login(sc);
					break;
				case 0:
					System.out.println("Thanks for using ");
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid choice");
				sc.nextLine();
			}

		} while (choice != 0);
		sc.close();
	}
}
