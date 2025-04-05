package com.astafiev.recipemanager.preloading;

import com.astafiev.recipemanager.model.Ingredient;
import com.astafiev.recipemanager.model.IngredientType;
import com.astafiev.recipemanager.model.RecipeType;
import com.astafiev.recipemanager.model.Unit;
import com.astafiev.recipemanager.repository.IngredientRepository;
import com.astafiev.recipemanager.repository.IngredientTypeRepository;
import com.astafiev.recipemanager.repository.RecipeTypeRepository;
import com.astafiev.recipemanager.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PreLoader implements ApplicationRunner {

    private RecipeTypeRepository recipeTypeRepository;

    private IngredientTypeRepository ingredientTypeRepository;

    private UnitRepository unitRepository;

    private IngredientRepository ingredientRepository;

    @Autowired
    public void setRecipeTypeRepository(RecipeTypeRepository recipeTypeRepository) {
        this.recipeTypeRepository = recipeTypeRepository;
    }
    @Autowired
    public void setIngredientTypeRepository(IngredientTypeRepository ingredientTypeRepository) {
        this.ingredientTypeRepository = ingredientTypeRepository;
    }
    @Autowired
    public void setUnitRepository(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Autowired
    public void setRp(RecipeTypeRepository rtp) {
        this.recipeTypeRepository = rtp;
    }
    @Autowired
    public void setIngredientRepository(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        ingredientTypeRepository.save(
                new IngredientType(
                        "veggie"
                )
        );


        ingredientRepository.save(
                new Ingredient(
                        ingredientTypeRepository.findIngredientTypeById(1L).orElse(null),
                        "Potato1",
                        "Decription"
                )
        );
        ingredientRepository.save(
                new Ingredient(
                        ingredientTypeRepository.findIngredientTypeById(1L).orElse(null),
                        "Potato2",
                        "Decription"
                )
        );
        ingredientRepository.save(
                new Ingredient(
                        ingredientTypeRepository.findIngredientTypeById(1L).orElse(null),
                        "Potato3",
                        "Decription"
                )
        );

        unitRepository.save(new Unit(
                "kg"
                )
        );
        unitRepository.save(new Unit(
                        "gramm"
                )
        );
        unitRepository.save(new Unit(
                        "cm"
                )
        );


        recipeTypeRepository.save(
                new RecipeType(
                        "fry",
                        "It's fucking stir fry dude what else could it be"
                )
        );
    }
}
