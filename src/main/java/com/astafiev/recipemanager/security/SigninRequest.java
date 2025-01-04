package com.astafiev.recipemanager.security;

import lombok.Data;
import lombok.Getter;

@Data
public class SigninRequest {
    private String username;
    private String password;
    private String email;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
