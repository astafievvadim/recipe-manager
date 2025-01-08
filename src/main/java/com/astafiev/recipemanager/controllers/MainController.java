package com.astafiev.recipemanager.controllers;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/legal")
public class MainController {

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userAccessed(){
        return "it works";
    }
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }
}
