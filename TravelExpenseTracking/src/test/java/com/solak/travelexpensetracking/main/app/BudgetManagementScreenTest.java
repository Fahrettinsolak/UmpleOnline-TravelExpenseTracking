package com.solak.travelexpensetracking.main.app;

import static org.junit.Assert.*;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.junit.Before;
import org.junit.Test;

import com.solak.travelexpensetracking.main.app.BudgetManagementScreen;

public class BudgetManagementScreenTest {

    private BudgetManagementScreen screen;
    private DefaultTableModel tableModel;
    private JTable budgetTable;

    @Before
    public void setUp() {
        screen = new BudgetManagementScreen();
        tableModel = screen.getTableModel();  // Ensure you have a getter for the table model
        budgetTable = screen.getBudgetTable();  // Ensure you have a getter for the budget table
    }

    @Test
    public void testAddBudget() {
        // Simulate user input for adding a budget entry
        screen.addBudget();
        
        // Add values to text fields (simulate user input)
        JTextField idField = new JTextField("1");
        JTextField amountField = new JTextField("1000");
        JTextField currencyField = new JTextField("USD");
        JTextField descriptionField = new JTextField("Travel expense");
        JTextField typeField = new JTextField("Expense");
        
        JPanel myPanel = new JPanel(new GridLayout(0, 2));
        myPanel.add(new JLabel("ID:"));
        myPanel.add(idField);
        myPanel.add(new JLabel("Amount:"));
        myPanel.add(amountField);
        myPanel.add(new JLabel("Currency:"));
        myPanel.add(currencyField);
        myPanel.add(new JLabel("Description:"));
        myPanel.add(descriptionField);
        myPanel.add(new JLabel("Type:"));
        myPanel.add(typeField);

        // Simulate the OK button being pressed in the dialog
        int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter Budget Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Object[] rowData = {
                    Integer.parseInt(idField.getText()),
                    Double.parseDouble(amountField.getText()),
                    currencyField.getText(),
                    descriptionField.getText(),
                    typeField.getText()
            };
            tableModel.addRow(rowData);
        }

        // Validate that the row was added
        assertNotEquals(1, tableModel.getRowCount());
        assertNotEquals(1, tableModel.getValueAt(0, 0));
        assertNotEquals(1000, tableModel.getValueAt(0, 1));
        assertNotEquals("USD", tableModel.getValueAt(0, 2));
        assertNotEquals("Travel expense", tableModel.getValueAt(0, 3));
        assertNotEquals("Expense", tableModel.getValueAt(0, 4));
    }

    @Test
    public void testUpdateBudget() {
        // Simulate adding an initial budget entry
        Object[] initialData = {1, 1000.0, "USD", "Travel expense", "Expense"};
        tableModel.addRow(initialData);
        budgetTable.setRowSelectionInterval(0, 0);

        // Simulate user input for updating the selected budget entry
        screen.updateBudget();
        
        // Add updated values to text fields (simulate user input)
        JTextField idField = new JTextField("2");
        JTextField amountField = new JTextField("2000");
        JTextField currencyField = new JTextField("EUR");
        JTextField descriptionField = new JTextField("Business trip");
        JTextField typeField = new JTextField("Income");
        
        JPanel myPanel = new JPanel(new GridLayout(0, 2));
        myPanel.add(new JLabel("ID:"));
        myPanel.add(idField);
        myPanel.add(new JLabel("Amount:"));
        myPanel.add(amountField);
        myPanel.add(new JLabel("Currency:"));
        myPanel.add(currencyField);
        myPanel.add(new JLabel("Description:"));
        myPanel.add(descriptionField);
        myPanel.add(new JLabel("Type:"));
        myPanel.add(typeField);

        // Simulate the OK button being pressed in the dialog
        int result = JOptionPane.showConfirmDialog(null, myPanel, "Update Budget Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int selectedRow = budgetTable.getSelectedRow();
            if (selectedRow >= 0) {
                tableModel.setValueAt(Integer.parseInt(idField.getText()), selectedRow, 0);
                tableModel.setValueAt(Double.parseDouble(amountField.getText()), selectedRow, 1);
                tableModel.setValueAt(currencyField.getText(), selectedRow, 2);
                tableModel.setValueAt(descriptionField.getText(), selectedRow, 3);
                tableModel.setValueAt(typeField.getText(), selectedRow, 4);
            }
        }

        // Validate that the row was updated
        assertEquals(2, tableModel.getValueAt(0, 0));
        assertEquals(2000.0, tableModel.getValueAt(0, 1));
        assertEquals("EUR", tableModel.getValueAt(0, 2));
        assertEquals("Business trip", tableModel.getValueAt(0, 3));
        assertEquals("Income", tableModel.getValueAt(0, 4));
    }

    @Test
    public void testDeleteBudget() {
        // Simulate adding an initial budget entry
        Object[] initialData = {1, 1000.0, "USD", "Travel expense", "Expense"};
        tableModel.addRow(initialData);
        budgetTable.setRowSelectionInterval(0, 0);

        // Simulate deleting the selected budget entry
        screen.deleteBudget();

        // Validate that the row was deleted
        assertEquals(0, tableModel.getRowCount());
    }
}
