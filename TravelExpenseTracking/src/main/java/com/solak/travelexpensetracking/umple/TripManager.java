package com.solak.travelexpensetracking.umple;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;
import java.sql.Date;

// line 32 "model.ump"
// line 127 "model.ump"
public class TripManager
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TripManager Associations
  private List<Trip> trips;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TripManager()
  {
    trips = new ArrayList<Trip>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Trip getTrip(int index)
  {
    Trip aTrip = trips.get(index);
    return aTrip;
  }

  public List<Trip> getTrips()
  {
    List<Trip> newTrips = Collections.unmodifiableList(trips);
    return newTrips;
  }

  public int numberOfTrips()
  {
    int number = trips.size();
    return number;
  }

  public boolean hasTrips()
  {
    boolean has = trips.size() > 0;
    return has;
  }

  public int indexOfTrip(Trip aTrip)
  {
    int index = trips.indexOf(aTrip);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTrips()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Trip addTrip(UUID aTripId, String aDestination, Date aStartDate, Date aEndDate)
  {
    return new Trip(aTripId, aDestination, aStartDate, aEndDate, this);
  }

  public boolean addTrip(Trip aTrip)
  {
    boolean wasAdded = false;
    if (trips.contains(aTrip)) { return false; }
    TripManager existingTripManager = aTrip.getTripManager();
    boolean isNewTripManager = existingTripManager != null && !this.equals(existingTripManager);
    if (isNewTripManager)
    {
      aTrip.setTripManager(this);
    }
    else
    {
      trips.add(aTrip);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTrip(Trip aTrip)
  {
    boolean wasRemoved = false;
    //Unable to remove aTrip, as it must always have a tripManager
    if (!this.equals(aTrip.getTripManager()))
    {
      trips.remove(aTrip);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTripAt(Trip aTrip, int index)
  {  
    boolean wasAdded = false;
    if(addTrip(aTrip))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTrips()) { index = numberOfTrips() - 1; }
      trips.remove(aTrip);
      trips.add(index, aTrip);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTripAt(Trip aTrip, int index)
  {
    boolean wasAdded = false;
    if(trips.contains(aTrip))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTrips()) { index = numberOfTrips() - 1; }
      trips.remove(aTrip);
      trips.add(index, aTrip);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTripAt(aTrip, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=trips.size(); i > 0; i--)
    {
      Trip aTrip = trips.get(i - 1);
      aTrip.delete();
    }
  }

  // line 35 "model.ump"
  public void createTrip(String username, Trip trip){
    
  }

  // line 36 "model.ump"
  public Trip viewTrip(UUID tripId){
	return null;
    
  }

  // line 37 "model.ump"
  public void deleteTrip(UUID tripId){
    
  }

}