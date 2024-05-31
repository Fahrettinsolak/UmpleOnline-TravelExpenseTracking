package com.solak.TravelExpense.umple;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;
import java.util.*;

// line 69 "model.ump"
// line 149 "model.ump"
public class Trip
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Trip Attributes
  private UUID tripId;
  private String destination;
  private Date startDate;
  private Date endDate;
  private List<String> accommodations;
  private List<String> transportation;
  private List<String> activities;

  //Trip Associations
  private TripManager tripManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Trip(UUID aTripId, String aDestination, Date aStartDate, Date aEndDate, TripManager aTripManager)
  {
    tripId = aTripId;
    destination = aDestination;
    startDate = aStartDate;
    endDate = aEndDate;
    accommodations = new ArrayList<String>();
    transportation = new ArrayList<String>();
    activities = new ArrayList<String>();
    boolean didAddTripManager = setTripManager(aTripManager);
    if (!didAddTripManager)
    {
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTripId(UUID aTripId)
  {
    boolean wasSet = false;
    tripId = aTripId;
    wasSet = true;
    return wasSet;
  }

  public boolean setDestination(String aDestination)
  {
    boolean wasSet = false;
    destination = aDestination;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartDate(Date aStartDate)
  {
    boolean wasSet = false;
    startDate = aStartDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndDate(Date aEndDate)
  {
    boolean wasSet = false;
    endDate = aEndDate;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetMany */
  public boolean addAccommodation(String aAccommodation)
  {
    boolean wasAdded = false;
    wasAdded = accommodations.add(aAccommodation);
    return wasAdded;
  }

  public boolean removeAccommodation(String aAccommodation)
  {
    boolean wasRemoved = false;
    wasRemoved = accommodations.remove(aAccommodation);
    return wasRemoved;
  }
  /* Code from template attribute_SetMany */
  public boolean addTransportation(String aTransportation)
  {
    boolean wasAdded = false;
    wasAdded = transportation.add(aTransportation);
    return wasAdded;
  }

  public boolean removeTransportation(String aTransportation)
  {
    boolean wasRemoved = false;
    wasRemoved = transportation.remove(aTransportation);
    return wasRemoved;
  }
  /* Code from template attribute_SetMany */
  public boolean addActivity(String aActivity)
  {
    boolean wasAdded = false;
    wasAdded = activities.add(aActivity);
    return wasAdded;
  }

  public boolean removeActivity(String aActivity)
  {
    boolean wasRemoved = false;
    wasRemoved = activities.remove(aActivity);
    return wasRemoved;
  }

  public UUID getTripId()
  {
    return tripId;
  }

  public String getDestination()
  {
    return destination;
  }

  public Date getStartDate()
  {
    return startDate;
  }

  public Date getEndDate()
  {
    return endDate;
  }
  /* Code from template attribute_GetMany */
  public String getAccommodation(int index)
  {
    String aAccommodation = accommodations.get(index);
    return aAccommodation;
  }

  public String[] getAccommodations()
  {
    String[] newAccommodations = accommodations.toArray(new String[accommodations.size()]);
    return newAccommodations;
  }

  public int numberOfAccommodations()
  {
    int number = accommodations.size();
    return number;
  }

  public boolean hasAccommodations()
  {
    boolean has = accommodations.size() > 0;
    return has;
  }

  public int indexOfAccommodation(String aAccommodation)
  {
    int index = accommodations.indexOf(aAccommodation);
    return index;
  }
  /* Code from template attribute_GetMany */
  public String getTransportation(int index)
  {
    String aTransportation = transportation.get(index);
    return aTransportation;
  }

  public String[] getTransportation()
  {
    String[] newTransportation = transportation.toArray(new String[transportation.size()]);
    return newTransportation;
  }

  public int numberOfTransportation()
  {
    int number = transportation.size();
    return number;
  }

  public boolean hasTransportation()
  {
    boolean has = transportation.size() > 0;
    return has;
  }

  public int indexOfTransportation(String aTransportation)
  {
    int index = transportation.indexOf(aTransportation);
    return index;
  }
  /* Code from template attribute_GetMany */
  public String getActivity(int index)
  {
    String aActivity = activities.get(index);
    return aActivity;
  }

  public String[] getActivities()
  {
    String[] newActivities = activities.toArray(new String[activities.size()]);
    return newActivities;
  }

  public int numberOfActivities()
  {
    int number = activities.size();
    return number;
  }

  public boolean hasActivities()
  {
    boolean has = activities.size() > 0;
    return has;
  }

  public int indexOfActivity(String aActivity)
  {
    int index = activities.indexOf(aActivity);
    return index;
  }
  /* Code from template association_GetOne */
  public TripManager getTripManager()
  {
    return tripManager;
  }
  /* Code from template association_SetOneToMany */
  public boolean setTripManager(TripManager aTripManager)
  {
    boolean wasSet = false;
    if (aTripManager == null)
    {
      return wasSet;
    }

    TripManager existingTripManager = tripManager;
    tripManager = aTripManager;
    if (existingTripManager != null && !existingTripManager.equals(aTripManager))
    {
      existingTripManager.removeTrip(this);
    }
    tripManager.addTrip(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    TripManager placeholderTripManager = tripManager;
    this.tripManager = null;
    if(placeholderTripManager != null)
    {
      placeholderTripManager.removeTrip(this);
    }
  }

  // line 78 "model.ump"
  public void updateDestination(String destination){
    
  }

  // line 79 "model.ump"
  public void updateStartDate(Date startDate){
    
  }

  // line 80 "model.ump"
  public void updateEndDate(Date endDate){
    
  }

  // line 81 "model.ump"
  public void updateAccommodations(String [] accommodations){
    
  }

  // line 82 "model.ump"
  public void updateTransportation(String [] transportation){
    
  }

  // line 83 "model.ump"
  public void updateActivities(String [] activities){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "destination" + ":" + getDestination()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "tripId" + "=" + (getTripId() != null ? !getTripId().equals(this)  ? getTripId().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "startDate" + "=" + (getStartDate() != null ? !getStartDate().equals(this)  ? getStartDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endDate" + "=" + (getEndDate() != null ? !getEndDate().equals(this)  ? getEndDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "tripManager = "+(getTripManager()!=null?Integer.toHexString(System.identityHashCode(getTripManager())):"null");
  }
}