package com.solak.TravelExpense.main.lib.models;

import static org.junit.Assert.*;

import org.junit.Test;

import com.solak.TravelExpense.umple.UserCredential;

public class UserCredentialWrapperTest {

	@Test
    public void testParametricConstructor() {
        UserCredential userCredential = new UserCredential("testUsername", "testPassword", null);
        UserCredentialWrapper userCredentialWrapper;

        userCredentialWrapper = new UserCredentialWrapper(userCredential);

        assertNotNull(userCredentialWrapper);
    }
}
