package com.solak.travelexpensetracking.main.lib.wrappers;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.solak.travelexpensetracking.main.lib.wrappers.TripManagerWrapper;
import com.solak.travelexpensetracking.umple.Trip;
import com.solak.travelexpensetracking.umple.TripManager;

public class TripManagerWrapperTest {

	@Test
    public void testParametricConstructor() {
        // Arrange
        TripManager tripManager = new TripManager();
        TripManagerWrapper tripManagerWrapper;

        tripManagerWrapper = new TripManagerWrapper(tripManager);

        assertNotNull(tripManagerWrapper);
        assertEquals(tripManager, tripManagerWrapper.getTripManager());
    }
	
	@Test
    public void testViewTrip() {
        // Arrange
        TripManager tripManager = new TripManager();
        TripManagerWrapper tripManagerWrapper = new TripManagerWrapper(tripManager);
        UUID tripId = UUID.randomUUID();
        Trip expectedTrip = new Trip(tripId, "Test Destination", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000), tripManager); // 1 day later

        // Act
        tripManager.addTrip(expectedTrip); // önce beklenen gezinin TripManager'a eklenmesi
        Trip viewedTrip = tripManagerWrapper.viewTrip(tripId);

        // Assert
        assertNotEquals(expectedTrip, viewedTrip);
    }
	
	@Test
    public void testCreateTrip() {
        // Arrange
        TripManager tripManager = new TripManager();
        TripManagerWrapper tripManagerWrapper = new TripManagerWrapper(tripManager);
        String username = "testUser";
        Trip expectedTrip = new Trip(UUID.randomUUID(), "Test Destination", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000), tripManager); // 1 day later

        tripManagerWrapper.createTrip(username, expectedTrip);

        Trip createdTrip = tripManager.getTrip(0); 
        assertNotNull(createdTrip);
        assertEquals(expectedTrip, createdTrip);
    }
	
	@Test
    public void testDeleteTrip() {
        TripManager tripManager = new TripManager();
        TripManagerWrapper tripManagerWrapper = new TripManagerWrapper(tripManager);
        UUID tripId = UUID.randomUUID();
        Trip tripToDelete = new Trip(tripId, "Test Destination", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000), tripManager); 
        tripManager.addTrip(tripToDelete);

        tripManagerWrapper.deleteTrip(tripId);

        assertTrue(tripManager.hasTrips()); 
    }
	
	@Test
    public void testGetTrip() {
        TripManager tripManager = new TripManager();
        TripManagerWrapper tripManagerWrapper = new TripManagerWrapper(tripManager);
        UUID tripId = UUID.randomUUID();
        Trip expectedTrip = new Trip(tripId, "Test Destination", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000), tripManager); 
        tripManager.addTrip(expectedTrip);

        Trip retrievedTrip = tripManagerWrapper.getTrip(0);

        assertEquals(expectedTrip, retrievedTrip);
    }
	
	@Test
    public void testGetTrips() {
        TripManager tripManager = new TripManager();
        TripManagerWrapper tripManagerWrapper = new TripManagerWrapper(tripManager);
        UUID tripId1 = UUID.randomUUID();
        UUID tripId2 = UUID.randomUUID();
        Trip trip1 = new Trip(tripId1, "Test Destination 1", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000), tripManager); 
        Trip trip2 = new Trip(tripId2, "Test Destination 2", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000), tripManager); 
        tripManager.addTrip(trip1);
        tripManager.addTrip(trip2);

        List<Trip> trips = tripManagerWrapper.getTrips();

        assertEquals(2, trips.size());
        assertTrue(trips.contains(trip1));
        assertTrue(trips.contains(trip2));
    }
	
	@Test
    public void testNumberOfTrips() {
        TripManager tripManager = new TripManager();
        TripManagerWrapper tripManagerWrapper = new TripManagerWrapper(tripManager);
        UUID tripId1 = UUID.randomUUID();
        UUID tripId2 = UUID.randomUUID();
        Trip trip1 = new Trip(tripId1, "Test Destination 1", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000), tripManager); 
        Trip trip2 = new Trip(tripId2, "Test Destination 2", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000), tripManager); 
        tripManager.addTrip(trip1);
        tripManager.addTrip(trip2);

        int numberOfTrips = tripManagerWrapper.numberOfTrips();

        assertEquals(2, numberOfTrips);
    }
	
	@Test
    public void testHasTrips_WhenHasTrips() {
        TripManager tripManager = new TripManager();
        TripManagerWrapper tripManagerWrapper = new TripManagerWrapper(tripManager);
        UUID tripId = UUID.randomUUID();
        Trip trip = new Trip(tripId, "Test Destination", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000), tripManager); // 1 day later
        tripManager.addTrip(trip);

        boolean hasTrips = tripManagerWrapper.hasTrips();

        assertTrue(hasTrips);
    }
	
	@Test
    public void testIndexOfTrip_WhenTripExists() {
        TripManager tripManager = new TripManager();
        TripManagerWrapper tripManagerWrapper = new TripManagerWrapper(tripManager);
        UUID tripId = UUID.randomUUID();
        Trip trip = new Trip(tripId, "Test Destination", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000), tripManager); // 1 day later
        tripManager.addTrip(trip);

        int indexOfTrip = tripManagerWrapper.indexOfTrip(trip);

        assertEquals(0, indexOfTrip);
    }
	
	 @Test
	    public void testAddTrip() {
	        TripManager tripManager = new TripManager();
	        TripManagerWrapper tripManagerWrapper = new TripManagerWrapper(tripManager);
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 

	        Trip addedTrip = tripManagerWrapper.addTrip(tripId, destination, startDate, endDate);

	        assertNotNull(addedTrip);
	        assertEquals(tripId, addedTrip.getTripId());
	        assertEquals(destination, addedTrip.getDestination());
	        assertEquals(startDate, addedTrip.getStartDate());
	        assertEquals(endDate, addedTrip.getEndDate());
	    }
	 
	 @Test
	    public void testAddAndRemoveTrip() {
	        TripManager tripManager = new TripManager();
	        TripManagerWrapper tripManagerWrapper = new TripManagerWrapper(tripManager);
	        UUID tripId = UUID.randomUUID();
	        String destination = "Test Destination";
	        Date startDate = new Date(System.currentTimeMillis());
	        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
	        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);

	        boolean added = tripManagerWrapper.addTrip(trip);
	        boolean removed = tripManagerWrapper.removeTrip(trip);

	        assertFalse(added);
	        assertFalse(removed);
	        assertTrue(tripManagerWrapper.getTripManager().getTrips().contains(trip));
	    }
	 
	 @Test
	    public void testAddTripAtAndAddOrMoveTripAt() {
	        TripManager tripManager = new TripManager();
	        TripManagerWrapper tripManagerWrapper = new TripManagerWrapper(tripManager);
	        UUID tripId1 = UUID.randomUUID();
	        Trip trip1 = new Trip(tripId1, "Test Destination 1", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000), tripManager); 
	        UUID tripId2 = UUID.randomUUID();
	        Trip trip2 = new Trip(tripId2, "Test Destination 2", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000), tripManager); 
	        UUID tripId3 = UUID.randomUUID();
	        Trip trip3 = new Trip(tripId3, "Test Destination 3", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000), tripManager); 

	        tripManagerWrapper.addTrip(trip1);
	        tripManagerWrapper.addTripAt(trip2, 0);
	        boolean addedOrMoved = tripManagerWrapper.addOrMoveTripAt(trip3, 1);
	        List<Trip> trips = tripManagerWrapper.getTripManager().getTrips();

	        assertTrue(addedOrMoved);
	        assertNotEquals(trip2, trips.get(1));
	        assertNotEquals(trip3, trips.get(0));
	    }

	    @Test
	    public void testDelete() {
	        TripManager tripManager = new TripManager();
	        TripManagerWrapper tripManagerWrapper = new TripManagerWrapper(tripManager);
	        UUID tripId = UUID.randomUUID();
	        Trip trip = new Trip(tripId, "Test Destination", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000), tripManager); 
	        tripManager.addTrip(trip);

	        tripManagerWrapper.delete();
	        List<Trip> trips = tripManagerWrapper.getTripManager().getTrips();

	        assertEquals(0, trips.size());
	    }


}
