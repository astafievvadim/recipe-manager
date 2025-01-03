package com.astafiev.recipemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "nutrition_values")
public class NutritionValue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nutritionValueId;

    private String label;

    public NutritionValue() {
    }

    public NutritionValue(Long nutritionValueId, String label) {
        this.nutritionValueId = nutritionValueId;
        this.label = label;
    }

    public Long getNutritionValueId() {
        return nutritionValueId;
    }

    public void setNutritionValueId(Long nutritionValueId) {
        this.nutritionValueId = nutritionValueId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
