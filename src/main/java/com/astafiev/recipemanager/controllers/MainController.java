package com.astafiev.recipemanager.controllers;
import com.astafiev.recipemanager.dtos.RecipeDTO;
import com.astafiev.recipemanager.dtos.RecipeIngredientDTO;
import com.astafiev.recipemanager.model.Ingredient;
import com.astafiev.recipemanager.model.Recipe;
import com.astafiev.recipemanager.model.RecipeIngredient;
import com.astafiev.recipemanager.model.RecipeIngredientId;
import com.astafiev.recipemanager.repos.IngredientRepository;
import com.astafiev.recipemanager.repos.RecipeTypeRepository;
import com.astafiev.recipemanager.repos.UnitRepository;
import com.astafiev.recipemanager.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/legal")
public class MainController {

    RecipeService recipeService;
    RecipeTypeRepository recipeTypeRepository;
    UnitRepository unitRepository;
    IngredientRepository ingredientRepository;

    @Autowired
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Autowired
    public void setRecipeTypeRepository(RecipeTypeRepository recipeTypeRepository) {
        this.recipeTypeRepository = recipeTypeRepository;
    }
    @Autowired
    public void setUnitRepository(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }
    @Autowired
    public void setIngredientRepository(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userAccessed(){
        return "it works";
    }
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @PostMapping("/recipe")
    public ResponseEntity<?> addRecipeFromDTO(@RequestBody RecipeDTO recipe) {

        recipeService.saveRecipeFromDTIO(recipe);

        return ResponseEntity.ok("all good");
    }
}


    /*
    @PostMapping("/exampleRecipe")
    public ResponseEntity<?> exampleRecipe() {


        return ResponseEntity.ok("Recipe asved");
    }    @PostMapping("/TESTaddRecipe")
    public ResponseEntity<?> TESTaddRecipe(
            @RequestParam("label") String label,
            @RequestParam("instructions") String instructions
    ) {

        Recipe r = new Recipe();
        r.setLabel(label);
        r.setInstructions(instructions);
        recipeService.saveRecipe(r);
        return ResponseEntity.ok("Recipe asved");
    }


    @PostMapping("/recipe")
    public ResponseEntity<?> addRecipe(@RequestBody Recipe recipe) {

        Recipe r = new Recipe();
        r.setLabel(recipe.getLabel());
        r.setInstructions(recipe.getInstructions());

        recipeService.saveRecipe(r);

        return ResponseEntity.ok("Recipe saved");
    }


     */