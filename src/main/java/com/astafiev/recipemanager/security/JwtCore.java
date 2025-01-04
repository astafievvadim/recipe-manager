package com.astafiev.recipemanager.security;

import com.astafiev.recipemanager.model.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtCore {

    @Value("${recipemanager.app.secret}")
    private String secret;
    @Value("${recipemanager.app.expiratonMs}")
    private int lifetimeMs;

    public static String getUsernameFromJwt(String jwt, JwtCore core) {
        return Jwts.parser().setSigningKey(core.secret).parseClaimsJwt(jwt).getBody().getSubject();
    }

    public String generateToken(Authentication auth){

        UserDetailsImpl userDetails = (UserDetailsImpl)auth.getPrincipal();
        Date now = Date.from(Instant.now());

        return Jwts.builder()
                .setSubject(
                        (userDetails.getUsername())
                ).setIssuedAt(now)
                .setExpiration(new Date((now.getTime()+lifetimeMs)))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
