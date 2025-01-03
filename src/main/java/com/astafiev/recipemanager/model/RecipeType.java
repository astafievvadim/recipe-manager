package com.astafiev.recipemanager.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Entity
@Table(name="recipe_types")
public class RecipeType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recipeTypeId;
    @NonNull
    private String label;
    @NonNull
    private String description;

    public RecipeType() {
    }

    public RecipeType(long RecipeTypeId, @NonNull String label, @NonNull String description) {
        this.recipeTypeId = RecipeTypeId;
        this.label = label;
        this.description = description;
    }

    public void setRecipeTypeId(long recipeTypeId) {
        this.recipeTypeId = recipeTypeId;
    }

    public long getRecipeTypeId() {
        return recipeTypeId;
    }

    public void setLabel(@NonNull String label) {
        this.label = label;
    }

    @NonNull
    public String getLabel() {
        return label;
    }


    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

}
