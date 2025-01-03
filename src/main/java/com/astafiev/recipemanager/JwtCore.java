package com.astafiev.recipemanager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
@Component
public class JwtCore {

    @Value("${recipemanager.app.secret}")
    private String secret;
    @Value("${recipemanager.app.expiratonMs}")
    private int lifetimeMs;

    public String generateToken(Authentication auth){
        return null;
    }
}
