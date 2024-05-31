package com.solak.travelexpensetracking.main.app;

import javax.swing.SwingUtilities;

/**
 * @class Main
 * @brief The main class to launch the application.
 * It initializes the GUI by displaying the RegisterScreen.
 */
public class Main {
    /**
     * @brief The main method to start the application.
     * It uses SwingUtilities.invokeLater to ensure that the GUI creation and updates
     * are performed on the Event Dispatch Thread.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            /**
             * @brief The run method to create and display the RegisterScreen.
             * It is executed on the Event Dispatch Thread.
             */
            @Override
            public void run() {
                new RegisterScreen().setVisible(true);
            }
        });
    }
}