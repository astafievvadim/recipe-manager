package com.astafiev.recipemanager.repos;

import com.astafiev.recipemanager.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Serializable> {

    //Optional<Ingredient> getIngredientById(Long id);
    Ingredient getIngredientById(Long id);

    List<Ingredient> findAll();
}
