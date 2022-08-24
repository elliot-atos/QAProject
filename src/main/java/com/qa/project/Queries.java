package com.qa.project;

import java.util.Scanner;

public class Queries {

	private static Scanner scan = new Scanner(System.in);
	Customers customer = new Customers();

	static String getInput() {
		System.out.println("Enter query choice: ");
		return scan.nextLine();
	}

	public void queryType() {
		SQLqueries query = new SQLqueries();
		boolean exit = false;
		try {
			do {
				switch (getInput().toLowerCase()) {
				case "insert":
					System.out.println("Enter First Name: ");
					String fname = scan.nextLine();
					customer.setFirstName(fname);

					System.out.println("Enter Surname: ");
					String sname = scan.nextLine();
					customer.setSurName(sname);

					System.out.println("Enter sex: ");
					char sex = scan.nextLine().charAt(0);
					customer.setSex(sex);

					System.out.println("Enter age: ");
					int age = scan.nextInt();
					customer.setAge(age);
					scan.nextLine();

					query.insert(new Customers(fname, sname, age, sex));
					break;
				case "read":
					query.read();
					break;
				case "readname":
					System.out.println("Enter surname of record to read: ");
					String readName = scan.nextLine();
					query.readByName(readName);
					break;
				case "readid":
					System.out.println("Enter id of record to read: ");
					int readID = scan.nextInt();
					scan.nextLine();
					query.readById(readID);
					break;
				case "updatefname":
					System.out.println("Enter first name of record to update: ");
					String oldFName = scan.nextLine();
					System.out.println("Enter the new first name of the customer: ");
					String newFName = scan.nextLine();
					query.updatefname(oldFName, newFName);
					break;
				case "delete":
					System.out.println("Enter first name of record to delete: ");
					String fName = scan.nextLine();
					System.out.println("Enter surname of record to delete: ");
					String surname = scan.nextLine();
					query.delete(fName, surname);
					break;
				default:
					System.out.println("Invalid choice");
				}
				System.out.println("Would you like to continue? (y/n)");
				String quit = scan.nextLine();
				if (quit.toLowerCase().equals("n")) {
					exit = true;
				}
			} while (exit != true);
			System.out.println("Goodbye.");
		} finally {
			query.close();
		}
	}

}