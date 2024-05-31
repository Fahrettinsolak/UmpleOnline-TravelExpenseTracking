package com.solak.travelexpensetracking.umple;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;
import java.util.UUID;

// line 60 "model.ump"
// line 144 "model.ump"
public class Report
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Report Attributes
  private UUID reportId;
  private String content;
  private Date creationDate;

  //Report Associations
  private ReportManager reportManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Report(UUID aReportId, String aContent, Date aCreationDate, ReportManager aReportManager)
  {
    reportId = aReportId;
    content = aContent;
    creationDate = aCreationDate;
    boolean didAddReportManager = setReportManager(aReportManager);
    if (!didAddReportManager)
    {
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setReportId(UUID aReportId)
  {
    boolean wasSet = false;
    reportId = aReportId;
    wasSet = true;
    return wasSet;
  }

  public boolean setContent(String aContent)
  {
    boolean wasSet = false;
    content = aContent;
    wasSet = true;
    return wasSet;
  }

  public boolean setCreationDate(Date aCreationDate)
  {
    boolean wasSet = false;
    creationDate = aCreationDate;
    wasSet = true;
    return wasSet;
  }

  public UUID getReportId()
  {
    return reportId;
  }

  public String getContent()
  {
    return content;
  }

  public Date getCreationDate()
  {
    return creationDate;
  }
  /* Code from template association_GetOne */
  public ReportManager getReportManager()
  {
    return reportManager;
  }
  /* Code from template association_SetOneToMany */
  public boolean setReportManager(ReportManager aReportManager)
  {
    boolean wasSet = false;
    if (aReportManager == null)
    {
      return wasSet;
    }

    ReportManager existingReportManager = reportManager;
    reportManager = aReportManager;
    if (existingReportManager != null && !existingReportManager.equals(aReportManager))
    {
      existingReportManager.removeReport(this);
    }
    reportManager.addReport(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ReportManager placeholderReportManager = reportManager;
    this.reportManager = null;
    if(placeholderReportManager != null)
    {
      placeholderReportManager.removeReport(this);
    }
  }

  // line 65 "model.ump"
  public void updateContent(String content){
    
  }

  // line 66 "model.ump"
  public void updateCreationDate(Date creationDate){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "content" + ":" + getContent()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "reportId" + "=" + (getReportId() != null ? !getReportId().equals(this)  ? getReportId().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "creationDate" + "=" + (getCreationDate() != null ? !getCreationDate().equals(this)  ? getCreationDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "reportManager = "+(getReportManager()!=null?Integer.toHexString(System.identityHashCode(getReportManager())):"null");
  }
}