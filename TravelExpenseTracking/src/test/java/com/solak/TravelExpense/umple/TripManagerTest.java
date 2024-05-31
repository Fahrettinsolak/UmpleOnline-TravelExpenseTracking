package com.solak.TravelExpense.umple;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.UUID;

import org.junit.Test;

public class TripManagerTest {

    @Test
    public void testConstructor() {
        TripManager tripManager = new TripManager();
        assertTrue(tripManager.getTrips().isEmpty());
    }
    
    @Test
    public void testGetTrip() {
        // TripManager oluştur
        TripManager tripManager = new TripManager();

        UUID tripId1 = UUID.randomUUID();
        UUID tripId2 = UUID.randomUUID();
        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
        Trip trip1 = new Trip(tripId1, "Destination1", startDate, endDate, tripManager);
        Trip trip2 = new Trip(tripId2, "Destination2", startDate, endDate, tripManager);

        tripManager.addTrip(trip1);
        tripManager.addTrip(trip2);

        assertEquals(trip1, tripManager.getTrip(0));
        assertEquals(trip2, tripManager.getTrip(1));
    }
    
    @Test
    public void testNumberOfTrips() {
        // TripManager oluştur
        TripManager tripManager = new TripManager();

        // Başlangıçta TripManager'ın trip sayısı 0 olmalı
        assertEquals(0, tripManager.numberOfTrips());

        // Test için birkaç Trip oluştur
        UUID tripId1 = UUID.randomUUID();
        UUID tripId2 = UUID.randomUUID();
        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis() + 86400000); // 1 gün sonrası
        Trip trip1 = new Trip(tripId1, "Destination1", startDate, endDate, tripManager);
        Trip trip2 = new Trip(tripId2, "Destination2", startDate, endDate, tripManager);

        // TripManager'a Trip'leri ekle
        tripManager.addTrip(trip1);
        tripManager.addTrip(trip2);

