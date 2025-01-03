package com.astafiev.recipemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "ingredient_nutrition")
public class IngredientNutrition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingredientNutritionId;

    private Ingredient ingredient;

    private NutritionValue nutritionValue;

    private Unit unit;

    private double amount;

    public IngredientNutrition() {
    }

    public IngredientNutrition(Long ingredientNutritionId, Ingredient ingredient, NutritionValue nutritionValue, Unit unit, double amount) {
        this.ingredientNutritionId = ingredientNutritionId;
        this.ingredient = ingredient;
        this.nutritionValue = nutritionValue;
        this.unit = unit;
        this.amount = amount;
    }

    public Long getIngredientNutritionId() {
        return ingredientNutritionId;
    }

    public void setIngredientNutritionId(Long ingredientNutritionId) {
        this.ingredientNutritionId = ingredientNutritionId;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public NutritionValue getNutritionValue() {
        return nutritionValue;
    }

    public void setNutritionValue(NutritionValue nutritionValue) {
        this.nutritionValue = nutritionValue;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
