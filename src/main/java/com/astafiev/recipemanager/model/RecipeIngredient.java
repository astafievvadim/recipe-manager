package com.astafiev.recipemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredient implements Serializable {

    @EmbeddedId
    private RecipeIngredientId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("recipeId")
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ingredientId")
    private Ingredient ingredient;
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("unitId")
    private Unit unit;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Recipe recipeId, Ingredient ingredient, double amount, Unit unit) {
        this.recipe = recipeId;
        this.ingredient = ingredient;
        this.amount = amount;
        this.unit = unit;
    }

    public RecipeIngredientId getId() {
        return id;
    }

    public void setId(RecipeIngredientId id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
