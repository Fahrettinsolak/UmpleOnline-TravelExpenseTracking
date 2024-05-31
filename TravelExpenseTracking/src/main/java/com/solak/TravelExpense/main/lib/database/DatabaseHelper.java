package com.solak.TravelExpense.main.lib.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {

    private static final String DATABASE_URL = "jdbc:sqlite:travel_expense.db"; // SQLite URL

    public static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL)) {
            if (conn != null) {
                try (Statement stmt = conn.createStatement()) {
                    String[] tableCreationQueries = getTableCreationQueries();
                    for (String query : tableCreationQueries) {
                        stmt.executeUpdate(query);
                    }
                    System.out.println("Database initialized successfully.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String[] getTableCreationQueries() {
        return new String[] {
            "CREATE TABLE IF NOT EXISTS authentication_manager (" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT" +
            ");",

            "CREATE TABLE IF NOT EXISTS user_credential (" +
            "    username TEXT PRIMARY KEY," +
            "    password TEXT NOT NULL" +
            ");",

            "CREATE TABLE IF NOT EXISTS budget_manager (" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT" +
            ");",

            "CREATE TABLE IF NOT EXISTS report_manager (" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT" +
            ");",

            "CREATE TABLE IF NOT EXISTS trip_manager (" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT" +
            ");",

            "CREATE TABLE IF NOT EXISTS expense_manager (" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT" +
            ");",

            "CREATE TABLE IF NOT EXISTS budget (" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "    amount DOUBLE," +
            "    currency VARCHAR(255)," +
            "    description VARCHAR(255)," +
            "    type VARCHAR(255)" +
            ");",

            "CREATE TABLE IF NOT EXISTS report (" +
            "    report_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "    content VARCHAR(255)," +
            "    creation_date DATE" +
            ");",

            "CREATE TABLE IF NOT EXISTS trip (" +
            "    trip_id INTEGER PRIMARY KEY," +
            "    destination VARCHAR(255)," +
            "    start_date DATE," +
            "    end_date DATE" +
            ");",

            "CREATE TABLE IF NOT EXISTS expense (" +
            "    expense_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "    date DATE," +
            "    amount DOUBLE," +
            "    currency VARCHAR(255)," +
            "    category VARCHAR(255)," +
            "    payment_method VARCHAR(255)" +
            ");"
        };
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
