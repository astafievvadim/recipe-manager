package com.astafiev.recipemanager.repository;

import com.astafiev.recipemanager.model.Ingredient;
import com.astafiev.recipemanager.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Serializable> {
    Optional<Ingredient> findIngredientById(Long id);
    List<Ingredient> findAll();
    List<Ingredient> findIngredientsByRecipeIngredientsRecipe(Recipe recipe);
    List<Ingredient> findIngredientsByRecipeIngredientsRecipeId(Long id);
}
