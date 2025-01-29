package com.astafiev.recipemanager.controllers;

import com.astafiev.recipemanager.dtos.RecipeDto;
import com.astafiev.recipemanager.model.Ingredient;
import com.astafiev.recipemanager.model.Recipe;
import com.astafiev.recipemanager.services.IngredientService;
import com.astafiev.recipemanager.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private RecipeService recipeService;
    private IngredientService ingredientService;
    @Autowired
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @GetMapping("/all")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }
    @PostMapping("/put")
    public ResponseEntity<?> addRecipeFromDTO(@RequestBody RecipeDto recipe) {

        Recipe r = recipeService.getRecipeFromDto(recipe);
        recipeService.saveRecipe(r);

        return ResponseEntity.ok("all good");
    }

    @GetMapping("/{recipeId}/ingredients")
    public List<Ingredient> getAllIngredients(@PathVariable Long recipeId) {

        return ingredientService.getAllWithRecipeId(recipeId);

    }
}
