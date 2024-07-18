# Library Management System

## Project Overview
This project implements a simple library management system in Java. 
It allows users to manage books in a library with features for adding, searching, listing, and deleting book records. 
The system continuously displays a menu and processes user choices until terminated.

## Author Information
- **Author:** PUSHKAR D
- **Email:** pushkardwarkanath@gmail.com
- **GitHub:** [https://github.com/pushkar666](https://github.com/pushkar666)
- **Project ID:** PS14APRILOF24JFS#012

## Features
- **Add New Book:** Allows users to add a new book with details such as name, ID, author, and price.
- **Search for Book:** Provides options to search for books by name, author, or ID. Supports partial matches for name and author.
- **List All Books:** Displays all books currently in the database.
- **Delete Data List:** Provides an option to clear all book records from the database.
- **Exit Program:** Exits the application with a thank you message.

## Project Structure
- **LibOp:** Manages user interactions and calls appropriate methods for book operations.
- **JdbcHandler:** Handles database operations including adding, searching, listing, and deleting book records.
- **Main:** Entry point of the application, continuously displays the menu and processes user choices.

## Usage
1. **Run the Application:**
   - Start the application by running the `Main` class.
   
2. **Select an Option from the Menu:**
   - **1:** Add a new book.
   - **2:** Search for a book.
   - **3:** List all books.
   - **4:** Delete all book records.
   - **5:** Exit the program.

3. **Follow the Prompts:**
   - Enter details as prompted for the selected option.

## Database Configuration
- **URL:** `jdbc:mysql://localhost:3306/library_db`
- **User:** `root`
- **Password:** `29587674`

Ensure the MySQL database is running and the specified database (`library_db`) and table (`lib1`) are created before running the application.

## Dependencies
- Java Development Kit (JDK) 8 or higher
- MySQL Connector/J

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
