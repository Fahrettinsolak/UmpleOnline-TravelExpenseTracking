package com.solak.TravelExpense.main.lib.wrappers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.solak.TravelExpense.umple.AuthenticationManager;
import com.solak.TravelExpense.umple.UserCredential;

public class AuthenticationManagerWrapperTest {

	private AuthenticationManagerWrapper wrapper;
    private AuthenticationManager authManager;
    private UserCredential user1;
    private UserCredential user2;

    @Before
    public void setUp() {
        authManager = new AuthenticationManager();
        wrapper = new AuthenticationManagerWrapper(authManager);

        // Initialize some sample user credentials
        user1 = new UserCredential("user1", "password1", authManager);
        user2 = new UserCredential("user2", "password2", authManager);
    }

    @Test
    public void testLogin() {
        wrapper.register("user1", "password1");
        assertFalse(wrapper.login("user1", "password1"));
        assertFalse(wrapper.login("user1", "wrongpassword"));
        assertFalse(wrapper.login("user3", "password1"));
    }

    @Test
    public void testLogout() {
        wrapper.register("user1", "password1");
        wrapper.login("user1", "password1");
        wrapper.logout("user1");
        // No easy way to assert logout without mock, but we can ensure no exceptions thrown
    }

    @Test
    public void testRegister() {
        assertFalse(wrapper.register("user1", "password1"));
        assertFalse(wrapper.register("user1", "password1")); // Duplicate registration should fail
    }

    @Test
    public void testChangePassword() {
        wrapper.register("user1", "password1");
        assertFalse(wrapper.changePassword("user1", "password1", "newpassword1"));
        assertFalse(wrapper.changePassword("user1", "wrongpassword", "newpassword1"));
        assertFalse(wrapper.login("user1", "newpassword1"));
    }

    @Test
    public void testGetUserCredential() {
        authManager.addUserCredential(user1);
        UserCredential retrievedUser = wrapper.getUserCredential(0);
        assertEquals(user1, retrievedUser);
    }

    @Test
    public void testGetUserCredentials() {
        authManager.addUserCredential(user1);
        authManager.addUserCredential(user2);
        List<UserCredential> users = wrapper.getUserCredentials();
        assertEquals(2, users.size());
        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
    }

    @Test
    public void testNumberOfUserCredentials() {
        authManager.addUserCredential(user1);
        authManager.addUserCredential(user2);
        int count = wrapper.numberOfUserCredentials();
        assertEquals(2, count);
    }

    @Test
    public void testHasUserCredentials() {
        assertTrue(wrapper.hasUserCredentials());
        authManager.addUserCredential(user1);
        assertTrue(wrapper.hasUserCredentials());
    }

    @Test
    public void testIndexOfUserCredential() {
        authManager.addUserCredential(user1);
        int index = wrapper.indexOfUserCredential(user1);
        assertEquals(0, index);
    }

    @Test
    public void testAddUserCredentialWithDetails() {
        UserCredential newUser = wrapper.addUserCredential("user3", "password3");
        assertNotNull(newUser);
        assertEquals("user3", newUser.getUsername());
        assertEquals("password3", newUser.getPassword());
    }

    @Test
    public void testAddUserCredentialObject() {
        assertFalse(wrapper.addUserCredential(user1));
        assertTrue(wrapper.getUserCredentials().contains(user1));
    }

    @Test
    public void testRemoveUserCredential() {
        authManager.addUserCredential(user1);
        assertFalse(wrapper.removeUserCredential(user1));
        assertTrue(wrapper.getUserCredentials().contains(user1));
    }

    @Test
    public void testAddUserCredentialAt() {
        wrapper.addUserCredentialAt(user1, 0);
        assertEquals(user1, wrapper.getUserCredential(0));
    }

    @Test
    public void testAddOrMoveUserCredentialAt() {
        wrapper.addUserCredentialAt(user1, 0);
        wrapper.addOrMoveUserCredentialAt(user2, 0);
        assertEquals(user2, wrapper.getUserCredential(0));
        assertEquals(user1, wrapper.getUserCredential(1));
    }

    @Test
    public void testDelete() {
        authManager.addUserCredential(user1);
        authManager.addUserCredential(user2);
        wrapper.delete();
        assertTrue(wrapper.getUserCredentials().isEmpty());
    }

}
