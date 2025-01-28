package com.astafiev.recipemanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class RecipeIngredientId implements Serializable {

    @Column(name = "recipe_id")
    private Long recipeId;

    @Column(name = "ingredient_id")
    private Long ingredientId;

    @Column(name = "unit_id")
    private Long unitId;
    public RecipeIngredientId(Long recipeId, Long ingredientId, Long unitId) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.unitId = unitId;
    }

    public RecipeIngredientId() {
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeIngredientId that)) return false;
        return Objects.equals(recipeId, that.recipeId) && Objects.equals(ingredientId, that.ingredientId) && Objects.equals(unitId, that.unitId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, ingredientId, unitId);
    }
}
