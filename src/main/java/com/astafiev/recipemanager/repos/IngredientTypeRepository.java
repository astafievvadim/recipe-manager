package com.astafiev.recipemanager.repos;

import com.astafiev.recipemanager.model.IngredientType;
import com.astafiev.recipemanager.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Optional;

public interface IngredientTypeRepository  extends JpaRepository<IngredientType, Serializable> {
    Optional<IngredientType> findIngredientTypeById(Long id);

}
