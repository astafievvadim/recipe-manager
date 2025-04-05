package com.astafiev.recipemanager.service;

import com.astafiev.recipemanager.model.Ingredient;
import com.astafiev.recipemanager.model.Recipe;
import com.astafiev.recipemanager.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient getById(Long id){
        return ingredientRepository.findIngredientById(id).orElse(null);
    }

    public List<Ingredient> getAll(){
        return ingredientRepository.findAll();
    }

    public List<Ingredient> getAllWithRecipe(Recipe recipe){
        return ingredientRepository.findIngredientsByRecipeIngredientsRecipe(recipe);
    }

    public List<Ingredient> getAllWithRecipeId(Long id){
        return ingredientRepository.findIngredientsByRecipeIngredientsRecipeId(id);
    }
}
