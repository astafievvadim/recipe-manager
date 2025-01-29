package com.astafiev.recipemanager.controllers;
import com.astafiev.recipemanager.dtos.RecipeDto;
import com.astafiev.recipemanager.model.Ingredient;
import com.astafiev.recipemanager.model.Recipe;
import com.astafiev.recipemanager.repos.IngredientRepository;
import com.astafiev.recipemanager.repos.RecipeTypeRepository;
import com.astafiev.recipemanager.repos.UnitRepository;
import com.astafiev.recipemanager.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
