package com.solak.TravelExpense.main.app;

import com.solak.TravelExpense.main.lib.models.TripWrapper;
import com.solak.TravelExpense.main.lib.wrappers.TripManagerWrapper;
import com.solak.TravelExpense.umple.TripManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TripManagementScreen extends JFrame {
    private JTable tripTable;
    private DefaultTableModel tableModel;
    private List<TripWrapper> trips; // Trips stored in memory
    private TripManagerWrapper tripManagerWrapper;

    public TripManagementScreen(TripManagerWrapper tripManagerWrapper) {
        this.tripManagerWrapper = tripManagerWrapper;
        trips = new ArrayList<>(); // Initialize the in-memory list

        setTitle("Trip Planning");
        setSize(710, 610);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setBounds(21, 113, 650, 386);

        // Table Panel
        tableModel = new DefaultTableModel(new Object[]{"Trip Id", "Destination", "Start Date", "End Date"}, 0);
        getContentPane().setLayout(null);
        
        JLabel lblTravelExpense = new JLabel("Trip Planning", SwingConstants.CENTER);
        lblTravelExpense.setForeground(Color.WHITE);
        lblTravelExpense.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
        lblTravelExpense.setBounds(7, 22, 664, 52);
        getContentPane().add(lblTravelExpense);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(81, 85, 531, 15);
        getContentPane().add(separator);
        
        JButton backButton_1 = new JButton("Back To Menu");
        backButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 // Implement back to menu functionality
                new MainApp().setVisible(true);
                dispose();
        	}
        });
        backButton_1.setForeground(new Color(255, 255, 255));
        backButton_1.setBackground(new Color(255, 0, 0));
        backButton_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
        backButton_1.setBounds(21, 522, 152, 23);
        getContentPane().add(backButton_1);
        tripTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(tripTable);
        tableScrollPane.setBounds(10, 56, 630, 305);
        mainPanel.setLayout(null);
        mainPanel.add(tableScrollPane);

        getContentPane().add(mainPanel);
        
                // Button Panel
                JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
                buttonPanel.setBounds(10, 17, 635, 23);
                mainPanel.add(buttonPanel);
                JButton addButton = new JButton("Add Travel");
                addButton.setBackground(new Color(0, 128, 192));
                addButton.setForeground(new Color(255, 255, 255));
                addButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
                JButton arrangeButton = new JButton("Arrange Travel");
                arrangeButton.setBackground(new Color(0, 128, 192));
                arrangeButton.setForeground(new Color(255, 255, 255));
                arrangeButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
                JButton deleteButton = new JButton("Delete Trip");
                deleteButton.setBackground(new Color(0, 128, 192));
                deleteButton.setForeground(new Color(255, 255, 255));
                deleteButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
                buttonPanel.add(addButton);
                buttonPanel.add(arrangeButton);
                buttonPanel.add(deleteButton);
                
                        addButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                addTrip();
                            }
                        });
                        
                                arrangeButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        arrangeTrip();
                                    }
                                });
                                
                                        deleteButton.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                deleteTrip();
                                            }
                                        });
                
                                		ImageIcon icon2 = new ImageIcon(RegisterScreen.class.getResource("login.jpg"));
                                		JLabel label_loginbackground = new JLabel("");
                                		label_loginbackground.setBounds(0, 0, 688, 569);
                                		Image image2 = icon2.getImage().getScaledInstance(label_loginbackground.getWidth(),
                                		label_loginbackground.getHeight(), Image.SCALE_SMOOTH);
                                		ImageIcon iccon = new ImageIcon(image2);
                                		label_loginbackground.setIcon(iccon);
                                		getContentPane().add(label_loginbackground);

        loadTrips();
    }

    private void loadTrips() {
        tableModel.setRowCount(0); // Clear existing data
        for (TripWrapper trip : trips) {
            tableModel.addRow(new Object[]{
                    trip.getTripId().toString(),  // Convert UUID to String
                    trip.getDestination(),
                    trip.getStartDate(),
                    trip.getEndDate()
            });
        }
    }

    private void addTrip() {
        JTextField destinationField = new JTextField();
        JTextField startDateField = new JTextField();
        JTextField endDateField = new JTextField();
        Object[] message = {
                "Destination:", destinationField,
                "Start Date (yyyy-mm-dd):", startDateField,
                "End Date (yyyy-mm-dd):", endDateField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add Travel", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String destination = destinationField.getText();
                Date startDate = Date.valueOf(startDateField.getText());
                Date endDate = Date.valueOf(endDateField.getText());

                TripWrapper newTrip = new TripWrapper(UUID.randomUUID(), destination, startDate, endDate, tripManagerWrapper.getTripManager());
                trips.add(newTrip); // Add the trip to the in-memory list
                JOptionPane.showMessageDialog(this, "Trip added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTrips(); // Refresh the table to show the new trip
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Invalid date format. Please use yyyy-mm-dd.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void arrangeTrip() {
        int selectedRow = tripTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a trip to arrange.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        UUID tripId = UUID.fromString((String) tableModel.getValueAt(selectedRow, 0));
        // Implementation to arrange trip (not shown here)
        JOptionPane.showMessageDialog(this, "Arrange trip functionality is not implemented yet.", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private void deleteTrip() {
        int selectedRow = tripTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a trip to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        UUID tripId = UUID.fromString((String) tableModel.getValueAt(selectedRow, 0));
        trips.removeIf(trip -> trip.getTripId().equals(tripId)); // Remove the trip from the in-memory list
        JOptionPane.showMessageDialog(this, "Trip deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        loadTrips(); // Refresh the table to remove the deleted trip
    }
}
