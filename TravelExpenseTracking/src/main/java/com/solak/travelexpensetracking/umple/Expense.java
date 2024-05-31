package com.solak.travelexpensetracking.umple;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;
import java.util.UUID;

// line 86 "model.ump"
// line 154 "model.ump"
public class Expense
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Expense Attributes
  private UUID expenseId;
  private Date date;
  private double amount;
  private String currency;
  private String category;
  private String paymentMethod;

  //Expense Associations
  private ExpenseManager expenseManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Expense(UUID aExpenseId, Date aDate, double aAmount, String aCurrency, String aCategory, String aPaymentMethod, ExpenseManager aExpenseManager)
  {
    expenseId = aExpenseId;
    date = aDate;
    amount = aAmount;
    currency = aCurrency;
    category = aCategory;
    paymentMethod = aPaymentMethod;
    boolean didAddExpenseManager = setExpenseManager(aExpenseManager);
    if (!didAddExpenseManager)
    {
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setExpenseId(UUID aExpenseId)
  {
    boolean wasSet = false;
    expenseId = aExpenseId;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

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

  public boolean setCategory(String aCategory)
  {
    boolean wasSet = false;
    category = aCategory;
    wasSet = true;
    return wasSet;
  }

  public boolean setPaymentMethod(String aPaymentMethod)
  {
    boolean wasSet = false;
    paymentMethod = aPaymentMethod;
    wasSet = true;
    return wasSet;
  }

  public UUID getExpenseId()
  {
    return expenseId;
  }

  public Date getDate()
  {
    return date;
  }

  public double getAmount()
  {
    return amount;
  }

  public String getCurrency()
  {
    return currency;
  }

  public String getCategory()
  {
    return category;
  }

  public String getPaymentMethod()
  {
    return paymentMethod;
  }
  /* Code from template association_GetOne */
  public ExpenseManager getExpenseManager()
  {
    return expenseManager;
  }
  /* Code from template association_SetOneToMany */
  public boolean setExpenseManager(ExpenseManager aExpenseManager)
  {
    boolean wasSet = false;
    if (aExpenseManager == null)
    {
      return wasSet;
    }

    ExpenseManager existingExpenseManager = expenseManager;
    expenseManager = aExpenseManager;
    if (existingExpenseManager != null && !existingExpenseManager.equals(aExpenseManager))
    {
      existingExpenseManager.removeExpense(this);
    }
    expenseManager.addExpense(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ExpenseManager placeholderExpenseManager = expenseManager;
    this.expenseManager = null;
    if(placeholderExpenseManager != null)
    {
      placeholderExpenseManager.removeExpense(this);
    }
  }

  // line 94 "model.ump"
  public void updateDate(Date date){
    
  }

  // line 95 "model.ump"
  public void updateAmount(double amount){
    
  }

  // line 96 "model.ump"
  public void updateCurrency(String currency){
    
  }

  // line 97 "model.ump"
  public void updateCategory(String category){
    
  }

  // line 98 "model.ump"
  public void updatePaymentMethod(String paymentMethod){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "amount" + ":" + getAmount()+ "," +
            "currency" + ":" + getCurrency()+ "," +
            "category" + ":" + getCategory()+ "," +
            "paymentMethod" + ":" + getPaymentMethod()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "expenseId" + "=" + (getExpenseId() != null ? !getExpenseId().equals(this)  ? getExpenseId().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "expenseManager = "+(getExpenseManager()!=null?Integer.toHexString(System.identityHashCode(getExpenseManager())):"null");
  }
}