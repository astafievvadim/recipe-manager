package com.astafiev.recipemanager.repository;

import com.astafiev.recipemanager.model.IngredientType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Optional;

public interface IngredientTypeRepository  extends JpaRepository<IngredientType, Serializable> {
    Optional<IngredientType> findIngredientTypeById(Long id);

}
