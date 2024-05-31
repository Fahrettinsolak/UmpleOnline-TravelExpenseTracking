package com.solak.TravelExpense.main.lib.models;

import com.solak.TravelExpense.umple.AuthenticationManager;
import com.solak.TravelExpense.umple.UserCredential;

public class UserCredentialWrapper {
    private UserCredential userCredential;

    // Constructor to initialize with an existing UserCredential
    public UserCredentialWrapper(UserCredential userCredential) {
        this.userCredential = userCredential;
    }

    // Constructor to initialize a new UserCredential
    public UserCredentialWrapper(AuthenticationManager authManager, String username, String password) {
        this.userCredential = authManager.addUserCredential(username, password);
    }

    public boolean setUsername(String username) {
        return userCredential.setUsername(username);
    }

    public boolean setPassword(String password) {
        return userCredential.setPassword(password);
    }

    public String getUsername() {
        return userCredential.getUsername();
    }

    public String getPassword() {
        return userCredential.getPassword();
    }

    public AuthenticationManager getAuthenticationManager() {
        return userCredential.getAuthenticationManager();
    }

    public boolean setAuthenticationManager(AuthenticationManager authenticationManager) {
        return userCredential.setAuthenticationManager(authenticationManager);
    }

    public void delete() {
        userCredential.delete();
    }

    @Override
    public String toString() {
        return userCredential.toString();
    }
}
