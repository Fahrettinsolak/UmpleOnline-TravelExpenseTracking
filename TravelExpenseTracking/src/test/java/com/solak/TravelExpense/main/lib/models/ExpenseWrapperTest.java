package com.solak.TravelExpense.main.lib.models;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.solak.TravelExpense.umple.Expense;
import com.solak.TravelExpense.umple.ExpenseManager;

public class ExpenseWrapperTest {

    private Expense mockExpense;
    private ExpenseWrapper expenseWrapper;
    private ExpenseManager expenseManager;
    private UUID expenseId;
    private Date date;

    @Before
    public void setUp() {
        expenseManager = new ExpenseManager();
        expenseId = UUID.randomUUID();
        date = new Date(System.currentTimeMillis());
        mockExpense = new Expense(expenseId, date, 100.0, "USD", "Transport", "Credit Card", expenseManager);
        expenseWrapper = new ExpenseWrapper(mockExpense);
    }

    @Test
    public void testSetExpenseId() {
        UUID newExpenseId = UUID.randomUUID();
        assertTrue(expenseWrapper.setExpenseId(newExpenseId));
        assertEquals(newExpenseId, expenseWrapper.getExpenseId());
    }

    @Test
    public void testSetDate() {
        Date newDate = new Date(System.currentTimeMillis() + 86400000); // +1 day
        assertTrue(expenseWrapper.setDate(newDate));
        assertEquals(newDate, expenseWrapper.getDate());
    }

    @Test
    public void testSetAmount() {
        assertTrue(expenseWrapper.setAmount(200.0));
        assertEquals(200.0, expenseWrapper.getAmount(), 0.01);
    }

    @Test
    public void testSetCurrency() {
        assertTrue(expenseWrapper.setCurrency("EUR"));
        assertEquals("EUR", expenseWrapper.getCurrency());
    }

    @Test
    public void testSetCategory() {
        assertTrue(expenseWrapper.setCategory("Food"));
        assertEquals("Food", expenseWrapper.getCategory());
    }

    @Test
    public void testSetPaymentMethod() {
        assertTrue(expenseWrapper.setPaymentMethod("Cash"));
        assertEquals("Cash", expenseWrapper.getPaymentMethod());
    }

    @Test
    public void testGetExpenseId() {
        assertEquals(mockExpense.getExpenseId(), expenseWrapper.getExpenseId());
    }

    @Test
    public void testGetDate() {
        assertEquals(mockExpense.getDate(), expenseWrapper.getDate());
    }

    @Test
    public void testGetAmount() {
        assertEquals(mockExpense.getAmount(), expenseWrapper.getAmount(), 0.01);
    }

    @Test
    public void testGetCurrency() {
        assertEquals(mockExpense.getCurrency(), expenseWrapper.getCurrency());
    }

    @Test
    public void testGetCategory() {
        assertEquals(mockExpense.getCategory(), expenseWrapper.getCategory());
    }

    @Test
    public void testGetPaymentMethod() {
        assertEquals(mockExpense.getPaymentMethod(), expenseWrapper.getPaymentMethod());
    }

    @Test
    public void testGetExpenseManager() {
        assertEquals(expenseManager, expenseWrapper.getExpenseManager());
    }

    @Test
    public void testSetExpenseManager() {
        ExpenseManager newManager = new ExpenseManager();
        assertTrue(expenseWrapper.setExpenseManager(newManager));
        assertEquals(newManager, expenseWrapper.getExpenseManager());
    }

    @Test
    public void testDelete() {
        expenseWrapper.delete();
        // Assuming delete sets some fields to null or performs cleanup
        // Adjust assertions based on actual behavior
    }

    @Test
    public void testUpdateDate() {
        Date newDate = new Date(System.currentTimeMillis() + 86400000); // +1 day
        expenseWrapper.updateDate(newDate);
        assertNotEquals(newDate, expenseWrapper.getDate());
    }

    @Test
    public void testUpdateAmount() {
        expenseWrapper.updateAmount(150.0);
        assertNotEquals(150.0, expenseWrapper.getAmount(), 0.01);
    }

    @Test
    public void testUpdateCurrency() {
        expenseWrapper.updateCurrency("GBP");
        assertNotEquals("GBP", expenseWrapper.getCurrency());
    }

    @Test
    public void testUpdateCategory() {
        expenseWrapper.updateCategory("Leisure");
        assertNotEquals("Leisure", expenseWrapper.getCategory());
    }

    @Test
    public void testUpdatePaymentMethod() {
        expenseWrapper.updatePaymentMethod("Debit Card");
        assertNotEquals("Debit Card", expenseWrapper.getPaymentMethod());
    }

    @Test
    public void testToString() {
        String expectedString = mockExpense.toString();
        assertEquals(expectedString, expenseWrapper.toString());
    }
    
    @Test
    public void testDefaultConstructor() {
        ExpenseWrapper expenseWrapper = new ExpenseWrapper();
        
        assertNotNull(expenseWrapper);
    }
}
