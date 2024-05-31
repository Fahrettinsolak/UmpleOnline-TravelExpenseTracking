package com.solak.TravelExpense.umple;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 16 "model.ump"
// line 116 "model.ump"
public class BudgetManager
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BudgetManager Associations
  private List<Budget> budgets;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BudgetManager()
  {
    budgets = new ArrayList<Budget>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Budget getBudget(int index)
  {
    Budget aBudget = budgets.get(index);
    return aBudget;
  }

  public List<Budget> getBudgets()
  {
    List<Budget> newBudgets = Collections.unmodifiableList(budgets);
    return newBudgets;
  }

  public int numberOfBudgets()
  {
    int number = budgets.size();
    return number;
  }

  public boolean hasBudgets()
  {
    boolean has = budgets.size() > 0;
    return has;
  }

  public int indexOfBudget(Budget aBudget)
  {
    int index = budgets.indexOf(aBudget);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBudgets()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Budget addBudget(double aAmount, String aCurrency, String aDescription, String aType)
  {
    return new Budget(aAmount, aCurrency, aDescription, aType, this);
  }

  public boolean addBudget(Budget aBudget)
  {
    boolean wasAdded = false;
    if (budgets.contains(aBudget)) { return false; }
    BudgetManager existingBudgetManager = aBudget.getBudgetManager();
    boolean isNewBudgetManager = existingBudgetManager != null && !this.equals(existingBudgetManager);
    if (isNewBudgetManager)
    {
      aBudget.setBudgetManager(this);
    }
    else
    {
      budgets.add(aBudget);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBudget(Budget aBudget)
  {
    boolean wasRemoved = false;
    //Unable to remove aBudget, as it must always have a budgetManager
    if (!this.equals(aBudget.getBudgetManager()))
    {
      budgets.remove(aBudget);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBudgetAt(Budget aBudget, int index)
  {  
    boolean wasAdded = false;
    if(addBudget(aBudget))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBudgets()) { index = numberOfBudgets() - 1; }
      budgets.remove(aBudget);
      budgets.add(index, aBudget);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBudgetAt(Budget aBudget, int index)
  {
    boolean wasAdded = false;
    if(budgets.contains(aBudget))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBudgets()) { index = numberOfBudgets() - 1; }
      budgets.remove(aBudget);
      budgets.add(index, aBudget);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBudgetAt(aBudget, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=budgets.size(); i > 0; i--)
    {
      Budget aBudget = budgets.get(i - 1);
      aBudget.delete();
    }
  }

  // line 19 "model.ump"
  public void setBudget(String username, Budget budget){
    
  }

  // line 20 "model.ump"
  public Budget viewBudget(String username){
	return null;
    
  }

  // line 21 "model.ump"
  public void deleteBudget(String username){
    
  }

}