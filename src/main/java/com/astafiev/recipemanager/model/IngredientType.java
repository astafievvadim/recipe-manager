package com.astafiev.recipemanager.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Entity
@Table(name = "ingredient_types")
public class IngredientType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingredientTypeId;

    @NonNull
    private String label;

    public IngredientType() {
    }

    public IngredientType(Long ingredientTypeId, @NonNull String label) {
        this.ingredientTypeId = ingredientTypeId;
        this.label = label;
    }

    public Long getIngredientTypeId() {
        return ingredientTypeId;
    }

    public void setIngredientTypeId(Long ingredientTypeId) {
        this.ingredientTypeId = ingredientTypeId;
    }

    @NonNull
    public String getLabel() {
        return label;
    }

    public void setLabel(@NonNull String label) {
        this.label = label;
    }
}
