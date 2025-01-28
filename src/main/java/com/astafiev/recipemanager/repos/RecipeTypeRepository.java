package com.astafiev.recipemanager.repos;

import com.astafiev.recipemanager.model.RecipeType;
import com.astafiev.recipemanager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeTypeRepository extends JpaRepository<RecipeType, Long> {

     RecipeType getRecipeTypeById(Long id);
}
