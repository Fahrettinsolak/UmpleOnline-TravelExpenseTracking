package com.solak.TravelExpense.main.lib.database;

import com.solak.TravelExpense.main.lib.models.UserCredentialWrapper;
import com.solak.TravelExpense.umple.AuthenticationManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserCredentialDAO {
    private AuthenticationManager authManager;

    public UserCredentialDAO(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    public List<UserCredentialWrapper> getAllUserCredentials() throws SQLException {
        List<UserCredentialWrapper> userCredentials = new ArrayList<>();
        String query = "SELECT * FROM user_credential";
        try (Connection connection = DatabaseHelper.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                UserCredentialWrapper userCredential = new UserCredentialWrapper(authManager, username, password);
                userCredentials.add(userCredential);
            }
        }
        return userCredentials;
    }

    public void addUserCredential(UserCredentialWrapper userCredential) throws SQLException {
        String query = "INSERT INTO user_credential (username, password) VALUES (?, ?)";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, userCredential.getUsername());
            preparedStatement.setString(2, userCredential.getPassword());
            preparedStatement.executeUpdate();
        }
    }

    public void updateUserCredential(UserCredentialWrapper userCredential) throws SQLException {
        String query = "UPDATE user_credential SET password = ? WHERE username = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, userCredential.getPassword());
            preparedStatement.setString(2, userCredential.getUsername());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteUserCredential(String username) throws SQLException {
        String query = "DELETE FROM user_credential WHERE username = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        }
    }
}
