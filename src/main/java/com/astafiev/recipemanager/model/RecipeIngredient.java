package com.astafiev.recipemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Optional;

@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredient implements Serializable {

    @EmbeddedId
    @JsonIgnore
    private RecipeIngredientId id = new RecipeIngredientId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("recipeId")
    @JsonIgnore
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @MapsId("ingredientId")
    private Ingredient ingredient;
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("unitId")
    private Unit unit;

    public RecipeIngredient() {
    }

    public RecipeIngredient(RecipeIngredientId recipeIngredientId,  Recipe recipe, Ingredient ingredient, double amount, Unit unit) {
        this.recipe = recipe;
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

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "id=" + id +
                //", recipe=" + recipe +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                ", unit=" + unit +
                '}';
    }
}
