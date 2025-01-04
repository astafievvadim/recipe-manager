package com.astafiev.recipemanager.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/legal")
public class MainController {

    @GetMapping("/user")
    public String userAccessed(Principal principal){
        if(principal == null){
            return null;
        }
        else{
            return principal.getName();
        }
    }
}
