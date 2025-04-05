package com.astafiev.recipemanager.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.io.Serializable;

@Entity
@Table(name = "ingredient_nutrition")
public class IngredientNutrition implements Serializable {

    @EmbeddedId
    private IngredientNutritionId id = new IngredientNutritionId();

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @MapsId("ingredientId")
    private Ingredient ingredient;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @MapsId("nutritionValueId")
    private NutritionValue nutritionValue;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @MapsId("unitId")
    private Unit unit;

    private double amount;
    public IngredientNutrition() {
    }

    public IngredientNutrition(Ingredient ingredient, NutritionValue nutritionValue, Unit unit, double amount) {
        this.ingredient = ingredient;
        this.nutritionValue = nutritionValue;
        this.unit = unit;
        this.amount = amount;
    }

    public IngredientNutritionId getId() {
        return id;
    }

    public void setId(IngredientNutritionId id) {
        this.id = id;
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
