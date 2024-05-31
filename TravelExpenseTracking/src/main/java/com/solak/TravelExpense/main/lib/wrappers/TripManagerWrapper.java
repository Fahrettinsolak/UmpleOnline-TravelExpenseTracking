package com.solak.TravelExpense.main.lib.wrappers;

import com.solak.TravelExpense.umple.Trip;
import com.solak.TravelExpense.umple.TripManager;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class TripManagerWrapper {
    private TripManager tripManager;

    public TripManagerWrapper(TripManager tripManager) {
        this.tripManager = tripManager;
    }

    public TripManager getTripManager() {
        return tripManager;
    }

    public void createTrip(String username, Trip trip) {
        tripManager.createTrip(username, trip);
    }

    public Trip viewTrip(UUID tripId) {
        return tripManager.viewTrip(tripId);
    }

    public void deleteTrip(UUID tripId) {
        tripManager.deleteTrip(tripId);
    }

    public Trip getTrip(int index) {
        return tripManager.getTrip(index);
    }

    public List<Trip> getTrips() {
        return tripManager.getTrips();
    }

    public int numberOfTrips() {
        return tripManager.numberOfTrips();
    }

    public boolean hasTrips() {
        return tripManager.hasTrips();
    }

    public int indexOfTrip(Trip aTrip) {
        return tripManager.indexOfTrip(aTrip);
    }

    public Trip addTrip(UUID aTripId, String aDestination, Date aStartDate, Date aEndDate) {
        return tripManager.addTrip(aTripId, aDestination, aStartDate, aEndDate);
    }

    public boolean addTrip(Trip aTrip) {
        return tripManager.addTrip(aTrip);
    }

    public boolean removeTrip(Trip aTrip) {
        return tripManager.removeTrip(aTrip);
    }

    public boolean addTripAt(Trip aTrip, int index) {
        return tripManager.addTripAt(aTrip, index);
    }

    public boolean addOrMoveTripAt(Trip aTrip, int index) {
        return tripManager.addOrMoveTripAt(aTrip, index);
    }

    public void delete() {
        tripManager.delete();
    }
}
