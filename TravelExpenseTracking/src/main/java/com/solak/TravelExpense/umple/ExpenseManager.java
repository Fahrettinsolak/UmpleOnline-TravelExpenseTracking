package com.solak.TravelExpense.umple;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;
import java.sql.Date;

// line 40 "model.ump"
// line 133 "model.ump"
public class ExpenseManager
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ExpenseManager Associations
  private List<Expense> expenses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ExpenseManager()
  {
    expenses = new ArrayList<Expense>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Expense getExpense(int index)
  {
    Expense aExpense = expenses.get(index);
    return aExpense;
  }

  public List<Expense> getExpenses()
  {
    List<Expense> newExpenses = Collections.unmodifiableList(expenses);
    return newExpenses;
  }

  public int numberOfExpenses()
  {
    int number = expenses.size();
    return number;
  }

  public boolean hasExpenses()
  {
    boolean has = expenses.size() > 0;
    return has;
  }

  public int indexOfExpense(Expense aExpense)
  {
    int index = expenses.indexOf(aExpense);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfExpenses()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Expense addExpense(UUID aExpenseId, Date aDate, double aAmount, String aCurrency, String aCategory, String aPaymentMethod)
  {
    return new Expense(aExpenseId, aDate, aAmount, aCurrency, aCategory, aPaymentMethod, this);
  }

  public boolean addExpense(Expense aExpense)
  {
    boolean wasAdded = false;
    if (expenses.contains(aExpense)) { return false; }
    ExpenseManager existingExpenseManager = aExpense.getExpenseManager();
    boolean isNewExpenseManager = existingExpenseManager != null && !this.equals(existingExpenseManager);
    if (isNewExpenseManager)
    {
      aExpense.setExpenseManager(this);
    }
    else
    {
      expenses.add(aExpense);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeExpense(Expense aExpense)
  {
    boolean wasRemoved = false;
    //Unable to remove aExpense, as it must always have a expenseManager
    if (!this.equals(aExpense.getExpenseManager()))
    {
      expenses.remove(aExpense);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addExpenseAt(Expense aExpense, int index)
  {  
    boolean wasAdded = false;
    if(addExpense(aExpense))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExpenses()) { index = numberOfExpenses() - 1; }
      expenses.remove(aExpense);
      expenses.add(index, aExpense);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveExpenseAt(Expense aExpense, int index)
  {
    boolean wasAdded = false;
    if(expenses.contains(aExpense))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExpenses()) { index = numberOfExpenses() - 1; }
      expenses.remove(aExpense);
      expenses.add(index, aExpense);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addExpenseAt(aExpense, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=expenses.size(); i > 0; i--)
    {
      Expense aExpense = expenses.get(i - 1);
      aExpense.delete();
    }
  }

  // line 43 "model.ump"
  public void addExpense(String username, Expense expense){
    
  }

  // line 44 "model.ump"
  public List<Expense> viewExpenses(String username){
	return null;
    
  }

  // line 45 "model.ump"
  public void deleteExpense(UUID expenseId){
    
  }

}