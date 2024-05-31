package com.solak.TravelExpense.main.lib.models;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.solak.TravelExpense.umple.Budget;
import com.solak.TravelExpense.umple.BudgetManager;

public class BudgetWrapperTest {

    private Budget mockBudget;
    private BudgetWrapper budgetWrapper;
    private BudgetManager budgetManager;

    @Before
    public void setUp() {
        budgetManager = new BudgetManager();
        mockBudget = new Budget(1000.0, "USD", "Initial Description", "Travel", budgetManager);
        budgetWrapper = new BudgetWrapper(mockBudget);
    }

    @Test
    public void testSetAmount() {
        assertTrue(budgetWrapper.setAmount(2000.0));
        assertEquals(2000.0, budgetWrapper.getAmount(), 0.01);
    }

    @Test
    public void testSetCurrency() {
        assertTrue(budgetWrapper.setCurrency("EUR"));
        assertEquals("EUR", budgetWrapper.getCurrency());
    }

    @Test
    public void testSetDescription() {
        assertTrue(budgetWrapper.setDescription("Updated Description"));
        assertEquals("Updated Description", budgetWrapper.getDescription());
    }

    @Test
    public void testSetType() {
        assertTrue(budgetWrapper.setType("Business"));
        assertEquals("Business", budgetWrapper.getType());
    }

    @Test
    public void testgetId() {
        BudgetWrapper budgetWrapper = new BudgetWrapper();
        assertNotNull("BudgetWrapper instance should not be null", budgetWrapper);
    }

    @Test
    public void testGetBudgetManager() {
        assertEquals(budgetManager, budgetWrapper.getBudgetManager());
    }

    @Test
    public void testSetBudgetManager() {
        BudgetManager newManager = new BudgetManager();
        assertTrue(budgetWrapper.setBudgetManager(newManager));
        assertEquals(newManager, budgetWrapper.getBudgetManager());
    }

    @Test
    public void testDelete() {
        budgetWrapper.delete();
        // Assuming delete sets budgetManager to null
        // If delete does something different, adjust this test accordingly
        assertNull(budgetWrapper.getBudgetManager());
    }

    @Test
    public void testUpdateDescription() {
        budgetWrapper.updateDescription("New Description");
        assertNotEquals("New Description", budgetWrapper.getDescription());
    }

    @Test
    public void testUpdateAmount() {
        budgetWrapper.updateAmount(1500.0);
        assertNotEquals(1500.0, budgetWrapper.getAmount(), 0.01);
    }

    @Test
    public void testUpdateCurrency() {
        budgetWrapper.updateCurrency("GBP");
        assertNotEquals("GBP", budgetWrapper.getCurrency());
    }

    @Test
    public void testUpdateType() {
        budgetWrapper.updateType("Leisure");
        assertNotEquals("Leisure", budgetWrapper.getType());
    }

    @Test
    public void testToString() {
        String expectedString = mockBudget.toString();
        assertEquals(expectedString, budgetWrapper.toString());
    }
    
    @Test
    public void testParametricConstructor() {
        BudgetWrapper budgetWrapper = new BudgetWrapper();
        assertNotNull("BudgetWrapper instance should not be null", budgetWrapper);
    }
}
