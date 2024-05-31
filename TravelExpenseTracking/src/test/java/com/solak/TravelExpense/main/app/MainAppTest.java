package com.solak.TravelExpense.main.app;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

public class MainAppTest {

	    private MainApp mainApp;

	    @Before
	    public void setUp() {
	        mainApp = new MainApp();
	    }

	    @Test
	    public void testMainAppInitialization() {
	        assertNotNull(mainApp);
	        assertEquals("Seyahat Gider Takibi", mainApp.getTitle());
	        assertEquals(710, mainApp.getSize().width);
	        assertEquals(610, mainApp.getSize().height);
	        assertEquals(JFrame.EXIT_ON_CLOSE, mainApp.getDefaultCloseOperation());
	    }

	    @Test
	    public void testOpenTripManagementScreen() {
	        JButton button = findButton(mainApp, "Trip Planning");
	        assertNotNull(button);
	        button.doClick();
	        // Ekstra kontrol gerektiren yerler
	    }

	    @Test
	    public void testOpenExpenseManagementScreen() {
	        JButton button = findButton(mainApp, "Expense Recording");
	        assertNotNull(button);
	        button.doClick();
	        // Ekstra kontrol gerektiren yerler
	    }

	    @Test
	    public void testOpenBudgetManagementScreen() {
	        JButton button = findButton(mainApp, "Budget Management");
	        assertNotNull(button);
	        button.doClick();
	        // Ekstra kontrol gerektiren yerler
	    }

	    @Test
	    public void testOpenReportScreen() {
	        JButton button = findButton(mainApp, "Summary Report");
	        assertNotNull(button);
	        button.doClick();
	        // Ekstra kontrol gerektiren yerler
	    }

	    private JButton findButton(Container container, String text) {
	        for (Component component : container.getComponents()) {
	            if (component instanceof JButton) {
	                JButton button = (JButton) component;
	                if (button.getText().equals(text)) {
	                    return button;
	                }
	            } else if (component instanceof Container) {
	                JButton button = findButton((Container) component, text);
	                if (button != null) {
	                    return button;
	                }
	            }
	        }
	        return null;
	    }

}
