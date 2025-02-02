package com.astafiev.recipemanager.repository;

import com.astafiev.recipemanager.model.NutritionValue;
import com.astafiev.recipemanager.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface NutritionRepository  extends JpaRepository<NutritionValue, Serializable> {
}
