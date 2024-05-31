package com.solak.TravelExpense.main.lib.wrappers;



import java.util.List;
import java.util.UUID;

import com.solak.TravelExpense.umple.Expense;
import com.solak.TravelExpense.umple.ExpenseManager;

import java.sql.Date;

public class ExpenseManagerWrapper {
    private ExpenseManager expenseManager;

    public ExpenseManagerWrapper(ExpenseManager expenseManager) {
        this.expenseManager = expenseManager;
    }

    public void addExpense(String username, Expense expense) {
        expenseManager.addExpense(username, expense);
    }

    public List<Expense> viewExpenses(String username) {
        return expenseManager.viewExpenses(username);
    }

    public void deleteExpense(UUID expenseId) {
        expenseManager.deleteExpense(expenseId);
    }

    public Expense getExpense(int index) {
        return expenseManager.getExpense(index);
    }

    public List<Expense> getExpenses() {
        return expenseManager.getExpenses();
    }

    public int numberOfExpenses() {
        return expenseManager.numberOfExpenses();
    }

    public boolean hasExpenses() {
        return expenseManager.hasExpenses();
    }

    public int indexOfExpense(Expense aExpense) {
        return expenseManager.indexOfExpense(aExpense);
    }

    public Expense addExpense(UUID aExpenseId, Date aDate, double aAmount, String aCurrency, String aCategory, String aPaymentMethod) {
        return expenseManager.addExpense(aExpenseId, aDate, aAmount, aCurrency, aCategory, aPaymentMethod);
    }

    public boolean addExpense(Expense aExpense) {
        return expenseManager.addExpense(aExpense);
    }

    public boolean removeExpense(Expense aExpense) {
        return expenseManager.removeExpense(aExpense);
    }

    public boolean addExpenseAt(Expense aExpense, int index) {
        return expenseManager.addExpenseAt(aExpense, index);
    }

    public boolean addOrMoveExpenseAt(Expense aExpense, int index) {
        return expenseManager.addOrMoveExpenseAt(aExpense, index);
    }

    public void delete() {
        expenseManager.delete();
    }
}
