package com.solak.travelexpensetracking.main.lib.models;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.solak.travelexpensetracking.main.lib.models.TripWrapper;
import com.solak.travelexpensetracking.umple.Trip;
import com.solak.travelexpensetracking.umple.TripManager;

public class TripWrapperTest {

    private Trip mockTrip;
    private TripWrapper tripWrapper;
    private TripManager tripManager;
    private UUID tripId;
    private Date startDate;
    private Date endDate;

    @Before
    public void setUp() {
        tripManager = new TripManager();
        tripId = UUID.randomUUID();
        startDate = new Date(System.currentTimeMillis());
        endDate = new Date(System.currentTimeMillis() + 86400000); 
        mockTrip = new Trip(tripId, "Initial Destination", startDate, endDate, tripManager);
        tripWrapper = new TripWrapper(mockTrip);
    }

    @Test
    public void testDefaultConstructor() {

        TripWrapper tripWrapper = new TripWrapper();
        
        assertNotNull(tripWrapper);
        
    }

    @Test
    public void testParameterizedConstructor() {
        TripWrapper tripWrapper = new TripWrapper(tripId, "New Destination", startDate, endDate, tripManager);
        
        assertNotNull(tripWrapper);
        assertEquals(tripId, tripWrapper.getTripId());
        assertEquals("New Destination", tripWrapper.getDestination());
        assertEquals(startDate, tripWrapper.getStartDate());
        assertEquals(endDate, tripWrapper.getEndDate());
        assertEquals(tripManager, tripWrapper.getTripManager());
    }

    @Test
    public void testGetTripId() {
        assertEquals(mockTrip.getTripId(), tripWrapper.getTripId());
    }

    @Test
    public void testSetTripId() {
        UUID newTripId = UUID.randomUUID();
        tripWrapper.setTripId(newTripId);
        assertEquals(newTripId, tripWrapper.getTripId());
    }

    @Test
    public void testGetDestination() {
        assertEquals(mockTrip.getDestination(), tripWrapper.getDestination());
    }

    @Test
    public void testSetDestination() {
        String newDestination = "Updated Destination";
        tripWrapper.setDestination(newDestination);
        assertEquals(newDestination, tripWrapper.getDestination());
    }

    @Test
    public void testGetStartDate() {
        assertEquals(mockTrip.getStartDate(), tripWrapper.getStartDate());
    }

    @Test
    public void testSetStartDate() {
        Date newStartDate = new Date(System.currentTimeMillis() + 86400000); 
        tripWrapper.setStartDate(newStartDate);
        assertEquals(newStartDate, tripWrapper.getStartDate());
    }

    @Test
    public void testGetEndDate() {
        assertEquals(mockTrip.getEndDate(), tripWrapper.getEndDate());
    }

    @Test
    public void testSetEndDate() {
        Date newEndDate = new Date(System.currentTimeMillis() + 172800000); 
        tripWrapper.setEndDate(newEndDate);
        assertEquals(newEndDate, tripWrapper.getEndDate());
    }

    @Test
    public void testGetTripManager() {
        assertEquals(tripManager, tripWrapper.getTripManager());
    }

    @Test
    public void testSetTripManager() {
        TripManager newManager = new TripManager();
        tripWrapper.setTripManager(newManager);
        assertEquals(newManager, tripWrapper.getTripManager());
    }

    @Test
    public void testGetAccommodations() {
        String[] accommodations = {"Hotel A", "Hotel B"};
        mockTrip.updateAccommodations(accommodations);
        assertNotEquals(Arrays.asList(accommodations), tripWrapper.getAccommodations());
    }

    @Test
    public void testAddAccommodation() {
        String newAccommodation = "Hotel C";
        tripWrapper.addAccommodation(newAccommodation);
        assertTrue(tripWrapper.getAccommodations().contains(newAccommodation));
    }

    @Test
    public void testRemoveAccommodation() {
        String accommodation = "Hotel A";
        tripWrapper.addAccommodation(accommodation);
        tripWrapper.removeAccommodation(accommodation);
        assertFalse(tripWrapper.getAccommodations().contains(accommodation));
    }

    @Test
    public void testGetTransportation() {
        String[] transportation = {"Car", "Plane"};
        mockTrip.updateTransportation(transportation);
        assertNotEquals(Arrays.asList(transportation), tripWrapper.getTransportation());
    }

    @Test
    public void testAddTransportation() {
        String newTransportation = "Bus";
        tripWrapper.addTransportation(newTransportation);
        assertTrue(tripWrapper.getTransportation().contains(newTransportation));
    }

    @Test
    public void testRemoveTransportation() {
        String transportation = "Car";
        tripWrapper.addTransportation(transportation);
        tripWrapper.removeTransportation(transportation);
        assertFalse(tripWrapper.getTransportation().contains(transportation));
    }

    @Test
    public void testGetActivities() {
        String[] activities = {"Sightseeing", "Hiking"};
        mockTrip.updateActivities(activities);
        assertNotEquals(Arrays.asList(activities), tripWrapper.getActivities());
    }

    @Test
    public void testAddActivity() {
        String newActivity = "Swimming";
        tripWrapper.addActivity(newActivity);
        assertTrue(tripWrapper.getActivities().contains(newActivity));
    }

    @Test
    public void testRemoveActivity() {
        String activity = "Sightseeing";
        tripWrapper.addActivity(activity);
        tripWrapper.removeActivity(activity);
        assertFalse(tripWrapper.getActivities().contains(activity));
    }

    @Test
    public void testUpdateDestination() {
        String newDestination = "New Destination for Update";
        tripWrapper.updateDestination(newDestination);
        assertNotEquals(newDestination, tripWrapper.getDestination());
    }

    @Test
    public void testUpdateStartDate() {
        Date newStartDate = new Date(System.currentTimeMillis() + 259200000); 
        tripWrapper.updateStartDate(newStartDate);
        assertNotEquals(newStartDate, tripWrapper.getStartDate());
    }

    @Test
    public void testUpdateEndDate() {
        Date newEndDate = new Date(System.currentTimeMillis() + 345600000); 
        tripWrapper.updateEndDate(newEndDate);
        assertNotEquals(newEndDate, tripWrapper.getEndDate());
    }

    @Test
    public void testUpdateAccommodations() {
        String[] newAccommodations = {"Hotel D", "Hotel E"};
        tripWrapper.updateAccommodations(newAccommodations);
        assertNotEquals(Arrays.asList(newAccommodations), tripWrapper.getAccommodations());
    }

    @Test
    public void testUpdateTransportation() {
        String[] newTransportation = {"Train", "Bike"};
        tripWrapper.updateTransportation(newTransportation);
        assertNotEquals(Arrays.asList(newTransportation), tripWrapper.getTransportation());
    }

    @Test
    public void testUpdateActivities() {
        String[] newActivities = {"Running", "Skiing"};
        tripWrapper.updateActivities(newActivities);
        assertNotEquals(Arrays.asList(newActivities), tripWrapper.getActivities());
    }

    @Test
    public void testDelete() {
        tripWrapper.delete();
        
    }

    @Test
    public void testToString() {
        String expectedString = mockTrip.toString();
        assertEquals(expectedString, tripWrapper.toString());
    }
}
