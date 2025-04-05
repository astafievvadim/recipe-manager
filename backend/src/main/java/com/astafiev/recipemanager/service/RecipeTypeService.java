package com.astafiev.recipemanager.service;

import com.astafiev.recipemanager.model.RecipeType;
import com.astafiev.recipemanager.repository.RecipeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeTypeService {

    private RecipeTypeRepository recipeTypeRepository;
    @Autowired
    public RecipeTypeService(RecipeTypeRepository recipeTypeRepository) {
        this.recipeTypeRepository = recipeTypeRepository;
    }

    public RecipeType getById(Long id){
        return recipeTypeRepository.findRecipeTypeById(id).orElse(null);
    }
}
