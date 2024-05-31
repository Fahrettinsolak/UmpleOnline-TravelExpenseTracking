package com.solak.TravelExpense.main.lib.wrappers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.solak.TravelExpense.umple.Budget;
import com.solak.TravelExpense.umple.BudgetManager;

public class BudgetManagerWrapperTest {

	private BudgetManagerWrapper wrapper;
    private BudgetManager manager;
    private Budget budget1;
    private Budget budget2;

    @Before
    public void setUp() {
        manager = new BudgetManager();
        wrapper = new BudgetManagerWrapper(manager);

        // Initialize some sample budgets
        budget1 = new Budget(1000.0, "USD", "Travel budget", "Personal", manager);
        budget2 = new Budget(500.0, "USD", "Food budget", "Personal", manager);
    }

    @Test
    public void testSetBudget() {
        wrapper.setBudget("user1", budget1);
        Budget retrievedBudget = wrapper.viewBudget("user1");
        assertNotEquals(budget1, retrievedBudget);
    }

    @Test
    public void testViewBudget() {
        wrapper.setBudget("user1", budget1);
        Budget retrievedBudget = wrapper.viewBudget("user1");
        assertNotEquals(budget1, retrievedBudget);
    }

    @Test
    public void testDeleteBudget() {
        wrapper.setBudget("user1", budget1);
        wrapper.deleteBudget("user1");
        Budget retrievedBudget = wrapper.viewBudget("user1");
        assertNull(retrievedBudget);
    }

    @Test
    public void testGetBudget() {
        manager.addBudget(budget1);
        Budget retrievedBudget = wrapper.getBudget(0);
        assertEquals(budget1, retrievedBudget);
    }

    @Test
    public void testGetBudgets() {
        manager.addBudget(budget1);
        manager.addBudget(budget2);
        List<Budget> budgets = wrapper.getBudgets();
        assertEquals(2, budgets.size());
        assertTrue(budgets.contains(budget1));
        assertTrue(budgets.contains(budget2));
    }

    @Test
    public void testNumberOfBudgets() {
        manager.addBudget(budget1);
        manager.addBudget(budget2);
        int count = wrapper.numberOfBudgets();
        assertEquals(2, count);
    }

    @Test
    public void testHasBudgets() {
        assertTrue(wrapper.hasBudgets());
        manager.addBudget(budget1);
        assertTrue(wrapper.hasBudgets());
    }

    @Test
    public void testIndexOfBudget() {
        manager.addBudget(budget1);
        int index = wrapper.indexOfBudget(budget1);
        assertEquals(0, index);
    }

    @Test
    public void testAddBudgetWithDetails() {
        double amount = 1000.0;
        String currency = "USD";
        String description = "Travel budget";
        String type = "Personal";

        Budget newBudget = wrapper.addBudget(amount, currency, description, type);
        assertNotNull(newBudget);
        assertEquals(amount, newBudget.getAmount(), 0.001);
        assertEquals(currency, newBudget.getCurrency());
        assertEquals(description, newBudget.getDescription());
        assertEquals(type, newBudget.getType());
    }

    @Test
    public void testAddBudgetObject() {
        assertFalse(wrapper.addBudget(budget1));
        assertTrue(wrapper.getBudgets().contains(budget1));
    }

    @Test
    public void testRemoveBudget() {
        manager.addBudget(budget1);
        assertFalse(wrapper.removeBudget(budget1));
        assertTrue(wrapper.getBudgets().contains(budget1));
    }

    @Test
    public void testAddBudgetAt() {
        wrapper.addBudgetAt(budget1, 0);
        assertEquals(budget1, wrapper.getBudget(0));
    }

    @Test
    public void testAddOrMoveBudgetAt() {
        wrapper.addBudgetAt(budget1, 0);
        wrapper.addOrMoveBudgetAt(budget2, 0);
        assertEquals(budget2, wrapper.getBudget(0));
        assertEquals(budget1, wrapper.getBudget(1));
    }

    @Test
    public void testDelete() {
        manager.addBudget(budget1);
        manager.addBudget(budget2);
        wrapper.delete();
        assertTrue(wrapper.getBudgets().isEmpty());
    }
}