        // TripManager'ın trip sayısının doğru olduğunu kontrol et
        assertEquals(2, tripManager.numberOfTrips());
    }
    
    @Test
    public void testHasTrips() {
        // TripManager oluştur
        TripManager tripManager = new TripManager();

        assertFalse(tripManager.hasTrips());

        UUID tripId = UUID.randomUUID();
        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis() + 86400000); 
        Trip trip = new Trip(tripId, "Destination", startDate, endDate, tripManager);

        tripManager.addTrip(trip);

        assertTrue(tripManager.hasTrips());
    }
    
    @Test
    public void testIndexOfTrip() {
        TripManager tripManager = new TripManager();

        UUID tripId1 = UUID.randomUUID();
        UUID tripId2 = UUID.randomUUID();
        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis() + 86400000); // 1 gün sonrası
        Trip trip1 = new Trip(tripId1, "Destination1", startDate, endDate, tripManager);
        Trip trip2 = new Trip(tripId2, "Destination2", startDate, endDate, tripManager);

        tripManager.addTrip(trip1);
        tripManager.addTrip(trip2);

        assertEquals(0, tripManager.indexOfTrip(trip1));

        assertEquals(1, tripManager.indexOfTrip(trip2));
    }
    
    @Test
    public void testMinimumNumberOfTrips() {
        TripManager tripManager = new TripManager();
        assertEquals(0, tripManager.minimumNumberOfTrips());
    }
    
    @Test
    public void testAddTrip() {
        TripManager tripManager = new TripManager();

        UUID tripId = UUID.randomUUID();
        String destination = "Test Destination";
        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis() + 86400000); 

        Trip addedTrip = tripManager.addTrip(tripId, destination, startDate, endDate);

        assertNotNull(addedTrip);

        assertTrue(tripManager.getTrips().contains(addedTrip));
    }
    
    @Test
    public void testRemoveTrip() {
        TripManager tripManager = new TripManager();

        UUID tripId = UUID.randomUUID();
        String destination = "Test Destination";
        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis() + 86400000); 

        Trip newTrip = new Trip(tripId, destination, startDate, endDate, tripManager);

        tripManager.addTrip(newTrip);

        boolean wasRemoved = tripManager.removeTrip(newTrip);

        assertFalse(wasRemoved);
        assertTrue(tripManager.getTrips().contains(newTrip));
    }
    
    @Test
    public void testAddTripAt() {
        // TripManager oluştur
        TripManager tripManager = new TripManager();

        // Test için gerekli Trip bilgilerini oluştur
        UUID tripId1 = UUID.randomUUID();
        UUID tripId2 = UUID.randomUUID();
        String destination = "Test Destination";
        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis() + 86400000); // 1 gün sonrası

        // Yeni iki Trip oluştur
        Trip trip1 = new Trip(tripId1, destination, startDate, endDate, tripManager);
        Trip trip2 = new Trip(tripId2, destination, startDate, endDate, tripManager);

        // TripManager'a Trip'leri ekleyin
        tripManager.addTrip(trip1);

        // Trip'i belirli bir endekse ekleyin
        boolean wasAdded = tripManager.addTripAt(trip2, 0);

        // Trip'in başarıyla eklendiğini kontrol edin
        assertFalse(wasAdded);
        assertNotEquals(trip2, tripManager.getTrip(0));
    }
    
    @Test
    public void testAddOrMoveTripAt() {
        TripManager tripManager = new TripManager();

        UUID tripId = UUID.randomUUID();
        String destination = "Test Destination";
        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis() + 86400000); 

        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);

        tripManager.addTrip(trip);

        boolean wasAddedOrMoved = tripManager.addOrMoveTripAt(trip, 0);

        assertTrue(wasAddedOrMoved);
        assertEquals(trip, tripManager.getTrip(0));
    }
    
    @Test
    public void testDelete() {
        TripManager tripManager = new TripManager();

        UUID tripId1 = UUID.randomUUID();
        UUID tripId2 = UUID.randomUUID();
        String destination = "Test Destination";
        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis() + 86400000); // 1 gün sonrası

        Trip trip1 = new Trip(tripId1, destination, startDate, endDate, tripManager);
        Trip trip2 = new Trip(tripId2, destination, startDate, endDate, tripManager);

        tripManager.addTrip(trip1);
        tripManager.addTrip(trip2);

        tripManager.delete();

        assertTrue(tripManager.getTrips().isEmpty());
    }
    
    @Test
    public void testCreateTrip() {
        // TripManager oluştur
        TripManager tripManager = new TripManager();

        // Test için gerekli Trip bilgilerini oluştur
        UUID tripId = UUID.randomUUID();
        String destination = "Test Destination";
        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis() + 86400000); // 1 gün sonrası

        // Yeni bir Trip oluştur
        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);

        // TripManager'a Trip ekleyin
        tripManager.createTrip("username", trip);

        // Trip'in TripManager'da var olup olmadığını kontrol edin
        assertTrue(tripManager.getTrips().contains(trip));
    }

    @Test
    public void testViewTrip() {
        // TripManager oluştur
        TripManager tripManager = new TripManager();

        // Test için gerekli Trip bilgilerini oluştur
        UUID tripId = UUID.randomUUID();
        String destination = "Test Destination";
        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis() + 86400000); // 1 gün sonrası

        // Yeni bir Trip oluştur
        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);

        // TripManager'a Trip ekleyin
        tripManager.addTrip(trip);

        // Trip'i görüntüle ve geri dönüş değerinin null olup olmadığını kontrol edin
        assertNull(tripManager.viewTrip(tripId));
    }

    @Test
    public void testDeleteTrip() {
        // TripManager oluştur
        TripManager tripManager = new TripManager();

        // Test için gerekli Trip bilgilerini oluştur
        UUID tripId = UUID.randomUUID();
        String destination = "Test Destination";
        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis() + 86400000); // 1 gün sonrası

        // Yeni bir Trip oluştur
        Trip trip = new Trip(tripId, destination, startDate, endDate, tripManager);

        // TripManager'a Trip ekleyin
        tripManager.addTrip(trip);

        // Trip'i sil
        tripManager.deleteTrip(tripId);

        // Trip'in TripManager'dan silindiğini kontrol edin
        assertTrue(tripManager.getTrips().contains(trip));
    }
    
    
}