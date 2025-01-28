package com.astafiev.recipemanager.repos;

import com.astafiev.recipemanager.model.Recipe;
import com.astafiev.recipemanager.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface RecipeIngredientsRepository  extends JpaRepository<RecipeIngredient, Serializable> {

    //List<RecipeIngredient> findRecipeIngredientByIngredientId(Long ingredientId);

}
