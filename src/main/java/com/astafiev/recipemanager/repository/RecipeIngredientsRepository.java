package com.astafiev.recipemanager.repository;

import com.astafiev.recipemanager.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface RecipeIngredientsRepository  extends JpaRepository<RecipeIngredient, Serializable> {

    //List<RecipeIngredient> findRecipeIngredientByIngredientId(Long ingredientId);

}
