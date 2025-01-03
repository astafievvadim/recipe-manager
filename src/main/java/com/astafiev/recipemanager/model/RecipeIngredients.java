package com.astafiev.recipemanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredients implements Serializable {

    @Id
    @GeneratedValue()
    private Long recipeIngredientsId;
    @NonNull
    private Recipe recipe;
    @NonNull
    private Ingredient ingredient;
    @NonNull
    private double amount;
    @NonNull
    private Unit unit;

    public RecipeIngredients() {
    }

    public RecipeIngredients(Long recipeIngredientsId, Recipe recipe, Ingredient ingredient, double amount, Unit unit) {
        this.recipeIngredientsId = recipeIngredientsId;
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.amount = amount;
        this.unit = unit;
    }

    public Long getRecipeIngredientsId() {
        return recipeIngredientsId;
    }

    public void setRecipeIngredientsId(Long recipeIngredientsId) {
        this.recipeIngredientsId = recipeIngredientsId;
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
