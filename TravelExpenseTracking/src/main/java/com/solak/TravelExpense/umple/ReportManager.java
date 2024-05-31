package com.solak.TravelExpense.umple;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;
import java.sql.Date;

// line 24 "model.ump"
// line 121 "model.ump"
public class ReportManager
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ReportManager Associations
  private List<Report> reports;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ReportManager()
  {
    reports = new ArrayList<Report>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Report getReport(int index)
  {
    Report aReport = reports.get(index);
    return aReport;
  }

  public List<Report> getReports()
  {
    List<Report> newReports = Collections.unmodifiableList(reports);
    return newReports;
  }

  public int numberOfReports()
  {
    int number = reports.size();
    return number;
  }

  public boolean hasReports()
  {
    boolean has = reports.size() > 0;
    return has;
  }

  public int indexOfReport(Report aReport)
  {
    int index = reports.indexOf(aReport);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfReports()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Report addReport(UUID aReportId, String aContent, Date aCreationDate)
  {
    return new Report(aReportId, aContent, aCreationDate, this);
  }

  public boolean addReport(Report aReport)
  {
    boolean wasAdded = false;
    if (reports.contains(aReport)) { return false; }
    ReportManager existingReportManager = aReport.getReportManager();
    boolean isNewReportManager = existingReportManager != null && !this.equals(existingReportManager);
    if (isNewReportManager)
    {
      aReport.setReportManager(this);
    }
    else
    {
      reports.add(aReport);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeReport(Report aReport)
  {
    boolean wasRemoved = false;
    //Unable to remove aReport, as it must always have a reportManager
    if (!this.equals(aReport.getReportManager()))
    {
      reports.remove(aReport);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addReportAt(Report aReport, int index)
  {  
    boolean wasAdded = false;
    if(addReport(aReport))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReports()) { index = numberOfReports() - 1; }
      reports.remove(aReport);
      reports.add(index, aReport);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveReportAt(Report aReport, int index)
  {
    boolean wasAdded = false;
    if(reports.contains(aReport))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReports()) { index = numberOfReports() - 1; }
      reports.remove(aReport);
      reports.add(index, aReport);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addReportAt(aReport, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=reports.size(); i > 0; i--)
    {
      Report aReport = reports.get(i - 1);
      aReport.delete();
    }
  }

  // line 27 "model.ump"
  public Report generateReport(String username){
	return null;
    
  }

  // line 28 "model.ump"
  public Report viewReport(UUID reportId){
	return null;
    
  }

  // line 29 "model.ump"
  public void deleteReport(UUID reportId){
    
  }

}