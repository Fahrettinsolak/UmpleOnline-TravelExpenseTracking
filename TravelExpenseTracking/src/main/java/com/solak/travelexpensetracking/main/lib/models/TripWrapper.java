package com.solak.travelexpensetracking.main.lib.models;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.solak.travelexpensetracking.umple.Trip;
import com.solak.travelexpensetracking.umple.TripManager;

public class TripWrapper {

	
    private Trip trip;
    

	public TripWrapper() {
	}
    
    public TripWrapper(Trip trip) {
        this.trip = trip;
    }

    // Constructor to create a TripWrapper with a new Trip instance
    public TripWrapper(UUID tripId, String destination, Date startDate, Date endDate, TripManager tripManager) {
        this.trip = new Trip(tripId, destination, startDate, endDate, tripManager);
    }

    // Getters and Setters for the wrapped Trip
    public UUID getTripId() {
        return trip.getTripId();
    }

    public void setTripId(UUID tripId) {
        trip.setTripId(tripId);
    }

    public String getDestination() {
        return trip.getDestination();
    }

    public void setDestination(String destination) {
        trip.setDestination(destination);
    }

    public Date getStartDate() {
        return trip.getStartDate();
    }

    public void setStartDate(Date startDate) {
        trip.setStartDate(startDate);
    }

    public Date getEndDate() {
        return trip.getEndDate();
    }

    public void setEndDate(Date endDate) {
        trip.setEndDate(endDate);
    }

    public TripManager getTripManager() {
        return trip.getTripManager();
    }

    public void setTripManager(TripManager tripManager) {
        trip.setTripManager(tripManager);
    }

    // Methods to update accommodations
    public List<String> getAccommodations() {
        return List.of(trip.getAccommodations());
    }

    public void addAccommodation(String accommodation) {
        trip.addAccommodation(accommodation);
    }

    public void removeAccommodation(String accommodation) {
        trip.removeAccommodation(accommodation);
    }

    // Methods to update transportation
    public List<String> getTransportation() {
        return List.of(trip.getTransportation());
    }

    public void addTransportation(String transportation) {
        trip.addTransportation(transportation);
    }

    public void removeTransportation(String transportation) {
        trip.removeTransportation(transportation);
    }

    // Methods to update activities
    public List<String> getActivities() {
        return List.of(trip.getActivities());
    }

    public void addActivity(String activity) {
        trip.addActivity(activity);
    }

    public void removeActivity(String activity) {
        trip.removeActivity(activity);
    }

    // Additional methods to update the trip details
    public void updateDestination(String destination) {
        trip.updateDestination(destination);
    }

    public void updateStartDate(Date startDate) {
        trip.updateStartDate(startDate);
    }

    public void updateEndDate(Date endDate) {
        trip.updateEndDate(endDate);
    }

    public void updateAccommodations(String[] accommodations) {
        trip.updateAccommodations(accommodations);
    }

    public void updateTransportation(String[] transportation) {
        trip.updateTransportation(transportation);
    }

    public void updateActivities(String[] activities) {
        trip.updateActivities(activities);
    }

    // Method to delete the trip
    public void delete() {
        trip.delete();
    }

    @Override
    public String toString() {
        return trip.toString();
    }
}
