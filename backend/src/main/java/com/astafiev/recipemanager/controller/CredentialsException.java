package com.astafiev.recipemanager.controller;

public class CredentialsException extends Exception {
    public CredentialsException(String credentials_are_taken) {
        super(credentials_are_taken);
    }
}
