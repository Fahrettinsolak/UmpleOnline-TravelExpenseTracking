package com.solak.travelexpensetracking.main.lib.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.solak.travelexpensetracking.main.lib.models.TripWrapper;
import com.solak.travelexpensetracking.main.lib.wrappers.TripManagerWrapper;

/**
 * @brief Data Access Object (DAO) class for managing Trip objects in the
 *        database.
 */
public class TripDAO {

	private TripManagerWrapper tripManagerWrapper; // tripManagerWrapper değişkeni tanımlandı

	/**
	 * @brief Constructor for TripDAO.
	 * @param tripManagerWrapper The TripManagerWrapper instance.
	 */
	public TripDAO(TripManagerWrapper tripManagerWrapper) {
		this.tripManagerWrapper = tripManagerWrapper;
	}

	/**
	 * @brief Retrieves all trips from the database.
	 * @return A list of TripWrapper objects.
	 * @throws SQLException If a database access error occurs.
	 */
	public List<TripWrapper> getAllTrips() throws SQLException {
		List<TripWrapper> trips = new ArrayList<>();
		String query = "SELECT trip_id, destination, start_date, end_date FROM trip";
		try (Connection connection = DatabaseHelper.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {

			while (resultSet.next()) {
				UUID tripId = UUID.fromString(resultSet.getString("trip_id"));
				String destination = resultSet.getString("destination");
				java.sql.Date startDate = resultSet.getDate("start_date");
				java.sql.Date endDate = resultSet.getDate("end_date");

				trips.add(
						new TripWrapper(tripId, destination, startDate, endDate, tripManagerWrapper.getTripManager()));
			}
		}
		return trips;
	}

	/**
	 * @brief Adds a new trip to the database.
	 * @param trip The TripWrapper object to be added.
	 * @throws SQLException If a database access error occurs.
	 */
	public void addTrip(TripWrapper trip) throws SQLException {
		String query = "INSERT INTO trip (trip_id, destination, start_date, end_date) VALUES (?, ?, ?, ?)";
		try (Connection connection = DatabaseHelper.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, trip.getTripId().toString());
			preparedStatement.setString(2, trip.getDestination());
			preparedStatement.setDate(3, new java.sql.Date(trip.getStartDate().getTime()));
			preparedStatement.setDate(4, new java.sql.Date(trip.getEndDate().getTime()));
			preparedStatement.executeUpdate();
		}
	}

	/**
	 * @brief Updates an existing trip in the database.
	 * @param trip The TripWrapper object with updated information.
	 * @throws SQLException If a database access error occurs.
	 */
	public void updateTrip(TripWrapper trip) throws SQLException {
		String query = "UPDATE trip SET destination = ?, start_date = ?, end_date = ? WHERE trip_id = ?";
		try (Connection connection = DatabaseHelper.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, trip.getDestination());
			preparedStatement.setDate(2, new java.sql.Date(trip.getStartDate().getTime()));
			preparedStatement.setDate(3, new java.sql.Date(trip.getEndDate().getTime()));
			preparedStatement.setString(4, trip.getTripId().toString());
			// other fields if available
			preparedStatement.executeUpdate();
		}
	}

	/**
	 * @brief Deletes a trip from the database.
	 * @param tripId The UUID of the trip to be deleted.
	 * @throws SQLException If a database access error occurs.
	 */
	public void deleteTrip(UUID tripId) throws SQLException {
		String query = "DELETE FROM trip WHERE trip_id = ?";
		try (Connection connection = DatabaseHelper.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, tripId.toString());
			preparedStatement.executeUpdate();
		}
	}
}
