package com.solak.TravelExpense.main.app;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.UUID;

import javax.swing.table.DefaultTableModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.solak.TravelExpense.main.lib.wrappers.TripManagerWrapper;
import com.solak.TravelExpense.umple.Trip;
import com.solak.TravelExpense.umple.TripManager;

public class TripManagementScreenTest {

	private TripManager tripManager;
    private TripManagerWrapper tripManagerWrapper;

    @Before
    public void setUp() {
        tripManager = new TripManager();
        tripManagerWrapper = new TripManagerWrapper(tripManager);
    }

    @After
    public void tearDown() {
        tripManager = null;
        tripManagerWrapper = null;
    }

    @Test
    public void testCreateTrip() {
        Trip trip = new Trip(UUID.randomUUID(), "Paris", Date.valueOf("2024-06-01"), Date.valueOf("2024-06-05"), tripManager);
        tripManagerWrapper.createTrip("user123", trip);
        assertEquals(1, tripManager.numberOfTrips());
    }

    @Test
    public void testViewTrip() {
        Trip trip = new Trip(UUID.randomUUID(), "Paris", Date.valueOf("2024-06-01"), Date.valueOf("2024-06-05"), tripManager);
        tripManagerWrapper.createTrip("user123", trip);
        assertNull(tripManagerWrapper.viewTrip(trip.getTripId()));
    }

    @Test
    public void testDeleteTrip() {
        Trip trip = new Trip(UUID.randomUUID(), "Paris", Date.valueOf("2024-06-01"), Date.valueOf("2024-06-05"), tripManager);
        tripManagerWrapper.createTrip("user123", trip);
        tripManagerWrapper.deleteTrip(trip.getTripId());
        assertNotEquals(0, tripManager.numberOfTrips());
    }

}
