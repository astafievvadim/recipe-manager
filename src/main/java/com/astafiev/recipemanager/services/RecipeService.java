package com.astafiev.recipemanager.services;

import com.astafiev.recipemanager.dtos.RecipeDTO;
import com.astafiev.recipemanager.dtos.RecipeIngredientDTO;
import com.astafiev.recipemanager.model.Recipe;
import com.astafiev.recipemanager.model.RecipeIngredient;
import com.astafiev.recipemanager.model.RecipeIngredientId;
import com.astafiev.recipemanager.repos.IngredientRepository;
import com.astafiev.recipemanager.repos.RecipeRepository;
import com.astafiev.recipemanager.repos.RecipeTypeRepository;
import com.astafiev.recipemanager.repos.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {


    private RecipeRepository recipeRepository;

    RecipeTypeRepository recipeTypeRepository;
    UnitRepository unitRepository;
    IngredientRepository ingredientRepository;
    @Autowired
    public void setRecipeTypeRepository(RecipeTypeRepository recipeTypeRepository) {
        this.recipeTypeRepository = recipeTypeRepository;
    }
    @Autowired
    public void setUnitRepository(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }
    @Autowired
    public void setIngredientRepository(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Autowired
    public void setRecipeRepository(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes(){
        return recipeRepository.findAll();
    }

    public void saveRecipe(Recipe recipe){
        recipeRepository.save(recipe);
    }

    public void saveRecipeFromDTIO(RecipeDTO recipe){

        Recipe r = new Recipe();
        r.setLabel(recipe.getLabel());
        r.setInstructions(recipe.getInstructions());
        r.setDescription(recipe.getDescription());
        r.setRecipeType(recipeTypeRepository.getRecipeTypeById(recipe.getRecipeTypeId()));

        List<RecipeIngredientDTO> tempList = recipe.getRecipeIngredientIds();
        List<RecipeIngredient> temp = new ArrayList<>();


        for (RecipeIngredientDTO riDTO : tempList) {


            temp.add(new RecipeIngredient(

                            new RecipeIngredientId(
                                    r.getId(),
                                    riDTO.getIngredientId(),
                                    riDTO.getUnitId()
                            ),
                            r,
                            ingredientRepository.getIngredientById(riDTO.getIngredientId()),
                            riDTO.getAmount(),
                            unitRepository.getUnitById(riDTO.getUnitId()).orElse(null)
                    )
            );
        }

        r.setRecipeIngredients(temp);

        recipeRepository.save(r);
    }
}
