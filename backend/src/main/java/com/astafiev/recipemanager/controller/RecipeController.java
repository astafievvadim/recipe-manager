package com.astafiev.recipemanager.controller;

import com.astafiev.recipemanager.dto.RecipeDto;
import com.astafiev.recipemanager.model.Ingredient;
import com.astafiev.recipemanager.model.Recipe;
import com.astafiev.recipemanager.model.User;
import com.astafiev.recipemanager.service.IngredientService;
import com.astafiev.recipemanager.service.RecipeService;
import com.astafiev.recipemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private RecipeService recipeService;
    private UserService userService;
    private IngredientService ingredientService;
    @Autowired
    public RecipeController(RecipeService recipeService, IngredientService ingredientService, UserService userService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.userService = userService;
    }

    @GetMapping("/{recipeId}")
    public Recipe getRecipe(@PathVariable Long recipeId) {

        return recipeService.getById(recipeId);
    }

    //rework this one
    @GetMapping("/{recipeId}/get/{number}")
    public Page<Recipe> getSomeRecipes(@PathVariable Long recipeId, @PathVariable int number) {

        return recipeService.getSomeRecipes(recipeId,number);
    }

    @DeleteMapping("/{recipeId}")
    public ResponseEntity<?> deleteRecipe(@PathVariable Long recipeId){

        recipeService.deleteRecipe(
                recipeService.getById(recipeId)
        );

        return ResponseEntity.ok("Recipe deleted successfully");
    }


    @PostMapping("/")
    public ResponseEntity<?> addRecipeFromDTO(@RequestBody RecipeDto recipe, Principal principal) {

        if(principal == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body("You must be logged in to do dat");
        }

        Recipe r = recipeService.getRecipeFromDto(recipe);
        r.setUser( userService.getUserByUsername(principal.getName()));
        recipeService.saveRecipe(r);

        return ResponseEntity.ok("Recipe added");
    }

    @PostMapping("/{recipeId}/edit")
    public ResponseEntity<?> editRecipe(@RequestBody RecipeDto recipe, Principal principal, @PathVariable Long recipeId) {

        if(principal == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body("You must be logged in to do dat");
        }

        Recipe r = recipeService.getRecipeFromDto(recipe);
        User user = userService.getUserByUsername(principal.getName());


        return ResponseEntity.ok(recipeService.updateRecipe(recipeId, r, user));
    }

    @GetMapping("/{recipeId}/ingredients")
    public List<Ingredient> getAllIngredients(@PathVariable Long recipeId) {

        return ingredientService.getAllWithRecipeId(recipeId);

    }
}
