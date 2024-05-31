package com.solak.travelexpensetracking.main.app;

import static org.junit.Assert.*;

import java.awt.Frame;

import javax.swing.SwingUtilities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.solak.travelexpensetracking.main.app.Main;
import com.solak.travelexpensetracking.main.app.RegisterScreen;

public class MainTest {

	 @Before
	    public void setUp() {
	        // Set up any necessary environment before tests
	    }

	    @After
	    public void tearDown() {
	        // Clean up after tests if necessary
	    }

	    @Test
	    public void testMain() throws Exception {
	        SwingUtilities.invokeAndWait(new Runnable() {
	            @Override
	            public void run() {
	                Main.main(new String[]{});
	                boolean isRegisterScreenVisible = false;
	                for (Frame frame : Frame.getFrames()) {
	                    if (frame instanceof RegisterScreen) {
	                        isRegisterScreenVisible = frame.isVisible();
	                        frame.dispose();  // Clean up after test
	                    }
	                }
	                assertFalse("RegisterScreen should be visible", isRegisterScreenVisible);
	            }
	        });
	    }

}
