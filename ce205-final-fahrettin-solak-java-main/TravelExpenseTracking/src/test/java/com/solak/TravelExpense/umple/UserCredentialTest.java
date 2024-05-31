package com.solak.TravelExpense.umple;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.solak.TravelExpense.umple.AuthenticationManager;
import com.solak.TravelExpense.umple.UserCredential;
import com.solak.TravelExpense.main.lib.models.UserCredentialWrapper;

public class UserCredentialTest {

    private AuthenticationManager authManager;
    private UserCredentialWrapper userCredentialWrapper;
    
    @Before
    public void setUp() {
        authManager = new AuthenticationManager();
        userCredentialWrapper = new UserCredentialWrapper(authManager, "username", "password");
    }

    @After
    public void tearDown() {
        authManager = null;
        userCredentialWrapper = null;
    }

    @Test
    public void testSetUsername() {
        assertTrue(userCredentialWrapper.setUsername("newusername"));
        assertEquals("newusername", userCredentialWrapper.getUsername());
    }
    
    @Test
    public void testSetPassword() {
        assertTrue(userCredentialWrapper.setPassword("newpassword"));
        assertEquals("newpassword", userCredentialWrapper.getPassword());
    }
    
    @Test
    public void testGetUsername() {
        assertEquals("username", userCredentialWrapper.getUsername());
    }
    
    @Test
    public void testGetPassword() {
        assertEquals("password", userCredentialWrapper.getPassword());
    }
    
    @Test
    public void testGetAuthenticationManager() {
        assertEquals(authManager, userCredentialWrapper.getAuthenticationManager());
    }
    
    @Test
    public void testSetAuthenticationManager() {
        AuthenticationManager newAuthManager = new AuthenticationManager();
        assertTrue(userCredentialWrapper.setAuthenticationManager(newAuthManager));
        assertEquals(newAuthManager, userCredentialWrapper.getAuthenticationManager());
    }
    
    @Test
    public void testDelete() {
        userCredentialWrapper.delete();
        assertNull(userCredentialWrapper.getAuthenticationManager());
    }
    
    @Test
    public void testToString() {
        assertNotEquals("UserCredential{username='username', password='password'}", userCredentialWrapper.toString());
    }
}
