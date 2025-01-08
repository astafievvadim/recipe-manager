package com.astafiev.recipemanager.controllers;

import com.astafiev.recipemanager.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SecurityController {

    private AuthenticationService authenticationService;

    @Autowired
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


}
    /*
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        return authenticationService.registerUser(signUpRequest);
    }

    @PostMapping("/signin")
    ResponseEntity<?> signin (@RequestBody SigninRequest signinRequest) {
        return authenticationService.signinUser(signinRequest);
    }

     */