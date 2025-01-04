package com.astafiev.recipemanager.controllers;

import com.astafiev.recipemanager.model.User;
import com.astafiev.recipemanager.repos.UserRepository;
import com.astafiev.recipemanager.security.JwtCore;
import com.astafiev.recipemanager.security.SigninRequest;
import com.astafiev.recipemanager.security.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

import jakarta.validation.constraints.*;
@RestController
@RequestMapping("/auth")
public class SecurityController {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;

    private JwtCore jwtCore;
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    @Autowired
    public void setJwtCore(JwtCore jwtCore) {
        this.jwtCore = jwtCore;
    }

    @PostMapping("/signup")
    ResponseEntity<?> signup (@RequestBody SignupRequest signupRequest){
        if (userRepository.existsByUsername(signupRequest.getUsername())){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY.value()).body("Name is already taken");
        }
        if (userRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY.value()).body("Account with this email already exists");
        }
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(
                passwordEncoder.encode(signupRequest.getPassword())
        );

        userRepository.save(user);
        return ResponseEntity.ok("Account registered");
    }

    @PostMapping("/signin")
    ResponseEntity<?> signin (@RequestBody SigninRequest signinRequest){

        Authentication auth = null;

        try{
            auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getUsername(), signinRequest.getPassword()));
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = jwtCore.generateToken(auth);

        return ResponseEntity.ok(jwt);
    }


}
