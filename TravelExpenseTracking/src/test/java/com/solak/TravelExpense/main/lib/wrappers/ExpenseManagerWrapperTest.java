package com.solak.TravelExpense.main.lib.wrappers;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.solak.TravelExpense.umple.Expense;
import com.solak.TravelExpense.umple.ExpenseManager;

public class ExpenseManagerWrapperTest {

	private ExpenseManagerWrapper wrapper;
    private ExpenseManager manager;
    private Expense expense1;
    private Expense expense2;
    
    @Before
    public void setUp() {
        manager = new ExpenseManager();
        wrapper = new ExpenseManagerWrapper(manager);

        // Initialize some sample expenses
        expense1 = new Expense(UUID.randomUUID(), Date.valueOf("2023-01-01"), 100.0, "USD", "Travel", "Credit Card", manager);
        expense2 = new Expense(UUID.randomUUID(), Date.valueOf("2023-01-02"), 200.0, "USD", "Food", "Cash", manager);
    }

    @Test
    public void testAddExpense() {
        wrapper.addExpense("user1", expense1);
        List<Expense> expenses = wrapper.viewExpenses("user1");
    }

    @Test
    public void testViewExpenses() {
        wrapper.addExpense("user1", expense1);
        wrapper.addExpense("user1", expense2);
        List<Expense> expenses = wrapper.viewExpenses("user1");
    }

    @Test
    public void testDeleteExpense() {
        wrapper.addExpense("user1", expense1);
        wrapper.deleteExpense(expense1.getExpenseId());
        List<Expense> expenses = wrapper.viewExpenses("user1");
 }

    @Test
    public void testGetExpense() {
        manager.addExpense(expense1);
        Expense retrievedExpense = wrapper.getExpense(0);
        assertEquals(expense1, retrievedExpense);
    }

    @Test
    public void testGetExpenses() {
        manager.addExpense(expense1);
        manager.addExpense(expense2);
        List<Expense> expenses = wrapper.getExpenses();
        assertEquals(2, expenses.size());
        assertTrue(expenses.contains(expense1));
        assertTrue(expenses.contains(expense2));
    }

    @Test
    public void testNumberOfExpenses() {
        manager.addExpense(expense1);
        manager.addExpense(expense2);
        int count = wrapper.numberOfExpenses();
        assertEquals(2, count);
    }

    @Test
    public void testHasExpenses() {
        assertTrue(wrapper.hasExpenses());
        manager.addExpense(expense1);
        assertTrue(wrapper.hasExpenses());
    }

    @Test
    public void testIndexOfExpense() {
        manager.addExpense(expense1);
        int index = wrapper.indexOfExpense(expense1);
        assertEquals(0, index);
    }

    @Test
    public void testAddExpenseWithDetails() {
        UUID id = UUID.randomUUID();
        Date date = Date.valueOf("2023-01-01");
        double amount = 100.0;
        String currency = "USD";
        String category = "Travel";
        String paymentMethod = "Credit Card";

        Expense newExpense = wrapper.addExpense(id, date, amount, currency, category, paymentMethod);
        assertNotNull(newExpense);
        assertEquals(id, newExpense.getExpenseId());
        assertEquals(date, newExpense.getDate());
        assertEquals(amount, newExpense.getAmount(), 0.001);
        assertEquals(currency, newExpense.getCurrency());
        assertEquals(category, newExpense.getCategory());
        assertEquals(paymentMethod, newExpense.getPaymentMethod());
    }

    @Test
    public void testAddExpenseObject() {
        assertFalse(wrapper.addExpense(expense1));
        assertTrue(wrapper.getExpenses().contains(expense1));
    }

    @Test
    public void testRemoveExpense() {
        manager.addExpense(expense1);
        assertFalse(wrapper.removeExpense(expense1));
        assertTrue(wrapper.getExpenses().contains(expense1));
    }

    @Test
    public void testAddExpenseAt() {
        wrapper.addExpenseAt(expense1, 0);
        assertEquals(expense1, wrapper.getExpense(0));
    }

    @Test
    public void testAddOrMoveExpenseAt() {
        wrapper.addExpenseAt(expense1, 0);
        wrapper.addOrMoveExpenseAt(expense2, 0);
        assertEquals(expense2, wrapper.getExpense(0));
        assertEquals(expense1, wrapper.getExpense(1));
    }

    @Test
    public void testDelete() {
        manager.addExpense(expense1);
        manager.addExpense(expense2);
        wrapper.delete();
        assertTrue(wrapper.getExpenses().isEmpty());
    }
   


}
