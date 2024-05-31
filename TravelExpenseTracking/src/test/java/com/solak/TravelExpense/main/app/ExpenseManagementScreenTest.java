package com.solak.TravelExpense.main.app;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import javax.swing.table.DefaultTableModel;
import java.util.UUID;
import java.util.Date;

public class ExpenseManagementScreenTest {

    private ExpenseManagementScreen screen;
    private DefaultTableModel tableModel;

    @Before
    public void setUp() {
        screen = new ExpenseManagementScreen();
        tableModel = screen.getTableModel();
    }

    @Test
    public void testAddExpense() {
        // Simulate adding an expense entry
        ExpenseWrapper newExpense = new ExpenseWrapper();
        newExpense.setExpenseId(UUID.randomUUID());
        newExpense.setDate(new java.sql.Date(new Date().getTime()));
        newExpense.setAmount(100.0);
        newExpense.setCurrency("USD");
        newExpense.setCategory("Travel");
        newExpense.setPaymentMethod("Credit Card");

        screen.getExpenses().add(newExpense);
        screen.loadExpenses();

        // Validate that the row was added
        assertEquals(1, tableModel.getRowCount());
        assertEquals(newExpense.getExpenseId(), tableModel.getValueAt(0, 0));
        assertEquals(newExpense.getDate(), tableModel.getValueAt(0, 1));
        assertEquals(newExpense.getAmount(), tableModel.getValueAt(0, 2));
        assertEquals(newExpense.getCurrency(), tableModel.getValueAt(0, 3));
        assertEquals(newExpense.getCategory(), tableModel.getValueAt(0, 4));
        assertEquals(newExpense.getPaymentMethod(), tableModel.getValueAt(0, 5));
    }

    @Test
    public void testUpdateExpense() {
        // Simulate adding an initial expense entry
        ExpenseWrapper initialExpense = new ExpenseWrapper();
        initialExpense.setExpenseId(UUID.randomUUID());
        initialExpense.setDate(new java.sql.Date(new Date().getTime()));
        initialExpense.setAmount(100.0);
        initialExpense.setCurrency("USD");
        initialExpense.setCategory("Travel");
        initialExpense.setPaymentMethod("Credit Card");

        screen.getExpenses().add(initialExpense);
        screen.loadExpenses();
        screen.getExpenseTable().setRowSelectionInterval(0, 0);

        // Simulate user input for updating the selected expense entry
        ExpenseWrapper updatedExpense = new ExpenseWrapper();
        updatedExpense.setExpenseId(initialExpense.getExpenseId());
        updatedExpense.setDate(new java.sql.Date(new Date().getTime()));
        updatedExpense.setAmount(200.0);
        updatedExpense.setCurrency("EUR");
        updatedExpense.setCategory("Business");
        updatedExpense.setPaymentMethod("Debit Card");

        screen.getExpenses().remove(initialExpense);
        screen.getExpenses().add(updatedExpense);
        screen.loadExpenses();

        // Validate that the row was updated
        assertEquals(1, tableModel.getRowCount());
        assertEquals(updatedExpense.getExpenseId(), tableModel.getValueAt(0, 0));
        assertEquals(updatedExpense.getDate(), tableModel.getValueAt(0, 1));
        assertEquals(updatedExpense.getAmount(), tableModel.getValueAt(0, 2));
        assertEquals(updatedExpense.getCurrency(), tableModel.getValueAt(0, 3));
        assertEquals(updatedExpense.getCategory(), tableModel.getValueAt(0, 4));
        assertEquals(updatedExpense.getPaymentMethod(), tableModel.getValueAt(0, 5));
    }

    @Test
    public void testDeleteExpense() {
        // Simulate adding an initial expense entry
        ExpenseWrapper initialExpense = new ExpenseWrapper();
        initialExpense.setExpenseId(UUID.randomUUID());
        initialExpense.setDate(new java.sql.Date(new Date().getTime()));
        initialExpense.setAmount(100.0);
        initialExpense.setCurrency("USD");
        initialExpense.setCategory("Travel");
        initialExpense.setPaymentMethod("Credit Card");

        screen.getExpenses().add(initialExpense);
        screen.loadExpenses();
        screen.getExpenseTable().setRowSelectionInterval(0, 0);

        // Simulate deleting the selected expense entry
        screen.getExpenses().remove(initialExpense);
        screen.loadExpenses();

        // Validate that the row was deleted
        assertEquals(0, tableModel.getRowCount());
    }
}