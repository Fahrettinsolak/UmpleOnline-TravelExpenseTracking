package com.solak.TravelExpense.main.app;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BudgetManagementScreen extends JFrame {
    private JTable budgetTable;
    private DefaultTableModel tableModel;

    public BudgetManagementScreen() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Budget Management");
        setSize(710, 610);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        String[] columnNames = {"ID", "Amount", "Currency", "Description", "Type"};
        tableModel = new DefaultTableModel(columnNames, 0);
        budgetTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(budgetTable);
        scrollPane.setBounds(10, 155, 674, 348);
        getContentPane().add(scrollPane);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(10, 121, 674, 23);
        buttonPanel.setLayout(new GridLayout(1, 3));

        JButton addButton = new JButton("Add Budget");
        addButton.setBackground(new Color(0, 128, 192));
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
        JButton updateButton = new JButton("Update Budget");
        updateButton.setBackground(new Color(0, 128, 192));
        updateButton.setForeground(new Color(255, 255, 255));
        updateButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
        JButton deleteButton = new JButton("Delete Budget");
        deleteButton.setBackground(new Color(0, 128, 192));
        deleteButton.setForeground(new Color(255, 255, 255));
        deleteButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        getContentPane().add(buttonPanel);
        
                JButton backToMenuButton = new JButton("Back To Menu");
                backToMenuButton.setBackground(new Color(255, 0, 0));
                backToMenuButton.setForeground(new Color(255, 255, 255));
                backToMenuButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
                backToMenuButton.setBounds(10, 514, 134, 23);
                getContentPane().add(backToMenuButton);
                
                JLabel lblBudgetManagement = new JLabel("Budget Management", SwingConstants.CENTER);
                lblBudgetManagement.setForeground(Color.WHITE);
                lblBudgetManagement.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
                lblBudgetManagement.setBounds(10, 11, 664, 52);
                getContentPane().add(lblBudgetManagement);
                
                JSeparator separator = new JSeparator();
                separator.setBounds(84, 74, 531, 15);
                getContentPane().add(separator);
                
                ImageIcon icon2 = new ImageIcon(RegisterScreen.class.getResource("login.jpg"));
        		JLabel label_loginbackground = new JLabel("");
        		label_loginbackground.setBounds(0, 0, 688, 569);
        		Image image2 = icon2.getImage().getScaledInstance(label_loginbackground.getWidth(),
        		label_loginbackground.getHeight(), Image.SCALE_SMOOTH);
        		ImageIcon iccon = new ImageIcon(image2);
        		label_loginbackground.setIcon(iccon);
                getContentPane().add(label_loginbackground);
                
                        backToMenuButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Menüye dönme işlemi burada yapılabilir
                            	                openMainApp();
                            }
                        });

        // Button Action Listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBudget();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBudget();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBudget();
            }
        });
    }

    public void addBudget() {
        JTextField idField = new JTextField(5);
        JTextField amountField = new JTextField(5);
        JTextField currencyField = new JTextField(5);
        JTextField descriptionField = new JTextField(5);
        JTextField typeField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(0, 2));
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

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Budget Details", JOptionPane.OK_CANCEL_OPTION);
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
    }

    public void updateBudget() {
        int selectedRow = budgetTable.getSelectedRow();
        if (selectedRow >= 0) {
            JTextField idField = new JTextField(5);
            JTextField amountField = new JTextField(5);
            JTextField currencyField = new JTextField(5);
            JTextField descriptionField = new JTextField(5);
            JTextField typeField = new JTextField(5);

            idField.setText(tableModel.getValueAt(selectedRow, 0).toString());
            amountField.setText(tableModel.getValueAt(selectedRow, 1).toString());
            currencyField.setText(tableModel.getValueAt(selectedRow, 2).toString());
            descriptionField.setText(tableModel.getValueAt(selectedRow, 3).toString());
            typeField.setText(tableModel.getValueAt(selectedRow, 4).toString());

            JPanel myPanel = new JPanel();
            myPanel.setLayout(new GridLayout(0, 2));
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

            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Update Budget Details", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                tableModel.setValueAt(Integer.parseInt(idField.getText()), selectedRow, 0);
                tableModel.setValueAt(Double.parseDouble(amountField.getText()), selectedRow, 1);
                tableModel.setValueAt(currencyField.getText(), selectedRow, 2);
                tableModel.setValueAt(descriptionField.getText(), selectedRow, 3);
                tableModel.setValueAt(typeField.getText(), selectedRow, 4);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a budget to update.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void deleteBudget() {
        int selectedRow = budgetTable.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a budget to delete.",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void openMainApp() {
        // Code to open TripManagementScreen
        new MainApp().setVisible(true);
        this.dispose();
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JTable getBudgetTable() {
        return budgetTable;
    }


}
