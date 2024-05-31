package com.solak.travelexpensetracking.umple;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/



// line 48 "model.ump"
// line 139 "model.ump"
public class Budget
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Budget Attributes
  private double amount;
  private String currency;
  private String description;
  private String type;

  //Budget Associations
  private BudgetManager budgetManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Budget(double aAmount, String aCurrency, String aDescription, String aType, BudgetManager aBudgetManager)
  {
    amount = aAmount;
    currency = aCurrency;
    description = aDescription;
    type = aType;
    boolean didAddBudgetManager = setBudgetManager(aBudgetManager);
    if (!didAddBudgetManager)
    {
      throw new RuntimeException("Unable to create budget due to budgetManager. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAmount(double aAmount)
  {
    boolean wasSet = false;
    amount = aAmount;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrency(String aCurrency)
  {
    boolean wasSet = false;
    currency = aCurrency;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public double getAmount()
  {
    return amount;
  }

  public String getCurrency()
  {
    return currency;
  }

  public String getDescription()
  {
    return description;
  }

  public String getType()
  {
    return type;
  }
  /* Code from template association_GetOne */
  public BudgetManager getBudgetManager()
  {
    return budgetManager;
  }
  /* Code from template association_SetOneToMany */
  public boolean setBudgetManager(BudgetManager aBudgetManager)
  {
    boolean wasSet = false;
    if (aBudgetManager == null)
    {
      return wasSet;
    }

    BudgetManager existingBudgetManager = budgetManager;
    budgetManager = aBudgetManager;
    if (existingBudgetManager != null && !existingBudgetManager.equals(aBudgetManager))
    {
      existingBudgetManager.removeBudget(this);
    }
    budgetManager.addBudget(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    BudgetManager placeholderBudgetManager = budgetManager;
    this.budgetManager = null;
    if(placeholderBudgetManager != null)
    {
      placeholderBudgetManager.removeBudget(this);
    }
  }

  // line 54 "model.ump"
  public void updateDescription(String description){
    
  }

  // line 55 "model.ump"
  public void updateAmount(double amount){
    
  }

  // line 56 "model.ump"
  public void updateCurrency(String currency){
    
  }

  // line 57 "model.ump"
  public void updateType(String type){
    
  }
  public int getId() {
      return getId();  // Budget sınıfınızda bir getId() metodu olduğunu varsayıyoruz
  }

  public String toString()
  {
    return super.toString() + "["+
            "amount" + ":" + getAmount()+ "," +
            "currency" + ":" + getCurrency()+ "," +
            "description" + ":" + getDescription()+ "," +
            "type" + ":" + getType()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "budgetManager = "+(getBudgetManager()!=null?Integer.toHexString(System.identityHashCode(getBudgetManager())):"null");
  }
}