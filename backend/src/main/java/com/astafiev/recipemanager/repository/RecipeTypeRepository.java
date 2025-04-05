package com.astafiev.recipemanager.repository;

import com.astafiev.recipemanager.model.RecipeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeTypeRepository extends JpaRepository<RecipeType, Long> {

     Optional<RecipeType> findRecipeTypeById(Long id);
}
