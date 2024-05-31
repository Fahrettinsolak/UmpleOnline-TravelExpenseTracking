package com.solak.travelexpensetracking.main.app;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @class ExpenseManagementScreen
 * @brief This class represents the Expense Management screen of the application.
 * It allows the user to add, update, and delete expense entries in a table.
 */
public class ExpenseManagementScreen extends JFrame {
    private JTable expenseTable;
    private DefaultTableModel tableModel;
    private List<ExpenseWrapper> expenses;

    /**
     * @brief Constructor for the ExpenseManagementScreen class.
     * It initializes the user interface components and loads expenses.
     */
    public ExpenseManagementScreen() {
        expenses = new ArrayList<>();

        setTitle("Expense Management");
        setSize(710, 610);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblExpenseManagement = new JLabel("Expense Management", SwingConstants.CENTER);
        lblExpenseManagement.setForeground(Color.WHITE);
        lblExpenseManagement.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
        lblExpenseManagement.setBounds(10, 10, 664, 52);
        getContentPane().add(lblExpenseManagement);

        JSeparator separator = new JSeparator();
        separator.setBounds(84, 73, 531, 15);
        getContentPane().add(separator);

        JPanel panel = new JPanel();
        panel.setBounds(10, 99, 674, 396);
        getContentPane().add(panel);

        tableModel = new DefaultTableModel(new Object[]{"Expense Id", "Date", "Amount", "Currency", "Category", "Payment Method"}, 0);
        panel.setLayout(null);
        expenseTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(expenseTable);
        scrollPane.setBounds(10, 55, 654, 334);
        panel.add(scrollPane);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(10, 11, 654, 33);
        panel.add(buttonPanel);

        JButton addButton = new JButton("Add Expense");
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
        addButton.setBackground(new Color(0, 128, 192));
        addButton.setBounds(10, 5, 200, 23);

        JButton updateButton = new JButton("Update Expense");
        updateButton.setForeground(new Color(255, 255, 255));
        updateButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
        updateButton.setBackground(new Color(0, 128, 192));
        updateButton.setBounds(226, 5, 211, 23);

        JButton deleteButton = new JButton("Delete Expense");
        deleteButton.setForeground(new Color(255, 255, 255));
        deleteButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
        deleteButton.setBackground(new Color(0, 128, 192));
        deleteButton.setBounds(447, 5, 200, 23);

        buttonPanel.setLayout(null);
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        JButton backButton = new JButton("Back To Menu");
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
        backButton.setBackground(new Color(255, 0, 0));
        backButton.setBounds(10, 521, 135, 23);
        getContentPane().add(backButton);

        ImageIcon icon2 = new ImageIcon(RegisterScreen.class.getResource("login.jpg"));
        JLabel label_loginbackground = new JLabel("");
        label_loginbackground.setBounds(0, 0, 688, 569);
        Image image2 = icon2.getImage().getScaledInstance(label_loginbackground.getWidth(),
                label_loginbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iccon = new ImageIcon(image2);
        label_loginbackground.setIcon(iccon);
        getContentPane().add(label_loginbackground);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainApp().setVisible(true);
                dispose();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExpense();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateExpense();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteExpense();
            }
        });

        loadExpenses();
    }

    /**
     * @brief Loads expenses into the table.
     * It clears existing data and adds expenses from the list.
     */
    public void loadExpenses() {
        tableModel.setRowCount(0); // Clear existing data
        for (ExpenseWrapper expense : expenses) {
            tableModel.addRow(new Object[]{
                    expense.getExpenseId(),
                    expense.getDate(),
                    expense.getAmount(),
                    expense.getCurrency(),
                    expense.getCategory(),
                    expense.getPaymentMethod()
            });
        }
    }

    /**
     * @brief Adds a new expense entry.
     * It prompts the user to enter expense details and adds the entry to the list.
     */
    public void addExpense() {
        ExpenseWrapper expense = getExpenseDetailsFromUser(null);
        if (expense != null) {
            expenses.add(expense);
            loadExpenses();
        }
    }

    /**
     * @brief Updates the selected expense entry.
     * It prompts the user to enter updated details and updates the entry in the list.
     */
    public void updateExpense() {
        int selectedRow = expenseTable.getSelectedRow();
        if (selectedRow != -1) {
            UUID expenseId = (UUID) tableModel.getValueAt(selectedRow, 0);
            ExpenseWrapper expense = findExpenseById(expenseId);
            if (expense != null) {
                ExpenseWrapper updatedExpense = getExpenseDetailsFromUser(expense);
                if (updatedExpense != null) {
                    expenses.remove(expense);
                    expenses.add(updatedExpense);
                    loadExpenses();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an expense to update.");
        }
    }

    /**
     * @brief Deletes the selected expense entry.
     * It removes the selected entry from the list.
     */
    public void deleteExpense() {
        int selectedRow = expenseTable.getSelectedRow();
        if (selectedRow != -1) {
            UUID expenseId = (UUID) tableModel.getValueAt(selectedRow, 0);
            ExpenseWrapper expense = findExpenseById(expenseId);
            if (expense != null) {
                expenses.remove(expense);
                loadExpenses();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an expense to delete.");
        }
    }

    /**
     * @brief Prompts the user to enter expense details.
     * It creates a dialog with fields for expense details.
     * @param expense The expense to update, or null to create a new expense.
     * @return The entered expense details.
     */
    public ExpenseWrapper getExpenseDetailsFromUser(ExpenseWrapper expense) {
        JTextField dateField = new JTextField(expense == null ? "" : expense.getDate().toString());
        JTextField amountField = new JTextField(expense == null ? "" : String.valueOf(expense.getAmount()));
        JTextField currencyField = new JTextField(expense == null ? "" : expense.getCurrency());
        JTextField categoryField = new JTextField(expense == null ? "" : expense.getCategory());
        JTextField paymentMethodField = new JTextField(expense == null ? "" : expense.getPaymentMethod());

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Date:"));
        panel.add(dateField);
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(new JLabel("Currency:"));
        panel.add(currencyField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Payment Method:"));
        panel.add(paymentMethodField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Expense Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            ExpenseWrapper newExpense = new ExpenseWrapper();
            if (expense == null) {
                newExpense.setExpenseId(UUID.randomUUID());
            } else {
                newExpense.setExpenseId(expense.getExpenseId());
            }
            newExpense.setDate(java.sql.Date.valueOf(dateField.getText()));
            newExpense.setAmount(Double.parseDouble(amountField.getText()));
            newExpense.setCurrency(currencyField.getText());
            newExpense.setCategory(categoryField.getText());
            newExpense.setPaymentMethod(paymentMethodField.getText());
            return newExpense;
        } else {
            return null;
        }
    }

    /**
     * @brief Finds an expense by its ID.
     * @param expenseId The ID of the expense to find.
     * @return The expense with the given ID, or null if not found.
     */
    public ExpenseWrapper findExpenseById(UUID expenseId) {
        for (ExpenseWrapper expense : expenses) {
            if (expense.getExpenseId().equals(expenseId)) {
                return expense;
            }
        }
        return null;
    }

    /**
     * @brief Gets the table model.
     * @return The table model.
     */
    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    /**
     * @brief Gets the expense table.
     * @return The expense table.
     */
    public JTable getExpenseTable() {
        return expenseTable;
    }

    /**
     * @brief Gets the list of expenses.
     * @return The list of expenses.
     */
    public List<ExpenseWrapper> getExpenses() {
        return expenses;
    }
}

/**
 * @class ExpenseWrapper
 * @brief This class wraps the expense details.
 */
class ExpenseWrapper {
    private UUID expenseId;
    private java.sql.Date date;
    private double amount;
    private String currency;
    private String category;
    private String paymentMethod;

    /**
     * @brief Gets the expense ID.
     * @return The expense ID.
     */
    public UUID getExpenseId() {
        return expenseId;
    }

    /**
     * @brief Sets the expense ID.
     * @param expenseId The expense ID.
     */
    public void setExpenseId(UUID expenseId) {
        this.expenseId = expenseId;
    }

    /**
     * @brief Gets the date of the expense.
     * @return The date of the expense.
     */
    public java.sql.Date getDate() {
        return date;
    }

    /**
     * @brief Sets the date of the expense.
     * @param date The date of the expense.
     */
    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    /**
     * @brief Gets the amount of the expense.
     * @return The amount of the expense.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @brief Sets the amount of the expense.
     * @param amount The amount of the expense.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @brief Gets the currency of the expense.
     * @return The currency of the expense.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @brief Sets the currency of the expense.
     * @param currency The currency of the expense.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @brief Gets the category of the expense.
     * @return The category of the expense.
     */
    public String getCategory() {
        return category;
    }

    /**
     * @brief Sets the category of the expense.
     * @param category The category of the expense.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @brief Gets the payment method of the expense.
     * @return The payment method of the expense.
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @brief Sets the payment method of the expense.
     * @param paymentMethod The payment method of the expense.
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

