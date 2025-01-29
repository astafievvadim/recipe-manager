package com.astafiev.recipemanager.repos;

import com.astafiev.recipemanager.model.Ingredient;
import com.astafiev.recipemanager.model.Recipe;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Serializable> {

    //Optional<Ingredient> findIngredientById(Long id);
    Optional<Ingredient> findIngredientById(Long id);

    List<Ingredient> findAll();
    //findRecipesByRecipeIngredientsIngredient
    List<Ingredient> findIngredientsByRecipeIngredientsRecipe(Recipe recipe);
    List<Ingredient> findIngredientsByRecipeIngredientsRecipeId(Long id);
}
