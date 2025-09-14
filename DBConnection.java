package com.ecommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // H2 Database URL (embedded mode, stored in project folder)
    private static final String URL = "jdbc:h2:./ecommerce_db;AUTO_SERVER=TRUE";
    private static final String USER = "sa";      // default H2 user
    private static final String PASSWORD = "";    // default H2 password

    // Get a database connection
    public static Connection getConnection() throws Exception {
        try {
            // Load H2 JDBC driver
            Class.forName("org.h2.Driver");

            // Connect to H2 database
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("H2 Database connected successfully!");
            return con;
        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            throw e;
        }
    }

    // Test the connection
    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConnection();
            if (con != null) {
                System.out.println("Connection test passed!");
            }
        } catch (Exception e) {
            System.out.println("Connection test failed!");
        }
    }
}
