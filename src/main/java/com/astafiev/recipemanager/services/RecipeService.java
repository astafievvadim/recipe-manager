package com.astafiev.recipemanager.services;

import com.astafiev.recipemanager.dtos.RecipeDto;
import com.astafiev.recipemanager.dtos.RecipeIngredientDto;
import com.astafiev.recipemanager.model.Recipe;
import com.astafiev.recipemanager.model.RecipeIngredient;
import com.astafiev.recipemanager.model.RecipeIngredientId;
import com.astafiev.recipemanager.repos.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    private RecipeTypeService recipeTypeService;
    private UnitService unitService;
    private IngredientService ingredientService;

    @Autowired
    public void setRecipeTypeService(RecipeTypeService recipeTypeService) {
        this.recipeTypeService = recipeTypeService;
    }
    @Autowired
    public void setUnitService(UnitService unitService) {
        this.unitService = unitService;
    }
    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
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

    public Recipe getRecipeFromDto(RecipeDto recipeDto){

        Recipe r = new Recipe();
        r.setLabel(recipeDto.getLabel());
        r.setInstructions(recipeDto.getInstructions());
        r.setDescription(recipeDto.getDescription());
        r.setRecipeType(recipeTypeService.getById(recipeDto.getRecipeTypeId()));

        List<RecipeIngredientDto> tempList = recipeDto.getRecipeIngredientIds();
        List<RecipeIngredient> temp = new ArrayList<>();


        for (RecipeIngredientDto riDTO : tempList) {


            temp.add(new RecipeIngredient(

                            new RecipeIngredientId(
                                    r.getId(),
                                    riDTO.getIngredientId(),
                                    riDTO.getUnitId()
                            ),
                            r,
                            ingredientService.getById(riDTO.getIngredientId()),
                            riDTO.getAmount(),
                            unitService.getById(riDTO.getUnitId())
                    )
            );
        }

        r.setRecipeIngredients(temp);

        return(r);
    }
}
