package com.astafiev.recipemanager.repos;

import com.astafiev.recipemanager.model.Recipe;
import com.astafiev.recipemanager.model.RecipeIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Serializable> {
}
