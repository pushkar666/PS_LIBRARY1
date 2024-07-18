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
        
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, author);
            pstmt.setDouble(4, price);

            int res = pstmt.executeUpdate();
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
					 System.out.printf("ID: %-3d Name: %-25s Author: %-20s Price: %.2f%n",rs.getInt("ID"), rs.getString("NAME"), rs.getString("AUTHOR"), rs.getDouble("PRICE"));
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
					 System.out.printf("ID: %-3d Name: %-25s Author: %-20s Price: %.2f%n",rs.getInt("ID"), rs.getString("NAME"), rs.getString("AUTHOR"), rs.getDouble("PRICE"));
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