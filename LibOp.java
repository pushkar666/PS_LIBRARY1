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
