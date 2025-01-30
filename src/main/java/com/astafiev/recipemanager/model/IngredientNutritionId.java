package com.astafiev.recipemanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Embeddable
public class IngredientNutritionId implements Serializable {

    @Column(name = "ingredient_id")
    private Long ingredientId;
    @Column(name = "nutrition_value_id")
    private Long nutritionValueId;
    @Column(name = "unit_id")
    private Long unitId;


}
