package com.solak.travelexpensetracking.main.lib.wrappers;

import java.util.List;

import com.solak.travelexpensetracking.umple.Budget;
import com.solak.travelexpensetracking.umple.BudgetManager;

public class BudgetManagerWrapper {
    private BudgetManager budgetManager;

    public BudgetManagerWrapper(BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
    }

    public void setBudget(String username, Budget budget) {
        budgetManager.setBudget(username, budget);
    }

    public Budget viewBudget(String username) {
        return budgetManager.viewBudget(username);
    }

    public void deleteBudget(String username) {
        budgetManager.deleteBudget(username);
    }

    public Budget getBudget(int index) {
        return budgetManager.getBudget(index);
    }

    public List<Budget> getBudgets() {
        return budgetManager.getBudgets();
    }

    public int numberOfBudgets() {
        return budgetManager.numberOfBudgets();
    }

    public boolean hasBudgets() {
        return budgetManager.hasBudgets();
    }

    public int indexOfBudget(Budget aBudget) {
        return budgetManager.indexOfBudget(aBudget);
    }

    public Budget addBudget(double aAmount, String aCurrency, String aDescription, String aType) {
        return budgetManager.addBudget(aAmount, aCurrency, aDescription, aType);
    }

    public boolean addBudget(Budget aBudget) {
        return budgetManager.addBudget(aBudget);
    }

    public boolean removeBudget(Budget aBudget) {
        return budgetManager.removeBudget(aBudget);
    }

    public boolean addBudgetAt(Budget aBudget, int index) {
        return budgetManager.addBudgetAt(aBudget, index);
    }

    public boolean addOrMoveBudgetAt(Budget aBudget, int index) {
        return budgetManager.addOrMoveBudgetAt(aBudget, index);
    }

    public void delete() {
        budgetManager.delete();
    }
}
