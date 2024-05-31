package com.solak.TravelExpense.main.lib.database;

import com.solak.TravelExpense.main.lib.models.TripWrapper;
import com.solak.TravelExpense.main.lib.wrappers.TripManagerWrapper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TripDAO {
	private TripManagerWrapper tripManagerWrapper; // tripManagerWrapper değişkeni tanımlandı

    public TripDAO(TripManagerWrapper tripManagerWrapper) {
        this.tripManagerWrapper = tripManagerWrapper;
    }
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

	            trips.add(new TripWrapper(tripId, destination, startDate, endDate, tripManagerWrapper.getTripManager()));
	        }
	    }
	    return trips;
	}
	
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

    public void deleteTrip(UUID tripId) throws SQLException {
        String query = "DELETE FROM trip WHERE trip_id = ?";
        try (Connection connection = DatabaseHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, tripId.toString());
            preparedStatement.executeUpdate();
        }
    }
}
