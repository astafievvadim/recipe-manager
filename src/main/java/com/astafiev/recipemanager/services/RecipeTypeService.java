package com.astafiev.recipemanager.services;

import com.astafiev.recipemanager.model.RecipeType;
import com.astafiev.recipemanager.repos.RecipeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeTypeService {

    private RecipeTypeRepository recipeTypeRepository;

    @Autowired
    public void setRecipeTypeRepository(RecipeTypeRepository recipeTypeRepository) {
        this.recipeTypeRepository = recipeTypeRepository;
    }

    public RecipeType getById(Long id){
        return recipeTypeRepository.findRecipeTypeById(id).orElse(null);
    }
}
