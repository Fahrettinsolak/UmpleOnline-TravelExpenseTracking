package com.solak.travelexpensetracking.main.lib.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.solak.travelexpensetracking.main.lib.models.UserCredentialWrapper;
import com.solak.travelexpensetracking.umple.AuthenticationManager;

/**
 * @brief Data Access Object (DAO) class for managing UserCredential objects in
 *        the database.
 */
public class UserCredentialDAO {
	private AuthenticationManager authManager;

	/**
	 * @brief Constructor for UserCredentialDAO.
	 * @param authManager The AuthenticationManager instance.
	 */
	public UserCredentialDAO(AuthenticationManager authManager) {
		this.authManager = authManager;
	}

	/**
	 * @brief Retrieves all user credentials from the database.
	 * @return A list of UserCredentialWrapper objects.
	 * @throws SQLException If a database access error occurs.
	 */
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

	/**
	 * @brief Adds a new user credential to the database.
	 * @param userCredential The UserCredentialWrapper object to be added.
	 * @throws SQLException If a database access error occurs.
	 */
	public void addUserCredential(UserCredentialWrapper userCredential) throws SQLException {
		String query = "INSERT INTO user_credential (username, password) VALUES (?, ?)";
		try (Connection connection = DatabaseHelper.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, userCredential.getUsername());
			preparedStatement.setString(2, userCredential.getPassword());
			preparedStatement.executeUpdate();
		}
	}

	/**
	 * @brief Updates an existing user credential in the database.
	 * @param userCredential The UserCredentialWrapper object with updated
	 *                       information.
	 * @throws SQLException If a database access error occurs.
	 */
	public void updateUserCredential(UserCredentialWrapper userCredential) throws SQLException {
		String query = "UPDATE user_credential SET password = ? WHERE username = ?";
		try (Connection connection = DatabaseHelper.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, userCredential.getPassword());
			preparedStatement.setString(2, userCredential.getUsername());
			preparedStatement.executeUpdate();
		}
	}

	/**
	 * @brief Deletes a user credential from the database.
	 * @param username The username of the user credential to be deleted.
	 * @throws SQLException If a database access error occurs.
	 */
	public void deleteUserCredential(String username) throws SQLException {
		String query = "DELETE FROM user_credential WHERE username = ?";
		try (Connection connection = DatabaseHelper.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, username);
			preparedStatement.executeUpdate();
		}
	}
}
