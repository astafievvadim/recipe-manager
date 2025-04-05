package com.astafiev.recipemanager.service;

import com.astafiev.recipemanager.dto.RecipeDto;
import com.astafiev.recipemanager.dto.RecipeIngredientDto;
import com.astafiev.recipemanager.model.Recipe;
import com.astafiev.recipemanager.model.RecipeIngredient;
import com.astafiev.recipemanager.model.RecipeIngredientId;
import com.astafiev.recipemanager.model.User;
import com.astafiev.recipemanager.repository.CommentRepository;
import com.astafiev.recipemanager.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    private RecipeTypeService recipeTypeService;
    private UnitService unitService;
    private IngredientService ingredientService;

    private CommentRepository commentRepository;
    @Autowired
    public RecipeService(RecipeRepository recipeRepository, RecipeTypeService recipeTypeService, UnitService unitService, IngredientService ingredientService, CommentRepository commentRepository) {
        this.recipeRepository = recipeRepository;
        this.recipeTypeService = recipeTypeService;
        this.unitService = unitService;
        this.ingredientService = ingredientService;
        this.commentRepository = commentRepository;
    }

    public Recipe getById(Long id){
        return recipeRepository.findRecipeById(id).orElseThrow();
    }

    public Recipe updateRecipe(Long id, Recipe recipe, User user){

        Recipe inDB = recipeRepository.findRecipeById(id).get();

        if(!Objects.equals(inDB.getUser().getId(), user.getId())){
            throw new RuntimeException(new Exception());
        }

        if(
                recipe.getLabel() != null &
                        !recipe.getLabel().isEmpty()
        ){
            inDB.setLabel(recipe.getLabel());
        }

        if(
                recipe.getDescription() != null &
                        !recipe.getDescription().isEmpty()
        ){
            inDB.setDescription(recipe.getDescription());
        }

        if(
                recipe.getInstructions() != null &
                        !recipe.getInstructions().isEmpty()
        ){
            inDB.setInstructions(recipe.getInstructions());
        }

        if(
                recipe.getRecipeIngredients() != null &
                        !recipe.getRecipeIngredients().isEmpty()
        ){
            for(int i = 0; i < inDB.getRecipeIngredients().size(); i++){
                inDB.getRecipeIngredients().remove(i);
            }

            inDB.getRecipeIngredients().addAll(recipe.getRecipeIngredients());
        }

        if(
                recipe.getRecipeType() != null &
                        !recipe.getRecipeType().isEmpty()
        ){
            inDB.setRecipeType(recipe.getRecipeType());
        }

        return recipeRepository.save(inDB);
    }

    public void deleteRecipe(Recipe recipe){
        recipeRepository.delete(recipe);
    }

    public List<Recipe> getAllRecipes(){
        return recipeRepository.findAll();
    }

    public Page<Recipe> getSomeRecipes(Long fromId, int number){
        PageRequest pageable = PageRequest.of(0, number);
        return recipeRepository.findAllById(fromId,pageable);
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
