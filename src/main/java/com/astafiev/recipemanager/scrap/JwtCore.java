/*
package com.astafiev.recipemanager.security;

import com.astafiev.recipemanager.model.User;
import com.astafiev.recipemanager.model.UserDetailsImpl;
import com.astafiev.recipemanager.repository.UserRepository;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.security.Key;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Component
public class JwtCore {

    @Value("${recipemanager.app.secret}")
    private String secret;
    @Value("${recipemanager.app.expiratonMs}")
    private int lifetimeMs;

    private static final Logger logger = LoggerFactory.getLogger(JwtCore.class);
    public String generateJwtToken(Authentication auth){

        UserDetailsImpl userPrincipal = (UserDetailsImpl) auth.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                //.claim("password", userPrincipal.getPassword())
                .setIssuedAt(new Date())
                .setIssuedAt(new Date(new Date().getTime() + lifetimeMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public String getUsernameFromJwtToken(String jwtToken){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken).getBody().getSubject();
    }

    public boolean validateJwkToken(String jwtToken){
        try{
            Jwts.parser().setSigningKey(secret).parse(jwtToken);
        } catch (MalformedJwtException ex){
            logger.error("Invalid JWT token: {}", ex.getMessage());
        } catch (ExpiredJwtException ex){
            logger.error("JWT token is expired: {}", ex.getMessage());
        } catch (UnsupportedJwtException ex){
            logger.error("JWT token is unsupported: {}", ex.getMessage());
        } catch (IllegalArgumentException ex){
            logger.error("JWT claims string is empty: {}", ex.getMessage());
        }

        return false;
    }

    private boolean getIfTokenIsExpired(Jwt jwtToken) {
        return Objects.requireNonNull(jwtToken.getExpiresAt()).isBefore(Instant.now());
    }

    public boolean isTokenValid(Jwt jwtToken, UserDetails userDetails) {
        final String userName = getUsernameFromJwtToken(jwtToken.toString());
        boolean isTokenExpired = getIfTokenIsExpired(jwtToken);
        boolean isTokenUserSameAsDatabase = userName.equals(userDetails.getUsername());
        return !isTokenExpired  && isTokenUserSameAsDatabase;
    }

    private UserRepository useruserInfoRepo;
    public UserDetails userDetails(String email){
        try {
            return (UserDetails) useruserInfoRepo.findUserByEmail(email).orElseThrow(ChangeSetPersister.NotFoundException::new);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
*/