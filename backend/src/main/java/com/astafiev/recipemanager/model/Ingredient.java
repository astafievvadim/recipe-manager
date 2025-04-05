package com.astafiev.recipemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "ingredients")
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ingredient_type_id")
    private IngredientType ingredientType;

    private String label;

    private String description;


    @JsonIgnore
    @OneToMany(
            mappedBy = "ingredient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    @OneToMany(
            mappedBy = "ingredient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List <IngredientNutrition> ingredientNutrition;

        public List<IngredientNutrition> getIngredientNutrition() {
        return ingredientNutrition;
    }

        public void setIngredientNutrition(List<IngredientNutrition> ingredientNutrition) {
        this.ingredientNutrition = ingredientNutrition;
    }


    public Ingredient() {
    }

    public Ingredient( IngredientType ingredientType, String label, String description) {
        this.ingredientType = ingredientType;
        this.label = label;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", ingredientType=" + ingredientType.getLabel() +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", ingredientNutrition=" + ingredientNutrition +
                '}';
    }
}
