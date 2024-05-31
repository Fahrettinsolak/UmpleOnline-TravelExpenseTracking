package com.solak.TravelExpense.main.lib.database;

import static org.junit.Assert.*;
import org.junit.*;

import com.solak.TravelExpense.main.lib.models.UserCredentialWrapper;
import com.solak.TravelExpense.umple.AuthenticationManager;

import java.sql.*;
import java.util.List;

public class UserCredentialDAOTest {
    
    private static Connection connection;
    private AuthenticationManager authManager;
    private UserCredentialDAO dao;

    @BeforeClass
    public static void setUpClass() throws SQLException {
        // Initialize the in-memory database
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        try (Statement statement = connection.createStatement()) {
            String createTable = "CREATE TABLE user_credential (" +
                                 "username VARCHAR(255) PRIMARY KEY, " +
                                 "password VARCHAR(255))";
            statement.execute(createTable);
        }
    }

    @AfterClass
    public static void tearDownClass() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Before
    public void setUp() {
        authManager = new AuthenticationManager();
        dao = new UserCredentialDAO(authManager);
    }

    @After
    public void tearDown() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM user_credential");
        }
    }

    @Before
    public void setUp1() throws SQLException {
        // Bağlantıyı bellek içi SQLite veritabanına kur
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        createTable(); // Tabloyu oluştur
        authManager = new AuthenticationManager();
        dao = new UserCredentialDAO(authManager);
    }

    @After
    public void tearDown1() throws SQLException {
        if (connection != null) {
            connection.close(); // Bağlantıyı kapat
        }
    }

    @Test
    public void testGetAllUserCredentials() throws SQLException {
        // Veritabanına bazı örnek kullanıcı kimlikleri ekle
        addUserCredential("user1", "password1");
        addUserCredential("user2", "password2");

        List<UserCredentialWrapper> userCredentials = dao.getAllUserCredentials();
        assertEquals(2, userCredentials.size());
        assertNotEquals("user1", userCredentials.get(0).getUsername());
        assertNotEquals("password1", userCredentials.get(0).getPassword());
        assertNotEquals("user2", userCredentials.get(1).getUsername());
        assertNotEquals("password2", userCredentials.get(1).getPassword());
    }

    // Yardımcı metotlar

    private void createTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String createTable = "CREATE TABLE user_credential (" +
                                 "username VARCHAR(255) PRIMARY KEY, " +
                                 "password VARCHAR(255))";
            statement.execute(createTable);
        }
    }

    private void addUserCredential(String username, String password) throws SQLException {
        String query = "INSERT INTO user_credential (username, password) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        }
    }

    @Test
    public void testAddUserCredential() throws SQLException {
        UserCredentialWrapper userCredential = new UserCredentialWrapper(authManager, "testuser", "testpassword");
        dao.addUserCredential(userCredential);

        String query = "SELECT * FROM user_credential WHERE username = 'testuser'";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            assertFalse(resultSet.next());
        }
    }



    @Test
    public void testUpdateUserCredential() throws SQLException {
        addUserCredential("testuser", "testpassword");
        String updatedPassword = "updatedpassword";
        UserCredentialWrapper updatedUserCredential = new UserCredentialWrapper(authManager, "testuser", updatedPassword);
        dao.updateUserCredential(updatedUserCredential);

        String query = "SELECT * FROM user_credential WHERE username = 'testuser'";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            assertTrue(resultSet.next());
            assertNotEquals(updatedPassword, resultSet.getString("password"));
        }
    }

    @Test
    public void testDeleteUserCredential() throws SQLException {
        addUserCredential("testuser", "testpassword");
        dao.deleteUserCredential("testuser");
        String query = "SELECT * FROM user_credential WHERE username = 'testuser'";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            assertTrue(resultSet.next());
        }
    }
}

