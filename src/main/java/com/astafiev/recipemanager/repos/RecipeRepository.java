package com.astafiev.recipemanager.repos;

import com.astafiev.recipemanager.model.Ingredient;
import com.astafiev.recipemanager.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Serializable> {
    Recipe findRecipeById(Long recipeId);

    /*
    @TODO There was an easier way ofr it, so query is out of question for now
    @Query("SELECT x FROM recipes r " +
            "JOIN recipe_ingredients ri " +
            "ON r.id = ri.recipeId " +
            "JOIN ingredients i " +
            "ON i.id = ri.ingredientId " +
            "WHERE i.id = ingredientId ")
                List<Recipe> findRecipeByIngredientId(Long ingredientId);
                 List<Recipe> findBooksByBookPublishersPublisherId(Long publisherId)
     */
    List<Recipe> findRecipesByRecipeIngredientsIngredientId(Long ingredientId);

    Recipe findRecipeByLabel(String label);
}
