package com.solak.travelexpensetracking.umple;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.solak.travelexpensetracking.umple.Trip;
import com.solak.travelexpensetracking.umple.TripManager;

import java.sql.Date;
import java.util.Arrays;
import java.util.UUID;

public class TripTest {
	 @Test
	    public void testConstructor() {
	        // Arrange
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 

	        // Act
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);

	        // Assert
	        assertNotNull(trip);
	        assertEquals(tripId, trip.getTripId());
	        assertEquals(destination, trip.getDestination());
	        assertEquals(startDate, trip.getStartDate());
	        assertEquals(endDate, trip.getEndDate());
	        assertFalse(trip.hasAccommodations());
	        assertFalse(trip.hasTransportation());
	        assertFalse(trip.hasActivities());
	        assertEquals(tripManager, trip.getTripManager());
	    }
	 
	 @Test
	    public void testSetTripId() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);

	        UUID newTripId = UUID.randomUUID();
	        boolean result = trip.setTripId(newTripId);

	        assertTrue(result);
	        assertEquals(newTripId, trip.getTripId());
	    }
	 
	 @Test
	    public void testSetDestination() {
	        // Arrange
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);

	        // Act
	        String newDestination = "New Test Destination";
	        boolean result = trip.setDestination(newDestination);

	        // Assert
	        assertTrue(result);
	        assertEquals(newDestination, trip.getDestination());
	    }
	 
	 @Test
	    public void testSetStartDate() {
	        // Arrange
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);

	        // Act
	        Date newStartDate = new Date(System.currentTimeMillis() + 86400000); 
	        boolean result = trip.setStartDate(newStartDate);

	        // Assert
	        assertTrue(result);
	        assertEquals(newStartDate, trip.getStartDate());
	    }
	 
	 @Test
	    public void testSetEndDate() {
	        // Arrange
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);

	        // Act
	        Date newEndDate = new Date(System.currentTimeMillis() + 86400000); 
	        boolean result = trip.setEndDate(newEndDate);

	        // Assert
	        assertTrue(result);
	        assertEquals(newEndDate, trip.getEndDate());
	    }
	 
	 @Test
	    public void testAddAccommodation() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);

	        String accommodation = "Test Accommodation";
	        boolean result = trip.addAccommodation(accommodation);

	        
	        assertTrue(result);
	        assertTrue(trip.hasAccommodations());
	        assertTrue(Arrays.asList(trip.getAccommodations()).contains(accommodation));
	    }
	 
	 @Test
	    public void testRemoveAccommodation() {
	        // Arrange
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String accommodation = "Test Accommodation";
	        trip.addAccommodation(accommodation);

	        boolean result = trip.removeAccommodation(accommodation);

	        assertTrue(result);
	        assertFalse(trip.hasAccommodations());
	        assertFalse(Arrays.asList(trip.getAccommodations()).contains(accommodation));
	    }
	 
	 @Test
	    public void testAddTransportation() {
	        // Arrange
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);

	        String transportation = "Test Transportation";
	        boolean result = trip.addTransportation(transportation);

	        assertTrue(result);
	        assertTrue(trip.hasTransportation());
	        assertTrue(Arrays.asList(trip.getTransportation()).contains(transportation));
	    }
	 
	 @Test
	    public void testRemoveTransportation() {
	        // Arrange
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000);
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String transportation = "Test Transportation";
	        trip.addTransportation(transportation);

	        boolean result = trip.removeTransportation(transportation);

	        assertTrue(result);
	        assertFalse(trip.hasTransportation());
	        assertFalse(Arrays.asList(trip.getTransportation()).contains(transportation));
	    }
	 
	 @Test
	    public void testAddActivity() {
	        // Arrange
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);

	        String activity = "Test Activity";
	        boolean result = trip.addActivity(activity);

	        assertTrue(result);
	        assertTrue(trip.hasActivities());
	        assertTrue(Arrays.asList(trip.getActivities()).contains(activity));
	    }
	 
	 @Test
	    public void testRemoveActivity() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String activity = "Test Activity";
	        trip.addActivity(activity);

	        boolean result = trip.removeActivity(activity);

	        assertTrue(result);
	        assertFalse(trip.hasActivities());
	        assertFalse(Arrays.asList(trip.getActivities()).contains(activity));
	    }
	 
	 @Test
	    public void testGetAccommodation() {
	        // Arrange
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String accommodation = "Test Accommodation";
	        trip.addAccommodation(accommodation);

	        // Act
	        String result = trip.getAccommodation(0);

	        // Assert
	        assertNotNull(result);
	        assertEquals(accommodation, result);
	    }
	 
	 @Test
	    public void testNumberOfAccommodations() {
	        // Arrange
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager();
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String accommodation1 = "Test Accommodation 1";
	        String accommodation2 = "Test Accommodation 2";
	        trip.addAccommodation(accommodation1);
	        trip.addAccommodation(accommodation2);

	        int result = trip.numberOfAccommodations();

	        assertEquals(2, result);
	    }
	 
	 @Test
	    public void testIndexOfAccommodation() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String accommodation1 = "Test Accommodation 1";
	        String accommodation2 = "Test Accommodation 2";
	        trip.addAccommodation(accommodation1);
	        trip.addAccommodation(accommodation2);

	        int result1 = trip.indexOfAccommodation(accommodation1);
	        int result2 = trip.indexOfAccommodation(accommodation2);

	        assertEquals(0, result1);
	        assertEquals(1, result2);
	    }
	 
	 @Test
	    public void testGetTransportation() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String transportation1 = "Test Transportation 1";
	        String transportation2 = "Test Transportation 2";
	        trip.addTransportation(transportation1);
	        trip.addTransportation(transportation2);

	        String result1 = trip.getTransportation(0);
	        String result2 = trip.getTransportation(1);

	        assertNotNull(result1);
	        assertNotNull(result2);
	        assertEquals(transportation1, result1);
	        assertEquals(transportation2, result2);
	    }
	 
	 @Test
	    public void testNumberOfTransportation() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String transportation1 = "Test Transportation 1";
	        String transportation2 = "Test Transportation 2";
	        trip.addTransportation(transportation1);
	        trip.addTransportation(transportation2);

	        int result = trip.numberOfTransportation();

	        assertEquals(2, result);
	    }
	 
	 @Test
	    public void testIndexOfTransportation() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager();
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String transportation1 = "Test Transportation 1";
	        String transportation2 = "Test Transportation 2";
	        trip.addTransportation(transportation1);
	        trip.addTransportation(transportation2);

	        int result1 = trip.indexOfTransportation(transportation1);
	        int result2 = trip.indexOfTransportation(transportation2);

	        assertEquals(0, result1);
	        assertEquals(1, result2);
	    }
	 @Test
	    public void testGetActivity() {
	        // Arrange
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String activity1 = "Test Activity 1";
	        String activity2 = "Test Activity 2";
	        trip.addActivity(activity1);
	        trip.addActivity(activity2);

	        // Act
	        String result1 = trip.getActivity(0);
	        String result2 = trip.getActivity(1);

	        // Assert
	        assertNotNull(result1);
	        assertNotNull(result2);
	        assertEquals(activity1, result1);
	        assertEquals(activity2, result2);
	    }
	 
	 @Test
	    public void testNumberOfActivities() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String activity1 = "Test Activity 1";
	        String activity2 = "Test Activity 2";
	        trip.addActivity(activity1);
	        trip.addActivity(activity2);

	        int result = trip.numberOfActivities();

	        assertEquals(2, result);
	    }
	 
	 @Test
	    public void testIndexOfActivity() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String activity1 = "Test Activity 1";
	        String activity2 = "Test Activity 2";
	        trip.addActivity(activity1);
	        trip.addActivity(activity2);

	        int result1 = trip.indexOfActivity(activity1);
	        int result2 = trip.indexOfActivity(activity2);

	        assertEquals(0, result1);
	        assertEquals(1, result2);
	    }
	 
	 @Test
	    public void testSetTripManager_Valid() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        TripManager newTripManager = new TripManager();

	        boolean result = trip.setTripManager(newTripManager);

	        assertTrue(result);
	        assertEquals(newTripManager, trip.getTripManager());
	    }
	 
	 @Test
	    public void testUpdateDestination() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager();
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String newDestination = "New Destination";

	        trip.updateDestination(newDestination);

	        assertNotEquals(newDestination, trip.getDestination());
	    }
	 
	 @Test
	    public void testDelete() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager();
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);

	        trip.delete();

	        assertNull(trip.getTripManager());
	    }
	 
	 @Test
	    public void testUpdateStartDate() {
	        // Arrange
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date originalStartDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, originalStartDate, endDate, tripManager);
	        Date newStartDate = new Date(System.currentTimeMillis() + 172800000); 

	        trip.updateStartDate(newStartDate);

	        assertNotEquals(newStartDate, trip.getStartDate());
	    }
	 
	 @Test
	    public void testUpdateEndDate() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date originalEndDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, originalEndDate, tripManager);
	        Date newEndDate = new Date(System.currentTimeMillis() + 172800000); 

	        trip.updateEndDate(newEndDate);

	        assertNotEquals(newEndDate, trip.getEndDate());
	    }
	 
	 @Test
	    public void testUpdateAccommodations() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String[] originalAccommodations = {"Hotel A", "Hotel B"};
	        trip.addAccommodation("Hotel A");
	        trip.addAccommodation("Hotel B");
	        String[] newAccommodations = {"Hotel C", "Hotel D"};

	        trip.updateAccommodations(newAccommodations);
	    }
	 
	 @Test
	    public void testUpdateTransportation() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String[] originalTransportation = {"Flight A", "Train B"};
	        trip.addTransportation("Flight A");
	        trip.addTransportation("Train B");
	        String[] newTransportation = {"Bus C", "Car D"};

	        trip.updateTransportation(newTransportation);
	    }
	 
	 @Test
	    public void testUpdateActivities() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);
	        String[] originalActivities = {"Sightseeing", "Hiking"};
	        trip.addActivity("Sightseeing");
	        trip.addActivity("Hiking");
	        String[] newActivities = {"Shopping", "Museum visit"};

	        trip.updateActivities(newActivities);
	    }
	 
	 @Test
	    public void testToString() {
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        TripManager tripManager = new TripManager(); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);

	        String result = trip.toString();

	        assertFalse(result.contains("destination: " + destination));
	        assertTrue(result.contains("tripId=" + tripId.toString()));
	        assertTrue(result.contains("startDate=" + startDate.toString()));
	        assertTrue(result.contains("endDate=" + endDate.toString()));
	        assertTrue(result.contains("tripManager = " + Integer.toHexString(System.identityHashCode(tripManager))));
	    }

}
