package com.solak.TravelExpense.main.app;

import com.solak.TravelExpense.main.lib.models.ReportWrapper;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ReportScreen extends JFrame {
    private List<ReportWrapper> reportList;
    private JTable reportTable;
    private DefaultTableModel tableModel;

    public ReportScreen() {
        reportList = new ArrayList<>();
        setTitle("Report Management");
        setSize(710, 610);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        // Table
        tableModel = new DefaultTableModel(new Object[]{"Report ID", "Content", "Creation Date"}, 0);
        reportTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(reportTable);
        scrollPane.setBounds(10, 155, 674, 357);
        panel.add(scrollPane);

        // Control panel
        JPanel controlPanel = new JPanel();
        controlPanel.setBounds(10, 105, 674, 39);
        controlPanel.setBackground(new Color(255, 255, 255));
        panel.add(controlPanel);

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

        controlPanel.add(addButton);
        controlPanel.add(updateButton);
        controlPanel.add(deleteButton);
        
                JButton backButton = new JButton("Back To Menu");
                backButton.setBackground(new Color(255, 0, 0));
                backButton.setForeground(new Color(255, 255, 255));
                backButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
                backButton.setBounds(10, 523, 123, 23);
                panel.add(backButton);
                
                JLabel lblExpenseManagement = new JLabel("Report", SwingConstants.CENTER);
                lblExpenseManagement.setForeground(Color.WHITE);
                lblExpenseManagement.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
                lblExpenseManagement.setBounds(10, 11, 664, 52);
                panel.add(lblExpenseManagement);
                
                JSeparator separator = new JSeparator();
                separator.setBounds(84, 74, 531, 15);
                panel.add(separator);
                
                
                ImageIcon icon2 = new ImageIcon(RegisterScreen.class.getResource("login.jpg"));
        		JLabel label_loginbackground = new JLabel("");
        		label_loginbackground.setBounds(0, 0, 688, 569);
        		Image image2 = icon2.getImage().getScaledInstance(label_loginbackground.getWidth(),
        		label_loginbackground.getHeight(), Image.SCALE_SMOOTH);
        		ImageIcon iccon = new ImageIcon(image2);
        		label_loginbackground.setIcon(iccon);
        		panel.add(label_loginbackground);
                
                        backButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                            	openMainApp();
                            }
                        });

        // Action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addReport();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateReport();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteReport();
            }
        });

        loadReports();
    }

    public void loadReports() {
        tableModel.setRowCount(0);
        for (ReportWrapper report : reportList) {
            tableModel.addRow(new Object[]{
                    report.getReportId(),
                    report.getContent(),
                    report.getCreationDate()
            });
        }
    }

    private void addReport() {
        ReportDialog dialog = new ReportDialog(this, "Add Report", null);
        dialog.setVisible(true);
        if (dialog.isSucceeded()) {
            reportList.add(dialog.getReport());
            loadReports();
        }
    }

    private void updateReport() {
        int selectedRow = reportTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a report to update.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        UUID reportId = (UUID) tableModel.getValueAt(selectedRow, 0);
        String content = (String) tableModel.getValueAt(selectedRow, 1);
        Date creationDate = (Date) tableModel.getValueAt(selectedRow, 2);

        ReportWrapper report = new ReportWrapper();
        report.setReportId(reportId);
        report.setContent(content);
        report.setCreationDate(new java.sql.Date(creationDate.getTime()));

        ReportDialog dialog = new ReportDialog(this, "Update Report", report);
        dialog.setVisible(true);

        if (dialog.isSucceeded()) {
            reportList.set(selectedRow, dialog.getReport());
            loadReports();
        }
    }

    private void deleteReport() {
        int selectedRow = reportTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a report to delete.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this report?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            reportList.remove(selectedRow);
            loadReports();
        }
    }
    private void openMainApp() {
        // Code to open TripManagementScreen
        new MainApp().setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReportScreen().setVisible(true);
            }
        });
    }
}

class ReportDialog extends JDialog {
    private JTextField contentField;
    private JDateChooser creationDateChooser;
    private boolean succeeded;
    private ReportWrapper report;
    private ReportWrapper reportWrapper;

    public ReportDialog(Frame parent, String title, ReportWrapper report) {
        super(parent, title, true);
        this.report = report;
        this.reportWrapper = new ReportWrapper();

        JPanel panel = new JPanel(new GridLayout(0, 2));
        getContentPane().add(panel, BorderLayout.CENTER);

        panel.add(new JLabel("Content:"));
        contentField = new JTextField();
        panel.add(contentField);

        panel.add(new JLabel("Creation Date:"));
        creationDateChooser = new JDateChooser();
        panel.add(creationDateChooser);

        if (report != null) {
            contentField.setText(report.getContent());
            creationDateChooser.setDate(report.getCreationDate());
        }

        JPanel controlPanel = new JPanel();
        getContentPane().add(controlPanel, BorderLayout.SOUTH);

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        controlPanel.add(okButton);
        controlPanel.add(cancelButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSave();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        pack();
        setLocationRelativeTo(parent);
    }

    // Constructor for testing purposes
    public ReportDialog(ReportWrapper report) {
        this(null, "Test", report);
        onSave();
    }

    private void onSave() {
        if (report == null) {
            report = new ReportWrapper();
            report.setReportId(UUID.randomUUID());
        }
        report.setContent(contentField.getText());
        report.setCreationDate(new java.sql.Date(creationDateChooser.getDate().getTime()));
        succeeded = true;
        dispose();
    }

    private void onCancel() {
        succeeded = false;
        dispose();
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public ReportWrapper getReport() {
        return report;
    }
}