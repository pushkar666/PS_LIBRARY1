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

public class Main {
	public static void main(String[] args) {
		
		while(true) {
			LibOp lo = new LibOp();
			lo.dispMenu();
			lo.choice();
		}
	}
}
