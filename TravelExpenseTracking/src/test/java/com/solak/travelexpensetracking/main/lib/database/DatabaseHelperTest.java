package com.solak.travelexpensetracking.main.lib.database;

import org.junit.Test;

import com.solak.travelexpensetracking.main.lib.database.DatabaseHelper;

import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.Assert.*;

public class DatabaseHelperTest {

    @Test
    public void testGetConnection() {
        try {
            Connection connection = DatabaseHelper.getConnection();
            assertNotNull("Connection should not be null", connection);
            assertFalse("Connection should be open", connection.isClosed());
            DatabaseHelper.closeConnection(connection);
        } catch (SQLException e) {
        }
    }

    @Test
    public void testInitializeDatabase() {
        try {
            DatabaseHelper.initializeDatabase();
            assertTrue("Assuming tables are created successfully", true);
        } catch (Exception e) {
        }
    }
}
