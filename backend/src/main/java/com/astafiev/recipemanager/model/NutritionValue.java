package com.astafiev.recipemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "nutrition_values")
public class NutritionValue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String label;

    @JsonIgnore
    @JoinColumn(name = "nutrition_value_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<IngredientNutrition> ingredientNutrition;

    public NutritionValue() {
    }

    public NutritionValue( String label) {

        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
