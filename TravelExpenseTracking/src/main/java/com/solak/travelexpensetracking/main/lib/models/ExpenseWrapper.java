package com.solak.travelexpensetracking.main.lib.models;

import java.sql.Date;
import java.util.UUID;

import com.solak.travelexpensetracking.umple.Expense;
import com.solak.travelexpensetracking.umple.ExpenseManager;

public class ExpenseWrapper {
	private Expense expense;

	public ExpenseWrapper() {

	}

	public ExpenseWrapper(Expense expense) {
		this.expense = expense;
	}

	public boolean setExpenseId(UUID expenseId) {
		return expense.setExpenseId(expenseId);
	}

	public boolean setDate(Date date) {
		return expense.setDate(date);
	}

	public boolean setAmount(double amount) {
		return expense.setAmount(amount);
	}

	public boolean setCurrency(String currency) {
		return expense.setCurrency(currency);
	}

	public boolean setCategory(String category) {
		return expense.setCategory(category);
	}

	public boolean setPaymentMethod(String paymentMethod) {
		return expense.setPaymentMethod(paymentMethod);
	}

	public UUID getExpenseId() {
		return expense.getExpenseId();
	}

	public Date getDate() {
		return expense.getDate();
	}

	public double getAmount() {
		return expense.getAmount();
	}

	public String getCurrency() {
		return expense.getCurrency();
	}

	public String getCategory() {
		return expense.getCategory();
	}

	public String getPaymentMethod() {
		return expense.getPaymentMethod();
	}

	public ExpenseManager getExpenseManager() {
		return expense.getExpenseManager();
	}

	public boolean setExpenseManager(ExpenseManager expenseManager) {
		return expense.setExpenseManager(expenseManager);
	}

	public void delete() {
		expense.delete();
	}

	public void updateDate(Date date) {
		expense.updateDate(date);
	}

	public void updateAmount(double amount) {
		expense.updateAmount(amount);
	}

	public void updateCurrency(String currency) {
		expense.updateCurrency(currency);
	}

	public void updateCategory(String category) {
		expense.updateCategory(category);
	}

	public void updatePaymentMethod(String paymentMethod) {
		expense.updatePaymentMethod(paymentMethod);
	}

	@Override
	public String toString() {
		return expense.toString();
	}
}

