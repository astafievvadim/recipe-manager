package com.astafiev.recipemanager.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Entity
@Table(name="recipe_types")
public class RecipeType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String label;

    private String description;

    public RecipeType() {
    }

    public RecipeType(String label, String description) {

        this.label = label;
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public String getLabel() {
        return label;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public boolean isEmpty() {
        return label != null && description != null;
    }
}
