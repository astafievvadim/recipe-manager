package com.astafiev.recipemanager.repository;

import com.astafiev.recipemanager.model.Ingredient;
import com.astafiev.recipemanager.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Serializable> {
    //Recipe findRecipeById(Long recipeId);
    List<Recipe> findRecipesByRecipeIngredientsIngredientId(Long ingredientId);
    List<Recipe> findByLabelContaining(String string);

    List<Recipe> findRecipesByRecipeIngredientsIngredient(Ingredient ingredient);
    //Recipe findRecipeByLabel(String label);
    //List<Recipe> findAll();

    Optional<Recipe> findRecipeById(Long id);
}


    /*
    @Query("SELECT x FROM recipes r " +
            "JOIN recipe_ingredients ri " +
            "ON r.id = ri.recipeId " +
            "JOIN ingredients i " +
            "ON i.id = ri.ingredientId " +
            "WHERE i.id = ingredientId ")
                List<Recipe> findRecipeByIngredientId(Long ingredientId);
     */