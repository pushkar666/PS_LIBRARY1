/*
 * AUTHOR ID: PS14APRILOF24JFS#012
 * Author: PUSHKAR D
 * Email: pushkardwarkanath@gmail.com
 * GitHub: https://github.com/pushkar666
 * 
 * Project Synopsis:
 * This project is a simple library management system where users can interact with
 * a menu to perform various operations related to book management. The system allows
 * users to add new books, search for books by name, author, or ID, list all books,
 * and delete all records from the database. The program continuously displays the 
 * menu and processes user choices until the user decides to exit.
 * 
 * Classes and Interfaces:
 * - LibInt: An interface that defines the structure for library operations including 
 *           displaying the menu and handling user choices.
 * - LibOp: Implements LibInt to provide the actual functionality for adding books, 
 *          searching for books, listing books, and deleting all records. It interacts 
 *          with the JdbcHandler class to perform database operations.
 * - JdbcHandler: Handles database interactions with MySQL to perform operations such 
 *                 as adding books, searching books based on different criteria, listing 
 *                 all books, and truncating the book list.
 * - Main: Contains the main method to run the application, continuously displaying the 
 *         menu and processing user choices by creating instances of LibOp.
 *         
 *         Usage:
 * - Run the `Main` class to start the application.
 * - Follow the on-screen menu to interact with the library system.
 * - Use the menu options to perform various operations such as adding books, searching, and listing them.
 * - To exit the application, select the 'Exit' option from the menu.
 */

package com.PS.Library.L1;

import java.util.Scanner;

interface LibInt {
	void dispMenu();
	void choice();
}

public class LibOp implements LibInt{
	Scanner sc = new Scanner(System.in);
	JdbcHandler jh = null;
	
	public void dispMenu() {
		System.out.println("ENTER THE CHOICE");
		System.out.println("1: For adding new book");
		System.out.println("2: Search for book");
		System.out.println("3: List of book");
		System.out.println("4. Delete Data List");
		System.out.println("5: Exit");
	}
	
	public void choice() {
		try {
			System.out.println();
			int ch = sc.nextInt();
			sc.nextLine();
			switch(ch) {
				case 1 : addBook(ch);
				break;
				case 2 : searchBook(ch);
				break;
				case 3 : listBook(ch);
				break;
				case 4: truncateList(ch);
				break;
				case 5 : exitProgram();
				break;
			}
		} 
		catch (Exception e) {
			System.out.println("WRONG CHOICE");
			sc.nextLine();
		}
	}

	

	private void addBook(int ch) {
		System.out.println();
		System.out.println("Enter the name: ");
		String name = sc.nextLine();
		System.out.println("Enter the ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Author: ");
		String author = sc.nextLine();
		System.out.println("Enter the price: ");
		double price = sc.nextDouble();
		sc.nextLine();
		jh = new JdbcHandler(name, author, id, price, ch);
		System.out.println("Succesfully Added");
		System.out.println();
	}
	
	private void searchBook(int ch) {
		String name="",author="";
		int id=0;
		System.out.println();
		System.out.println("1: Search by Name");
		System.out.println("2: Search by Author");
		System.out.println("3: Search by id");
		int ch1 = sc.nextInt();
		sc.nextLine();
		switch(ch1) {
			case 1 : 
				System.out.println("Enter the Book Name");
				name = sc.nextLine();
				break;
			case 2 : 
				System.out.println("Enter the Author Name");
				author = sc.nextLine();
				break;
			case 3 : 
				System.out.println("Enter the ID");
				id = sc.nextInt();
				sc.nextLine();
				break;
			default : System.out.println("WRONG CHOICE");
			return;
		}
		jh = new JdbcHandler(name, author, id, null, ch);

	}

	private void listBook(int ch) {
		jh = new JdbcHandler(null, null, null, null, ch);
	}
	
	private void truncateList(int ch) {
		jh = new JdbcHandler(null, null, null, null, ch);
	}	

	private void exitProgram() {
		System.out.println("THANK YOU\nEXITING THE PROGRAM");
		System.exit(0);
	}
	
}
