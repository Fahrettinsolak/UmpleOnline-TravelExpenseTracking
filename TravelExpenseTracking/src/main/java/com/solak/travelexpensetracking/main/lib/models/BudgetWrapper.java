package com.solak.travelexpensetracking.main.lib.models;

import com.solak.travelexpensetracking.umple.Budget;
import com.solak.travelexpensetracking.umple.BudgetManager;

public class BudgetWrapper {
    private Budget budget;
    
	public BudgetWrapper() {
	}
	

    public BudgetWrapper(Budget budget) {
        this.budget = budget;
    }

    public boolean setAmount(double amount) {
        return budget.setAmount(amount);
    }

    public boolean setCurrency(String currency) {
        return budget.setCurrency(currency);
    }
    public int getId() {
        return budget.getId();  
    }

    public boolean setDescription(String description) {
        return budget.setDescription(description);
    }
    
    public boolean setType(String type) {
        return budget.setType(type);
    }

    public double getAmount() {
        return budget.getAmount();
    }

    public String getCurrency() {
        return budget.getCurrency();
    }

    public String getDescription() {
        return budget.getDescription();
    }

    public String getType() {
        return budget.getType();
    }

    public BudgetManager getBudgetManager() {
        return budget.getBudgetManager();
    }

    public boolean setBudgetManager(BudgetManager budgetManager) {
        return budget.setBudgetManager(budgetManager);
    }

    public void delete() {
        budget.delete();
    }

    public void updateDescription(String description) {
        budget.updateDescription(description);
    }

    public void updateAmount(double amount) {
        budget.updateAmount(amount);
    }

    public void updateCurrency(String currency) {
        budget.updateCurrency(currency);
    }

    public void updateType(String type) {
        budget.updateType(type);
    }

    @Override
    public String toString() {
        return budget.toString();
    }
}
