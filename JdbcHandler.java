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

import java.sql.*;

public class JdbcHandler {

	String url = "jdbc:mysql://localhost:3306/library_db";
	String user = "root";
	String password = "29587674";

	String name, author;
	Integer id,ch;
	Double price;

	public JdbcHandler(String name, String author, Integer id, Double price, Integer ch) {
		this.name = name;
		this.author = author;
		this.id = id;
		this.price = price;
		this.ch = ch;
		
		if(this.ch.equals(1)) {
			addBook();
		}
		else if(this.ch.equals(2)) {
			searchBook();
		}
		else if(this.ch.equals(3)) {
			listBook();
		}
		
		else if(this.ch.equals(4)) {
			truncateList();
		}
	}


	public void addBook() {
        String query = "INSERT INTO lib1 (ID, NAME, AUTHOR, PRICE) VALUES (?, ?, ?, ?)";
        int res = 0;
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, author);
            pstmt.setDouble(4, price);
            try {
            	res = pstmt.executeUpdate();
            }
            catch (SQLException e){
            	System.out.println("BOOK OR ID IS ALREADY REGISTERED");
            }
            
            System.out.println("Number of records inserted: " + res);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
	
	private void searchBook() {
		String query = "";
		if (name != null && !name.isEmpty()) {
			query = "SELECT * FROM lib1 WHERE NAME LIKE ?";
		} 
		else if (author != null && !author.isEmpty()) {
			query = "SELECT * FROM lib1 WHERE AUTHOR LIKE ?";
		} 
		else if (id != null && id > 0) {
			query = "SELECT * FROM lib1 WHERE ID = ?";
		}

		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = con.prepareStatement(query)) {

			Class.forName("com.mysql.cj.jdbc.Driver");

			if (name != null && !name.isEmpty()) {
				pstmt.setString(1,"%" + name + "%");
			} 
			else if (author != null && !author.isEmpty()) {
				pstmt.setString(1, "%" + author + "%");
			} 
			else if (id != null && id > 0) {
				pstmt.setInt(1, id);
			}

			try (ResultSet rs = pstmt.executeQuery()) {
				boolean hasData = false;
				while (rs.next()) {
					 System.out.printf("ID: %-3d Name: %-30s Author: %-20s Price: %.2f%n",rs.getInt("ID"), rs.getString("NAME"), rs.getString("AUTHOR"), rs.getDouble("PRICE"));
					 hasData = true;
				}
				
				if (!hasData) {
	                System.out.println("NO DATA EXISTS");
	            }
				System.out.println();
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void listBook() {
		String query = "SELECT * FROM lib1;";
        
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (ResultSet rs = pstmt.executeQuery()) {
            	boolean hasData = false;
				while (rs.next()) {
					 System.out.printf("ID: %-3d Name: %-30s Author: %-20s Price: %.2f%n",rs.getInt("ID"), rs.getString("NAME"), rs.getString("AUTHOR"), rs.getDouble("PRICE"));
					 hasData = true;
				}
				
				if (!hasData) {
	                System.out.println("NO DATA EXISTS");
	            }
				System.out.println();
			}

        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}
	
	private void truncateList() {
		String query = "TRUNCATE TABLE lib1;";
        
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            stmt.executeUpdate(query);
            System.out.println("DATA LIST DELETED SUCCESSFULLY");
            System.out.println();
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}

}